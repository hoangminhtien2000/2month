package com.service2.controllers;
import com.service2.model.dto.DtoInput;
import com.service2.service.SaveAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/service2")
@RestController
public class ServiceController {

    @Autowired
    private SaveAddress saveAddress;

    @PostMapping("/{dem}")
    public Integer dem(@PathVariable int dem){
        return 2+dem;
    }


    @PostMapping("/receiver")
    public String saveAddress(@RequestBody DtoInput dtoInput){
        return saveAddress.saveAddress(dtoInput);
    }



}
