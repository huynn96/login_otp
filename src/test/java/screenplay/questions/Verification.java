package screenplay.questions;

import common.Utility;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import javax.mail.*;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class Verification implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        Properties mail = new Properties();
        mail.put("mail.pop3.host", "pop.gmail.com");
        mail.put("mail.pop3.port", "995");
        mail.put("mail.pop3.starttls.enable", "true");

        Session emailSession = Session.getDefaultInstance(mail);
        try {
            Store store = emailSession.getStore("pop3s");
            byte[] decodedBytes = Base64.getDecoder().decode("IXF3MjNlcjQ1dA==");
            String password = new String(decodedBytes);
            store.connect("pop.gmail.com", "huynnhu1996@gmail.com", password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message[] messages = emailFolder.getMessages();

            return Utility.getTextFromMessage(messages[messages.length-1]);

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Question<String> OTPFromEmail()
    {
        return new Verification();
    }
}
