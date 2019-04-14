package com.xupt.tlms.tlmsprovider.Dao;

import com.xupt.tlms.pojo.KeyWord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KeyWordDao {
    int insert(String name);
    List<KeyWord> findByName(String name);//模糊查询
    List<KeyWord> findAllByLiteratureId(int literatureId);
    KeyWord findById(int id);//根据id查找关键字
    List<KeyWord> findAll();//查询所有关键字
    int insertKeyWordAndLiterature(@Param("keywordId") int keywordId,@Param("literatureId") int literatureId);
}