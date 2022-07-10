package org.rabbitmq.org.rabbitmq.helloworld;
import  com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class Producer {
    private static final String  QUEUE_NAME="hello";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        try(Connection conn = factory.newConnection(); Channel channel = conn.createChannel()){
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String msg = "Hi, i am Rahul";
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            System.out.println("Pushed message -> "+msg);

        }
    }
}
