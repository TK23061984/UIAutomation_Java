package uiFramework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;





public class UIChromeDriver extends ChromeDriver{

	protected UIChromeDriver()
	{
		super();
	}
	
	protected void StartBrowser()
	{
		int browserCount = super.getWindowHandles().size();
		if (browserCount == 0)
        {
            try
            {
                super.startClient();
            }
            catch(Exception ex)
            {
                throw ex;
            }
        }
        else
        {
        	DesiredCapabilities capabilities = new DesiredCapabilities();
            super.startSession(capabilities);
        }
		super.manage().window().maximize();
	}
	
	/// <summary>
    /// Will stop the current browser
    /// </summary>
    protected void closeBrowser()
    {
        super.stopClient();
    }

    /// <summary>
    /// Takes a screenshot of the current
    /// </summary>
    /// <returns></returns>
    protected void takeScreenshot(String filename)
    {    	
    	File scrFile = super.getScreenshotAs(OutputType.FILE);
    	try {
			FileUtils.copyFile(scrFile, new File(filename));
		} catch (IOException e) {		
			e.printStackTrace();
		}
        
    }
}