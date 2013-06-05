package com.grailsinaction

class User {
	String userId
	String password
	String homepage
	Date dateCreated
	Profile profile
	static constraints = {
		userId (size:3..20,unique:true)
		password(size: 5..10,validator: { passwd, user ->
			return passwd != user.userId
		})
		profile(nullable: true)
	}
		static mapping = { profile lazy:false }
		static hasMany = [ posts : Post, tags : Tag,following : User ]
}
