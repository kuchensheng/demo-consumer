package com.songxiaocai.demo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sxc.dubbo.demo.api.DemoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
public class App 
{
    @Reference(version = "1.0")
    private DemoService demoService;

    @RequestMapping(value = "/sxc/test",method = RequestMethod.GET)
    public String getTest() {
        return demoService.sayHello();
    }

    @RequestMapping(value = "/sxc/test/{name}",method = RequestMethod.GET)
    public String getTest(@PathVariable(value = "name") String name) {
        return demoService.sayHello(name);
    }
}
