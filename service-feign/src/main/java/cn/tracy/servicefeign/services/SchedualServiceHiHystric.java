package cn.tracy.servicefeign.services;

import cn.tracy.servicefeign.faces.ScnedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements ScnedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
