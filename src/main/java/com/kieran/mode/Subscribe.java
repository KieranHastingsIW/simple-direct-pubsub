package com.kieran.mode;

import com.solacesystems.jcsmp.*;

import java.util.concurrent.CountDownLatch;

public class Subscribe{
    public void connect(JCSMPSession session, String topic) throws JCSMPException{
        final CountDownLatch latch = new CountDownLatch(1);

        final XMLMessageConsumer cons = session.getMessageConsumer(new XMLMessageListener() {

            @Override
            public void onReceive(BytesXMLMessage msg) {
                if (msg instanceof TextMessage) {
                    System.out.printf("TextMessage received: '%s'%n",
                            ((TextMessage)msg).getText());
                } else {
                    System.out.println("Message received.");
                }
                System.out.printf("Message Dump:%n%s%n",msg.dump());
//                latch.countDown();  // unblock main thread
            }

            @Override
            public void onException(JCSMPException e) {
                System.out.printf("Consumer received exception: %s%n",e);
//                latch.countDown();  // unblock main thread
            }
        });
        final Topic setTopic = JCSMPFactory.onlyInstance().createTopic(topic);
//        final Queue queue = JCSMPFactory.onlyInstance().createQueue();
        session.addSubscription(setTopic);
        cons.start();
        try {
            latch.await(); // block here until message received, and latch will flip
        } catch (InterruptedException e) {
            System.out.println("I was awoken while waiting");
        }
    }



}
