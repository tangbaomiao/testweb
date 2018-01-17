package baidu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by tangyaru on 2017/12/28.
 */
public class ChromeModel {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver","/Users/tangyaru/Documents/chromedriver");
        driver.get("http://www.baidu.com");
        driver.get("https://www.cnblogs.com/pick/");
        driver.navigate().back();
//        Set<String> winHandels = driver.getWindowHandles();
//        List<String> it = new ArrayList<String>(winHandels);
//        driver.switchTo().window(it.get(1));
//        Thread.sleep(1000);
//        String url = driver.getCurrentUrl();
//        System.out.println(url);
//        driver.switchTo().window(it.get(0));


    }

}
