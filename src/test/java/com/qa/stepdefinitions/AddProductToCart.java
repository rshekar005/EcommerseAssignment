package com.qa.stepdefinitions;

import com.qa.page.DashbaordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;

public class AddProductToCart {
    DashbaordPage dashbaordPage = new DashbaordPage();

    LoginPageDefinition loginPageDefinition = new LoginPageDefinition();

    @Given("user is in dashboard screen")
    public void user_is_in_dashboard_screen() throws IOException, InterruptedException {
        loginPageDefinition.user_is_on_sign_up_page_and_entered_useremail_from_and_romnumber("Login", 0);
        loginPageDefinition.clicked_on_continue_button();
        loginPageDefinition.entered_password_from_and_romnumber("Login", 0);
        loginPageDefinition.click_on_submit_button();
        Thread.sleep(5000);
        System.out.println("User is in dashboard page");
    }

    @And("user enters product name {string} in text box and selects a product")
    public void user_enters_product_name_in_text_box_and_selects_a_product(String arg0) throws InterruptedException {
        dashbaordPage.searchProduct(arg0);
    }

    @Then("Select a product and verify the product value")
    public void select_a_product_and_verify_the_product_value() {
        dashbaordPage.getPriceAmountAndThenClick();
    }

    @And("user clicks on add to cart option")
    public void user_clicks_on_add_to_cart_option() {
        dashbaordPage.clickOnAddToCart();
    }

    @And("then checkout and verify the added product value")
    public void then_checkout_and_verify_the_added_product_value() throws InterruptedException {
        String amount = dashbaordPage.clickOnProceed();
        Thread.sleep(2000);
        System.out.println("Total amount is " + amount);
        Assert.assertEquals("₹71,990.00",amount);
    }


}
