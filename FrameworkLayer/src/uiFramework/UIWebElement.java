package uiFramework;

import org.openqa.selenium.WebElement;

import common.Log;
import uiFramework.FindBy.FindType;


public class UIWebElement {
			
	private WebElement _element = null;
	private Log _log = null;
	
	public UIWebElement(WebElement element,Log logger)
	{
		_log = logger;
	}
	
			/// <summary>
			/// Finds descendent element
			/// </summary>
			/// <param name="findType">Method to use for searching for the child element</param>
			/// <param name="valueToFind">Value of the search method</param>
			/// <returns>WebElement child</returns>
			public UIWebElement findElement(FindType findType, String valueToFind)
			{
				return findElement(findType, valueToFind, 1500);
			}

			/// <summary>
			/// Finds descendent element
			/// </summary>
			/// <param name="findType">Method to use for searching for the child element</param>
			/// <param name="valueToFind">Value of the search method</param>
			/// <param name="waitTime">Duration of time to search for the element</param>
			/// <returns>WebElement child</returns>
			public UIWebElement findElement(FindType findType, String valueToFind, int waitTime)
			{
				UIWebElement child = null;
					try
					{									 
	                    while (child == null) 
	                    {
	                        try
	                        {
	                            child = new UIWebElement(_element.findElement(new FindBy().GetBy(findType, valueToFind)), _log);
	                        }
	                        catch(Exception ex)
	                        {
	                        	throw ex;
	                        }
	                    }
					}
					catch (Exception e)
					{
						_log.info("[GetDescendentElement] NoSuchElementException caught: " + e.getMessage());
					}

				if (child != null)
				{
					_log.info(String.format("[GetDescendentElement] Found element with FindBy.{0} = {1}.", findType.toString(), valueToFind));
				}
				else
				{
					_log.info(String.format("[GetDescendentElement] Did not find element with FindBy.{0} = {1}.", findType.toString(), valueToFind));
				}
				return child;
			}


}
