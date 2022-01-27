package com.konak.ugur.project.command;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Operation {

    String GO_BACK_OPERATION_CODE = "0";
    String FILE_DIRECTORY = System.getProperty("user.dir").concat(File.separator).concat("userFiles");

    boolean isExecutable(String input);

    void execute(List<String> fileListArray, boolean isArraySorted) throws IOException;

    boolean isExitOperation();

}
