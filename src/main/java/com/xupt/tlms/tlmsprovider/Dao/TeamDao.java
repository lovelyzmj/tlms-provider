package com.xupt.tlms.tlmsprovider.Dao;

import com.xupt.tlms.pojo.Team;
import com.xupt.tlms.vojo.TeamVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TeamDao {
    int insert(Team team);//创建团队

    TeamVo findOneById(int id);//根据id查找团队

    int addTeam(@Param("userId") int userId,@Param("teamId") int teamId);//加入团队

    int quitTeam(@Param("userId") int userId,@Param("teamId") int teamId);//退出团队

    int deleteTeam(int id);//删除团队

     List<TeamVo> findAllTeamByUserId(@Param("userId") int userId);//根据用户id查找所有加入的团队
}
