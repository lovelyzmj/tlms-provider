package com.xupt.tlms.tlmsprovider.Dao;

import com.xupt.tlms.pojo.Team;
import com.xupt.tlms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface UserDao {

    public int insert(User user);

    int update(User user);

    User getOne(@Param("userName") String userName,@Param("passWord") String passWord);

    User findOneByRealName(String realName);

    User finOneByUserId(int userId);

    List<User> getAllUser(@Param("teamId") int teamId);

}
