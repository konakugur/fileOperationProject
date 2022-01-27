package com.konak.ugur.project.handler;

import java.util.List;


public class SearchHandler {

    static public int binarySearch(List<String> fileListArray, int l, int r, String fileName)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (fileListArray.get(mid).equals(fileName))
                return mid;

            if (fileListArray.get(mid).compareTo(fileName) > 0)
                return binarySearch(fileListArray, l, mid - 1, fileName);

            return binarySearch(fileListArray, mid + 1, r, fileName);
        }

        return -1;
    }

    static public int linearSearch(List<String> fileListArray, String fileName) {
        for (int i=0; i<fileListArray.size(); i++) {
            if (fileListArray.get(i).equals(fileName))
                return i;
        }

        return -1;
    }

}
