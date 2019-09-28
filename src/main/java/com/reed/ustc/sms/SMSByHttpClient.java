package com.reed.ustc.sms;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


/**
 * created by reedfan on 2019/9/28 0028
 */

public class SMSByHttpClient {

    /**
     * http://sms.webchinese.cn/user/
     * @return
     * @throws Exception
     */
    public static String sendSms() throws Exception{
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
        post.addRequestHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
        NameValuePair[] data = {
//                new NameValuePair("Uid", "本站用户名"),
//                new NameValuePair("Key", "接口安全秘钥"),
                new NameValuePair("Uid", "reedfan"),
                new NameValuePair("Key", ""),
                new NameValuePair("smsMob", "18915228146"),
                new NameValuePair("smsText", "短信内容_test") };
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        for (Header h : headers) {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes(
                "gbk"));
        System.out.println(result); // 打印返回消息状态

        post.releaseConnection();
        return result;
    }

}
