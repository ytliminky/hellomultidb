package com.kohyoung.spc.mng.start;

import java.util.List;

public interface BasicMapper<T, PK> {

	public List<T> selectList(T t);
	public T selectOne(PK pk);
	public void insert(T t);
	public void update(T t);
	public void deletePK(PK pk);

}
