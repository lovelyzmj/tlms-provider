package com.xupt.tlms.tlmsprovider.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xupt.tlms.pojo.Notes;
import com.xupt.tlms.service.NotestService;
import com.xupt.tlms.tlmsprovider.Dao.NotesDao;
import com.xupt.tlms.vojo.NotesVo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NotesServiceImpl implements NotestService {

    @Resource
    private NotesDao notesDao;
    @Override
    public boolean writeNotes(Notes notes) {
        int flag = notesDao.insert(notes);
        if (flag == 0)
            return false;
        return true;
    }

    @Override
    public List<NotesVo> getSelfNotes(int userId) {
        return notesDao.findSelfNotes(userId);
    }

    @Override
    public List<NotesVo> getNotesByliteratureId(int literatureId) {
        return null;
    }

    @Override
    public boolean updateNotes(Notes notes) {
        if (notesDao.update(notes) == 0){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteNotes(int id) {
        return false;
    }

    @Override
    public NotesVo getById(int id) {
        return notesDao.findById(id);
    }
}
