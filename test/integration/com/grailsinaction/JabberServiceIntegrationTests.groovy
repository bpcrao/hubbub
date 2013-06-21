package com.grailsinaction

import static org.junit.Assert.*
import org.junit.*

class JabberServiceIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    def jabberService

    void testWriteToQueue2() {
        def post = [user: [userId: 'chuck_norris'],
                content: 'is backstroking across the atlantic']
        def jabberIds = ["glen@grailsinaction.com",
                "peter@grailsinaction.com" ]
        jabberService.sendMessage(post, jabberIds)
    }
}
