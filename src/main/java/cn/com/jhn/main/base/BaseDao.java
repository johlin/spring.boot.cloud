package cn.com.jhn.main.base;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @CALSS:BaseDao
 * @DESCRIPTION:
 * @AUTHOR: 陈琳
 * @VERSION: V1.0
 * @DATE:  2016/10/20 0020 下午 4:22
 */
@Repository
public class BaseDao {
	private static final String SQLID_SEPARATOR = "."; // namespace中连接类全名和sqlId的分隔符

	@Resource
	@Qualifier("readSqlSessionTemplate")
	private SqlSessionTemplate readSqlSessionTemplate;
	@Resource
	@Qualifier("writeSqlSessionTemplate")
	private SqlSessionTemplate writeSqlSessionTemplate;

	
    public BaseDao() {
		
	}

   
	protected String getSqlId(String sqlId) {
		return getSqlId(this.getClass(), sqlId);
	}

	@SuppressWarnings("rawtypes")
	protected static String getSqlId(Class clazz, String sqlId) {
		if (clazz == null || sqlId == null) {
			return null;
		}
		return clazz.getName() + SQLID_SEPARATOR + sqlId;
	}

	public SqlSessionTemplate getReadSqlSessionTemplate() {
		return readSqlSessionTemplate;
	}

	public void setReadSqlSessionTemplate(SqlSessionTemplate readSqlSessionTemplate) {
		this.readSqlSessionTemplate = readSqlSessionTemplate;
	}

	public SqlSessionTemplate getWriteSqlSessionTemplate() {
		return writeSqlSessionTemplate;
	}

	public void setWriteSqlSessionTemplate(SqlSessionTemplate writeSqlSessionTemplate) {
		this.writeSqlSessionTemplate = writeSqlSessionTemplate;
	}


}
