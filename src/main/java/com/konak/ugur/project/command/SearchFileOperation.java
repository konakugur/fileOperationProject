package com.konak.ugur.project.command;

import com.konak.ugur.project.handler.SearchHandler;

import java.util.List;
import java.util.Scanner;

public class SearchFileOperation implements Operation {

    private static final String SEARCH_OPERATION_EXECUTION_CODE = "3";

    public boolean isExecutable(String input) {
        return SEARCH_OPERATION_EXECUTION_CODE.equals(input);
    }

    public void execute(List<String> fileListArray, boolean isArraySorted) {
        boolean isBackOptionSelected = false;
        Scanner scanner = new Scanner(System.in);
        String userSelection;

        while (!isBackOptionSelected) {

            System.out.println("Please write the name of the file you want to search for. " +
                    "Press 0 if you want to go back to main menu.");

            userSelection = scanner.nextLine();

            if (GO_BACK_OPERATION_CODE.equals(userSelection)) {
                isBackOptionSelected = true;
            } else {

                int result;
                if (isArraySorted) {
                    result = SearchHandler.binarySearch(fileListArray, 0, fileListArray.size() - 1, userSelection);
                } else {
                    result = SearchHandler.linearSearch(fileListArray, userSelection);
                }


                if ( result != -1 ) {
                    System.out.println("File found in your directory. File no : " + result + 1);
                } else {
                    System.out.println("No file found with this name.");
                }
            }

        }

    }

    public boolean isExitOperation() {
        return false;
    }
}
