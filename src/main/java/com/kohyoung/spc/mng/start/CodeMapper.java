package com.kohyoung.spc.mng.start;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CodeMapper extends BasicMapper<Code, Long> {
	
	public List<Code> searchList(HashMap paramMap);
	
	public Integer searchCount(HashMap paramMap);
	
	public Code selectOneByCode(Code code);
	
	public void deleteFg(Code code);
	
	public void deleteByCode(Code code);
	
	public void deleteFgByCode(Code code);
}
