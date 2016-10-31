package cn.com.jhn.main.utils;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 * Sting工具类
 * StringUtil.java
 * 描述:	
 * 作者:唐凝宽
 * version:v1.0
 * 创建时间:2015年7月22日 上午10:03:24
 */
public class StringUtil {

	private static Logger logger = Logger.getLogger(StringUtil.class);
	/** 
     * 用于建立十六进制字符的输出的小写字符数组 
     */  
    private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5',  
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
  
    /** 
     * 用于建立十六进制字符的输出的大写字符数组 
     */  
    private static final char[] DIGITS_UPPER = { '0', '1', '2', '3', '4', '5',  
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
	
	/**
	 * 转成unicode码格式
	 * @param str
	 * @return
	 */
	 public static String toUnicode(String str){
		 String s1 = "";
	        for (int i = 0; i < str.length(); i++) {
	            s1 +="\\u" +  Integer.toHexString(str.charAt(i) & 0xffff);
	 
	        }
         return s1;
     }

	 public static String toUnicodeString(String s) {
	      StringBuffer sb = new StringBuffer();
	      for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c >= 0 && c <= 255) {
	          sb.append(c);
	        }
	        else {
	         sb.append("\\u"+Integer.toHexString(c));
	        }
	      }
	      return sb.toString();
	    }

	 /**
	  * 转成GBK格式
	  * @param s
	  * @return
	  */
    public static String unicodeToGB(String   s)   {     
           StringBuffer   sb   =   new   StringBuffer();     
           StringTokenizer   st   =   new   StringTokenizer(s,   "\\u");     
           while (st.hasMoreTokens()){     
               sb.append((char)Integer.parseInt(st.nextToken(),16));     
           }     
           return   sb.toString();     
       } 
    
   /**
    * 过滤特殊字符
    * @param str 过滤字符串
    * @param regEx 过滤内容
    * @return
    * @throws PatternSyntaxException
    */
    public static String StringFilter(String str,String regEx)throws PatternSyntaxException   {        
                // 只允许字母和数字          
                // String   regEx  =  "[^a-zA-Z0-9]";                        
          Pattern   p   =   Pattern.compile(regEx);        
          Matcher   m   =   p.matcher(str);        
          return   m.replaceAll("").trim();        
    }        
 
    /** 
     * 将字节数组转换为十六进制字符数组 
     *  
     * @param data 
     *            byte[] 
     * @return 十六进制char[] 
     */  
    public static char[] encodeHex(byte[] data) {  
        return encodeHex(data, true);  
    }  
  
    /** 
     * 将字节数组转换为十六进制字符数组 
     *  
     * @param data 
     *            byte[] 
     * @param toLowerCase 
     *            <code>true</code> 传换成小写格式 ， <code>false</code> 传换成大写格式 
     * @return 十六进制char[] 
     */  
    public static char[] encodeHex(byte[] data, boolean toLowerCase) {  
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);  
    }  
  
    /** 
     * 将字节数组转换为十六进制字符数组 
     *  
     * @param data 
     *            byte[] 
     * @param toDigits 
     *            用于控制输出的char[] 
     * @return 十六进制char[] 
     */  
    protected static char[] encodeHex(byte[] data, char[] toDigits) {  
        int l = data.length;  
        char[] out = new char[l << 1];  
        // two characters form the hex value.  
        for (int i = 0, j = 0; i < l; i++) {  
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];  
            out[j++] = toDigits[0x0F & data[i]];  
        }  
        return out;  
    }  
  
    /** 
     * 将字节数组转换为十六进制字符串 
     *  
     * @param data 
     *            byte[] 
     * @return 十六进制String 
     */  
    public static String encodeHexStr(byte[] data) {  
        return encodeHexStr(data, true);  
    }  
  
    /** 
     * 将字节数组转换为十六进制字符串 
     *  
     * @param data 
     *            byte[] 
     * @param toLowerCase 
     *            <code>true</code> 传换成小写格式 ， <code>false</code> 传换成大写格式 
     * @return 十六进制String 
     */  
    public static String encodeHexStr(byte[] data, boolean toLowerCase) {  
        return encodeHexStr(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);  
    }  
  
    /** 
     * 将字节数组转换为十六进制字符串 
     *  
     * @param data 
     *            byte[] 
     * @param toDigits 
     *            用于控制输出的char[] 
     * @return 十六进制String 
     */  
    protected static String encodeHexStr(byte[] data, char[] toDigits) {  
        return new String(encodeHex(data, toDigits));  
    }  
  
    /** 
     * 将十六进制字符数组转换为字节数组 
     *  
     * @param data 
     *            十六进制char[] 
     * @return byte[] 
     * @throws RuntimeException 
     *             如果源十六进制字符数组是一个奇怪的长度，将抛出运行时异常 
     */  
    public static byte[] decodeHex(char[] data) {  
  
        int len = data.length;  
  
        if ((len & 0x01) != 0) {  
            throw new RuntimeException("Odd number of characters.");  
        }  
  
        byte[] out = new byte[len >> 1];  
  
        // two characters form the hex value.  
        for (int i = 0, j = 0; j < len; i++) {  
            int f = toDigit(data[j], j) << 4;  
            j++;  
            f = f | toDigit(data[j], j);  
            j++;  
            out[i] = (byte) (f & 0xFF);  
        }  
  
        return out;  
    }  
  
    /** 
     * 将十六进制字符转换成一个整数 
     *  
     * @param ch 
     *            十六进制char 
     * @param index 
     *            十六进制字符在字符数组中的位置 
     * @return 一个整数 
     * @throws RuntimeException 
     *             当ch不是一个合法的十六进制字符时，抛出运行时异常 
     */  
    protected static int toDigit(char ch, int index) {  
        int digit = Character.digit(ch, 16);  
        if (digit == -1) {  
            throw new RuntimeException("Illegal hexadecimal character " + ch  
                    + " at index " + index);  
        }  
        return digit;  
    }  
 
    /**
     * 转化十六进制编码为字符串
     * @param s
     * @return
     */
    public static String toStringHex(String s){
    	byte[] baKeyword = new byte[s.length()/2];
    	for(int i = 0; i < baKeyword.length; i++){
		    try{
			    baKeyword[i] = (byte)(0xff & Integer.parseInt(s.substring(i*2, i*2+2),16));
			}catch(Exception e){
				logger.error("转换为字符串时出错", e);
		        e.printStackTrace();
		    }
    	}
	    try{
	    	s = new String(baKeyword, "utf-8");//UTF-16le:Not
	    }catch (Exception e1){
	    	logger.error("转换为字符串时出错", e1);
	    	e1.printStackTrace();
	    }
	    return s;
    }
    
    /**
     * 截取指定字符串内的字符
     * @param str 
     * @param param  
     * @param param2
     * @return
     */
    public static String subStr(String str,String param,String param2){
    	 
    	int num = str.indexOf(param);
    	int num2 = str.indexOf(param2);
    	if(num<0 || num2<0 || num >num2){
    		return str;
    	}
    	
    	return str.substring(num, num2);
    }
    /**
     * @description: 判断一个或多个字符串是否为空	
     * @author:唐凝宽
     * @return:boolean
     * @param strs
     * @return
     */
    public static boolean isEmpty(String... strs) {
		if (strs == null || strs.length == 0) {
			return true;
		}
		for (String string : strs) {
			if (string == null || "".equals(string.trim())) {
				return true;
			}
		}
		return false;
	}
    /**
     * @description:对字符串进行URLDecoder转码
     * @author:唐凝宽
     * @return:String
     * @param json
     * @return
     */
    public static String URLDecoder(String obj){
		String data = null;
		try {
			data = URLDecoder.decode(obj,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("URLDecoder转码出错",e);
			e.printStackTrace();
		}
		return data;
	}

}
