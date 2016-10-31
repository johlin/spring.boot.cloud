package cn.com.jhn.main.sys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 发票配置文件
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-21 下午 1:26
 **/
@ConfigurationProperties(locations = "classpath:config/application-pkcs7.properties")
public class InvoiceConf {

    private  String PUBLIC_TRUSTS;
    private  String CLIENT_DECRYPTPFX;
    private  String CLIENT_DECRYPTPFX_KEY;
    private  String CLIENT_DECRYPTCER;
    private  String PLATFORM_DECRYPTCER;
    private  String PLATFORM_DECRYPTPFX;
    private  String DLLADDRESS1;
    private  String DLLADDRESS2;

    public String getPUBLIC_TRUSTS() {
        return PUBLIC_TRUSTS;
    }

    public void setPUBLIC_TRUSTS(String PUBLIC_TRUSTS) {
        this.PUBLIC_TRUSTS = PUBLIC_TRUSTS;
    }

    public String getCLIENT_DECRYPTPFX() {
        return CLIENT_DECRYPTPFX;
    }

    public void setCLIENT_DECRYPTPFX(String CLIENT_DECRYPTPFX) {
        this.CLIENT_DECRYPTPFX = CLIENT_DECRYPTPFX;
    }

    public String getCLIENT_DECRYPTPFX_KEY() {
        return CLIENT_DECRYPTPFX_KEY;
    }

    public void setCLIENT_DECRYPTPFX_KEY(String CLIENT_DECRYPTPFX_KEY) {
        this.CLIENT_DECRYPTPFX_KEY = CLIENT_DECRYPTPFX_KEY;
    }

    public String getCLIENT_DECRYPTCER() {
        return CLIENT_DECRYPTCER;
    }

    public void setCLIENT_DECRYPTCER(String CLIENT_DECRYPTCER) {
        this.CLIENT_DECRYPTCER = CLIENT_DECRYPTCER;
    }

    public String getPLATFORM_DECRYPTCER() {
        return PLATFORM_DECRYPTCER;
    }

    public void setPLATFORM_DECRYPTCER(String PLATFORM_DECRYPTCER) {
        this.PLATFORM_DECRYPTCER = PLATFORM_DECRYPTCER;
    }

    public String getPLATFORM_DECRYPTPFX() {
        return PLATFORM_DECRYPTPFX;
    }

    public void setPLATFORM_DECRYPTPFX(String PLATFORM_DECRYPTPFX) {
        this.PLATFORM_DECRYPTPFX = PLATFORM_DECRYPTPFX;
    }

    public String getDLLADDRESS1() {
        return DLLADDRESS1;
    }

    public void setDLLADDRESS1(String DLLADDRESS1) {
        this.DLLADDRESS1 = DLLADDRESS1;
    }

    public String getDLLADDRESS2() {
        return DLLADDRESS2;
    }

    public void setDLLADDRESS2(String DLLADDRESS2) {
        this.DLLADDRESS2 = DLLADDRESS2;
    }
}
