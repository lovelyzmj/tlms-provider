package com.xupt.tlms.tlmsprovider.Dao;

import com.xupt.tlms.pojo.Comment;
import com.xupt.tlms.vojo.CommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {
    int insert(Comment comment);

    List<CommentVo> findAllCommentByNotesId(int notesId);

    List<CommentVo> findMyComment(int userId);

    int delete (int id);
}
