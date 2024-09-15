package com.acloud.acloud.service;

import java.util.List;

import com.acloud.acloud.dto.FileList;

public interface DirectoryService {
    List<FileList> getCurrentDirectory(String curDir) throws Exception;
}
