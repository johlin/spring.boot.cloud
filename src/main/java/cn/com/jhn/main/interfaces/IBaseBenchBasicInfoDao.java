/**
 * @FILE:IBaseBenchBasicInfoDao.java
 * @AUTHOR:孙弘治
 * @DATE:2016年4月16日 下午5:35:31
 **/
package cn.com.jhn.main.interfaces;

import java.util.Map;

/**
 * @CALSS:
 * @DESCRIPTION:
 * @AUTHOR: 陈琳
 * @VERSION: V1.0
 * @DATE:  2016/10/20 0020 下午 4:29
 */
public interface IBaseBenchBasicInfoDao {

	String getAllocationId(Map<String, String> map);
	
	Integer getAllocationIdByTypeCode(Map<String, Object> map);

}

