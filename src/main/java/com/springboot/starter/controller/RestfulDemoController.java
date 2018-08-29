package com.springboot.starter.controller;

import com.springboot.starter.dto.DemoDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restful-demo")
public class RestfulDemoController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAll() {
        return DemoDto.builder().build().toString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") Integer id) {
        return "Get by Id " + id;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody String demo) {
        return "save" + demo;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody String demo) {
        return "update" + demo;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        return "delete " + id;
    }

    /**
     * tomcat 默认只解析POST的表单，对于PUT和DELETE的不处理，所以Spring拿不到。
     *
     * 解决方案1：修改tomcat的server.xml
     * <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000"
     *      redirectPort="8443"
     *      parseBodyMethods="POST,PUT,DELETE"
     *      URIEncoding="UTF-8" />
     *
     * 解决方案2：在web.xml中添加HttpPutFormContentFilter 提供对PUT的支持
     * HiddenHttpMethodFilter 可以支持PUT和DELETE
     * <filter>
     *     <filter-name>HttpPutFormContentFilter</filter-name>
     *     <filter-class>org.springframework.web.filter.HttpPutFormContentFilter</filter-class>
     * </filter>
     * <filter-mapping>
     *     <filter-name>HttpPutFormContentFilter</filter-name>
     *     <url-pattern>/*</url-pattern>
     * </filter-mapping>
     *
     * 另有一说法PUT和DELETE不安全，建议不要使用。
     */
}
