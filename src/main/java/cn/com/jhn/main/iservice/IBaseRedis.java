package cn.com.jhn.main.iservice;
/**
 * @CALSS:IBASERedis
 * @DESCRIPTION:
 * @AUTHOR: 陈琳
 * @VERSION: V1.0
 * @DATE:  2016/10/28 0028 下午 1:48
 */
public interface IBaseRedis {
    public Boolean put(String key,String value);

    public Boolean jedisPut(String key,String value);
}
