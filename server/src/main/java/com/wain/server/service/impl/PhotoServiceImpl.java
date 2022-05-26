package com.wain.server.service.impl;

import com.wain.server.dao.PhotolistMapper;
import com.wain.server.domain.Photolist;
import com.wain.server.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotolistMapper photolistMapper;

    @Override
    public boolean addPhoto(Photolist photo){
        return photolistMapper.insert(photo) > 0;
    }

    @Override
    public boolean detelePhoto(Integer id){
        return photolistMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Photolist> allPhoto(){
        return photolistMapper.selectAll();
    }
}
