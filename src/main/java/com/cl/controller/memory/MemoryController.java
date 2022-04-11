package com.cl.controller.memory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("memory")
public class MemoryController {

    @RequestMapping("out")
    public void out() {
        List<Object> list = new ArrayList<>();
        while (true) {
            System.out.println(System.currentTimeMillis());
            list.add(new Object());
        }
    }
}
