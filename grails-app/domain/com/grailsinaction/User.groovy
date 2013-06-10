package com.grailsinaction

class User {
    String username
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    transient springSecurityService

    String homepage
    Date dateCreated
    Profile profile


    @Override
    public String toString() {
        return "User{" +
                ", homepage='" + homepage + '\'' +
                ", profile=" + profile +
                ", username='" + username + '\'' +
                '}';
    }

//    ,size: 5..10, validator: { passwd, user ->
//        return passwd != user.username
//    }
    static constraints = {
        username(blank: false,size: 3..20, unique: true)
        password(blank: false)
        profile(nullable: true)
        homepage(nullable: true)
    }
    static mapping = {
        profile lazy: false
        posts sort: "dateCreated"
        password column: '`password`'
    }
    static hasMany = [posts: Post, tags: Tag, following: User]




    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}
