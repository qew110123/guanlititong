package yineng.datacenter.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yineng.datacenter.manager.constant.ReturnMessage;
import yineng.datacenter.manager.model.ResponseModel;
import yineng.datacenter.manager.model.UserModel;
import yineng.datacenter.manager.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public ModelAndView login(UserModel userModel) throws Exception{
		ModelAndView mv = new ModelAndView();
		ResponseModel login = userService.login(userModel);
		String returnCode = login.getReturnCode();
		if(ReturnMessage.SUCCESS.getCode().equals(returnCode)&&login.getData()!=null){
			mv.setViewName("index");
		}else{
			mv.setViewName("user/login");
		}
		return mv;
	}
}
