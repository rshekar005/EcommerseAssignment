package com.qa.page;

import com.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class SignPage extends BasePage {
    private By username= By.id("ap_email");
    private By continueButton =By.id("continue");


    public SignPage enterUserName(String userName){
        doSendKeys(username, userName,WaitStrategy.PRESENCE);
        return  this;
    }

    public PasswordPage clickContinue(){
        doClick(continueButton,WaitStrategy.CLICKABLE);
        return new PasswordPage();
    }
}
