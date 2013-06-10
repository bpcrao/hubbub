package com.grailsinaction

class PostController {
    def scaffold = true
    def postService
    def springSecurityService
    def timeline = {
        def user = User.get(springSecurityService.principal.id)
        render(view: "timeline", model: [user: user])
    }

    def addPost = {
        def post
        try {
            post= postService.createPost(params.id, params.content)
            flash.message = "Successfully posted"
        }
        catch (e) {
            flash.message = e.getMessage()
        }

        if (post) {
            flash.message = "Added new post"
        }
        else {
            flash.message = "Failed to add new post"
        }

        redirect(action: 'timeline', id: params.id)
    }

    static navigation = [
            [group: 'tabs', action: 'timeline', title: 'My Timeline', order: 0],

    ]
}
