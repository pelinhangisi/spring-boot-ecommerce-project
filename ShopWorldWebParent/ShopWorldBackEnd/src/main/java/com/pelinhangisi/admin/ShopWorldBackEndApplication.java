package com.pelinhangisi.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.pelinhangisi.shopworldcommon.entity", "com.pelinhangisi.admin.user"})
public class ShopWorldBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopWorldBackEndApplication.class, args);
    }

}
