package com.grailsinaction

class ProfileController {
    def scaffold = true

    def search = {
    }

    def results = {

        def profileProps = Profile.metaClass.properties*.name

        def profiles = Profile.withCriteria {
            or{
                params.each { field, value ->
                    if (profileProps.grep(field)
                            && value) {
                        ilike(field, value)
                    }
                }
            }
        }
        return [ profiles : profiles ]
    }
}
