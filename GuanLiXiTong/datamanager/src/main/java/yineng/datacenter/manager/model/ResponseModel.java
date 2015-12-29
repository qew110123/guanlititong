package yineng.datacenter.manager.model;

public class ResponseModel {
	private String returnCode;
	private String returnMessage;
	private Object data; 
//	//总播放数据
//	private Object topdata; //表头数据
//	private Object pingfendata; //总播放数据
	
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
