package com.acloud.acloud.service;

import java.util.List;

import com.acloud.acloud.dto.CurrentDirectoryDTO;
import com.acloud.acloud.dto.FileList;

public interface DirectoryService {
    CurrentDirectoryDTO getCurrentDirectory(String path, String curDir) throws Exception;
}
