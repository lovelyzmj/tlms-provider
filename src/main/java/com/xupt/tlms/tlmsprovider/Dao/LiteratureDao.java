package com.xupt.tlms.tlmsprovider.Dao;

import com.xupt.tlms.pojo.Literature;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LiteratureDao {
   List<Literature> findAllByResearchId(int researchId);
   Literature findOneById(int id);
   int insert(Literature literature);
   int insertLiteratureAndResearch(@Param("literatureId") int literatureId,@Param("researchId") int researchId);
   Literature findLiteratureByNameAndResearchId(@Param("name") String name,@Param("researchId") int researchId);
}
