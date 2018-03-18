package dao;

import java.util.List;

import entity.Autograph;

public interface AutographDao {
	List<Autograph> queryByKind(int kindid) throws Exception;

	Autograph queryOne(int autograpgid) throws Exception;
}
