package com.konak.ugur.project.command;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddFileOperation implements Operation {

    private static final String ADD_FILE_OPERATION_CODE = "1";

    public boolean isExecutable(String input) {
        return ADD_FILE_OPERATION_CODE.equals(input);
    }

    public void execute(List<String> fileListArray, boolean isArraySorted) throws IOException {
        boolean isBackOptionSelected = false;
        Scanner scanner = new Scanner(System.in);
        String userSelection;

        while (!isBackOptionSelected) {

            System.out.println("Please write the name of the file you want to add. " +
                    "Press 0 if you want to go back to main menu.");

            userSelection = scanner.nextLine();

            if (GO_BACK_OPERATION_CODE.equals(userSelection)) {
                isBackOptionSelected = true;
            } else {
                File file = new File(FILE_DIRECTORY.concat(File.separator).concat(userSelection));
                if (file.createNewFile()) {
                    System.out.println("New file added to user directory.");
                    if (isArraySorted) {
                        int index = fileListArray.size();
                        for (int i=0; i<fileListArray.size(); i++) {
                            if (userSelection.compareTo(fileListArray.get(i)) <= 0) {
                                index = i;
                                break;
                            }
                        }
                        fileListArray.add(index, file.getName());
                    } else {
                        fileListArray.add(file.getName());
                    }
                } else {
                    System.out.println("A file with this name already exists. File couldn't be created.");
                }
            }

        }

    }

    public boolean isExitOperation() {
        return false;
    }
}
