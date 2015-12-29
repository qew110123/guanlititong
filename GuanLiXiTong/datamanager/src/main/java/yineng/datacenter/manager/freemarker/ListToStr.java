package yineng.datacenter.manager.freemarker;

import java.util.List;

import yineng.datacenter.manager.util.StringUtils;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/** 
 * <p>Description: </p>
 * <p>Copyright: Copyright (c)2015,艺能科技  All rights reserved.</p>
 * @author wangxw
 * @date 创建时间：2015年11月12日 上午11:13:50 
 * @version 1.0 
 */

public class ListToStr implements TemplateMethodModelEx {

	@SuppressWarnings("rawtypes")
	@Override
	public Object exec(List arguments) throws TemplateModelException {
		SimpleSequence simpleSequence = (SimpleSequence) arguments.get(0);
		if(simpleSequence==null||simpleSequence.size()==0){
			return "";
		}else{
			List list = simpleSequence.toList();
			return StringUtils.listToString(list);
		}
	}
}
