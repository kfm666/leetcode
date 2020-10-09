package util;

import java.util.Random;

public class ArraysUtil {
    public static int[] generateArray(int size,int range){
        int[] data = new int[size];
        Random random = new Random();
        for(int i=0;i<size;i++){
            data[i] = random.nextInt(range);
        }
        return data;
    }
}
