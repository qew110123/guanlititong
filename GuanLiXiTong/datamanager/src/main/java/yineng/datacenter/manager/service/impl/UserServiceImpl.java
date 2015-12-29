package yineng.datacenter.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yineng.datacenter.manager.constant.ReturnMessage;
import yineng.datacenter.manager.model.ResponseModel;
import yineng.datacenter.manager.model.UserModel;
import yineng.datacenter.manager.mybatis.dao.MyBatisDao;
import yineng.datacenter.manager.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private MyBatisDao myBatisDao;
	public ResponseModel login(UserModel userModel) throws Exception {
		ResponseModel responseModel = new ResponseModel();
		//UserModel userInfo = myBatisDao.get("UserMapper.getUser", userModel);
		
		responseModel.setReturnCode(ReturnMessage.SUCCESS.getCode());
		//responseModel.setData(userInfo);
		return responseModel;
	}

}
