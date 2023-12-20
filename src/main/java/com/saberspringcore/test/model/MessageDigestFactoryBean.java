package com.saberspringcore.test.model;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest> , InitializingBean {
    private String algorithmName = "MD5";
    private MessageDigest messageDigest = null;

    @Override
    public MessageDigest getObject() {
        return messageDigest;
    }

    @Override
    public Class<?> getObjectType() {
        return MessageDigest.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public MessageDigest getMessageDigest() {
        return messageDigest;
    }

    public void setMessageDigest(MessageDigest messageDigest) {
        this.messageDigest = messageDigest;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        messageDigest= MessageDigest.getInstance(algorithmName);
    }
}
