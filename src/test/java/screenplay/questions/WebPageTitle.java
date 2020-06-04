package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class WebPageTitle implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getDriver().getTitle();
    }

    public static Question<String> get()
    {
        return new WebPageTitle();
    }
}
