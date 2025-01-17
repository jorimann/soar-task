package ui.tests;

import ui.factories.AddressFactory;
import ui.factories.CreditCardFactory;
import ui.factories.UserDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import ui.models.*;
import ui.pages.*;

import java.util.*;

public class WebTests extends BaseTest {
    Logger LOGGER = LoggerFactory.getLogger(WebTests.class);
    @Test
    public void task1() {
        // 1. navigate to provided web application
        // 2. Scroll down to the end of page
        // 3. Change items per page to the maximum number
        // 4. assert that home page displays all of items
        final int MAX_ITEMS_ON_PAGE = 48;
        int numberOfAvailableProducts = productsPage.getExpectedNumberOfProductsAvailable();

        productsPage.selectItemsPerPage(MAX_ITEMS_ON_PAGE);

        int numberOfProductsOnPage = productsPage.getCountOfProductsOnPage();

        if (numberOfAvailableProducts > MAX_ITEMS_ON_PAGE){
            Assertions.assertEquals(MAX_ITEMS_ON_PAGE,numberOfProductsOnPage);
        } else {
            Assertions.assertEquals(numberOfAvailableProducts, numberOfProductsOnPage);
        }
    }

    @Test
    public void task2() {
        // 1. Click on the first product ‘Apple Juice’
        // 2. Then assert that there is an popup appeared and image of product exists.
        // 3. Then if there is an review click on it to expand this review.
        // 4. Wait for couple of second then close product form.
        final String APPLE_JUICE_PRODUCT = "Apple Juice";
        final int COUPLE_SECONDS = 2000;

        productsPage.clickProductByName(APPLE_JUICE_PRODUCT);
        Assertions.assertTrue(productsPage.isImagePresent("apple_juice.jpg"));
        productsPage.openReviewsSectionIfExists();
        try {
            Thread.sleep(COUPLE_SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productsPage.closeProductCard();
    }

    @Test
    public void task3() {
        // 1. script that navigates to user registration page
        // 2. assert that frontend team added an input validation by clicking on all fields without
        // adding any values on it this must trigger a validation message.
        // 3. Fill registration form fields with required data [Self Generated Information] and click on show password advice then register to application.
        // 4. Assert the successful message of registration.
        // 5. App will redirect to login page use same generated information to login to web application.
        User user = UserDataFactory.getRandomUser();

        LoginPage loginPage = productsPage.goToLoginPage();
        loginPage.clickEmailField();
        loginPage.clickPasswordField();
        Assertions.assertTrue(loginPage.isEmailAbsenseErrorPresent());
        loginPage.clickEmailField();
        Assertions.assertTrue(loginPage.isPasswordAbsenseErrorPresent());

        UserRegistrationPage registrationPage = loginPage.goToUserRegistration();
        registrationPage.populateUserData(user);
        loginPage = registrationPage.completeRegistration();
        Assertions.assertTrue(loginPage.isConfirmationMessagePresent());
        productsPage = loginPage.login(user);
        Assertions.assertEquals(user.email(), productsPage.topMenu.getUserEmail());
    }

    @Test
    public void task4() {
        // 1. login via valid generated credentials
        // 2. at product page add five different product to basket
        // 3. assert that cart number changed to five
        // 4. assert that a there is a success popup message appearing at every time you add product to basket.
        // 5. Navigate to your basket and increase number of any product then delete it from basket
        // 6. assert that total price has been changed.
        // 7. The final step click on checkout and add address information then select delivery method.
        // 8. App will navigate to payment screen assert that your wallet has no money so select option to add a credit card information then continue purchase.
        // 9. Note: Generate random card information will be accepted.
        final int COUNT_OF_PRODUCTS_TO_SELECT = 5;

        User user = UserDataFactory.getRandomUser();
        Address address = AddressFactory.getAddress();
        DeliveryMethod deliveryMethod = DeliveryMethod.getRandomDeliveryMethod();
        CreditCard card = CreditCardFactory.getCard(user.fullName());

        LoginPage loginPage = registerNewUser(user);
        productsPage = loginPage.login(user);
        List<String> productsOnPage = productsPage.getListOfProductsOnPage(false);
        Assertions.assertTrue(productsOnPage.size() >= COUNT_OF_PRODUCTS_TO_SELECT);

        Collections.shuffle(productsOnPage);
        for (int i = 0; i < COUNT_OF_PRODUCTS_TO_SELECT; i++) {
            productsPage.addProductToBasket(productsOnPage.get(i));
        }

        Assertions.assertEquals(COUNT_OF_PRODUCTS_TO_SELECT, productsPage.topMenu.waitForCountOfProductsInBasket(COUNT_OF_PRODUCTS_TO_SELECT));

        BasketPage basketPage = productsPage.topMenu.goToBasketPage();
        basketPage.increaseQuantityOf(basketPage.getListOfProducts().get(0));
        double initialPrice = basketPage.getPriceTotal();
        basketPage.deleteProduct(basketPage.getListOfProducts().get(0));

        Assertions.assertEquals(COUNT_OF_PRODUCTS_TO_SELECT-1,
                productsPage.topMenu.waitForCountOfProductsInBasket(COUNT_OF_PRODUCTS_TO_SELECT-1));
        double currentPrice = basketPage.getPriceTotal();
        Assertions.assertTrue(currentPrice < initialPrice);

        AddressPage addressPage = basketPage.proceedWithCheckout();
        addressPage.addNewAddress(address);
        addressPage.selectAddress(address.name());
        addressPage.continueToDelivery();
        addressPage.selectDeliveryOption(deliveryMethod.toString());
        PaymentPage paymentPage = addressPage.continueToPayment();
        paymentPage.addPayment(card);
        paymentPage.selectPaymentOption(card.cardNumber().substring(card.cardNumber().length() - 4));
        OrderSummaryPage orderSummaryPage = paymentPage.continuerOrder();
        OrderCompletionPage orderCompletionPage = orderSummaryPage.placeOrderAndPay();
        Order actualOrder = orderCompletionPage.getOrderSummary();
        double deliveryPrice = deliveryMethod.getPrice();
        Assertions.assertEquals((double) Math.round((currentPrice + deliveryPrice) * 100) / 100, actualOrder.totalCost());
    }

    private LoginPage registerNewUser(User user) {
        LoginPage loginPage = productsPage.goToLoginPage();
        UserRegistrationPage registrationPage = loginPage.goToUserRegistration();
        registrationPage.populateUserData(user);
        return registrationPage.completeRegistration();
    }


}
