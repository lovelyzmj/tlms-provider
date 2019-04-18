package com.xupt.tlms.tlmsprovider.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xupt.tlms.pojo.Team;
import com.xupt.tlms.pojo.User;
import com.xupt.tlms.service.TeamService;
import com.xupt.tlms.tlmsprovider.Dao.TeamDao;
import com.xupt.tlms.vojo.TeamVo;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TeamServiceImpl implements TeamService
{
    @Resource
    private TeamDao teamDao;

    @Override
    public Team creatTeam(Team team) {
        int flag = teamDao.insert(team);
        if (flag == 0)
            return null;
        System.out.println(team);
        teamDao.addTeam(team.getCreaterId(),team.getId());
        return team;
    }

    @Override
    public TeamVo findTeam(int teamId) {
        return teamDao.findOneById(teamId);
    }

    @Override
    public boolean addTeam(int userId,int teamId) {
        int flag = teamDao.addTeam(userId,teamId);
        if (flag == 0)
            return false;
        return true;
    }

    @Override
    public boolean deleteTeam(int teamId) {
        int flag = teamDao.deleteTeam(teamId);
        if (flag == 0)
            return false;
        return true;
    }

    @Override
    public boolean quitTeam(int userId,int teamId) {
        int flag = teamDao.quitTeam(userId,teamId);
        if (flag == 0)
            return false;
        return true;
    }

    @Override
    public List<TeamVo> findAllTeamByUserId(int userId) {
        List<TeamVo> list = teamDao.findAllTeamByUserId(userId);
        if (list == null || list.size() == 0)
            return null;
        return list;
    }

}
