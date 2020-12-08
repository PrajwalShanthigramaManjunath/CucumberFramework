Feature: Booking the flight
	User should be able to book the flight by searching the availaible flights
	
Scenario: Declined payment
Given User navigates to Ryanair website 
And User accepts cookies  
And User enters the valid airport in From
And User enters the valid airport in To
And User selects One way trip
And User selects depart date
And User selects the number of Passengers
And User clicks on the search button
Then the User clicks on the desired flight
And User clicks on Continue with Value fare button
Then User clicks on Log in button
Then User enters the valid email address
And User enters the valid password
Then User selects the title
And User enters the First Name
And User enters the Last Name
And User clicks on continue button
Then User clicks on Random seat allocation
And User clicks on I want random seat allocation
Then User selects 1 Small Bag only
And click on Continue button
And click on continue Button
And User navigates to basket symbol
And User clicks on Check out button
Then User enters the contact number
And User selects I don't want to be insured
And User enters the invalid card number
And User enters the expiry date    
And User enters the Security code
And User enters the Cardholder name
And User enters address
And User enters city
And User enters country 
And User selects the EUR from Currency dropdown
And User marks the terms and conditions agreement
When User clicks on Pay now
Then User should be displayed payment decline message 