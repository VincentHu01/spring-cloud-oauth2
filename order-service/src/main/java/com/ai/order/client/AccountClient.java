package com.ai.order.client;


import com.ai.common.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "account-service", configuration = FeignConfiguration.class)
public interface AccountClient {

    @RequestMapping(value = "/account/getAccount/{id}", method = RequestMethod.GET)
    String getAccount(@PathVariable("id") int id);
}
