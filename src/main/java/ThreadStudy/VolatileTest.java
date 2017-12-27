package ThreadStudy;

/**
 * Created by tangyaru on 2017/12/27.
 *
 * 事实上运行它会发现每次运行结果都不一致，都是一个小于10000的数字。
 * https://www.cnblogs.com/dolphin0520/p/3920373.html   解释在这个链接深入剖析部分
 * 为什么在一个线程修改inc 不会把其他线程的inc置为无效？？？？？？
 *
 */
public class VolatileTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
