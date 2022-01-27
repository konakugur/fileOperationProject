package com.konak.ugur.project.command;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OperationHandler {

    public boolean handleOperation(String input, List<String> fileListArray, boolean isArraySorted) throws IOException {

        AddFileOperation ADD_FILE_OPERATION = new AddFileOperation();
        DeleteFileOperation DELETE_FILE_OPERATION = new DeleteFileOperation();
        SearchFileOperation SEARCH_FILE_OPERATION = new SearchFileOperation();
        ExitApplicationOperation EXIT_APPLICATION_OPERATION = new ExitApplicationOperation();
        ShowFilesOperation SHOW_FILES_OPERATION = new ShowFilesOperation();

        List<Operation> operationList = new ArrayList<>();
        operationList.add(ADD_FILE_OPERATION);
        operationList.add(DELETE_FILE_OPERATION);
        operationList.add(SEARCH_FILE_OPERATION);
        operationList.add(EXIT_APPLICATION_OPERATION);
        operationList.add(SHOW_FILES_OPERATION);

        for (Operation operation : operationList) {
            if (operation.isExecutable(input)) {
                operation.execute(fileListArray, isArraySorted);
                return operation.isExitOperation();
            }
        }

        UnknownOperation unknownOperation = new UnknownOperation();
        unknownOperation.execute(fileListArray, isArraySorted);
        return false;
    }

}
