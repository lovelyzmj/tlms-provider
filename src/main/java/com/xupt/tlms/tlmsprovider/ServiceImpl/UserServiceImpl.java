package com.xupt.tlms.tlmsprovider.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xupt.tlms.pojo.User;
import com.xupt.tlms.service.UserService;
import com.xupt.tlms.tlmsprovider.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public boolean register(User user) {
        int flag = userDao.insert(user);
        if (flag == 0)
            return false;
        return true;

    }

    @Override
    public User login(String userName, String password) {
        return userDao.getOne(userName,password);
    }

    @Override
    public User findByName(String realName) {
        return userDao.findOneByRealName(realName);
    }

    @Override
    public User findById(int id) {
        return userDao.finOneByUserId(id);
    }

    @Override
    public boolean updateUser(User user) {
        int flag = userDao.update(user);
        if (flag == 0)
            return false;
        return true;
    }

    @Override
    public List<User> FindAllUserByTeamId(int teamId) {
        List<User> list = userDao.getAllUser(teamId);
        if (list == null || list.size() == 0)
            return null;
        return list;
    }

    @Override
    public boolean findByUserName(String userName) {
        User user = userDao.findByUserName(userName);
        if (user == null)
            return false;
        return true;
    }

}
