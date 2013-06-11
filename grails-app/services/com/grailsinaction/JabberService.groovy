package com.grailsinaction

class JabberService {

    def jmsService

    static expose = ['jms']
    static destination = "jabberInQ"
    static listenerCount = 5



    void sendMessage(post, jabberIds) {
        log.debug "Sending jabber message for ${post.user.userId}..."
        jmsService.sendQueueJMSMessage("jabberOutQ",
                [username: post.user.username,
                        content: post.content,
                        to: jabberIds.join(",")])
    }

    void onMessage(msg) {
        log.debug "Got Incoming Jabber Response from: ${msg.jabberId}"
        print "******************** Got Incoming Jabber Response from: ${msg.jabberId}"
        try {
            def profile = Profile.findByJabberAddress(msg.jabberId)
            if (profile) {
                profile.user.addToPosts(new Post(content: msg.content))
            }
        } catch (t) {
            log.error "Error adding post for ${msg.jabberId}", t
        }
    }

}
