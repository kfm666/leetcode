package lock;

public class TestWaitNotify {
    static Object object = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                synchronized (object){
                    System.out.println("A");
                    try {
                        object.notifyAll();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
        new Thread(()->{
            while (true){
                synchronized (object){
                    System.out.println("B");
                    try {
                        object.notifyAll();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

    }
}
