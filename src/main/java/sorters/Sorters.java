package sorters;

import java.util.Arrays;

    /**
    * @author Zagrebelnyj Eugene
    * Class to sort the array in a variety of ways
    */

public abstract class Sorters {
    private static int temp;

        /**
         * method for sort array as "bubble with element emerge"
         * @param mas - array of elements
         * @return sorted array of elements
         */
    public static int[] bubbleSortEmerge(int[] mas){
        int[] result = Arrays.copyOf(mas, mas.length);
        for(int lane = 0; lane < result.length; lane++)
            for (int position = 0; position < (result.length - 1) - lane; position++)
                if (result[position] > result[position + 1]) {
                    temp = result[position];
                    result[position] = result[position + 1];
                    result[position + 1] = temp;
                }
        return result;
    }
        /**
         * method for sort array as "bubble with element drowns"
         * @param mas - array of elements
         * @return sorted array of elements
         */
    public static int[] bubbleSortDrowns(int[] mas){
        int[] result = Arrays.copyOf(mas, mas.length);
        for(int lane = 0; lane < result.length; lane++)
            for (int position = result.length - 1; position > lane; position--)
                if (result[position] < result[position - 1] ) {
                    temp = result[position];
                    result[position] = result[position - 1];
                    result[position - 1] = temp;
                }
        return result;
    }
        /**
         * method for sort array as "Quick sort"
         * @param start - first element array
         * @param end - last element array
         * @param mas - array of elements
         * @return sorted array of elements
         */
    public static int[] quickSort(int start, int end, int[] mas){
        int[] result = Arrays.copyOf(mas, mas.length);
        int count1 = start;
        int count2 = end;
        int bearing = result[(count1 + count2) / 2];
        while(count1 < count2){
            while(result[count1] < bearing)
                count1++;
            while(result[count2] > bearing)
                count2--;
            if(count1 <= count2){
                temp = result[count1];
                result[count1] = result[count2];
                result[count2] = temp;
                count1++;
                count2--;
            }
        }
        if(start < count2)
            result = quickSort(start, count2, result);

        if(end > count1)
            result = quickSort(count1, end, result);
        return result;
    }
        /**
         * method for sort array as "bubble with element emerge"
         * @param mas - array of elements
         * @return sorted array of elements
         */
    public static int[] sortAr(int[] mas){
        int[] result = Arrays.copyOf(mas,mas.length);
        Arrays.sort(result);
        return result;
    }
        /**
         * method for sort array as "Merge with bubbleSortEmerge"
         * @param mas - array of elements
         * @return sorted array of elements
         */
    public static int[] sortMergerWithBubbleSortEmerge(int[] mas){
        int[] result = Arrays.copyOf(mas, mas.length);
        int[][] arrays = division(result);
        if(arrays[0].length < 2) {
            return result;
        }else{
            sortMergerWithBubbleSortEmerge(arrays[0]);
            sortMergerWithBubbleSortEmerge(arrays[1]);
            arrays[0] = bubbleSortEmerge(arrays[0]);
            arrays[1] = bubbleSortEmerge(arrays[1]);
            result = merge(arrays[0], arrays[1]);
        }
        return result;
    }
        /**
         * method for sort array as "Merge with bubbleSortDrowns"
         * @param mas - array of elements
         * @return sorted array of elements
         */
    public static int[] sortMergerWithBubbleSortDrowns(int[] mas){
        int[] result = Arrays.copyOf(mas, mas.length);
        int[][] arrays = division(result);
        if(arrays[0].length < 2) {
            return result;
        }else{
            sortMergerWithBubbleSortDrowns(arrays[0]);
            sortMergerWithBubbleSortDrowns(arrays[1]);
            arrays[0] = bubbleSortDrowns(arrays[0]);
            arrays[1] = bubbleSortDrowns(arrays[1]);
            result = merge(arrays[0], arrays[1]);
        }
        return result;
    }
        /**
         * method for sort array as "Merge with quickSort"
         * @param mas - array of elements
         * @return sorted array of elements
         */
    public static int[] sortMergerWithQuickSort(int[] mas){
        int[] result = Arrays.copyOf(mas, mas.length);
        int[][] arrays = division(result);
        if(arrays[0].length < 2) {
            return result;
        }else{
            sortMergerWithQuickSort(arrays[0]);
            sortMergerWithQuickSort(arrays[1]);
            arrays[0] = quickSort(0,arrays[0].length - 1, arrays[0]);
            arrays[1] = quickSort(0,arrays[1].length - 1, arrays[1]);
            result = merge(arrays[0], arrays[1]);
        }
        return result;
    }
        /**
         * method for sort array as "Merge with sortAr"
         * @param mas - array of elements
         * @return sorted array of elements
         */
    public static int[] sortMergerWithArraysSort(int[] mas){
        int[] result = Arrays.copyOf(mas, mas.length);
        int[][] arrays = division(result);
        if(arrays[0].length < 2) {
            return result;
        }else{
            sortMergerWithArraysSort(arrays[0]);
            sortMergerWithArraysSort(arrays[1]);
            arrays[0] = sortAr(arrays[0]);
            arrays[1] = sortAr(arrays[1]);
            result = merge(arrays[0], arrays[1]);
        }
        return result;
    }

        /**
         * method for merge two arrays
         * @param mas1 - first array;
         * @param mas2 - second array;
         * @return - united array
         */
    private static int[] merge(int[] mas1, int[] mas2){
        int[] mas3 = new int[mas1.length + mas2.length];
        int counterForMas1 = 0, counterForMas2 = 0;
        int a;
        for (int counterForMas3 = 0; counterForMas3 < mas3.length; counterForMas3++) {
            if (counterForMas1 > mas1.length - 1) {
                a = mas2[counterForMas2];
                mas3[counterForMas3] = a;
                counterForMas2++;
            } else if (counterForMas2 > mas2.length-1) {
                a = mas1[counterForMas1];
                mas3[counterForMas3] = a;
                counterForMas1++;
            } else if (mas1[counterForMas1] < mas2[counterForMas2]) {
                a = mas1[counterForMas1];
                mas3[counterForMas3] = a;
                counterForMas1++;
            } else {
                a = mas2[counterForMas2];
                mas3[counterForMas3] = a;
                counterForMas2++;
            }
        }
        return mas3;
    }

        /**
         * method for division array by two
         * @param mas - array what needed division
         * @return two array
         */
    private static int[][] division(int[] mas){
        int[][] result = new int[2][];
        int count = 0;
        result[0] = new int[mas.length/2];
        result[1] = new int[mas.length - mas.length/2];
        for(int element : mas)
            if(count < mas.length/2)
                result[0][count++] = element;
            else
                result[1][count++ - mas.length/2] = element;
        return result;
    }

}
