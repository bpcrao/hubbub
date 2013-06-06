package com.grailsinaction
class PhotoUploadCommand {
    byte[] photo
    String userId

}
class ImageController {

    def index() { }

    def upload = { PhotoUploadCommand puc ->
        def user = User.findByUserId(puc.userId)
        user.profile.photo = puc.photo
        redirect(action: 'view', id: puc.userId)
    }


    def form = {
// pass through to upload form
        [ userList : User.list() ]
    }
    def view = {
// pass through to "view photo" page
    }


    def renderImage = {
        def user = User.findByUserId(params.id)
        if (user?.profile?.photo) {
            response.setContentLength(user.profile.photo.length)
            response.outputStream.write(user.profile.photo)
        } else {
            response.sendError(404)
        }
    }


}
