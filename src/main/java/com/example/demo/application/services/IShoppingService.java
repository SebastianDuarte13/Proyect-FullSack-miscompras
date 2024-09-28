package com.example.demo.application.services;

import org.springframework.stereotype.Service;
import com.example.demo.domain.entity.Shopping;

@Service
public interface IShoppingService {
    Shopping save(Shopping shopping);

}
