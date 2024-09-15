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
    private String type;
    private String ext;
    private String modified;
    
    private Long size;
}
