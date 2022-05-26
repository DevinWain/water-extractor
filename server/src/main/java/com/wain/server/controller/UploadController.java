package com.wain.server.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wain.server.constant.Constants;
import com.wain.server.domain.Photolist;
import com.wain.server.service.impl.PhotoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.util.Date;

@RestController
@Controller
public class UploadController {
    @Autowired
    private PhotoServiceImpl photoService;

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/data/img/originImages/**")
                    .addResourceLocations(Constants.ORIGIN_IMAGES_PATH);
        }
    }

    @ResponseBody
    @PostMapping (value = "/api/photo")
    public Object addPhoto(@RequestParam("file") MultipartFile mpfile){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        // 创建文件夹
        String fileRoot = System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "img"
                + System.getProperty("file.separator") + "originImages";
        String filePath = Constants.DATABASE_PATH + fileRoot;
        System.out.println(filePath);
        File file1 = new File(filePath);
        if (!file1.exists()){
            file1.mkdir();
        }

        String fileName = mpfile.getOriginalFilename();

        String storeUrlPath = fileRoot + System.getProperty("file.separator") + fileName;
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        System.out.println(filePath + System.getProperty("file.separator") + fileName);
        Photolist photolist = new Photolist();
        try {
            mpfile.transferTo(dest);
            photolist.setUrl(storeUrlPath);
            photolist.setCreatetime(new Date());
            boolean res = photoService.addPhoto(photolist);
            if (res) {
                objectNode.put("code", 1);
                objectNode.put("name", storeUrlPath);
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
