package com.hnchances.demo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.hnchances.demo.service.SmsService;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.Map;


@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public Boolean sendSms(String phoneNum, String templateCode, Map<String, Object> code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "accessKeysId", "生成accessKeys所对应的密码");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "签名名称");
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response.getHttpResponse().isSuccess();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

}

