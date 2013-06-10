package com.grailsinaction

class PostException extends RuntimeException {
    String message
    Post post
}

class PostService {

    boolean transactional = true

    Post createPost(String userId, String content) {
        def user = User.findByUsername(userId)
        if (user) {
            def post = new Post(content: content)
            user.addToPosts(post)
            if (user.save()) {
                def m = content =~ /@(\w+)/
                if (m) {
                    def targetUser =
                        User.findByUsername(m[0][1])
                    if (targetUser) {
                        new Reply(post: post, inReplyTo: targetUser).save()
                    }
                    else {
                        throw new PostException(
                                message: "Reply-to user not found", post: post)
                    }
                }

                return post
            } else {
                throw new PostException(message: "Invalid Post", post: post)
            }
        }
        throw new PostException(message: "Invalid user "+userId)

    }
}
