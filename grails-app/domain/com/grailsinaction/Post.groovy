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
	static hasMany = [ tags : Tag ]
}
