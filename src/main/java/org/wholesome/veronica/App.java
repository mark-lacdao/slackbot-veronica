package org.wholesome.veronica;

import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.events.SlackMessagePosted;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;
import com.ullink.slack.simpleslackapi.listeners.SlackMessagePostedListener;
import org.wholesome.veronica.interpreters.ChatInterpreter;
import org.wholesome.veronica.interpreters.Interpreter;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    private static Interpreter interpreter = new ChatInterpreter();

    public static void main(String[] args) throws IOException, InterruptedException {
        final SlackSession session = SlackSessionFactory.
                createWebSocketSlackSession("xoxb-8411653507-KXpj5CjLKXPd7UZYIjDHZNBF");
        session.addMessagePostedListener(new SlackMessagePostedListener() {
            @Override
            public void onEvent(SlackMessagePosted event, SlackSession session) {
                String message = event.getMessageContent();
                session.sendMessage(event.getChannel(),
                        interpreter.interpret(message, event.getSender().getUserName()), null);

                /*try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //2 secs later, let's update the message (I can only update my own messages)
                session.updateMessage(handle.getSlackReply().getTimestamp(),event.getChannel(),
                        event.getMessageContent()+" UPDATED");
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //2 secs later, let's now delete the message (I can only delete my own messages)
                session.deleteMessage(handle.getSlackReply().getTimestamp(),event.getChannel());*/
            }
        });
        session.connect();

        while (true) {
            Thread.sleep(1000);
        }
    }

    private static String getCommand(String message) {
        return message.substring(message.indexOf(" "), message.length()).trim();
    }

}
