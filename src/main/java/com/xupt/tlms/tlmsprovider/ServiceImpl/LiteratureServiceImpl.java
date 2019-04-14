package com.xupt.tlms.tlmsprovider.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xupt.tlms.pojo.KeyWord;
import com.xupt.tlms.pojo.Literature;
import com.xupt.tlms.service.LiteratureService;
import com.xupt.tlms.tlmsprovider.Dao.KeyWordDao;
import com.xupt.tlms.tlmsprovider.Dao.LiteratureDao;
import com.xupt.tlms.tlmsprovider.Dao.NotesDao;
import com.xupt.tlms.vojo.LiteratureVo;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LiteratureServiceImpl implements LiteratureService {

    @Resource
    private LiteratureDao literatureDao;

    @Resource
    private KeyWordDao keyWordDao;

    @Resource
    private NotesDao notesDao;


    @Override
    public boolean inputLiterature(Literature literature, List<KeyWord> list, int researchId) {
        if (literatureDao.insert(literature) == 0){
            return false;
        }
        if(literatureDao.insertLiteratureAndResearch(literature.getId(),researchId)== 0){
            return false;
        }

        for (int i = 0 ; i<list.size();i++){
            if (list.get(i).getId() != 0){
                if (keyWordDao.insertKeyWordAndLiterature(list.get(i).getId(),literature.getId()) == 0) {
                    return false;
                }
            }else {
                if (keyWordDao.insert(list.get(i).getName()) == 0) {
                    return false;
                }
                if (keyWordDao.insertKeyWordAndLiterature(list.get(i).getId(), literature.getId()) == 0) {
                    return false;
                }
            }
        }
        return true;
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
        LiteratureVo literatureVo = new LiteratureVo();
        literatureVo.setLiterature(literatureDao.findOneById(id));
        literatureVo.setKeyWordList(keyWordDao.findAllByLiteratureId(id));
        System.out.println(literatureVo.getKeyWordList());
        literatureVo.setNotesVos(notesDao.findNotesByliteratureId(id));
        return literatureVo;
    }

    @Override
    public boolean deleteLiterature(int id) {
        return false;
    }

    @Override
    public boolean updateLiterature(Literature literature) {
        return false;
    }

    @Override
    public boolean getLiteratureByNameAndResearchId(String name, int researchId) {
        if (literatureDao.findLiteratureByNameAndResearchId(name,researchId) == null)
            return false;
        return true;
    }
}
