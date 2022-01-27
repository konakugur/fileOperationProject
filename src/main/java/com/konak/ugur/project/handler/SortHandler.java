package com.konak.ugur.project.handler;

import java.util.Collections;
import java.util.List;

public class SortHandler {

    public static void handleSort(List<String> fileListArray, boolean isArraySorted) {

        if (!isArraySorted) {
            sort(fileListArray, 0, fileListArray.size()-1);
        }

    }

    static int partition(List<String> fileListArray, int low, int high)
    {
        String pivot = fileListArray.get(high);
        int i = (low-1);
        for (int j=low; j<high; j++) {
            if (fileListArray.get(j).compareTo(pivot) <= 0)
            {
                i++;
                Collections.swap(fileListArray, i, j);
            }
        }

        Collections.swap(fileListArray, i+1, high);

        return i+1;
    }

    static void sort(List<String> fileListArray, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(fileListArray, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(fileListArray, low, pi-1);
            sort(fileListArray, pi+1, high);
        }
    }

}
