package com.grailsinaction



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */


class JabberServiceTests extends GroovyTestCase {



    def jabberService

    void testWriteToQueue() {
        def post = [user: [userId: 'chuck_norris'],
                content: 'is backstroking across the atlantic']
        def jabberIds = ["glen@grailsinaction.com",
                "peter@grailsinaction.com" ]
        jabberService.sendMessage(post, jabberIds)
    }

}
