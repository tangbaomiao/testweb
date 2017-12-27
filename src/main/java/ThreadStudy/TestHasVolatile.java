package ThreadStudy;

/**
 * Created by tangyaru on 2017/12/25.
 */
public class TestHasVolatile {

    private static volatile boolean bChanged;

    public static void main(String[] args) throws InterruptedException {


        new Thread() {
            @Override
            public void run() {
                for (;;) {
                    if (bChanged == !bChanged) { //是不是bChanged为false才可以到if里面？

                        System.out.println("AAA");
                        System.out.println("!=");
                        System.exit(0);
                    }
                }
            }
        }.start();
        Thread.sleep(1);
        new Thread() {
            @Override
            public void run() {
                for (;;) {
                    //nun2 = num2 + 1;
                    System.out.println("BBBBBBB");
                    bChanged = !bChanged;
                }
            }
        }.start();
    }
}
