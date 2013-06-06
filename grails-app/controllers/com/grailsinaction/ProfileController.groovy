package com.grailsinaction

class ProfileController {
    def scaffold = true

    def advsearch = {
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


    static navigation = [
            [group:'tabs', action:'advsearch', order: 90],
    ]
}
