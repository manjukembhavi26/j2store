package one1;


import org.testng.annotations.Test;

import common.base;
import j2storepageobjects.homepage;

public class simpleone extends base{
	
	@Test
	public void CheckEndToEndApp() throws InterruptedException
	{
		homepage objecthome=new homepage(driver);
		objecthome.browseCategories();
		objecthome.browseBlogs();
		objecthome.addItemsToCart();
	}
	
	
	
	
}
