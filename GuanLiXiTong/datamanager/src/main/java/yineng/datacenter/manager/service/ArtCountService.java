package yineng.datacenter.manager.service;

import yineng.datacenter.manager.model.ResponseModel;

public interface ArtCountService {
	/**
	 * @return
	 * @throws Exception
	 */
	public ResponseModel getAll() throws Exception;

	public ResponseModel findBydata() throws Exception;
}
