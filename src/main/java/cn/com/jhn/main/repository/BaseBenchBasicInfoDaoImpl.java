/**
 * @FILE:BaseBenchBasicInfoDaoImpl.java
 * @AUTHOR:孙弘治
 * @DATE:2016年4月16日 下午5:36:42
 **/
package cn.com.jhn.main.repository;

import cn.com.jhn.main.base.BaseDao;
import cn.com.jhn.main.interfaces.IBaseBenchBasicInfoDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @CALSS:
 * @DESCRIPTION:
 * @AUTHOR: 陈琳
 * @VERSION: V1.0
 * @DATE: 2016/10/20 0020 下午 4:50
 */
@Repository
public class BaseBenchBasicInfoDaoImpl extends
        BaseDao implements
        IBaseBenchBasicInfoDao {

    Logger logger= Logger.getLogger(BaseBenchBasicInfoDaoImpl.class);
    @Override
    public String getAllocationId(Map<String, String> map) {
        return this.getReadSqlSessionTemplate().getMapper(IBaseBenchBasicInfoDao.class).getAllocationId(map);

    }

    @Override
    public Integer getAllocationIdByTypeCode(Map<String, Object> map) {

        return this.getReadSqlSessionTemplate().getMapper(IBaseBenchBasicInfoDao.class).getAllocationIdByTypeCode(map);
    }

}

