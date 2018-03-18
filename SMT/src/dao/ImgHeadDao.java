package dao;

import java.util.List;

import entity.Autograph;
import entity.Images;
import entity.ImgHead;

public interface ImgHeadDao {
	List<ImgHead> queryByKind(int kindid) throws Exception;

	ImgHead queryOne(int imgHeadid)throws Exception;
	
	int insert(ImgHead imgHead) throws Exception;
}
