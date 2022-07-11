package com.qa.page;

import com.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class PasswordPage extends BasePage {
    private By password = By.id("ap_password");
    private By submit = By.id("signInSubmit");

    public PasswordPage enterPassword(String Password) {
        doSendKeys(password, Password, WaitStrategy.PRESENCE);
        return this;
    }

    public void clickSubmit() {
        doClick(submit, WaitStrategy.CLICKABLE);
    }
}
