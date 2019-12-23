package stepDefinitions;

import cucumber.api.java.After;
//import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
//import cucumber.api.java.BeforeStep;


public class Hooks {
	
    @Before
    public void init() {
        System.out.println("--------------------------------------------------    @Before scenario");
    }

    @After
    public void cleanUp() {
        System.out.println("--------------------------------------------------      @After scenario");
    }

  /*
	@BeforeStep
    public void beforeStep() {
        System.out.println("  @BeforeStep");
    }

    //@AfterStep
    public void afterStep() {
        System.out.println("  @AfterStep");
    }*/
}
