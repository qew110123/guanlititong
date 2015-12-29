package yineng.datacenter.manager.service;

import yineng.datacenter.manager.model.ResponseModel;
import yineng.datacenter.manager.model.UserModel;

public interface UserService {
	/**
	 * @return
	 */
	public ResponseModel login(UserModel userModel) throws Exception;
}
