package com.qa.factory;

import com.qa.constants.FrameWorkConstants;
import com.qa.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Explicit wait factory produces different waits before operating on webelement
 *
 * @author rajasekhar
 */
public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
    }

    /**
     * @param waitStrategy Strategy to be applied to find a webelement {@link com.qa.enums.WaitStrategy}
     * @param locator      By locator of the webelement
     * @author rajasekhar
     */
    public static WebElement performExplicitWait(By locator, WaitStrategy waitStrategy) {
        WebElement element = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(FrameWorkConstants.getExplicitwait()))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(FrameWorkConstants.getExplicitwait()))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(FrameWorkConstants.getExplicitwait()))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
        } else {
            element = DriverFactory.getDriver().findElement(locator);
        }
        return element;
    }

}
