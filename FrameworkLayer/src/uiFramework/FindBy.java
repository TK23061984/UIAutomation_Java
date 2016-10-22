package uiFramework;

import org.openqa.selenium.By;

public class FindBy {

	protected By GetBy(FindType findType, String valueToFind)
	{
		By by = null;
		switch (findType)
		{
			case ClassName:
				{
					by = By.className(valueToFind);
					break;
				}
			case CssSelector:
				{
					by = By.cssSelector(valueToFind);
					break;
				}
			case Id:
				{
					by = By.id(valueToFind);
					break;
				}
			case LinkText:
				{
					by = By.linkText(valueToFind);
					break;
				}
			case Name:
				{
					by = By.name(valueToFind);
					break;
				}
			case PartialLinkText:
				{
					by = By.partialLinkText(valueToFind);
					break;
				}
			case TagName:
				{
					by = By.tagName(valueToFind);
					break;
				}
			case XPath:
				{
					by = By.xpath(valueToFind);
					break;
				}
		}
		return by;
	}


/// <summary>
/// Enum to select the mechanism to search for an element
/// </summary>
public enum FindType
{
	ClassName,
	CssSelector,
	Id,
	LinkText,
	Name,
	PartialLinkText,
	TagName,
	XPath,
    Undefined
}
	
}
