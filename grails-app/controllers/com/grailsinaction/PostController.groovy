package com.grailsinaction

class PostController {
    def scaffold = true
    def postService

    def timeline = {
        def user = User.findByUserId(params.id)
        render(view: "timeline", model: [ user: user ])
    }

    def addPost={

        try{
        def post = postService.createPost(params.id,params.content)
            flash.message="Successfully posted"
        }
        catch(PostException e){
            flash.message=e.getMessage()
        }
         redirect(action: 'timeline', id: params.id)
    }

    static navigation = [
            [group:'tabs', action:'timeline', title: 'My Timeline', order: 0],
    ]
}
