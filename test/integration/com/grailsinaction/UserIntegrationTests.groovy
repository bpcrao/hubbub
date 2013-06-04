package com.grailsinaction

import static org.junit.Assert.*
import org.junit.*

class UserIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testSaveUser() {
        def user = new User(userId: 'joe', password: 'secret',
                homepage: 'http://www.grailsinaction.com')
        assertNotNull user.save()
        assertNotNull user.id
        def foundUser = User.get(user.id)
        assertEquals 'joe', foundUser.userId
    }

    @Test
    void testSaveAndUpdate() {
        def user = new User(userId: 'joe', password: 'secret',
                homepage: 'http://www.grailsinaction.com')
        assertNotNull user.save()
        def foundUser = User.get(user.id)
        foundUser.password = 'sesame'
        foundUser.save()
        def editedUser = User.get(user.id)
        assertEquals 'sesame', editedUser.password
    }


    @Test
    void testSaveAndDelete() {
        def user = new User(userId: 'joe', password: 'secret',
                homepage: 'http://www.grailsinaction.com')
        assertNotNull user.save()
        def foundUser = User.get(user.id)
        foundUser.delete()
        assertFalse User.exists(user.id)
    }

    @Test
    void testValidation() {
        def user = new User(userId: 'jo', password: 'secret',
                homepage: 'http://www.grailsinaction.com')
        assertFalse user.validate()
        assertTrue user.hasErrors()
    }


    @Test
    void testUseridPasswordNotSame() {
        def user = new User(userId: 'joees', password: 'joees',
                homepage: 'http://www.grailsinaction.com')
        assertFalse user.validate()
        assertTrue user.hasErrors()
    }


}
