package com.xupt.tlms.tlmsprovider.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xupt.tlms.pojo.Research;
import com.xupt.tlms.service.ResearchService;
import com.xupt.tlms.tlmsprovider.Dao.ResearchDao;
import com.xupt.tlms.vojo.ResearchVo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResearchServiceImpl implements ResearchService {

    @Resource
    private ResearchDao researchDao;

    @Override
    public Research creatResearch(Research research) {
        int flag = researchDao.insert(research);
        if (flag == 0)
            return null;
        return research;
    }

    @Override
    public List<ResearchVo> findByUserId(int userId) {
        List<ResearchVo> list = researchDao.findAllByUserId(userId);
        if (list == null || list.size()==0)
            return null;
        return list;
    }

    @Override
    public boolean updateResearch(Research research) {
        int flag = researchDao.updateResearch(research);
        if (flag == 0)
            return false;
        return true;
    }

    @Override
    public boolean deleteResearchById(int id) {
        int flag = researchDao.deleteResearch(id);
        if (flag == 0)
            return false;
        return true;
    }
}
