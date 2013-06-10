package hubbub

import static org.junit.Assert.*
import org.junit.*
import com.grailsinaction.User

import com.grailsinaction.Profile

class QueryIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testBasicDynamicFinders() {
        def tuser = new User(username: 'glen', password: 'secret',
                profile: new Profile(email: 'glen@glensmith.com'))
                try{
                    tuser.save( failOnError:true )

                }
                catch (Exception e){
                    e.printStackTrace()
                }
        def t1user = new User(username: 'peter', password: 'sesame',
                profile: new Profile(homepage: 'http://www.peter.com/'))
                t1user.save( failOnError:true )
        def user = User.findByPassword('sesame')
        assertEquals 'peter', user.username
        user = User.findByUsernameAndPassword('glen',
                'secret')
        assertEquals 'glen', user.username
        def now = new Date()
        def users =
            User.findAllByDateCreatedBetween(now-1, now)
        assertEquals 2, users.size()
        def profiles =
            Profile.findAllByEmailIsNotNull()
        assertEquals 1, profiles.size()
    }


    void testQueryByExample() {
        new User(username: 'glen', password: 'password').save()
        new User(username: 'peter', password: 'password').save()
        new User(username: 'cynthia', password: 'sesame').save()
        def userToFind = new User(username: 'glen')
        def u1 = User.find(userToFind)
        assertEquals('password', u1.password)
        userToFind = new User(username: 'cynthia')
        def u2 = User.find(userToFind)
        assertEquals('cynthia', u2.username)
        userToFind = new User(password: 'password')
        def u3 = User.findAll(userToFind)
        assertEquals(['glen', 'peter'], u3*.username)
    }
}
