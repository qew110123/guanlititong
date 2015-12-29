package yineng.datacenter.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yineng.datacenter.manager.constant.ReturnMessage;
import yineng.datacenter.manager.model.ArtCountModel;
import yineng.datacenter.manager.model.ResponseModel;
import yineng.datacenter.manager.mybatis.dao.MyBatisDao;
import yineng.datacenter.manager.service.ArtCountService;
import yineng.datacenter.manager.util.TimeTest;

@Service
public class ArtCountServiceImpl implements ArtCountService {
	@Autowired
	private MyBatisDao myBatisDao;

	@Override
	public ResponseModel getAll() throws Exception {
		ResponseModel responseModel = new ResponseModel();
		List<ArtCountModel> artCountList = myBatisDao
				.getList("artCountMapper.getAll");
		responseModel.setReturnCode(ReturnMessage.SUCCESS.getCode());
		responseModel.setData(artCountList);
		return responseModel;
	}

	@Override
	public ResponseModel findBydata() throws Exception {
		ResponseModel responseModel = new ResponseModel();
		TimeTest tt = new TimeTest();
		String newtime = tt.getNowTime("yyyyMMdd");
		String times = tt.getBeforeAfterDatecha(newtime, -10);
		String strData = times;
		List<ArtCountModel> artCountListdao = myBatisDao.getList(
				"artCountMapper.findBydata", strData);
		responseModel.setReturnCode(ReturnMessage.SUCCESS.getCode());
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, String>> artCountList = new ArrayList();
		artCountList.add(mapArtCountreturn(artCountListdao, "总播放量", "优酷"));
		artCountList.add(mapArtCountreturn(artCountListdao, "总播放量", "爱奇艺"));
		artCountList.add(mapArtCountreturn(artCountListdao, "总播放量", "腾讯"));
		artCountList.add(mapArtCountreturn(artCountListdao, "总播放量", "搜狐"));
		artCountList.add(mapArtCountreturn(artCountListdao, "总播放量", "乐视"));
		artCountList.add(mapArtCountreturn(artCountListdao, "总播放量", "迅雷看看"));
		Map<String, String> mapArtCount = new HashMap<String, String>();
		for (Map<String, String> map : artCountList) {
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				if (mapArtCount.containsKey(key)) {
					String strIntnum = mapArtCount.get(key);
					int strvalue = (Integer.parseInt(strIntnum) + Integer
							.parseInt(map.get(key)));
					mapArtCount.remove(key);
					mapArtCount.put(key, String.valueOf(strvalue));
				} else {
					mapArtCount.put(key, map.get(key));
				}
			}
		}
		artCountList.add(mapArtCount);
		// 头文件
		data.put("countZongShuJuList", artCountList);
		List<String> listDate = new ArrayList();
		for (int i = 0; i <= 10; i++) {
			listDate.add(tt.getBeforeAfterDatecha(newtime, i - 10));
		}
		data.put("Topdata", listDate);
		// 评分
		List<Map<String, String>> artCountpingfenList = new ArrayList();
		artCountpingfenList.add(mapArtCountreturn(artCountListdao, "评分", "优酷"));
		artCountpingfenList
				.add(mapArtCountreturn(artCountListdao, "评分", "爱奇艺"));
		artCountpingfenList.add(mapArtCountreturn(artCountListdao, "评分", "腾讯"));
		artCountpingfenList.add(mapArtCountreturn(artCountListdao, "评分", "搜狐"));
		artCountpingfenList.add(mapArtCountreturn(artCountListdao, "评分", "乐视"));
		// artCountpingfenList.add(mapArtCountreturn(artCountListdao, "评分",
		// "迅雷看看"));
		Map<String, String> mapArtpingfenCount = new HashMap<String, String>();
		for (Map<String, String> map : artCountpingfenList) {
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				// System.out.println(key+"..."+map.get(key));
				// mapArtCount
				if (mapArtpingfenCount.containsKey(key)) {
					String strIntnum = mapArtpingfenCount.get(key);
					int strvalue = (Integer.parseInt(strIntnum) + Integer
							.parseInt(map.get(key)));
					mapArtpingfenCount.remove(key);
					mapArtpingfenCount.put(key, String.valueOf(strvalue));
				} else {
					mapArtpingfenCount.put(key, map.get(key));
				}
			}
		}
		artCountpingfenList.add(mapArtpingfenCount);

		data.put("pingfenList", artCountpingfenList);

		// 评论量
		List<Map<String, String>> artCountPingLunList = new ArrayList();
		artCountPingLunList
				.add(mapArtCountreturn(artCountListdao, "评论量", ""));
		data.put("CountPingLun", artCountPingLunList);
		// 搜索指数--电视剧
		List<Map<String, String>> artCountSouShuoZhiShuList = new ArrayList();
		artCountSouShuoZhiShuList.add(mapArtCountreturn(artCountListdao,
				"搜索指数", ""));
		data.put("CountSouShuoZhiShu", artCountSouShuoZhiShuList);

		// 媒体关注度--电视剧
		List<Map<String, String>> artCountMeiTiGuanZhuDuList = new ArrayList();
		artCountMeiTiGuanZhuDuList.add(mapArtCountreturn(artCountListdao,
				"媒体关注度", ""));
		data.put("CountMeiTiGuanZhuDu", artCountMeiTiGuanZhuDuList);
		responseModel.setData(data);
		return responseModel;
	}

	/**
	 * 进行数据的统一规范化
	 * 
	 * @param artCountListdao
	 * @param strgetClassOne
	 * @param strgetClassTwo
	 * @return
	 */
	public static Map<String, String> mapArtCountreturn(
			List<ArtCountModel> artCountListdao, String strgetClassOne,
			String strgetClassTwo) {
		Map<String, String> mapArtCount = new HashMap<String, String>();
		for (ArtCountModel artCountModel : artCountListdao) {
			if (strgetClassOne.equals(artCountModel.getClassOne())) {
				if (strgetClassTwo.equals("")) {
					mapArtCount.put(artCountModel.getCountData(), artCountModel
							.getCountNum().toString());
				}
				if (strgetClassTwo.equals(artCountModel.getClassTwo())) {
					// System.out.println(artCountModel.getId()+"&&"+artCountModel.getClassTwo()+"artCountModel.getCountData()"+artCountModel.getCountData()+"$$"+artCountModel.getCountNum().toString());
					mapArtCount.put(artCountModel.getCountData(), artCountModel
							.getCountNum().toString());
				}
			}
		}
		return mapArtCount;
	}

}
