package baidu;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.*;

import java.util.concurrent.TimeUnit;
import java.lang.Thread;


/**
 * Created by tangyaru on 2017/12/15.
 */
public class test {

    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.gecko.driver","/Users/tangyaru/Documents/geckodriver");
        WebDriver driver = new FirefoxDriver();
//        driver.get("http://www.baidu.com");
        driver.navigate().to("http://www.baidu.com");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); //暂停10秒
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//页面加载30s没有启动测试用例就会失败 防止网络延迟导致测试用例执行失败
//        driver.findElement(By.id("kw")).sendKeys("selenium");
//        driver.findElement(By.name("wd")).sendKeys("selenium");
//        driver.findElement(By.id("kw")).sendKeys("selenium");
//        driver.findElement(By.className("s_ipt")).sendKeys("selenium");
//        driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("test233333");
        driver.findElement(By.cssSelector("#kw")).sendKeys("1");
//        driver.findElement(By.tagName("input")).sendKeys("test");
        driver.findElement(By.cssSelector("input[value='百度一下']")).click();
        Thread.sleep(5000);

        driver.quit();

    }

}

