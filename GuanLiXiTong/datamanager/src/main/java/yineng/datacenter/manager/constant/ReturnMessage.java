package yineng.datacenter.manager.constant;

public enum ReturnMessage {

	/****************** 公用 ******************/
	SUCCESS("000", "成功"), 
	
	LOGOUT("100", "用户未登陆"),
	
	ERROR_PARAM("300", "参数错误"), 
	
	ERROR_SERVICE("500", "服务异常"),
	ERROR_DB("501", "数据库操作异常");
	
	private String code;
	private String message;

	private ReturnMessage(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static String getMessage(String code){
		
		String message = null;
		ReturnMessage returnMessages[] = ReturnMessage.values();
		for(int i=0; i<returnMessages.length; i++){
			ReturnMessage returnMessage = returnMessages[i];
			String temp_code = returnMessage.getCode();
			if(temp_code.equals(code)){
				message = returnMessage.getMessage();
				break;
			}
		}
		
		return message;
	}

}
