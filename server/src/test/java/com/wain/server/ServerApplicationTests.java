package com.wain.server;

import com.wain.server.domain.Photolist;
import com.wain.server.service.impl.PhotoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServerApplicationTests {

    @Autowired
    private PhotoServiceImpl photoService;

    @Test
    void testPhotoService() {
//        Photolist photo = new Photolist();
//        photo.setUrl("/src/hello");
//        photo.setCreatetime(new Date());

//        System.out.println(photoService.detelePhoto(2));
        System.out.println(photoService.allPhoto());
        System.out.println(System.getProperty("user.dir"));
    }

}
