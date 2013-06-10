package com.grailsinaction
class PhotoUploadCommand {
    byte[] photo
    String userId

}
class ImageController {
def springSecurityService
    def index() { }

    def upload = { PhotoUploadCommand puc ->
        def user = User.get(springSecurityService.principal.id)
        print user.username
        user.profile.photo = puc.photo

        redirect(action: 'view', id: user.username)
    }


    def form = {
// pass through to upload form
        [ userList : User.list() ]
    }
    def view = {
// pass through to "view photo" page
    }


    def renderImage = {
        def user = User.get(springSecurityService.principal.id)
        if (user?.profile?.photo) {
            response.setContentLength(user.profile.photo.length)
            response.outputStream.write(user.profile.photo)
        } else {
            response.sendError(404)
        }
    }

    static navigation = [
            [group:'tabs', action:'form', order: 91]

    ]
}
