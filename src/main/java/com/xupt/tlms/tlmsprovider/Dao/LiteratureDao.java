package com.xupt.tlms.tlmsprovider.Dao;

import com.xupt.tlms.pojo.Literature;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LiteratureDao {
   List<Literature> findAllByResearchId(int researchId);
}
