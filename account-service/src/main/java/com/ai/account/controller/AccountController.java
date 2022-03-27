package com.ai.account.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Slf4j
public class AccountController {

    @RequestMapping(value = "/getAccount/{id}", method = RequestMethod.GET)
    public String getAccount(@PathVariable("id") int id) throws Exception {
        log.info("id: "+id);
        if (id>=3) {
            throw new Exception("id is null exception");
        }
        log.info("执行getAccount方法");
        return "account: " + id;
    }
}
