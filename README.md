# simple-direct-pubsub
## A simple java application that can be used either as a publisher or a subscriber using the JCSMP Solace native API

### Prerequisites 
* Java 17
* login to Sparks Solace pubsub+ cloud

  
### Terminology  used in this read me 
<JCSMP host:port> place holder for the JCSMP host:port found in the connect section of the PubSub+ cluster manger 
All other place holders for connection can be found in the same pace as the JCSMP host:port place holder 
### Steps
* Clone repo to a directory of your choosing
* For a publishing application 
Open a terminal of your choosing and run the following command 
                `java -jar fresh.jar <JCSMP host:port> <message VPN> <username> <password> pub <Name of topic you wish to publish too>`

* For a Subscribing application 
Open a terminal of your choosing and run the following command 
                `java -jar fresh.jar <JCSMP host:port> <message VPN> <username> <password> sub <Name of topic you wish to subscribe too>`
