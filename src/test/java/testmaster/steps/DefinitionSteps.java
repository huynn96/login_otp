package testmaster.steps;

import cucumber.api.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import screenplay.questions.Verification;
import screenplay.questions.WebPageTitle;
import screenplay.tasks.Login;
import screenplay.ui.LoginPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.CoreMatchers.is;

public class DefinitionSteps {
    Actor anna;
    public DefinitionSteps()
    {
        anna = theActorCalled("anna");
    }
    @Given("^The login page is showed$")
    public void the_login_page_is_showed() {
        anna.attemptsTo(Open.browserOn().the(LoginPage.class));
    }

    @When("^The User attempt to login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_user_attempt_to_login_with_username_and_password(String username, String password) {
        anna.attemptsTo(
                Login.withUserName(username).andPassword(password)
        );
    }

    @And("^The User confirmed with OTP code from his Email$")
    public void the_user_confirmed_with_otp_code_from_his_email() {
        anna.attemptsTo(
                Enter.theValue(Verification.OTPFromEmail().answeredBy(anna)).into(LoginPage.OTPCODE),
                Click.on(LoginPage.CONFIRM_OTP)
        );
    }

    @Then("^The Homepage will be showed up$")
    public void the_homepage_will_be_showed_up() {
        anna.should(
                seeThat(WebPageTitle.get(), is("Admin - Testmaster.vn"))
        );
    }
}
