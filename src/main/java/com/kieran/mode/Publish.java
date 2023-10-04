package com.kieran.mode;

import com.solacesystems.jcsmp.*;

import java.util.Scanner;

public class Publish {
    public void connect(JCSMPSession session, String topic) throws JCSMPException {
        XMLMessageProducer prod = session.getMessageProducer(new JCSMPStreamingPublishEventHandler() {

            @Override
            public void responseReceived(String messageID) {
                System.out.println("Producer received response for msg: " + messageID);
            }

            @Override
            public void handleError(String messageID, JCSMPException e, long timestamp) {
                System.out.printf("Producer received error for msg: %s@%s - %s%n",
                        messageID, timestamp, e);
            }
        });
        final Topic setTopic = JCSMPFactory.onlyInstance().createTopic(topic);
        TextMessage msg = JCSMPFactory.onlyInstance().createMessage(TextMessage.class);






        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text here to Mock Events, every new line will be a new Event!");

        while(true) {

            msg.setText(scanner.nextLine());
            prod.send(msg, setTopic);
        }




    }
}