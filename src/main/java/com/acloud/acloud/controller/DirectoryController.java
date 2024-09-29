package com.acloud.acloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acloud.acloud.dto.CurrentDirectoryDTO;
import com.acloud.acloud.dto.FileList;
import com.acloud.acloud.service.DirectoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/directory")
public class DirectoryController {

    @Value("${path.absolute}")
    private String abPath;

    @Autowired
    private DirectoryService directoryService;

    @GetMapping("/currentDirectory/{*curDir}")
    public CurrentDirectoryDTO getCurrentDirectory(@PathVariable("curDir") String curDir) throws Exception {
        CurrentDirectoryDTO currentDirectoryDto = directoryService.getCurrentDirectory(abPath + "/" + curDir, curDir);

        return currentDirectoryDto;
    }

    @GetMapping("/testDirectory/{*path}")
    public String testDirectory(@PathVariable("path") String path) {
        System.out.println(path);
        return path;
    }
    
    
}
