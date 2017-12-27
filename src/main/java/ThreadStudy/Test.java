package ThreadStudy;

/**
 * Created by tangyaru on 2017/12/25.
 */
public class Test {

    private static volatile boolean bChanged;

    public static void main(String[] args) throws InterruptedException {


        new Thread() {
            @Override
            public void run() {
                for (;;) {
                    if (bChanged == !bChanged) {

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
