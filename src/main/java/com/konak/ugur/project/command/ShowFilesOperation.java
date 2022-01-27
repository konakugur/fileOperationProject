package com.konak.ugur.project.command;

import com.konak.ugur.project.handler.SortHandler;

import java.io.IOException;
import java.util.List;

public class ShowFilesOperation implements Operation {

    final String SHOW_FILES_EXECUTION_CODE = "4";

    @Override
    public boolean isExecutable(String input) {
        return SHOW_FILES_EXECUTION_CODE.equals(input);
    }

    @Override
    public void execute(List<String> fileListArray, boolean isArraySorted) throws IOException {
        if (fileListArray.isEmpty()) {
            System.out.println("Your directory is empty, no files found.");
        } else {
            SortHandler.handleSort(fileListArray, isArraySorted);
            fileListArray.forEach(System.out::println);
        }
    }

    @Override
    public boolean isExitOperation() {
        return false;
    }
}
