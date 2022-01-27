package com.konak.ugur.project;

import com.konak.ugur.project.command.OperationHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {

        final String FILE_DIRECTORY = System.getProperty("user.dir").concat(File.separator).concat("userFiles");

        File directoryCreator = new File(FILE_DIRECTORY);
        directoryCreator.mkdir();

        System.out.println("Creator : Uğur KONAK (VODAFONE TURKEY)");
        System.out.println("This application is created to show you the files in your directory, " +
                "add new file to your directory, " +
                "search for a file in your directory, " +
                "or remove a file from your directory.");

        OperationHandler operationHandler = new OperationHandler();
        Scanner scanner = new Scanner(System.in);
        boolean isExitApplicationSelected = false;
        String userInput;

        File directory = new File(FILE_DIRECTORY.concat(File.separator));
        File[] fileList = directory.listFiles();

        assert fileList != null;
        List<String> fileListArray = new ArrayList<>();

        for (File file : fileList) {
            fileListArray.add(file.getName());
        }

        boolean isArraySorted = false;
        final String SEARCH_FILE_EXECUTION_CODE = "4";

        while (!isExitApplicationSelected) {
            System.out.println("Please choose the action you want to take : ");
            System.out.println("1. Add a new file.");
            System.out.println("2. Delete a file.");
            System.out.println("3. Search for a file.");
            System.out.println("4. Show files in the directory.");
            System.out.println("0. Exit from the application.");

            userInput = scanner.nextLine();

            try {
                isExitApplicationSelected = operationHandler.handleOperation(userInput, fileListArray, isArraySorted);
            } catch (IOException e) {
                System.out.println("An error occured in file operations, please try again.");
            }


            if (SEARCH_FILE_EXECUTION_CODE.equals(userInput)) {
                isArraySorted = true;
            }

        }

    }

}
