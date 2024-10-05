package com.acloud.acloud.service;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.acloud.acloud.dto.CurrentDirectoryDTO;
import com.acloud.acloud.dto.FileList;
import com.acloud.acloud.dto.FolderList;
import com.acloud.acloud.util.DateFormatter;

@Service
public class DirectoryServiceImpl implements DirectoryService{

    @Override
    public CurrentDirectoryDTO getCurrentDirectory(String curDir) throws Exception {
        CurrentDirectoryDTO currentDirectoryDto = new CurrentDirectoryDTO();

        File dir = new File(curDir);
        if (!dir.exists()) {
            return currentDirectoryDto;
        }
        
        currentDirectoryDto.setDirectory(dir.getAbsolutePath());
        currentDirectoryDto.setCurrentDirectory(dir.getAbsolutePath());
        if (dir.getParentFile() != null) {
            currentDirectoryDto.setPreviousDirectory(dir.getParentFile().getAbsolutePath());
        } else {
            currentDirectoryDto.setPreviousDirectory(dir.getAbsolutePath());
        }
        

        /* 폴더 리스트 설정 */

        List<FolderList> folderList = new ArrayList<FolderList>();

        File[] folders = dir.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory(); // 폴더인지 검사
            }
            
        });

        for (File folder : folders) {
            String modified = DateFormatter.dateToDMY(new Date(folder.lastModified()));

            folderList.add(new FolderList("", folder.getName(), modified, "temp owner", 1, folder.length()));
        }

        currentDirectoryDto.setFolderList(folderList);

        /* 파일 리스트 설정 */

        List<FileList> fileList = new ArrayList<FileList>();
        
        File[] files = dir.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.isFile(); // 파일인지 검사
            }
            
        });

        for (File file : files) {
            String modified = DateFormatter.dateToDMY(new Date(file.lastModified()));

            int index = file.getName().lastIndexOf(".");
            String ext = index > 0 ? file.getName().substring(index + 1) : "";

            fileList.add(new FileList("", file.getName(), modified, "temp owner", ext, 2, file.length()));
        }

        currentDirectoryDto.setFileList(fileList);

        return currentDirectoryDto;
    }

}
