package com.hnchances.demo.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class SmsTool {

    static final String product = "Dysmsapi";

    static final String domain = "dysmsapi.aliyuncs.com";
    static final String accessKeyId = "LTAI5tNPZ45PLtpSCavqD3Tu";
    static final String accessKeySecret = "tUrasbQwJCdVlxL2yG9cnlZGwSnzEG";

    public static SendSmsResponse sendSms(String phone , String code) throws ClientException {

        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();

        request.setPhoneNumbers(phone);

        request.setSignName("您的验证码为：${code}，请勿泄露于他人！");

        request.setTemplateCode("SMS_246990004");

        request.setTemplateParam(code);


        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }
}

