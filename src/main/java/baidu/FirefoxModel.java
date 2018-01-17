package baidu;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;


/**
 * Created by tangyaru on 2017/12/15.
 */
public class FirefoxModel {

    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.gecko.driver","/Users/tangyaru/Documents/geckodriver");
        final WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
//        driver.manage().window().maximize();
//        driver.navigate().to("http://www.baidu.com");
        //隐式等待  缺点：等待期间什么也不干，干等 一般不用
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //暂停5秒
        //显示等待
//        WebDriverWait wait = new WebDriverWait(driver, 10, 100);//第三个参数把默认500ms找一次改为100ms
//        List<WebElement> waitlist = (List<WebElement>) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("kw")));//在10s内查找（500ms找一次），找不到抛出超时异常
        //自定义条件等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.id("xx"));
            }
        });


        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//页面加载30s没有启动测试用例就会失败 防止网络延迟导致测试用例执行失败
//        driver.findElement(By.id("kw")).sendKeys("selenium");
//        driver.findElement(By.name("wd")).sendKeys("selenium");
//        driver.findElement(By.id("kw")).sendKeys("selenium");
//        driver.findElement(By.className("s_ipt")).sendKeys("selenium");
//        driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("test233333");
//        driver.findElement(By.cssSelector("#kw")).sendKeys("1");
//        driver.findElement(By.tagName("input")).sendKeys("test");
//        driver.findElement(By.cssSelector("input[value='百度一下']")).click();
        String serchHandle = driver.getWindowHandle();
        System.out.println(serchHandle);
        Thread.sleep(5000);
//        String href = driver.findElement(By.cssSelector("[name=tj_trnews]")).getAttribute("href");
//        System.out.println(href);
//        c
//        executor.executeScript("window.location.href='" + href + "'");  //js在当前页打开新页面
        driver.get("https://www.cnblogs.com/pick/");
        driver.navigate().back(); //回退上一个页面
        driver.navigate().forward();//前进上个页面



//        driver.quit(); //关闭整个浏览器，close（）关闭当前窗口
        //driver.close();



    }


}


