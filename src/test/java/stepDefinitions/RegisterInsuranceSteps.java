package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.SelectPrecondition;
import pageObjects.SelectRegisteredOwner;

public class RegisterInsuranceSteps {
	
	SelectPrecondition rni;
	SelectRegisteredOwner sro;
	
	@Given("^I am in the starting page$")
	public void i_am_in_the_starting_page() throws Throwable {
		rni = new SelectPrecondition("https://hello.friday.de/quote/selectPrecondition");
	}

	@Given("^I select \"([^\"]*)\"$")
	public void i_select(String arg1) throws Throwable {
		rni.selectInsuranceOption();
	}

	@Given("^I want to have an insurance from today$")
	public void i_want_to_have_an_insurance_from_today() throws Throwable {
		rni.typeInsuranceStartingDate();
	}

	@When("^I click on Weiter button$")
	public void i_click_on() throws Throwable {
	    rni.clickOnWeiter();
	}

	@Then("^It asks for the owner of the car$")
	public void it_asks_for_the_owner_of_the_car() throws Throwable {
	    rni.checkCurrentURL("https://hello.friday.de/quote/selectRegisteredOwner");
	}
//-----------------------------------------------------------------------------------------

	@Given("^I am not the ownner of the car$")
	public void i_am_not_the_ownner_of_the_car() throws Throwable {
		sro = new SelectRegisteredOwner(rni.getDriver());
		sro.specifyTheCarOwner();
	}

	@Given("^the car is new when i purchase it$")
	public void the_car_is_new_when_i_purchase_it() throws Throwable {
	    sro.specifyTheNewOrUsed();
	}

	@When("^I click on Weiter$")
	public void i_click_on_Weiter() throws Throwable {
	    sro.clickOnWeiter();
	}

	@Then("^It navigates to selectVehicle$")
	public void it_navigates_to_selectVehicle() throws Throwable {
		
		sro.checkCurrentURL("https://hello.friday.de/quote/selectVehicle");
	 
	}
	
//-----------------------------------------------------------------------------


}
