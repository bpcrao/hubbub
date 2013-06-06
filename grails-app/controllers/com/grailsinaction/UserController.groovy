package com.grailsinaction

class UserController {

    def scaffold = true
    def search = {
    }

    def results = {
        def users = User.findAllByUserIdLike(params.userId)
        return [ users: users, term : params.userId ]
    }

    def register = {
        if(params){
        def user = new User(params)
        if (user.validate()) {
            user.save()
            flash.message = "Successfully Created User"
            redirect(uri: '/')
        } else {
            flash.message = "Error Registering User"
            return [ user: user ]
        }
        }
    }

    def profile={
        def user = User.findByUserId(params.id)
       render (view:  "profile" , model:[user: user] )
    }

    static navigation = [
            [group:'tabs', action:'search', order: 90],
            [action: 'register', order: 99, isVisible: { true }]
    ]
}
