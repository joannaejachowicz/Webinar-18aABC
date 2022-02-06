package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static boolean takeScreenshot(WebDriver driver, String filePath) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(screenshot, new File(filePath));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
