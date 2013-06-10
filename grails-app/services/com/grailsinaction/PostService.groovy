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
                return post
            } else {
                throw new PostException(message: "Invalid Post", post: post)
            }
        }
        throw new PostException(message: "Invalid user "+userId)

    }
}
