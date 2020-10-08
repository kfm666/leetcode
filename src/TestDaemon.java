public class TestDaemon {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new DaemonThread();
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(10000);
    }

    public static class DaemonThread implements Runnable{

        @Override
        public void run() {
            int i = 0;
            while (true){
                System.out.println(i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
