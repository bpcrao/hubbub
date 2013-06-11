// Place your Spring DSL code here
import org.apache.activemq.spring.ActiveMQConnectionFactory

beans = {
    connectionFactory(ActiveMQConnectionFactory) {
        brokerURL = "tcp://localhost:61616"
    }
}
