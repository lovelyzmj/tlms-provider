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

   public List<Literature> findLiteratureByName(String name);

   public List<Literature> findLiteratureByAuthor(String author);

   public List<Literature> findLiteratureByKeyWord(String keyWord);

   public boolean updateLiteratureStatus(@Param("id") int id, @Param("status") int status) ;

   public List<Literature> findLiteratureByUserId(int userId) ;


}
