package output;

import fillers.TypeFillers;
import sorters.TypeSorters;

import static analyzer.Analyzer.analyzer;

public class Output {
    public static void main(String[] args) {
        TypeSorters[] typeSorters = TypeSorters.values();
        int i = 0;
        for (long time : analyzer(30000, typeSorters, TypeFillers.RANDOM_ARRAY))
            System.out.println(typeSorters[i++] + ": " + time);
        //for(long time : analyzer(30000,typeSorters,TypeFillers.ASCENDING_ARRAY))
        //    System.out.println(typeSorters[i++] +": "+time);
        //for(long time : analyzer(30000,typeSorters,TypeFillers.ASCENDING_WITH_X_ARRAY))
        //    System.out.println(typeSorters[i++] +": "+time);
        //for(long time : analyzer(30000,typeSorters,TypeFillers.DESCENDING_ARRAY))
        //    System.out.println(typeSorters[i++] +": "+time);
    }
}
