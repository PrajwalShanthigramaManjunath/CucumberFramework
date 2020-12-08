package CucumberFramework.steps;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
// ./drivers\\chromedriver_win.exe

public class bookingSteps {

	WebDriver driver;
	

	@SuppressWarnings("deprecation")
	@Before()
	public void setup() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\test\\java\\CucumberFramework\\resources\\geckodriver.exe");
		
		
		this.driver = new FirefoxDriver();
		
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Given("^User navigates to Ryanair website$")
	public void user_navigates_to_Ryanair_website() throws Throwable {
		driver.get("https://www.ryanair.com/ie/en");
	}

	@Given("^User accepts cookies$")
	public void user_accepts_cookies() throws Throwable {
		driver.findElement(By.cssSelector(".cookie-popup-with-overlay__button")).click();
	}

	@Given("^User enters the valid airport in From$")
	public void user_enters_the_valid_airport_in_From() throws Throwable {
		driver.findElement(By.cssSelector("#input-button__departure")).click();
		driver.findElement(By.cssSelector("fsw-airport-item:nth-child(1)")).click();
	}

	@Given("^User enters the valid airport in To$")
	public void user_enters_the_valid_airport_in_To() throws Throwable {
		driver.findElement(By.cssSelector("fsw-airport-item:nth-child(4)")).click();
	}

	@Given("^User selects One way trip$")
	public void user_selects_One_way_trip() throws Throwable {
		driver.findElement(By.cssSelector("fsw-trip-type-button:nth-child(2)")).click();
	}

	@Given("^User selects depart date$")
	// div:nth-child(7) > .m-toggle__month
	// calendar.datepicker__calendar.datepicker__calendar--left > calendar-body > div:nth-child(2) > div:nth-child(13) > div
	public void user_selects_depart_date() throws Throwable {
		driver.findElement(By.cssSelector("[data-ref='input-button__dates-from']")).click();
		driver.findElement(By.cssSelector("div:nth-of-type(7) > .m-toggle__month")).click();
		driver.findElement(By.cssSelector(".datepicker__calendars .datepicker__calendar:nth-child(3) .ng-star-inserted:nth-of-type(2) [tabindex]")).click();
		
	}

	@Given("^User selects the number of Passengers$")
	public void user_selects_the_number_of_Passengers() throws Throwable {
		driver.findElement(By.cssSelector(".passengers__confirm-button.ry-button--anchor.ry-button--anchor-blue")).click();
	}

	@Given("^User clicks on the search button$")
	public void user_clicks_on_the_search_button() throws Throwable {
		driver.findElement(By.cssSelector(".flight-search-widget__start-search.ng-tns-c74-3.ng-trigger.ng-trigger-collapseExpandCta.ry-button--gradient-yellow")).click();
	}

