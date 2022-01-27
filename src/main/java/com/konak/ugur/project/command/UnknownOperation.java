package com.konak.ugur.project.command;

import java.util.List;

public class UnknownOperation implements Operation {

    public boolean isExecutable(String input) {
        return false;
    }

    public void execute(List<String> fileListArray, boolean isArraySorted) {
        System.out.println("The number you entered can not be processed. " +
                "Please make a valid choice from menu.");
    }

    public boolean isExitOperation() {
        return false;
    }
}
