

| Task | Link | Status |
| ----- | ----- | :---: |
| Functional Test |  | Done  |
| E2E Web Automation |  | Done |
| E2E Mobile Automation  |  | Done |
| Logical and security testing  |  | Not Done |
| Performance Testing  |  | Not Done |
| Test management |  | Done |

# Functional Test

## Exploration testing of [Juice-chop web store](https://juice-shop.herokuapp.com/#/)

**Note**: 

1. Testing was performed on local server. Browser: Chrome 131\. OS: MacOS 15.2
2. Because of timepressusre there are only Bug Summaries provided. 

### Exploratory Test Charters:

1. Test the User Registration and Login-Logout Flow
2. Explore the Shopping Cart Functionality
3. Test the Checkout and Payment Process
4. Orders & Payment
5. Privacy & Security

### Bug Reports:

\[Bug-001\] \[S: 3, P: 3\] Registration: The hint about password length limitation (up to 20 characters) is incorrect. The actual limit is 40 characters.  
\[Bug-002\] \[S: 3, P: 3\] User Profile: Username is incorrectly displayed with a backslash on the Profile page.  
\[Bug-003\] \[S: 2, P: 1\] User Profile: Clicking on an image link without a URL results in a 500 Server Error.  
\[Bug-004\] \[S: 2, P: 2\] User Profile: The "Upload Picture" button remains active even when no file is selected.  
\[Bug-005\] \[S: 2, P: 3\] User Profile: Uploading a picture via URL works with a delay, requiring a page refresh.  
\[Bug-006\] \[S: 1, P: 1\] User Profile: The system does not handle large picture sizes gracefully, leading to a 500 Server Error.  
\[Bug-007\] \[S: 3, P: 2\] User Profile: Clicking the “Upload Picture” button without selecting a file causes an endless request to [http://localhost:3000/profile/image/file](http://localhost:3000/profile/image/file).  
\[Bug-008\] \[S: 2, P: 3\] User Profile: The profile image stretches to the full width of the browser.  
\[Bug-009\] \[S: 2, P: 2\] User Profile: The user image is not applied to the menu content (default avatar is still displayed).  
\[Bug-010\] \[S: 1, P: 1\] User Profile: The username is not reflected in the menu content (email is still displayed).  
\[Bug-011\] \[S: 1, P: 2\] Logout: The system does not handle back navigation gracefully after logging out, resulting in a 500 Server Error when navigating back from the User Profile page.  
\[Bug-012\] \[S: 1, P: 1\] Login: Google login is not working, showing 400 and 401 errors ([http://127.0.0.1:3000/api/Users/](http://127.0.0.1:3000/api/Users/) and [http://127.0.0.1:3000/rest/user/login](http://127.0.0.1:3000/rest/user/login) ).  
\[Bug-013\] \[S: 3, P: 3\] Forgot Password: The hints for the New Password and Repeat New Password fields state the password length limit is 20 characters, but the correct limit is 40 characters.  
\[Bug-014\] \[S: 2, P: 2\] User Profile: The top-right menu block is missing on the User Profile page.  
\[Bug-015\] \[S: 2, P: 3\] Add New Address: The mobile number field does not support international phone number formats.  
\[Bug-016\] \[S: 2, P: 2\] Add New Address: There is no validation for the country name field.  
\[Bug-017\] \[S: 3, P: 3\] Add to Basket Enhancement: The notification message about adding a product or the inability to add one is too small and not centered, making it easy to miss.  
\[Bug-018\] \[S: 2, P: 2\] Proceed Order | Select an Address: The radio button behavior is unconventional; double-clicking disables the “Continue” button while the address remains selected.  
\[Bug-019\] \[S: 2, P: 2\] Proceed Order | Select an Address: Clicking the right side of the radio button disables address selection.  
\[Bug-020\] \[S: 2, P: 2\] Order Summary: There is no button to navigate back and adjust the order (before it's placed). While back navigation is possible, it breaks UX consistency.  
\[Bug-021\] \[S: 3, P: 3\] Proceed Order | Choose a delivery speed: The user can proceed with an unchecked delivery option (e.g., by clicking the One Day Delivery label twice).  
\[Bug-022\] \[S: 2, P: 2\] Proceed Order | My Payment Options: The "Donations" button leads to a dead link ([https://pwning.owasp-juice.shop/part3/donations.html](https://pwning.owasp-juice.shop/part3/donations.html)).  
\[Bug-023\] \[S: 2, P: 2\] Proceed Order | My Payment Options: There is an inconsistency in design; when a credit card is selected as the payment method and the user has a wallet balance, the "Pay" button is still clickable, but the selected payment option is unclear.  
\[Bug-024\] \[S: 2, P: 2\] Proceed Order | My Payment Options: The "Pay using wallet" button displays “Pay NaN” when the user navigates back during order processing.  
\[Bug-025\] \[S: 3, P: 3\] Digital Wallet: Entering the first digit in the "Enter an Amount" field turns it green, but it violates the \>10 rule.  
\[Bug-026\] \[S: 1, P: 1\] My Payment Options | Add new card: The expiration year can only be selected within the range of 2080 to 2099\.  
\[Bug-027\] \[S: 1, P: 1\] Product Review: The user's email is exposed when submitting a review.  
\[Bug-028\] \[S: 1, P: 1\] Concern: No emails are sent regarding registration or order status. This might indicate an unintegrated service or a potential issue with the application systems.  
\[Bug-029\] \[S: 2, P: 3\] Request Recycling Box: The system allows the pickup date to be set in the past.  
\[Bug-030\] \[S: 1, P: 2\] Request Data Erasure: The function works inconsistently; it logs the user out after requesting data erasure, but the account and data remain in the system.  
\[Bug-031\] \[S: 1, P: 2\] Last Login IP: The last login IP functionality does not work, and the IP address remains undefined.  
\[Bug-032\] \[S: 1, P: 2\] Deluxe Membership: There is no information in the order history regarding the purchase of Deluxe Membership.  
\[Bug-033\] \[S: 2, P: 2\] Deluxe Membership: Users cannot add products to the basket immediately after purchasing Deluxe Membership (401 Error). The user should be prompted to log in again.  
\[Bug-034\] \[S: 3, P: 2\] Request Recycling Box: The page contains stubbed text.  
\[Bug-035\] \[S: 2, P: 2\] Request Data Export: Export to PDF and Excel formats is disabled.

## Exploration testing of wikiapp application

**Note**:

1. Testing was performed on Emulator because application’s target Android version 7\. App is outdated and it may lead to security breaches and compatibility issues.
2. App fails to deliver core functionality. The current version is not suitable for user use and should not be presented to users.
3. Because of timepressusre there are only Bug Summaries provided.

### Exploratory Test Charters

1. Navigation & Basic Functionality Testing
2. Content Section Testing
3. Featured Article Testing

### Bug Reports:

\[Bug-036\] \[S: 2, P: 2\] Account Creation: Tapping the "Expose Password" button causes the 'Repeat Password' field to disappear.  
\[Bug-037\] \[S: 1, P: 1\] Support: The Wikipedia link in the app does not work.  
\[Bug-038\] \[S: 1, P: 1\] Log in to Wikipedia: The Privacy Policy link does not work.  
\[Bug-039\] \[S: 1, P: 2\] Nearby: The “Invalid value ‘6133.72182653217’ for integer parameter ‘ggsradius’” error prevents the Nearby functionality from working correctly.  
\[Bug-040\] \[S: 1, P: 1\] Wikipedia Articles: All Wikipedia articles display an "An Error Occurred" screen instead of content when the device is connected to the Internet.  
\[Bug-041\] \[S: 2, P: 2\] Offline Mode: The app does not show any notification when it is in offline mode.  
\[Bug-042\] \[S: 3, P: 2\] Share Featured Article: The app minimizes when attempting to share the Featured Article.  
\[Bug-043\] \[S: 2, P: 2\] Share Trending Article: The app minimizes when attempting to share any article from the Trending Card.  
\[Bug-044\] \[S: 3, P: 3\] News Feed Refresh: All cards disappear when the user hides the first several cards and three cards after the Randomizer component, then pulls down to refresh the News feed. The app needs to be reinstalled to restore functionality.

# E2E Web Automation

1. Tests are placed here: [https://github.com/jorimann/soar-task](https://github.com/jorimann/soar-task)
2. Test settings can be found in config.properties file
3. Production version is quite unstable. It is recommended to setup and run local version ([https://github.com/juice-shop/juice-shop](https://github.com/juice-shop/juice-shop))
4. To run web tests perform **./gradlew clean assemble webTests** command
5. Requirements:
    1. Java 17
    2. Gradle 8

# E2E Mobile Automation

1. Tests are placed here: [https://github.com/jorimann/soar-task](https://github.com/jorimann/soar-task)
2. Test settings can be found in config.properties file
3. To run web tests perform **./gradlew clean assemble androidTests** command
4. Requirements:
    1. Appium Server is up and running
    2. Emulator with suitable OS is up and running
    3. Java 17
    4. Gradle 8
       
# Logical and security testing

There was challenge itself to make app up and running in absence of setup instructions. I was manage to run application, but there were not enough time to perform task.

# Performance Testing

Not completed becasue of lack of time

# Test Management 
* Test Plan Document: [Test Plan (md version)](https://github.com/jorimann/soar-task/blob/main/Test%20Plan.md)
* Test Plan Document: [Test Plan (pdf version)](https://raw.githubusercontent.com/jorimann/soar-task/main/Soar%20Test%20Plan.pdf)
* Risks, Test Cases, Test Runs: [Google Sheet Document](https://docs.google.com/spreadsheets/d/16lyosNcRrLplU_6aTnfpJ2v3tThUPetKDS_esZxmwi4/edit?usp=sharing)

