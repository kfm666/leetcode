package test;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        WaitAndNotifyBlockQueue<Long> queue = new WaitAndNotifyBlockQueue<>(10);
        new Thread(()->{
            Long i = 0L;
            while (true){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                queue.put(i++);
            }
        }).start();
        for(int i=0;i<10;i++){
            new Thread(()->{
                while (true){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName()+"-----------"+queue.get());
                }

            },"thread-"+i).start();
        }
    }
}
