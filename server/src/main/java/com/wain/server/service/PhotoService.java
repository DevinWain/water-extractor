package com.wain.server.service;

import com.wain.server.domain.Photolist;

import java.util.List;

public interface PhotoService {

    boolean addPhoto(Photolist photo);

    boolean detelePhoto(Integer id);

    List<Photolist> allPhoto();
}
