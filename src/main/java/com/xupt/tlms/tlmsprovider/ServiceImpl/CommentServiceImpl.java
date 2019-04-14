package com.xupt.tlms.tlmsprovider.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xupt.tlms.pojo.Comment;
import com.xupt.tlms.service.CommentService;
import com.xupt.tlms.tlmsprovider.Dao.CommentDao;
import com.xupt.tlms.vojo.CommentVo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

    @Override
    public boolean wirteComment(Comment comment) {
        if (commentDao.insert(comment) == 0){
            return false;
        }
        return true;
    }

    @Override
    public List<CommentVo> getAllCommentByNotesId(int notesId) {
        List<CommentVo> list = commentDao.findAllCommentByNotesId(notesId);
        if (list == null || list.size() == 0)
            return null;
        return list;
    }

    @Override
    public List<CommentVo> getMyComment(int userId) {
        List<CommentVo> list = commentDao.findMyComment(userId);
        if (list == null || list.size() == 0)
            return null;
        return list;
    }

    @Override
    public boolean deleteById(int id) {
        if (commentDao.delete(id) == 0){
            return false;
        }
        return true;
    }
}
