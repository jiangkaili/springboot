package com.atguigu.eduorder.client;


import com.atguigu.commonutils.ordervo.UcenterMemberOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("service-edu")
public interface UcenterClient {

    @PostMapping("/educenter/member/getUserInfo/{id}")
    public UcenterMemberOrder getUserInfo(@PathVariable("id") String id);
}
