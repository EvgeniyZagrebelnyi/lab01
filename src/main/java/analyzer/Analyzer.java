package analyzer;

import fillers.TypeFillers;
import sorters.Sorters;
import sorters.TypeSorters;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static fillers.Fillers.*;

/**
 * @author Zagrebelnyj Eugene
 * Class for analyze the sorting speed
 */
public abstract class Analyzer {
    private static int[] mas;

    /**
     * method for choose type fill array
     * @param leng - length array
     * @param typeSorters - array the types of sorting array
     * @param typeFillers - the type of fill array
     * @return array time work
     */
    public static long[] analyzer(int leng, TypeSorters[] typeSorters, TypeFillers typeFillers) {
        long[] time = new long[8];
        int count = 0;
        switch (typeFillers){
            case ASCENDING_ARRAY:
                mas = generationArraySortedAscen(leng);
                for(TypeSorters typeSorter : typeSorters)
                    time[count++] = timeSort(mas, typeSorter);
                break;
            case ASCENDING_WITH_X_ARRAY:
                mas = generationArraySortedAscenWithX(leng);
                for(TypeSorters typeSorter : typeSorters)
                    time[count++] = timeSort(mas, typeSorter);
                break;
            case DESCENDING_ARRAY:
                mas = generationArraySortedDescen(leng);
                for(TypeSorters typeSorter : typeSorters)
                    time[count++] = timeSort(mas, typeSorter);
                break;
            case RANDOM_ARRAY:
                mas = generationArrayRandom(leng);
                for(TypeSorters typeSorter : typeSorters)
                    time[count++] = timeSort(mas, typeSorter);
        }
        return Arrays.copyOf(time, count);
    }

    /**
     * method for determining the time spent
     * @param newmas - the array of elements
     * @param typeSorter - The type of sorting
     * @return time work
     */
    private static long timeSort(int[] newmas, TypeSorters typeSorter){
        int[] mas = Arrays.copyOf(newmas,newmas.length);
        Calendar startTime = new GregorianCalendar();
        switch (typeSorter){
            case QUICK_SORT:
                Sorters.quickSort(0, mas.length -1 , mas);
                break;
            case BUBBLE_SORT_EMERGE:
                Sorters.bubbleSortEmerge(mas);
                break;
            case BUBBLE_SORT_DROWNS:
                Sorters.bubbleSortDrowns( mas);
                break;
            case ARRAYS_SORT:
                Sorters.sortAr(mas);
                break;
            case MERGE_WITH_QUICK_SORT:
                Sorters.sortMergerWithQuickSort(mas);
                break;
            case MERGE_WITH_BUBBLE_SORT_EMERGE:
                Sorters.sortMergerWithBubbleSortEmerge(mas);
                break;
            case MERGE_WITH_BUBBLE_SORT_DROWNS:
                Sorters.sortMergerWithBubbleSortDrowns(mas);
                break;
            case MERGE_WITH_ARRAYS_SORT:
                Sorters.sortMergerWithArraysSort(mas);
        }
        Calendar stopTime = new GregorianCalendar();
        long result = stopTime.getTimeInMillis() - startTime.getTimeInMillis();
        return result;
    }
}
