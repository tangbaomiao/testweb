import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tangyaru on 2018/1/16.
 *
 * Junit运行原理：也是先编译测试类，然后测试类作为一个参数传给JunitCore来运行JunitCore，JunitCore有main方法运行测试类中的测试用例
 */
@RunWith(Categories.class)   //不写就默认BlockJUnit4ClassRunner.class
@Categories.IncludeCategory(A.class)  //A必须是类或者接口  多个用数组{}  运行SuiteTest就运行SuiteTestDemo测试类中有@Category注释的方法；如果是在类上注释，表示运行整个测试类
@Suite.SuiteClasses(SuiteTestDemo.class) //多个测试类用数组{}   SuiteTestDemo测试类里面可能对测试用例进行分在不同的组中（前面A类就是一个组 ）
public class SuiteTest {
    @Test
    public void test1(){
        /**
         * 单独运行该测试用例异常：java.lang.Exception: No tests found matching Method test1(SuiteTest) from org.junit.internal.requests.ClassRequest@3b22cdd0
         *
         * 运行SuiteTest测试类不会运行该测试用例
         */
        System.out.println("SuiteTest");
        String a = "2";
//        assertEquals("ok","1",a);
//        assertTrue("ok",a.equals("2"));
    }

}

