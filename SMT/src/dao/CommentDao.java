package dao;

import java.util.List;

import entity.Comment;

public interface CommentDao {
	List<Comment> query(String use, int useid) throws Exception;

	int insert(Comment comment) throws Exception;
}
