package com.example.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BookService {
//    @Cacheable(value="books" , key="#isbn")
    @Cacheable(value="books" , key="#root.target.getKey(#isbn) + #isbn")
    public String getBooksByIsbn(String isbn){
        try{
            TimeUnit.SECONDS.sleep(6);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
        return "ISBN -> "+isbn;
    }
    public String getKey(String isbn){
        System.out.println(isbn);
        return "1_"+isbn;
    }
}
