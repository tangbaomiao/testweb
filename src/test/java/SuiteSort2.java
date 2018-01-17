import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by tangyaru on 2018/1/17.
 *
 * 自定义排序
 */
@RunWith(SortedRunner.class)
public class SuiteSort2 {
    @Index(value = 1)
    @Test
    public void test1(){
        System.out.println("1");
    }
    @Index(value = 2)
    @Test
    public void test4(){
        System.out.println("4");
    }
    @Index(value = 3)
    @Test
    public void test3(){
        System.out.println("3");
    }
    @Index(value = 4)
    @Test
    public void test2(){
        System.out.println("2");
    }

}
