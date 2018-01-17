import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;

/**
 * Created by tangyaru on 2018/1/17.
 *
 * 测试用例排序 有三种排序：随机(默认)、JVM排序（JVM自己的算法排序）、测试用例名称升序排序
 *
 * 自定义排序在SuiteSort2
 */
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING) //测试用例名称升序排序
public class SuiteSort1 {
    @Test
    public void atest(){
        System.out.println("a");
    }
    @Test
    public void dtest(){
        System.out.println("d");
    }
    @Test
    public void ctest(){
        System.out.println("c");
    }
    @Test
    public void btest(){
        System.out.println("b");
    }




}
