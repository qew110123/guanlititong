package yineng.datacenter.manager.mybatis.db;

/**
 * 数据库方言接口
 * 
 * @author x
 *
 */
public interface Dialect {  
	  
    public String getLimitString(String sql, int skipResults, int maxResults);  
      
}