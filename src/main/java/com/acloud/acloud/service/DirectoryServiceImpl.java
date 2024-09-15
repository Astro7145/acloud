package com.acloud.acloud.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.acloud.acloud.dto.FileList;

@Service
public class DirectoryServiceImpl implements DirectoryService{

    @Override
    public List<FileList> getCurrentDirectory(String curDir) throws Exception {
        List<FileList> fileList = new ArrayList<>();

        File dir = new File(curDir);
        if (!dir.exists()) {
            return fileList;
        }
        
        File[] files = dir.listFiles(); // 파일을 필터링 할 때는 listFiles(FileFilter filter)를 사용

        for (File file : files) {
            fileList.add(new FileList("", file.getName(), "", "", new Date(file.lastModified()).toString(), file.length()));
        }

        return fileList;
    }

}
