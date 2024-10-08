package com.acloud.acloud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FileList {
    private String id;
    private String name;
    private String modified;
    private String owner;
    private String ext;
    
    private int type; // 1 = 폴더, 2 = 파일

    private Long size;
}
