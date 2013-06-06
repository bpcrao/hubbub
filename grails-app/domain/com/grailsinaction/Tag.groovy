package com.grailsinaction

class Tag {
    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }

    String name
	User user
	static constraints = { name(blank: false) }
	static hasMany = [ posts : Post ]
	static belongsTo = [User, Post]
}
