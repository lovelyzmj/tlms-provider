package com.xupt.tlms.tlmsprovider.Dao;

import com.xupt.tlms.pojo.Notes;
import com.xupt.tlms.vojo.NotesVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotesDao {
    int insert(Notes notes);
    List<NotesVo> findSelfNotes(int userId);
    List<NotesVo> findNotesByliteratureId(int literatureId);
    int update(Notes notes);
    NotesVo findById(int id);
}
