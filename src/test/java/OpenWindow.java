import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Suite;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangyaru on 2017/12/28.
 *
 * 三大浏览器开启和基本操作
 * 隐式等待   自定义等待
 * 页面加载时间设置（防止网络延迟导致测试用例执行失败）
 * 前进／回退页面
 * 运行js
 * 截屏
 * Actions类 鼠标键盘操作
 * alert、confirm、prompt对话框
 * iframe／frame 里元素定位
 * 多个窗口 切换
 *
 * 管理测试用例 打包指定需要执行测试的类  第一种------使用annotation
 */
//@Suite.SuiteClasses({a.class,b.class})  只要该行代码就可以整合测试 可以把之前所有的写好的test class类进行集成 单元测试类a、b都会被运行
@RunWith(value = BlockJUnit4ClassRunner.class)  //这句话不写也可以 因为默认的 测试方法被封装到BlockJUnit4ClassRunner类里
public class OpenWindow {
    private WebDriver driver = new FirefoxDriver();

    @Test(timeout = 5000)         //500ms没执行完测试用例就抛出异常
    public void testFirefox(){
        /**
         * firefox打开页面
         *
         * 网络延迟导致测试用例失败  时间设置
         *
         * 回退  前进页面
         */
        //WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); //暂停10秒
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//页面加载30s没有启动测试用例就会失败 防止网络延迟导致测试用例执行失败
        driver.get("https://www.cnblogs.com/pick/");
        driver.navigate().back(); //回退上一个页面
        driver.navigate().forward();//前进上个页面

    }
    @Test
    public void testChrome(){
        /**
         * 在/usr/local/bin目录下有chrome启动插件，插件与浏览器要对应版本
         *
         * 不把插件移到默认位置，可以按下面处理：
         * System.setProperty("webdriver.chrome.driver","/Users/tangyaru/Documents/chromedriver");
         */
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); //暂停10秒（不建议使用隐式等待） 此处设置的等待时间 是针对全局设置的
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//页面加载30s没有启动测试用例就会失败 防止网络延迟导致测试用例执行失败
        driver.get("https://www.cnblogs.com/pick/");
        driver.navigate().back(); //回退上一个页面
        driver.navigate().forward();//前进上个页面

    }
    @Test(expected = ArithmeticException.class) //如果有ArithmeticException异常会显示测试通过 没有该异常测试会不通过
    public void testJS(){
        /**
         * 运行js代码
         */
        //WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        String href = "https://www.cnblogs.com/pick/";
//        js.executeScript("window.open('" + href + "')");  //js在新窗口打开页面
        WebElement input  = (WebElement)js.executeScript("document.getElementById(\"j_username\")");
        System.out.println(input);
//        input.sendKeys("11");
//        input.submit();

    }
    @Test
    public void testScreen() throws IOException {
        /**
         * 截屏
         */
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);//截屏保存在磁盘中
        OutputStream out = new FileOutputStream("/Users/tangyaru/IdeaProjects/testweb/picture.jpg");
        FileUtils.copyFile(file, out);//把磁盘中图片copy到目标位置
    }
    @Test
    public void testAction() throws InterruptedException {
        /**
         * Actions类 鼠标键盘操作
         */
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("#s_mp>area"));

        //双击某个元素
        actions.doubleClick(element).build().perform(); //省去build()也可以：actions.doubleClick(element).perform();

    }
    @Test
    public void testPredicate(){
        /**
         * 自定义等待
         */
        WebDriver driver = new FirefoxDriver();
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(100,TimeUnit.MILLISECONDS).withTimeout(10,TimeUnit.SECONDS);
//        wait.until(new Function<WebDriver, WebElement>() {
//
//        });
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                /**
                 * 可以写js代码 判断元素是否加载完成 再进行定位元素
                 */
                return webDriver.findElement(By.id("xx"));
            }
        });
    }
    @Test
    public void testAlertButton(){
        /**
         * alert对话框
         */
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Web/");
        WebElement alertEle = driver.findElement(By.id("alert"));
        alertEle.click();
        Alert alert = driver.switchTo().alert();
        String textAlert = alert.getText();
        System.out.println(textAlert);
        //alert.accept(); //相当于点击它的"确认"
        alert.dismiss();  //相当于点击"取消"或者叉掉对话框

    }
    @Test
    public void testConfirm(){
        /**
         * confirm对话框
         */
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Web/");
        driver.findElement(By.id("confirm")).click();
        Alert confirm = driver.switchTo().alert();
        String testConfirm = confirm.getText();
        System.out.print(testConfirm);
        //confirm.accept();
        confirm.dismiss();

    }
    @Test
    public void testPrompt(){
        /**
         * prompt对话框
         */
        WebDriver driver =  new FirefoxDriver();
        driver.get("http://localhost:8080/Web/");
        driver.findElement(By.id("prompt")).click();
        Alert prompt = driver.switchTo().alert();
        String text = prompt.getText();
        System.out.print(text);
        prompt.sendKeys("李四");
        prompt.accept();
    }
    @Test
    public void testFrame(){
        /**
         * iframe／frame 里元素定位
         */
       // WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Web/iframeMain.html");
        driver.switchTo().frame("frameA");
        driver.findElement(By.xpath(".//*[@id='iframeinput']"));//没有上面一行代码会报错

    }
    @Test
    public void testWindow() throws InterruptedException {
        /**
         * 多个窗口 切换
          */
       // WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com/");
        String firstHandel = driver.getWindowHandle();//保存第一个窗口
        System.out.println("第一个窗口"+firstHandel);
        driver.findElement(By.xpath(".//*[@id='head']/div/div/div/div/img")).click(); //通过点击操作打开新窗口
        Set<String> winHandels = driver.getWindowHandles(); //获取所有窗口

        //第一种方法把winHandeks变成可迭代对象 通过索引切换
//        List<String> it = new ArrayList<String>(winHandels);
//        driver.switchTo().window(it.get(1));
//        Thread.sleep(1000);
//        String url = driver.getCurrentUrl();
//        System.out.println(url);
//        driver.switchTo().window(it.get(0));//切换到第一个窗口
        //driver.switchTo().window(firstHandel); //该方法也是切换到第一个窗口

        //第二张方法
        Iterator<String> iter = winHandels.iterator();
        String temp;
        Thread.sleep(1000);
        while(iter.hasNext()){
            temp = iter.next();
            if (temp.equals(firstHandel)){
                driver.switchTo().window(temp);
            }

        }
    }














}
