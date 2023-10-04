package com.kieran;

import com.kieran.mode.Publish;
import com.solacesystems.jcsmp.*;
import com.kieran.mode.Subscribe;


import java.util.Objects;


public class Main {

    public static void main(String... args) throws JCSMPException {


        final JCSMPProperties properties = new JCSMPProperties();
        properties.setProperty(JCSMPProperties.HOST, args[0]);  // msg-backbone-ip:port
        properties.setProperty(JCSMPProperties.VPN_NAME, args[1]); // message-vpn
        properties.setProperty(JCSMPProperties.USERNAME, args[2]);
        properties.setProperty(JCSMPProperties.PASSWORD, args[3]);
        String topic  = args[5];
        final JCSMPSession session = JCSMPFactory.onlyInstance().createSession(properties);
        session.connect();

        if (Objects.equals(args[4], "sub")){
            System.out.println("You have selected Subscribe, application will subscribe to all messages produced on (queue or topic here)");
            Subscribe sub = new Subscribe();
            sub.connect(session, topic);
        } else if (Objects.equals(args[4], "pub")) {
            System.out.println("You have selected Publish, application will publish to (queue or topic here)");
            Publish pub = new Publish();
            pub.connect(session, topic);
        } else {
            System.out.println("Please select a mode for you application to run in\nEither \n\tpub\n\tsub");
        }
        }


}
