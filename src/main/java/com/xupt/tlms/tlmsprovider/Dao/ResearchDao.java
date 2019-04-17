package com.xupt.tlms.tlmsprovider.Dao;

import com.xupt.tlms.pojo.Research;
import com.xupt.tlms.vojo.ResearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResearchDao {
    int insert(Research research);
    int updateResearch(Research research);
    int deleteResearch(int id);
    List<ResearchVo> findAllByUserId(int userId);
    ResearchVo findOneById(int id);
}
