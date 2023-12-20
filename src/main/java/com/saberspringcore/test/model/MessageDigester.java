package com.saberspringcore.test.model;


import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;


public class MessageDigester {

    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String message) {

        System.out.println("using digest1");
        digest(message, digest1);
        System.out.println("using digest2");
        digest(message, digest2);
    }

    private void digest(String message, MessageDigest digest) {
        System.out.println("using algorithm : " + digest.getAlgorithm());
        digest.reset();
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        byte[] out = digest.digest(bytes);

        System.out.println("original message : "+ Arrays.toString(bytes));
        System.out.println("Encrypt message : "+ Arrays.toString(out));
    }
}
