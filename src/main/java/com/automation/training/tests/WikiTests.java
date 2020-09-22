package com.automation.training.tests;

import com.automation.training.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.training.pages.ArticlePage;
import com.automation.training.pages.WikiHomePage;

public class WikiTests extends BaseTests{
	

	
	@Test
	public void testWikiSearch() {
		WikiHomePage home = getWikiHomePage();
		ArticlePage articlePage = home.buscar("Java");
		Assert.assertEquals(articlePage.getPageTitle(), "Java");
	}

	@Test
	public void testWikiSearchHelloWorld() {
		WikiHomePage home = getWikiHomePage();
		ArticlePage articlePage = home.InternalSearch("Hello World");
		Assert.assertEquals(articlePage.getPageTitle(), "\"Hello, World!\" program");
	}

}
