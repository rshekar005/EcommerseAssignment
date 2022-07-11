package com.qa.page;

import com.qa.enums.WaitStrategy;
import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DashbaordPage extends BasePage {

    private final By userNameInDashbaord = By.xpath("//span[contains(text(),'Test')]");
    private final By textBox = By.id("twotabsearchtextbox");
    private final By searchList = By.xpath("//div[@class='s-suggestion-container']");
    private final By priceAmount = By.xpath("(//span[@class='a-price-whole'])[1]");
    private final By addToCart = By.id("add-to-cart-button");
    private final By checkout = By.id("attach-sidesheet-checkout-button");
    private final By toTalAmount = By.id("attach-accessory-cart-subtotal");

    public String getUserName() {
        return getText(userNameInDashbaord, WaitStrategy.VISIBLE);
    }

    public void searchProduct(String productName) throws InterruptedException {
        doSendKeys(textBox, productName, WaitStrategy.VISIBLE);
        Thread.sleep(2000);
        List<WebElement> productList = DriverFactory.getDriver().findElements(searchList);
        System.out.println(productList.size());
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).getText());
            if (productList.get(i).getText().equals(productName)) {
                Thread.sleep(2000);
                productList.get(i).click();
                break;
            }
        }
    }

    public void getPriceAmountAndThenClick() {
        String amount = DriverFactory.getDriver().findElement(priceAmount).getText();
        doClick(priceAmount, WaitStrategy.CLICKABLE);
    }

    public void clickOnAddToCart() {
        String parentwindow = DriverFactory.getDriver().getWindowHandle();
        Set<String> childWindows = DriverFactory.getDriver().getWindowHandles();
        System.out.println(parentwindow);
        System.out.println(childWindows.size());
        Iterator<String> itr = childWindows.iterator();
        while (itr.hasNext()) {
            String childwindow = itr.next();
            if (!parentwindow.equals(childwindow)) {
                System.out.println(DriverFactory.getDriver().switchTo().window(childwindow));
                WebElement element = DriverFactory.getDriver().findElement(addToCart);
                JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
                js.executeScript("arguments[0].scrollIntoView(true);", element);
                doClick(addToCart, WaitStrategy.CLICKABLE);
            }

        }
    }

    public String clickOnProceed() throws InterruptedException {
        Thread.sleep(2000);
        return DriverFactory.getDriver().findElement(toTalAmount).getText();
    }
}
