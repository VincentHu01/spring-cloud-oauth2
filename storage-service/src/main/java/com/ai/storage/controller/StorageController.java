package com.ai.storage.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class StorageController {

    @RequestMapping(value = "/getStorage/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('admin')")
    public String getStorage(@PathVariable("id") int id){
        log.info("执行查询库存getStorage方法");
        return "Storage: "+id*10;
    }
}
