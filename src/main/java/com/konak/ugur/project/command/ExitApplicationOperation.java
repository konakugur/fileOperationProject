package com.konak.ugur.project.command;

import java.util.List;

public class ExitApplicationOperation implements Operation {

    private static final String EXIT_APPLICATION_OPERATION_CODE = "0";

    public boolean isExecutable(String input) {
        return EXIT_APPLICATION_OPERATION_CODE.equals(input);
    }

    public void execute(List<String> fileListArray, boolean isArraySorted) {
        System.out.println("Closing application successfully...");
    }

    public boolean isExitOperation() {
        return true;
    }
}
