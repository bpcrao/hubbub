package com.grailsinaction

class User {
    String userId
    String password
    String homepage
    Date dateCreated
    Profile profile


    @Override
    public String toString() {
        return "User{" +
                ", homepage='" + homepage + '\'' +
                ", profile=" + profile +
                ", userId='" + userId + '\'' +
                '}';
    }

    static constraints = {
        userId(size: 3..20, unique: true)
        password(size: 5..10, validator: { passwd, user ->
            return passwd != user.userId
        })
        profile(nullable: true)
        homepage(nullable: true)
    }
    static mapping = {
        profile lazy: false
        posts sort: "dateCreated"

    }
    static hasMany = [posts: Post, tags: Tag, following: User]
}
