package yineng.datacenter.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yineng.datacenter.manager.constant.ReturnMessage;
import yineng.datacenter.manager.model.ResponseModel;
import yineng.datacenter.manager.service.ArtCountService;
import yineng.datacenter.manager.util.TimeTest;

@Controller
@RequestMapping("/artCount")
public class ArtCountController {
	@Autowired
	private ArtCountService artCountService;

	@RequestMapping("/getAll")
	public ModelAndView getAll() throws Exception {
		ModelAndView mv = new ModelAndView();
		ResponseModel responseModel = artCountService.getAll();
		String returnCode = responseModel.getReturnCode();
		if (ReturnMessage.SUCCESS.getCode().equals(returnCode)
				&& responseModel.getData() != null) {
			mv.addObject("artCountList", responseModel.getData());
			mv.setViewName("artCount/artCount");
		} else {
			mv.setViewName("user/login");
		}
		return mv;
	}

	@RequestMapping("/findBydata")
	public ModelAndView findBydata() throws Exception {
		ModelAndView mv = new ModelAndView();
		ResponseModel responseModel = artCountService.findBydata();
		String returnCode = responseModel.getReturnCode();
		
		if (ReturnMessage.SUCCESS.getCode().equals(returnCode)
				&& responseModel.getData() != null) {
			mv.addObject("data", responseModel.getData());
//			
////			头文件
//			mv.addObject("artDateList", responseModel.getData().getTopdata());
////			评分
//			mv.addObject("artCountPingFenList", responseModel.getPingfendata());	
			mv.setViewName("artCount/artCount");
		} else {
			mv.setViewName("user/login");
		}
		return mv;
	}
}
