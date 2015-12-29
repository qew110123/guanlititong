package yineng.datacenter.manager.mybatis.db.impl;

import yineng.datacenter.manager.mybatis.db.Dialect;

public class MysqlDialect implements Dialect {

	/* (non-Javadoc) 
	 * @see org.mybatis.extend.interceptor.IDialect#getLimitString(java.lang.String, int, int) 
	 */
	@Override
	public String getLimitString(String sql, int offset, int limit) {

		sql = sql.trim();
		StringBuffer buf = new StringBuffer(sql.length() + 20).append(sql);

		if (offset > 0) {
			buf.append(" limit ").append(offset).append(", ").append(limit);
		} else {
			buf.append(" limit ").append(limit);
		}
		
		return buf.toString();
	}
	


}