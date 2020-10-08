package lock;

public class MyLockTimeoutTest {
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        new Thread(()->{
            try {
                lock.lock();
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            long t = System.nanoTime();
            try {
                if(lock.tryLock(500)){
                    try{
                        System.out.println("try lock success");
                    }finally {
                        lock.unlock();
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println("cost "+(System.nanoTime()-t)/1000000.0 + " mills");
            }
        }).start();
    }
}
