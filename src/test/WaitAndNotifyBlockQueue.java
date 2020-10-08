package test;

public class WaitAndNotifyBlockQueue<E> {

    private Object OBJ = new Object();
    private Object[] items;
    private int count = 0;
    private int productIndex = 0;
    private int consumerIndex = 0;

    public WaitAndNotifyBlockQueue(int count) {
        this.items = new Object[count];
//        printf();
    }

    public void put(E e) {
        synchronized (OBJ) {
            try {
                while (count >= items.length) {
                    OBJ.wait();
                }
                if (productIndex+1 > items.length) {
                    productIndex = 0;
                }
                items[productIndex++] = e;
                count += 1;
                OBJ.notify();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    public E get() {
        synchronized (OBJ) {
            try {
                while (count <=0) {
                    OBJ.wait();
                }

                if (consumerIndex+1 > items.length) {
                    consumerIndex = 0;
                }
                E e = (E) items[consumerIndex++];
                count -= 1;
                OBJ.notify();
                return e;
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    public int getCount() {
        synchronized (OBJ) {
            return count;
        }
    }

    private void printLine() {
//        System.out.println();
        for (int i = 0; i < items.length; i++) {
        }
//        System.out.println();
    }

    // 便于查看数据而已，无实际用途
//    public void printf() {
//        synchronized (OBJ) {
//            for (int i = 1; i <= items.length; i++) {
//                if (i == productIndex) {
//                    System.out.print("  ⬇  ");
//                } else {
//                    System.out.print("     ");
//                }
//            }
//            printLine();
//            for (int i = 0; i < items.length; i++) {
//                Object num = items[i];
//                if (num != null) {
//                    System.out.printf("%4d", items[i]);
//                } else {
//                    System.out.print("NULL");
//                }
//                System.out.print("|");
//            }
//            printLine();
//            for (int i = 1; i <= items.length; i++) {
//                if (i == consumerIndex) {
//                    System.out.print("  ⬆  ");
//                } else {
//                    System.out.print("     ");
//                }
//            }
//            System.out.println("\nstart: " + consumerIndex  + ", end: " + productIndex + ", count: " + count + "\n\n");
//        }
//    }
}