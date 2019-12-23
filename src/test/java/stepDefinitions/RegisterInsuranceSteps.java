package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.EnterBirthDate;
import pageObjects.EnterRegistrationDate;
import pageObjects.SelectBodyType;
import pageObjects.SelectEngine;
import pageObjects.SelectEnginePower;
import pageObjects.SelectFuelType;
import pageObjects.SelectModel;
import pageObjects.SelectPrecondition;
import pageObjects.SelectRegisteredOwner;
import pageObjects.SelectVehicle;
import services.Driver;

public class RegisterInsuranceSteps{

	SelectPrecondition sp;
	SelectRegisteredOwner sro;
	SelectVehicle sv;
	SelectModel sm;
	SelectBodyType sbt;
	SelectFuelType sft;
	SelectEnginePower sep;
	SelectEngine se;
	EnterRegistrationDate erd;
	EnterBirthDate ebd;

	Driver driver;

	@Before
	public void testInitializer(){
		driver = new Driver();
		driver.maximizeWindow();

		System.out.println("========================== Before Scenario =======================");
	}



	@After
	public void tearDownTest(){
		driver.closeBrowser();
		System.out.println("========================== After Scenario =======================");
	}


	//---------------------------------------------------------- selectPrecondition	

	@Given("^I am in the starting page$")
	public void i_am_in_the_starting_page() throws Throwable {

		sp = new SelectPrecondition(driver,"https://hello.friday.de/quote/selectPrecondition");
	}

	@Given("^The car is already insured$")
	public void the_car_is_already_insured() throws Throwable {
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
		driver.checkCurrentURL("https://hello.friday.de/quote/selectRegisteredOwner");

	}

	//------------------------------------------------------------------------------ selectRegisteredOwner

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
		driver.checkCurrentURL("https://hello.friday.de/quote/selectVehicle");

	}

	//----------------------------------------------------------------------------- selectVehicle

	@When("^I click on the \"([^\"]*)\" of my car in the list$")
	public void i_click_on_the_in_the_list(String brand) throws Throwable {

		sv.selectCar(brand);
	}

	@Then("^I am asked to specify the model of my car in selectModel$")
	public void i_am_asked_to_specify_the_model_of_my_car_in_selectModel() throws Throwable {
		sm = new SelectModel(sv.getDriver());
		driver.checkCurrentURL("https://hello.friday.de/quote/selectModel");

	}
	//---------------------------------------------------------------------------  selectModelType
	@When("^I click on the \"([^\"]*)\" of my car$")
	public void i_click_on_the_model_of_my_car(String model) throws Throwable {
		sm.selectModelOfCar(model);
	}

	@Then("^I am asked to specify the body type of the car$")
	public void i_am_ask_to_specify_the_body_type_of_the_car() throws Throwable {
		sbt = new SelectBodyType(sm.getDriver());
		driver.checkCurrentURL("https://hello.friday.de/quote/selectBodyType");
	}


	//------------------------------------------------------------------------------   selectBodyType


	@When("^I click on the \"([^\"]*)\" of the car$")
	public void i_click_on_the_body_type_of_the_car(String bodyType) throws Throwable {

		sbt.selectBodyTypeOfTheCar(bodyType);
	}

	@Then("^I am asked to specify the Fuel Type of the car$")
	public void i_am_asked_to_specify_the_Fuel_Type_of_the_car() throws Throwable {

		sft = new SelectFuelType(sbt.getDriver());
		driver.checkCurrentURL("https://hello.friday.de/quote/selectFuelType");
		//		 sbt.takeScreenshot();

	}

	//--------------------------------------------------------  selectFuelType

	@When("^I select the \"([^\"]*)\"$")
	public void i_select_the_fuel(String fuel) throws Throwable {

		sft.selectFuel(fuel);
	}

	@Then("^I am asked to specify the horse power of the car$")
	public void i_am_asked_to_specify_the_horse_power_of_the_car() throws Throwable {
		sep = new SelectEnginePower(sft.getDriver());
		driver.checkCurrentURL("https://hello.friday.de/quote/selectEnginePower");
	}

	//--------------------------------------------------------  selectEnginePower
	@When("^I select the \"([^\"]*)\" of engine$")
	public void i_select_the_of_engine(String powerOfEngine) throws Throwable {

		sep.selectHorsePower(powerOfEngine);
	}

	@Then("^I am asked specify Engine$")
	public void i_am_asked_specify_Engine() throws Throwable {
		se = new SelectEngine(sep.getDriver());
		driver.checkCurrentURL("https://hello.friday.de/quote/selectEngine");
	}
	//----------------------------------------------------------------- select Engine

	@When("^I select the \"([^\"]*)\" of the car$")
	public void i_select_the_of_the_car(String engineOfTheCar) throws Throwable {
		se.selectEngine(engineOfTheCar);
	}

	@Then("^I am asked to specify the registeration date$")
	public void i_am_asked_to_specify_the_registeration_date() throws Throwable {
		erd = new EnterRegistrationDate(se.getDriver());
		driver.checkCurrentURL("https://hello.friday.de/quote/enterRegistrationDate");

	}

	//------------------------------------------------------------------ Registeration date

	@When("^I specify the registeration date$")
	public void i_specify_the_registeration_date() throws Throwable {
		erd.typeRegisterationDate();
		erd.clickOnWeiter();
	}

	@Then("^I am asked to specify my birth date$")
	public void i_am_asked_to_specify_my_birth_date() throws Throwable {
		ebd = new EnterBirthDate(erd.getDriver());
		driver.checkCurrentURL("https://hello.friday.de/quote/enterBirthDate");

	}

}
