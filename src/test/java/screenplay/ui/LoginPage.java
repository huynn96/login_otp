package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://testmaster.vn/admin")
public class LoginPage extends PageObject {

    public static final Target USERNAME = Target.the("username")
            .located(By.cssSelector("div.login-form input[type=\"email\"]"));

    public static final Target PASSWORD = Target.the("password")
            .located(By.cssSelector("div.login-form input[type=\"password\"]"));

    public static final Target OTPCODE = Target.the("OTP code")
            .located(By.cssSelector("div.login-form input[type=\"text\"]"));

    public static final Target LOGIN = Target.the("login button")
            .located(By.cssSelector("button.btn-login"));

    public static final Target CONFIRM_OTP = Target.the("confirm with OTP code")
            .located(By.cssSelector("button.btn-confirm"));
}