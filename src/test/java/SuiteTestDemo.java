import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.junit.Assert.*;

/**
 * Created by tangyaru on 2018/1/16.
 *
 * 管理测试用例 打包指定需要执行测试的类  第二种------使用category    第一种方法在OpenWindow测试类
 *
 * 断言
 */
@Category(A.class)  //  可以注释在类上／方法上  在类上表示该类所有测试用例都属于A
public class SuiteTestDemo {
    @Test
    public void test1(){
        System.out.println("A  test1");
        String a = "1";
        assertEquals("ok","1",a);
//        assertTrue("ok",a.equals("2"));
    }
}