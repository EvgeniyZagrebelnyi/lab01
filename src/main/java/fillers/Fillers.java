package fillers;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Zagrebelnyj Eugene
 * Class for array fill
 */
public abstract class Fillers {
    private static Random random = new Random();
    private static int[] result;

    /**
     * method for create an array of sorted ascending
     * @param lengArray - length array
     * @return array of sorted ascending
     */
    public static int[] generationArraySortedAscen(int lengArray){
        result = generationArrayRandom(lengArray);
        Arrays.sort(result);
        return result;
    }
    /**
     * method for create an array of sorted ascending with random last element
     * @param lengArray - length array
     * @return array of sorted ascending with random last element
     */
    public static int[] generationArraySortedAscenWithX(int lengArray){
        result = generationArraySortedAscen(lengArray);
        result[lengArray - 1] = random.nextInt(1000);
        return result;
    }
    /**
     * method for create an array of sorted descending
     * @param lengArray - length array
     * @return array of sorted descending
     */
    public static int[] generationArraySortedDescen(int lengArray){
        result = generationArraySortedAscen(lengArray);
        int temp;
        for(int count = 0; count < lengArray / 2; count++){
            temp = result[lengArray - 1 - count];
            result[lengArray - 1 - count] = result[count];
            result[count] = temp;
        }
        return result;
    }
    /**
     * method for create an array with random element
     * @param lengArray - length array
     * @return array with random element
     */
    public static int[] generationArrayRandom(int lengArray){
        result = new int[lengArray];
        for(int count = 0; count < lengArray; count++)
            result[count] = random.nextInt(1000);
        return result;
    }


}
