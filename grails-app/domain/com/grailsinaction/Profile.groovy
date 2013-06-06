package com.grailsinaction

class Profile {
	static belongsTo = User
	byte[] photo
	String fullName
	String bio
	String homepage
	String email
	String timezone
    String skin

    @Override
    public String toString() {
        return "Profile{" +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    String country
	String jabberAddress

	static constraints = {
		fullName(nullable: true)
		bio(nullable: true, maxSize: 1000)
		homepage(url: true, nullable: true)
		email(email: true, nullable: true)
		photo(nullable: true, maxSize:1024 * 1024*2)
		country(nullable: true)
		timezone(nullable: true)
		jabberAddress(email: true, nullable: true)
        skin(nullable: true, blank: true, inList: ['blues', 'backle'])
	}




}
