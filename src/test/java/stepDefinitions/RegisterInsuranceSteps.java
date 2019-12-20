package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.SelectBodyType;
import pageObjects.SelectEngine;
import pageObjects.SelectEnginePower;
import pageObjects.SelectFuelType;
import pageObjects.SelectModel;
import pageObjects.SelectPrecondition;
import pageObjects.SelectRegisteredOwner;
import pageObjects.SelectVehicle;

public class RegisterInsuranceSteps {
	
	SelectPrecondition sp;
	SelectRegisteredOwner sro;
	SelectVehicle sv;
	SelectModel sm;
	SelectBodyType sbt;
	SelectFuelType sft;
	SelectEnginePower sep;
	private SelectEngine se;
	
//---------------------------------------------------------- selectPrecondition	
	
	@Given("^I am in the starting page$")
	public void i_am_in_the_starting_page() throws Throwable {
		sp = new SelectPrecondition("https://hello.friday.de/quote/selectPrecondition");
	}

	@Given("^I select \"([^\"]*)\"$")
	public void i_select(String arg1) throws Throwable {
		sp.selectInsuranceOption();
	}

	@Given("^I want to have an insurance from today$")
	public void i_want_to_have_an_insurance_from_today() throws Throwable {
		sp.typeInsuranceStartingDate();
	}

	@When("^I click on Weiter button$")
	public void i_click_on() throws Throwable {
	    sp.clickOnWeiter();
	}

	@Then("^It asks for the owner of the car$")
	public void it_asks_for_the_owner_of_the_car() throws Throwable {
		sro = new SelectRegisteredOwner(sp.getDriver());
	    sro.checkCurrentURL("https://hello.friday.de/quote/selectRegisteredOwner");
	}
//----------------------------------------------------------------------------------------- selectRegisteredOwner

	@Given("^I am not the ownner of the car$")
	public void i_am_not_the_ownner_of_the_car() throws Throwable {
		
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
		sv = new SelectVehicle(sro.getDriver());
		sv.checkCurrentURL("https://hello.friday.de/quote/selectVehicle");
	 
	}
	
//----------------------------------------------------------------------------- selectVehicle

	@When("^I click on the brand of my car in the list$")
	public void i_click_on_the_in_the_list() throws Throwable {
		
	    sv.selectCar();
	}

	@Then("^I am asked to specify the model of my car in selectModel$")
	public void i_am_asked_to_specify_the_model_of_my_car_in_selectModel() throws Throwable {
		sm = new SelectModel(sv.getDriver());
	    sm.checkCurrentURL("https://hello.friday.de/quote/selectModel");
	}
//---------------------------------------------------------------------------  selectModelType
	@When("^I click on the model of my car$")
	public void i_click_on_the_model_of_my_car() throws Throwable {
	    sm.selectModelOfCar();
	    
	}

	@Then("^I am ask to specify the body type of the car$")
	public void i_am_ask_to_specify_the_body_type_of_the_car() throws Throwable {
	    sbt = new SelectBodyType(sm.getDriver());
	    sbt.checkCurrentURL("https://hello.friday.de/quote/selectBodyType");
	}
//------------------------------------------------------------------------------   selectBodyType
	
	
	@When("^I click on the body type of the car$")
	public void i_click_on_the_body_type_of_the_car() throws Throwable {
	    sbt.selectBodyTypeOfTheCar();
	    
	}

	@Then("^I am asked to specify the Fuel Type of the car$")
	public void i_am_asked_to_specify_the_Fuel_Type_of_the_car() throws Throwable {
	    
		 sft = new SelectFuelType(sbt.getDriver());
		 sft.checkCurrentURL("https://hello.friday.de/quote/selectFuelType");
	    
	}
	
//--------------------------------------------------------  selectFuelType
	
	@When("^I select the fuel$")
	public void i_select_the_fuel() throws Throwable {
		
		 sft.selectFuel();
	}

	@Then("^I am asked to specify the horse power of the car$")
	public void i_am_asked_to_specify_the_horse_power_of_the_car() throws Throwable {
	    sep = new SelectEnginePower(sft.getDriver());
	    sep.checkCurrentURL("https://hello.friday.de/quote/selectEnginePower");
	}
	
//--------------------------------------------------------  selectEnginePower
	@When("^I select the horespower  of the car$")
	public void i_select_the_horespower_of_the_car() throws Throwable {
	    sep.selectHorsePower();
	}

	@Then("^I am asked specify Engine$")
	public void i_am_asked_specify_Engine() throws Throwable {
		se = new SelectEngine(sep.getDriver());
		se.checkCurrentURL("https://hello.friday.de/quote/selectEngine");
	}
	
	
}
