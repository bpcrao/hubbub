package com.grailsinaction



import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

    void testConstraints() {
        def will = new User(username: "william")
        mockForConstraintsTests(User,[will])

        def testUser = new User()
        assertFalse testUser.validate()
        assertEquals "nullable",
                testUser.errors["username"]
        assertEquals "nullable",
                testUser.errors["password"]
        testUser = new User(username: "william", password: "william")
        assertFalse testUser.validate()
        assertEquals "unique", testUser.errors["username"]
        assertEquals "validator", testUser.errors["password"]

    }
}
