package com.ai.order.client;

import com.ai.common.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "storage-service", configuration = FeignConfiguration.class)
public interface StorageClient {

    @GetMapping(value = "/storage/getStorage/{id}", consumes="application/json")
    String getStorage(@PathVariable("id") int id);
}
