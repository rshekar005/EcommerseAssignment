package com.qa.enums;

/**
 * Enums to restrict the users to choose an appropriate waiting strategy before operating an element.
 * 
 * @author rajasekhar
 * @see com.qa.factory.ExplicitWaitFactory
 */
public enum WaitStrategy {
	
	CLICKABLE,
	PRESENCE,
	VISIBLE,
	NONE;
}
