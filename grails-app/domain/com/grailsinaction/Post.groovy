package com.grailsinaction

class Post {

	String content
	Date dateCreated
	static constraints = { content(blank: false) }
	static belongsTo = [ user : User ]
	static mapping = {
		profile lazy:false
		sort dateCreated:"desc"
	}

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                ", dateCreated=" + dateCreated +
                ", tags=" + tags +
                '}';
    }

    static hasMany = [ tags : Tag ]
}
