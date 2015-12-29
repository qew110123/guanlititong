package yineng.datacenter.manager.model;

import yineng.datacenter.manager.entity.User;

public class UserModel extends User {
	private static final long serialVersionUID = -3599357193523636619L;
	
	private String otherInfo;

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
}
