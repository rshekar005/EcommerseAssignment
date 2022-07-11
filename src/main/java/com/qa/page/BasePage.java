package com.qa.page;

import com.qa.enums.WaitStrategy;
import com.qa.factory.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class BasePage {

	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * 
	 * It acts as a parent class for all page classes
	 * @author rajasekhar
	 * @param element By Locator of the webelement
	 * @param waitStrategy Strategy to find webelement. Known  strategies {@link WaitStrategy}
	 */
	
	protected void doClick(By element, WaitStrategy waitStrategy) {
		ExplicitWaitFactory.performExplicitWait(element, WaitStrategy.CLICKABLE).click();
	}
	
	/**
	 * Locates element by given wait strategy, sends the value to located webelement and
	 * writes the pass even to the extent report.
	 * @author rajasekhar
	 * @param element By Locator of the webelement
	 * @param value value to be send the text box
	 * @param waitStrategy Strategy to find webelement. Known  strategies {@link WaitStrategy}
	 */
	protected void doSendKeys(By element, String value , WaitStrategy waitStrategy) {
		ExplicitWaitFactory.performExplicitWait(element, waitStrategy).sendKeys(value);
	}

	protected String getText(By element, WaitStrategy waitStrategy){
		return ExplicitWaitFactory.performExplicitWait(element, waitStrategy).getText();
	}
}
