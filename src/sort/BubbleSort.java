package sort;

import util.ArraysUtil;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] data = ArraysUtil.generateArray(1000,100000);
        int[] data1 = Arrays.copyOf(data,data.length);
        long time = System.nanoTime();
        sort(data);
        System.out.println("冒泡法排序耗时："+(System.nanoTime() - time));
        time = System.nanoTime();
        sortPlus(data1);
        System.out.println("冒泡法排序耗时："+(System.nanoTime() - time));

        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(data1));
    }

    /**
     * 经典冒泡排序
     * 每次循环将最小的元素放在最前面
     * @param data
     */
    public static void sort(int[] data){
        int temp;
        for(int i = 0; i< data.length;i++){
            for(int j = i+1; j< data.length;j++){
                if(data[i]> data[j]){
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
//            System.out.println("第"+i+"次排序的结果为："+Arrays.toString(data));
        }
    }

    /**
     * 冒泡改进
     * 每次循环，除了找出最小的元素，还能找出最大的元素，将最大的元素放在倒数的位置，可以节省一般的循环
     * @param data
     */
    public static void sortPlus(int[] data){
        int temp;
        int maxIndex = 0;
        for(int i = 0; i< data.length-i;i++){
            maxIndex = i;
            for(int j = i+1; j< data.length-i;j++){
                if(data[i]> data[j]){
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
                if(data[maxIndex] < data[j]){
                    maxIndex = j;
                }
            }
            temp = data[data.length - i - 1];
            data[data.length - i - 1] = data[maxIndex];
            data[maxIndex] = temp;
//            System.out.println("第"+i+"次排序的结果为："+Arrays.toString(data)+"，maxIndex="+maxIndex);
        }
    }
}
