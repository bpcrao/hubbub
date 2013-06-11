import org.apache.activemq.ActiveMQConnectionFactory
beans = {
    jmsConnectionFactory(ActiveMQConnectionFactory) {
        brokerURL =  'tcp://localhost:61616'
    }
}