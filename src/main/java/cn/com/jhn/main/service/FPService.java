package cn.com.jhn.main.service;

import cn.com.jhn.main.sys.InvoiceConf;
import cn.com.jhn.main.utils.Base64Helper;
import com.aisino.PKCS7;
import org.apache.commons.io.FileUtils;
import org.codehaus.xfire.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;

@Service
public class FPService {
    @Autowired
    protected InvoiceConf invoiceConf;

    /**
     * @param
     * @description:发票开据
     * @author:陈琳
     * @return:
     */
    public String invoiceIssued(String xml) throws Exception {
        //CA加密
        final String trustsBytes = invoiceConf.getPUBLIC_TRUSTS();
        String decryptPFXBytes = invoiceConf.getCLIENT_DECRYPTPFX();
        String decryptPFXKey = invoiceConf.getCLIENT_DECRYPTPFX_KEY();
        String dllAddress = invoiceConf.getDLLADDRESS2();
        final PKCS7 pkcs7Client = new PKCS7(dllAddress,
                                            FileUtils.readFileToByteArray(new File(trustsBytes)),
                                            FileUtils.readFileToByteArray(new File(decryptPFXBytes)),
                                            decryptPFXKey);
        final byte[] encodeData = pkcs7Client.pkcs7Encrypt(xml,
                                                           FileUtils.readFileToByteArray(
                                                                   new File(invoiceConf.getPLATFORM_DECRYPTCER())));
        final byte[] base64Date = Base64Helper.encode(encodeData);
        String encodeText = new String(base64Date);
        String encodeXML = new String(Base64Helper.encode(xml));
        String globle = "<?xml version='1.0' encoding='utf-8' ?>" +
                        "<interface xmlns='' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "
                        + "xsi:schemaLocation='http://www.chinatax.gov.cn/tirip/dataspec/interfaces.xsd' "
                        + "version='DZFP1.0' >"
                        + "<globalInfo>" + "<terminalCode>0</terminalCode>" + "<appId>ZZS_PT_DZFP</appId>"
                        + "<version>2.0</version>" + "<interfaceCode>ECXML.FPKJ.BC.E_INV</interfaceCode>"
                        + "<requestCode>14410101</requestCode>" + "<requestTime>2015-08-06 10:30:42 978</requestTime>"
                        + "<responseCode>144</responseCode>"
                        + "<dataExchangeId>P000000120160104270892641</dataExchangeId>"
                        + "<userName>14410101</userName>" + "<passWord>0981202609xFBzKNdCxSuCZP2TjDD2fA==</passWord>"
                        + "<taxpayerId>110101MXB6CK9Q6</taxpayerId>"
                        + "<authorizationCode>6270892641</authorizationCode>" + "</globalInfo>" + "<returnStateInfo>"
                        + "<returnCode />" + "<returnMessage />" + "</returnStateInfo>" + "<Data>" + "<dataDescription>"
                        + " <zipCode>0</zipCode>" + "<encryptCode>2</encryptCode>" + "<codeType>0</codeType>"
                        + "</dataDescription>" + "<content>" + encodeXML + "</content>" + "</Data>" + "</interface>";

        System.out.println(globle);
        Client client = new Client(
                new URL("http://ei-test.51fapiao.cn:20080/51TransferServicePro_zzs/webservice/eInvWS?wsdl"));
        Object[] objs = client.invoke("eiInterface", new Object[]{globle});
        String res = objs[0].toString();
        return res;
    }

    /**
     * @param
     * @description:发票下载
     * @author:陈琳
     * @return:
     */
    public String invoiceDownload(String xml) throws Exception {
        final String trustsBytes = invoiceConf.getPUBLIC_TRUSTS();
        String decryptPFXBytes = invoiceConf.getCLIENT_DECRYPTPFX();
        String decryptPFXKey = invoiceConf.getCLIENT_DECRYPTPFX_KEY();
        String dllAddress = invoiceConf.getDLLADDRESS2();
        final PKCS7 pkcs7Client = new PKCS7(dllAddress,
                                            FileUtils.readFileToByteArray(new File(trustsBytes)),
                                            FileUtils.readFileToByteArray(new File(decryptPFXBytes)),
                                            decryptPFXKey);
        final byte[] encodeData = pkcs7Client.pkcs7Encrypt(xml,
                                                           FileUtils.readFileToByteArray(
                                                                   new File(invoiceConf.getPLATFORM_DECRYPTCER())));
        final byte[] base64Data = Base64Helper.encode(encodeData);
        String encodeXml = new String(base64Data);
        String globle = "<?xml version='1.0' encoding='utf-8' ?>" +
                        "<interface xmlns='' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "
                        + "xsi:schemaLocation='http://www.chinatax.gov.cn/tirip/dataspec/interfaces.xsd' "
                        + "version='DZFP1.0' >"
                        +
                        "<globalInfo>" +
                        "<terminalCode>0</terminalCode>" +
                        "<appId>ZZS_PT_DZFP</appId>" +
                        "<version>2</version>" +
                        "<interfaceCode>ECXML.FPXZ.CX.E_INV</interfaceCode>" +
                        "<requestCode>14410101</requestCode>" +
                        "<requestTime>2015-08-06 10:30:42 978</requestTime>" +
                        "<responseCode>144</responseCode>" +
                        "<dataExchangeId>P0000001ECXML.FPKJ.BC.E_INV20150807eXl4EymmJ</dataExchangeId>" +
                        "<userName>14410101</userName>" +
                        "<passWord>0981202609xFBzKNdCxSuCZP2TjDD2fA==</passWord>" +
                        "<taxpayerId>110101MXB6CK9Q6</taxpayerId>" +
                        "<authorizationCode>6270892641</authorizationCode>" +
                        "</globalInfo>" +
                        "<returnStateInfo>" +
                        "<returnCode />" +
                        "<returnMessage />" +
                        "</returnStateInfo>" +
                        "<Data>" +
                        "<dataDescription>" +
                        " <zipCode>0</zipCode>" +
                        "<encryptCode>2</encryptCode>" +
                        "<codeType>0</codeType>" +
                        "</dataDescription>" +
                        "<content>" + encodeXml +
                        "</content>" +
                        "</Data>" +
                        "</interface>";
        Client client = new Client(
                new URL("http://ei-test.51fapiao.cn:20080/51TransferServicePro_zzs/webservice/eInvWS?wsdl"));
        Object[] objs = client.invoke("eiInterface", new Object[]{globle});
        String res = objs[0].toString();
        return res;
    }
}
