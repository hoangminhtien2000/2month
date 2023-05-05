package com.service3.controllers;
import com.service3.model.IDCard;
import com.service3.service.SaveIDCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/service3")
@RestController
public class ServiceController {

    @Autowired
    private SaveIDCard saveIDCard;

    @PostMapping("")
    public IDCard saveAddress(@RequestBody IDCard idCard){
       return saveIDCard.saveAddress(idCard);
    }



}
