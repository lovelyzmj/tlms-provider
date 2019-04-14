package com.xupt.tlms.tlmsprovider.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xupt.tlms.pojo.KeyWord;
import com.xupt.tlms.pojo.Literature;
import com.xupt.tlms.service.LiteratureService;
import com.xupt.tlms.tlmsprovider.Dao.LiteratureDao;
import com.xupt.tlms.vojo.LiteratureVo;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LiteratureServiceImpl implements LiteratureService {

    @Resource
    private LiteratureDao literatureDao;

    @Override
    public int inputLiterature(Literature literature, List<KeyWord> list, int i) {
        return 0;
    }

    @Override
    public List<Literature> getLiteratureByResearchId(int researchId) {
        List<Literature> list = literatureDao.findAllByResearchId(researchId);
        if (list == null || list.size() == 0)
            return null;
        return list;
    }

    @Override
    public LiteratureVo getLiteratureInfoById(int id) {
        return null;
    }

    @Override
    public boolean deleteLiterature(int id) {
        return false;
    }

    @Override
    public boolean updateLiterature(Literature literature) {
        return false;
    }
}
