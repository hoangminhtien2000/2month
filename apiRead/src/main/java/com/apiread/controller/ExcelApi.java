package com.apiread.controller;

import com.apiread.model.dto.DtoStudent;
import com.apiread.model.dto.OutputAPI;
import com.apiread.service.readWriteFile.ReadWriteService;
import com.apiread.service.readWriteFile.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ExcelApi {

    @Autowired
    private ReadWriteService readWriteService;

    @Autowired
    private StudentServiceImpl studentServiceImpl;

//    @GetMapping("/word1")
//    public  String greeting( ) {
//        return studentServiceImpl.message("names");
//    }
//
//    @GetMapping()
//    public List<DtoStudent> readExcel( @RequestParam("file") MultipartFile file) throws Exception {
//        return studentServiceImpl.readExcel(file);
//    }

    @PostMapping()
    public OutputAPI writeExcel(@RequestBody List<DtoStudent> dtoStudents, OutputAPI outputAPI) throws IOException {
        return studentServiceImpl.writeExcel(dtoStudents,outputAPI);
    }

    @PostMapping("/download/downloadBase64")
    public OutputAPI downloadExcelBase64(@RequestParam("file") MultipartFile file, OutputAPI outputAPI) throws Exception {
        return readWriteService.downloadExcelBase64(file,outputAPI);
    }

}
