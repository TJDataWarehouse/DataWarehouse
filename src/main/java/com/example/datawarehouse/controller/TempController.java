package com.example.datawarehouse.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin
@RequestMapping("/test")
public class TempController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public boolean testSongList(@RequestParam("id") Integer id){
        System.out.println("just a test");
        return true;
    }
}

