
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tangyaru on 2018/1/17.
 *
 * 自定义annotaton标签
 */
@Retention(RetentionPolicy.RUNTIME) //作用域：运行时候
@Target(ElementType.METHOD)  //设置只在方法上才能用该注释
public @interface Index {
    public int value();  //属性
}
