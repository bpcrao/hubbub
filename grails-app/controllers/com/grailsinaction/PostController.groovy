package com.grailsinaction

class PostController {
    def scaffold = true

    def timeline = {
        def user = User.findByUserId(params.id)
        render(view: "timeline", model: [ user: user ])
    }

    def addPost={
        def user = User.findByUserId(params.id)
        Post post = new Post(params)
        user.addToPosts(post)
        if (user.save()){
            flash.message="Posted message successfully"
        }        else{
            flash.message="Invalid post"
        }

        redirect(action: 'timeline', id: params.id)
    }
}
