package com.ai.order.controller;

import com.ai.order.client.AccountClient;
import com.ai.order.client.StorageClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    AccountClient accountClient;

    @Autowired
    StorageClient storageClient;

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String hello(@PathVariable("id") String id){
        log.info("调用oder服务");
        return "hello Order "+ id;
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String getOrder(@PathVariable("id") int id){
        log.info("执行getOrder方法");

        String account = "";
        try {
            log.info(">>>>>>>>>远程调用account服务");
            account = accountClient.getAccount(id);
        } catch (FeignException e) {
            log.error("调用 account 服务失败！"+e.status());
            e.printStackTrace();
        }

        String storage = "";
        try {
            log.info(">>>>>>>>>远程调用account服务");
            storage = storageClient.getStorage(id);
        } catch (FeignException e) {
            log.error("调用 storage 服务失败！"+e.status());
            e.printStackTrace();
        }

        return "Order "+ id +", " + account + ", " + storage;
    }
}
