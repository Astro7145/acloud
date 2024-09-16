package com.acloud.acloud.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrentDirectoryDTO {
    private String directory;
    private String currentDirectory;

    private List<FolderList> folderList;
    private List<FileList> fileList;
}
