package com.hnchances.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public interface  SmsService {
    public Boolean sendSms(String phoneNum, String templateCode, Map<String, Object> code);
}
