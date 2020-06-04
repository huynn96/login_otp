# The Example Integrate Cucumber With Serenity Screenplay Pattern

I created this example to solve 2 problems when working with Serenity Framework

## 1. How to read the data sent to Email like OTP or anything like this

This example execute login with Username and Pasword using OTP generated sent to user Email.

The actor get OTP code by ask a question like this 

```
Verification.OTPFromEmail().answeredBy(anna)

```
It can be used on the action like:

```
Enter.theValue(Verification.OTPFromEmail().answeredBy(anna)).into(LoginPage.OTPCODE)
```
## 2. Combine Serenity with Cucumber

Serenity can make a good solution for code maintainance as well as a best live report follow BDD while cucumber is more approachabble for new people who have less experience in automation.

Combine Serenity with Cucumber is a good idea to take advantage of these. We can create the feature file to list all scenario for each US then implement them in steps definition using Serenity Screenplay like youn did with Screenplay with Junit.

On hook before, we will create the webdriver and open the browser.

```
    @Managed
    public WebDriver hisDriver;

    @Before
    public void set_the_stage()
    {
        OnStage.setTheStage(new OnlineCast());
    }
```

The actor can be define on contructor method of each step definition. We also define and asign ability for actor on this function.

```
    Actor anna;
    public DefinitionSteps()
    {
        anna = theActorCalled("anna");
    }
```

And we can use anna variable on each step like 
```
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
    
    @Then("^The Homepage will be showed up$")
    public void the_homepage_will_be_showed_up() {
        anna.should(
                seeThat(WebPageTitle.get(), is("Admin - Testmaster.vn"))
        );
    }

```

## 3. Conclusion 

Hope that my example can help you more clear about Serenity Screenplay as well as combine Cucumber with Serenity to take the advantages of these library. 

If you have any question can send it to me via email is **khanh.tx@live.com** or refer to some courses ad Testmaster center where I am teaching [http://www.testmaster.vn/]
