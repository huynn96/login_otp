package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import screenplay.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private String username;
    private String password;

    public Login(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN)
        );
    }

    public static LoginBuilder withUserName(String username)
    {
        return new LoginBuilder(username);
    }

    public static class LoginBuilder
    {
        private String username;
        public LoginBuilder(String username)
        {
            this.username = username;
        }

        public Login andPassword(String password)
        {
            return instrumented(Login.class, this.username, password);
        }
    }
}
