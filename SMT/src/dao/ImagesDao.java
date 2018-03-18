package dao;

import java.util.List;

import entity.Images;

public interface ImagesDao {
	int insert(Images images) throws Exception;

	List<Images> queryImages(String use, int use_id) throws Exception;
}
