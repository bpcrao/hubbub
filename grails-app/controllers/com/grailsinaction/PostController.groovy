package com.grailsinaction

class PostController {
    def scaffold = true
    def postService

    def timeline = {
        def user = User.findByUserId(params.id)
        render(view: "timeline", model: [ user: user ])
    }

    def addPost={

        def post = postService.createPost(params.id,params.content)
        if (post){
            flash.message="Successfully posted"
        }                                     else{
            flash.message="post invalid"
        }
         redirect(action: 'timeline', id: params.id)
    }
}
