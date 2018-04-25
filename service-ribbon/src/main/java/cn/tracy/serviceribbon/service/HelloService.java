package cn.tracy.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    //熔断机制，指定当服务出错，返回hiError中的string
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://service-hi/hi?name="+name,String.class);
    }
    public String hiError(String name){
        return "hi,"+name +",Sorry,error";
    }
    /*当service-hi工程不可用时，service-ribbon调用service-hi的API时，会执行快速失败，而不是等待响应超时，控制了容器的线程阻塞。*/
}
