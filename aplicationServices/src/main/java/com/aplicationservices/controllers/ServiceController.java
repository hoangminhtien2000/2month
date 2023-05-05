package com.aplicationservices.controllers;

import com.aplicationservices.model.dto.DtoInput;
import com.aplicationservices.service.SendAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/service1")
@RestController
public class ServiceController {

    @Autowired
    private SendAddress sendAddress;

    @Value("${server.instance.name}")
    private String instance;

    @RequestMapping()
    public String sayHello(){
        return "Hello from " + instance;
    }

    @PostMapping("/{dem}")
    public Integer dem(@PathVariable int dem){
        return 1+dem;
    }


    @PostMapping("/send")
    public String sendAddress(@RequestBody DtoInput dtoInput){
        return sendAddress.sendAddress(dtoInput);
    }

}