	@Then("^the User clicks on the desired flight$")
	public void the_User_clicks_on_the_desired_flight() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".card-info__cols-container")).click();
	}

	@Then("^User clicks on Continue with Value fare button$")
	public void user_clicks_on_Continue_with_Value_fare_button() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".fare-card__button.fare-card__price.ry-button--outline-dark-blue > .fare-card__button-text.ng-star-inserted")).click();
	}

	@Then("^User clicks on Log in button$")
	public void user_clicks_on_Log_in_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".login-touchpoint__login-button.ry-button--full.ry-button--gradient-blue.ry-button--medium")).click();
	}

	@Then("^User enters the valid email address$")
	public void user_enters_the_valid_email_address() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("TestRyanairQA@gmail.com");
		
	}

	@Then("^User enters the valid password$")
	public void user_enters_the_valid_password() throws Throwable {
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Test$123" + Keys.ENTER);
		
	}


	@Then("^User selects the title$")
	public void user_selects_the_title() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//ry-dropdown[@id='title-0-error-message']//button[@type='button']")).click();
		driver.findElement(By.cssSelector("ry-dropdown-item:nth-of-type(1) .b2.dropdown-item__label")).click();
	}

	@Then("^User enters the First Name$")
	public void user_enters_the_First_Name() throws Throwable {
		driver.findElement(By.cssSelector("input#formState\\.passengers\\.ADT-0\\.name")).sendKeys("TestFirst");
	}

	@Then("^User enters the Last Name$")
	public void user_enters_the_Last_Name() throws Throwable {
		driver.findElement(By.cssSelector("input#formState\\.passengers\\.ADT-0\\.surname")).sendKeys("TestLast");
	}

	@Then("^User clicks on continue button$")
	public void user_clicks_on_continue_button() throws Throwable {
		driver.findElement(By.xpath("/html/body[@class='ng-tns-0-17']/flights-root[@class='ng-tns-c0-0']//ng-component[@class='ng-star-inserted']//continue-flow-container[@class='ng-star-inserted']/continue-flow[@class='desktop']//span/button[@class='continue-flow__button ry-button--gradient-yellow']")).click();
		Thread.sleep(5000);
	}

	@Then("^User clicks on Random seat allocation$")
	public void user_clicks_on_Random_seat_allocation() throws Throwable {
		driver.findElement(By.xpath("/html/body[@class='is-desktop']/seats-root//seats-container-root[@class='ng-star-inserted']/seats-container-v2/main//h4[.=' Option 2: Random seat allocation ']")).click();
	}

	@Then("^User clicks on I want random seat allocation$")
	public void user_clicks_on_I_want_random_seat_allocation() throws Throwable {
		driver.findElement(By.cssSelector(".b2.random-allocation-info__actions__button.ry-button--gradient-yellow")).click();
		Thread.sleep(6000);
		}

	@Then("^User selects (\\d+) Small Bag only$")
	public void user_selects_Small_Bag_only(int arg1) throws Throwable {
		driver.findElement(By.xpath("//bags-root/bags-booking-container[@class='ng-star-inserted']//div[@class='booking-content ng-star-inserted']/section[1]/bags-cabin-lazy-bag[@class='ng-star-inserted']/bags-cabin-bag/bags-bag-layout[@class='cabin-bag']//div[@role='table']//bags-cabin-bag-journey-container[@class='list-item ng-star-inserted']/bags-cabin-bag-row[@class='card ng-star-inserted']/bags-cabin-bag-products-container[@class='cell cell--content ng-star-inserted']/ry-radio-group//div[@class='card__item card__item--product ng-star-inserted']/bags-cabin-bag-product[1]//bags-product-selector//ry-radio-circle-button[@class='ng-star-inserted']/label[@class='ry-radio-circle-button__label']")).click();
	}

	@Then("^click on Continue button$")
	public void click_on_Continue_button() throws Throwable {
		driver.findElement(By.cssSelector("bags-continue-flow > .ry-button--gradient-yellow")).click();
		Thread.sleep(4000);
	}

	@Then("^click on continue Button$")
	public void click_on_continue_Button() throws Throwable {
		driver.findElement(By.cssSelector(".ng-star-inserted.ng-tns-c167-1.ng-trigger.ng-trigger-buttonTrigger.products-list__button-wrapper > .ng-tns-c167-1.ry-button--full.ry-button--gradient-yellow.ry-button--large")).click();
		Thread.sleep(3000);
		}

	@Then("^User navigates to basket symbol$")
	public void user_navigates_to_basket_symbol() throws Throwable {
		driver.findElement(By.cssSelector(".basket-total-icon__tick path")).click();
	}

	@Then("^User clicks on Check out button$")
	public void user_clicks_on_Check_out_button() throws Throwable {
		driver.findElement(By.xpath("//ry-tooltip[@id='ry-tooltip-1']//ry-price-breakdown-container//ry-price-breakdown-footer[@class='footer ng-star-inserted']//ry-basket-continue-flow-container[@class='ng-star-inserted']/ry-basket-continue-flow/button[@class='ry-button--full ry-button--gradient-yellow']")).click();
		Thread.sleep(5000);
		}

	@Then("^User enters the contact number$")
	public void user_enters_the_contact_number() throws Throwable {
		driver.findElement(By.xpath("//app-root/ng-component/ry-spinner//payment-form/form//contact-details[@class='ng-star-inserted']//div[@class='section-content section-content--desktop']//ry-input-d[@type='tel']//input[@name='undefined']")).sendKeys("894864933");
	}

	@Then("^User selects I don't want to be insured$")
	public void user_selects_I_don_t_want_to_be_insured() throws Throwable {
		driver.findElement(By.cssSelector("[for='insurance-opt-out'] ._background")).click();
	}

	@Then("^User enters the invalid card number$")
	public void user_enters_the_invalid_card_number() throws Throwable {
		driver.findElement(By.cssSelector("[data-ref='add-card-modal__account-number'] [type]")).sendKeys("5555 5555 5555 5557");
	}
	
	@Then("^User enters the expiry date$")
	public void user_enters_the_expiry_date() throws Throwable {
		driver.findElement(By.cssSelector(".select__wrapper .select:nth-of-type(1) .dropdown__toggle")).click();
		driver.findElement(By.cssSelector(".select__wrapper .select:nth-of-type(1) .ng-star-inserted:nth-of-type(2) .dropdown-item__label")).click();
		driver.findElement(By.cssSelector(".select__wrapper > div:nth-of-type(2) > ry-dropdown  .b2.dropdown__toggle")).click();
		driver.findElement(By.cssSelector(".select__wrapper .select:nth-of-type(2) .ng-star-inserted:nth-of-type(2) .dropdown-item__label")).click();
	}

	@Then("^User enters the Security code$")
	public void user_enters_the_Security_code() throws Throwable {
		driver.findElement(By.cssSelector("[data-ref='verification-code__input'] [type]")).sendKeys("123");
	}

	@Then("^User enters the Cardholder name$")
	public void user_enters_the_Cardholder_name() throws Throwable {
		driver.findElement(By.cssSelector("card-details [type='text']")).sendKeys("Test Name");
	}

	@Then("^User enters address$")
	public void user_enters_address() throws Throwable {
		driver.findElement(By.cssSelector("[data-ref='add-card-modal__address-line-1'] [type]")).sendKeys("Test Address");
	}

	@Then("^User enters city$")
	public void user_enters_city() throws Throwable {
		driver.findElement(By.cssSelector("[data-ref='add-card-modal__city'] [type]")).sendKeys("Dublin");
	}
	
	@Then("^User enters country$")
	public void user_enters_country() throws Throwable {
		driver.findElement(By.xpath("//app-root/ng-component/ry-spinner//payment-form/form//payment-methods[@class='ng-star-inserted']//ry-tabs[@class='ng-star-inserted']//add-method-modal[@class='ng-star-inserted']/form//billing-address/address-form/form/ry-autocomplete//input[@type='text']")).sendKeys("Ireland" + Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[data-ref='add-card-modal__postcode'] [type]")).sendKeys("X91 X367");	
	}

	@Then("^User selects the EUR from Currency dropdown$")
	public void user_selects_the_EUR_from_Currency_dropdown() throws Throwable {
		driver.findElement(By.cssSelector("[formcontrolname='foreignCurrencyCode'] .dropdown__toggle")).click();
		driver.findElement(By.cssSelector("[formcontrolname='foreignCurrencyCode'] .ng-star-inserted:nth-of-type(1) .dropdown-item__label")).click();
	}

	@Then("^User marks the terms and conditions agreement$")
	public void user_marks_the_terms_and_conditions_agreement() throws Throwable {
		driver.findElement(By.cssSelector("[for='termsAndConditions'] ._background")).click();
	}

	@Then("^User clicks on Pay now$")
	public void user_clicks_on_Pay_now() throws Throwable {
		driver.findElement(By.cssSelector(".pay-button.ry-button--gradient-yellow")).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^User should be displayed payment decline message$")
	public void user_should_be_displayed_payment_decline_message() throws Throwable {
	Thread.sleep(7000);
	WebElement errorMessage = driver.findElement(By.cssSelector("[data-ref='payment-methods__error-message'] .b2"));
	Assert.assertEquals(true, errorMessage.isDisplayed());
	}

}
