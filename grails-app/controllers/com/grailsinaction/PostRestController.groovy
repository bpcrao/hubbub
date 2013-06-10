package com.grailsinaction

import grails.converters.JSON

class PostRestController {

    def list = { render Post.list() as JSON }

}
