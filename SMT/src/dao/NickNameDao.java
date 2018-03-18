package dao;

import java.util.List;

import entity.NickName;

public interface NickNameDao {
	List<NickName> queryByKind(int kindid) throws Exception;

	NickName queryOne(int nickNameid) throws Exception;
}
