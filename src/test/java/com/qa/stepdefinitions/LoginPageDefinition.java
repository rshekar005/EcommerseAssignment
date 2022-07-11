package com.qa.stepdefinitions;

import com.qa.constants.FrameWorkConstants;
import com.qa.factory.DriverFactory;
import com.qa.page.DashbaordPage;
import com.qa.page.PasswordPage;
import com.qa.page.SignPage;
import com.qa.util.ExcelReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginPageDefinition {

    SignPage signPage = new SignPage();
    PasswordPage passwordPage = new PasswordPage();
    DashbaordPage dashbaordPage = new DashbaordPage();

    ExcelReader reader = new ExcelReader();


    @Given("user is on signUp page and entered useremail from {string} and romnumber {int}")
    public void user_is_on_sign_up_page_and_entered_useremail_from_and_romnumber(String sheetName, Integer rowNumber) throws IOException {
        List<Map<String, String>> data = reader.getData(FrameWorkConstants.getExcelpath(), sheetName);
        String username = data.get(rowNumber).get("username");
        signPage.enterUserName(username);
    }

    @And("clicked on continue button")
    public void clicked_on_continue_button() {
        signPage.clickContinue();
    }

    @Then("user navigated to password screen")
    public void user_navigated_to_password_screen() throws IOException {
        System.out.println("User is in Password Page");
        }

    @And("entered password from {string} and romnumber {int}")
    public void entered_password_from_and_romnumber(String sheetName, Integer rowNumber) throws IOException {
        List<Map<String, String>> data = reader.getData(FrameWorkConstants.getExcelpath(), sheetName);
        String password= data.get(rowNumber).get("password");
        passwordPage.enterPassword(password);
    }

    @And("click on submit button")
    public void click_on_submit_button() throws InterruptedException {
        passwordPage.clickSubmit();
        String userName = dashbaordPage.getUserName();
        System.out.println(userName);
        String[] str = userName.split(",");
        String expectedValue = str[1];
        Assert.assertEquals("TestUser", expectedValue.trim());
        Thread.sleep(5000);
    }
}
