package com.konak.ugur.project.command;

import com.konak.ugur.project.handler.SearchHandler;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class DeleteFileOperation implements Operation {

    private static final String DELETE_FILE_OPERATION_CODE = "2";

    public boolean isExecutable(String input) {
        return DELETE_FILE_OPERATION_CODE.equals(input);
    }

    public void execute(List<String> fileListArray, boolean isArraySorted) {
        boolean isBackOptionSelected = false;
        Scanner scanner = new Scanner(System.in);
        String userSelection;
        while (!isBackOptionSelected) {

            System.out.println("Please write the name of the file you want to delete. " +
                    "Press 0 if you want to go back to main menu.");

            userSelection = scanner.nextLine();

            if (GO_BACK_OPERATION_CODE.equals(userSelection)) {
                isBackOptionSelected = true;
            } else {
                File file = new File(FILE_DIRECTORY.concat(File.separator).concat(userSelection));
                if (file.delete()) {
                    System.out.println("File removed from your directory.");

                    int index;
                    if (isArraySorted) {
                        index = SearchHandler.binarySearch(fileListArray, 0, fileListArray.size()-1, userSelection);
                    } else {
                        index = SearchHandler.linearSearch(fileListArray, userSelection);
                    }
                    fileListArray.remove(index);

                } else {
                    System.out.println("A file with this name doesn't exist. File couldn't be deleted.");
                }
            }

        }

    }

    public boolean isExitOperation() {
        return false;
    }
}
