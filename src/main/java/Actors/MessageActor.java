package Actors;

import Protocols.MessageActorProtocol;
import akka.actor.AbstractActor;
import akka.actor.Props;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kirill on 07.03.2018.
 */
@Named("MessageActor")
@Scope("prototype")
public class MessageActor extends AbstractActor {

    Map<String, Integer> cache = new HashMap<String, Integer>();

    public static Props getProps() {
        return Props.create(MessageActor.class);
    }

    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    String reply = "Message from Actor, " + message;
                    System.out.println(reply);
//                    getSender().tell(reply, getSelf());
                })
                .build();
    }
}