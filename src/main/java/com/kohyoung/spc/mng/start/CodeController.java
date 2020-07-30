package com.kohyoung.spc.mng.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/code")
public class CodeController {
	
	public static final Logger logger = LoggerFactory.getLogger(CodeController.class);

	@Autowired
	CodeService codeService;

	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String searchListView(Model model, @RequestParam HashMap paramMap) {
		paramMap.put("useFlag", "Y");
//		HttpUtils.setPageMap(paramMap);

		HashMap resultMap = codeService.searchPage(paramMap);
		model.addAttribute("list", resultMap.get("list"));
		model.addAttribute("totalCount", resultMap.get("count"));

		return "code/list";
	}
	
	@RequestMapping(value = "/edit/{codeId}", method = RequestMethod.GET)
	public String editView(Model model, @PathVariable Long codeId) {
		Code code = codeService.selectOne(codeId);
		model.addAttribute("data", code );
		model.addAttribute("mode", "update" );

		return "code/edit";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addView(Model model) {
		model.addAttribute("mode", "insert" );
		
		return "code/edit";
	}
	
	// Restful API
	@ResponseBody 
	@RequestMapping(value = "/api/list", method = RequestMethod.GET)
	public ResponseEntity<List<Code>> selectList(final HttpServletRequest request, @ModelAttribute Code param) { // not yet used
		List<Code> codeList = codeService.selectList(param);

		if (codeList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Code>>(codeList, HttpStatus.OK); 
	}
	
	@ResponseBody 
	@RequestMapping(value = "/api/search", method = RequestMethod.GET)
	public ResponseEntity<List<Code>> searchList(@RequestParam HashMap paramMap) { // not yet used
		paramMap.put("useFlag", "Y");
//		HttpUtils.setPageMap(paramMap);

		List<Code> codeList = codeService.searchList(paramMap);

		if (codeList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Code>>(codeList, HttpStatus.OK);
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/api/{codeId}", method = RequestMethod.GET)
//	public ResponseEntity<?> selectOne(@PathVariable Long codeId) { // not yet used
//		Code code = codeService.selectOne(codeId);
//
//		if (code == null) {
//			return new ResponseEntity(new CustomErrorType("Code with codeId " + codeId + " not found"), HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<Code>(code, HttpStatus.OK);
//	}

	@ResponseBody
	@RequestMapping(value = "/api/insert", method = RequestMethod.POST)
	public ResponseEntity<Boolean> insert(final HttpServletRequest request, @RequestBody Code code) { // @ModelAttribute Code code
		Boolean isSuccess = false; 
		try {
			codeService.insert(code);
			isSuccess = true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return new ResponseEntity<Boolean>(isSuccess, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value = "/api/update", method = RequestMethod.POST)
	public ResponseEntity<Boolean> update(final HttpServletRequest request, @RequestBody Code code) {
		Boolean isSuccess = false; 
		try {
			codeService.update(code);
			isSuccess = true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return new ResponseEntity<Boolean>(isSuccess, HttpStatus.CREATED);
	}

	@ResponseBody
	@RequestMapping(value = "/api/delete/{codeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(final HttpServletRequest request, @PathVariable Long codeId) {
		Boolean isSuccess = false;
		
		Code code = new Code();
//		code.setCodeId(codeId);
		
		try {

			codeService.delete(code);
			isSuccess = true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return new ResponseEntity<Boolean>(isSuccess, HttpStatus.CREATED);
	}

}
