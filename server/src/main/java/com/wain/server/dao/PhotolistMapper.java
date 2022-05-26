package com.wain.server.dao;

import com.wain.server.domain.Photolist;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PhotolistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Photolist record);

    Photolist selectByPrimaryKey(Integer id);

    List<Photolist> selectAll();

    int updateByPrimaryKey(Photolist record);
}