package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;

	
	public TestContextSetup() throws IOException
	{
		//Creating Object of TestBase class
		testBase = new TestBase();
		
		//Creating Object of PageObjectManager Class and passing driver object in the form of 'testBase.WebDriverManager()'
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		
		//Creating Object of GenericUtils Class and provided driver Object in the form of 'testBase.WebDriverManager()'
		genericUtils = new GenericUtils(testBase.WebDriverManager());
		
		
		

	}
	
}
