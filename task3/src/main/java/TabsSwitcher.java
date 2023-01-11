import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsSwitcher {

    public static void switchToAnotherTab() {
        WebDriver driver = getDriver();
        //get current tab handle
        String oldTab = driver.getWindowHandle();
        //get handle of another tab
        String newTab = driver.getWindowHandles().stream().filter(s -> !s.equals(oldTab)).findFirst().orElse(null);
        //throw exception if new tab is not present
        if(newTab == null) {
            throw new RuntimeException("There is only one tab");
        }
        // change focus to the new tab
        driver.switchTo().window(newTab);
    }

    //todo move driver instance creation to a separate class and correct it
    public static WebDriver getDriver() {
        return new ChromeDriver();
    }

}
