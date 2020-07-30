package com.kohyoung.spc.mng.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


@Service
@Transactional
public class CodeService {
	@Autowired
    CodeMapper codeMapper;

	public HashMap searchPage(HashMap paramMap) {
		HashMap resultMap = new HashMap();
		
		resultMap.put("list", codeMapper.searchList(paramMap));
		resultMap.put("count", codeMapper.searchCount(paramMap));
		
		return resultMap;
	}

	public Code selectOne(Long codeId) {
		return codeMapper.selectOne(codeId);
	}

	public void insert(Code code) {
		codeMapper.insert(code);
	}
	
	public void update(Code code) {
		codeMapper.update(code);
	}

	public void delete(Code param) {
		codeMapper.deleteFg(param);;
	}
	
	// not yet used
	public List<Code> selectList(Code param) {
		return codeMapper.selectList(param);
	}
	public List<Code> searchList(HashMap paramMap) {
		return codeMapper.searchList(paramMap);
	}

	public void deletePK(Long codeId) {
		codeMapper.deletePK(codeId);
	}

}