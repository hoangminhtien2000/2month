package com.service3.service;

import com.service3.model.IDCard;
import com.service3.repository.IDCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IDCardServiceImpl implements SaveIDCard {

    @Autowired
    private IDCardRepo idCardRepo;

    @Override
    public IDCard saveAddress(IDCard idCard) {
        idCardRepo.save(idCard);
        return idCard;
    }
}