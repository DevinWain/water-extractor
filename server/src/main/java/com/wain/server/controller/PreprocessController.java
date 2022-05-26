package com.wain.server.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wain.server.constant.Constants;
import com.wain.server.service.RPC.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;
import java.util.HashMap;

@RestController
@Controller
public class PreprocessController {

    @Autowired
    private ClientService clientService;
    private ObjectMapper mapper = new ObjectMapper();

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/data/img/processed/**")
                    .addResourceLocations(Constants.PROCESSED_IMAGES_PATH);
        }
    }

    @ResponseBody
    @GetMapping(value = "/api/resize")
    public Object resizePhoto(@RequestParam("url") String url){
        System.out.println(url);
        ObjectNode objectNode = this.mapper.createObjectNode();;
        HashMap<String,String> map = new HashMap<>();
        map.put("url", url);
        try {
            String resp = clientService.getRestTemplate().getForObject("/resize/?url={url}", String.class, map);
//            boolean res = true;
            System.out.println(resp);
            JsonNode respJson = mapper.readTree(resp);
            boolean res = respJson.get("code").toString().equals("1");
            if (res) {
                objectNode.put("code", 1);
                objectNode.put("url", respJson.get("url").textValue());
//                objectNode.put("name", storeUrlPath);
                objectNode.put("msg", "上传成功");
            } else {
                objectNode.put("code", 0);
                objectNode.put("msg", "上传失败");
            }
            return objectNode;
        } catch (Exception e) {
            objectNode.put("code", 0);
            objectNode.put("msg", "上传失败" + e.getMessage());
            return objectNode;
        }
    }

    @ResponseBody
    @GetMapping(value = "/api/otsu-1d")
    public Object otsu1dPhoto(@RequestParam("url") String url){
        System.out.println(url);
        ObjectNode objectNode = this.mapper.createObjectNode();;
        HashMap<String,String> map = new HashMap<>();
        map.put("url", url);
        try {
            String resp = clientService.getRestTemplate().getForObject("/otsu-1d/?url={url}", String.class, map);
//            boolean res = true;
            System.out.println(resp);
            JsonNode respJson = mapper.readTree(resp);
            boolean res = respJson.get("code").toString().equals("1");
            if (res) {
                objectNode.put("code", 1);
                objectNode.put("url", respJson.get("url").textValue());
//                objectNode.put("name", storeUrlPath);
                objectNode.put("msg", "上传成功");
            } else {
                objectNode.put("code", 0);
                objectNode.put("msg", "上传失败");
            }
            return objectNode;
        } catch (Exception e) {
            objectNode.put("code", 0);
            objectNode.put("msg", "上传失败" + e.getMessage());
            return objectNode;
        }
    }
}
