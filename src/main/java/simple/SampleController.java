package simple;

/**
 * Created by Kirill on 06.03.2018.
 */
import Actors.MessageActor;
import Protocols.MessageActorProtocol;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import static simple.SpringExtension.SpringExtProvider;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
            SpringApplication.run(SampleController.class, args);

            AnnotationConfigApplicationContext ctx =
                    new AnnotationConfigApplicationContext();
            ctx.register(AppConfiguration.class);
            ctx.register(MessageActor.class);
            ctx.scan("simple");
            ctx.refresh();

            ActorSystem system = ctx.getBean(ActorSystem.class);

            ActorRef counter = system.actorOf(
                SpringExtProvider.get(system).props("CountingActor"), "counter");

            ActorRef message = system.actorOf(
                    SpringExtProvider.get(system).props("MessageActor"), "message");

            counter.tell(new CountingActor.Count(), null);
            message.tell(new MessageActorProtocol.Say("New message for test") , null);
            message.tell("New message for test String" , null);
//            counter.tell(new CountingActor.Count(), null);
//            counter.tell(new CountingActor.Count(), null);
    }
}