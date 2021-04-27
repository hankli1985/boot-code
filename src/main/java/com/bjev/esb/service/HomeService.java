package com.bjev.esb.service;

import com.bjev.esb.vo.resp.HomeRespVO;

/**
 * 首页
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
public interface HomeService {

    HomeRespVO getHomeInfo(String userId);
}
