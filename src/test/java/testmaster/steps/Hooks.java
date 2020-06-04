package testmaster.steps;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Managed
    public WebDriver hisDriver;

    @Before
    public void set_the_stage()
    {
        OnStage.setTheStage(new OnlineCast());
    }
}
