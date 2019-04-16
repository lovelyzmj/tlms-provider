package com.xupt.tlms.tlmsprovider.ServiceImpl;

import com.xupt.tlms.pojo.KeyWord;
import com.xupt.tlms.service.KeyWordService;
import com.xupt.tlms.tlmsprovider.Dao.KeyWordDao;

import javax.annotation.Resource;
import java.util.List;

public class KeyWordServiceImpl implements KeyWordService {
    @Resource
    private KeyWordDao keyWordDao;

    @Override
    public List<KeyWord> findByName(String name) {
        if (name == null || name.trim() == ""){
            return keyWordDao.findAll();
        }
        return keyWordDao.findByName(name);
    }

}
