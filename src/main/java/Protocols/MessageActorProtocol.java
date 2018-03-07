package Protocols;

/**
 * Created by Kirill on 07.03.2018.
 */
public class MessageActorProtocol {

    public static class Say {
        public final String name;

        public Say(String name) {
            this.name = name;
        }
    }
}