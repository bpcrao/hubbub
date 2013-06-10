import com.grailsinaction.User
import com.grailsinaction.Role
import com.grailsinaction.UserRole

class BootStrap {
    def springSecurityService

    def init = {
        def adminRole = Role.findByAuthority('ROLE_ADMIN')?:new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        def adminUser = User.findByUsername('admin') ?: new User(
                username: 'admin',
                password: springSecurityService.encodePassword('admin'),
                enabled: true).save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            UserRole.create adminUser, adminRole
        }
    }
    def destroy = {
    }
}
