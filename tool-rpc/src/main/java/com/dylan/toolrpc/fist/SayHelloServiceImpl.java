package com.dylan.toolrpc.fist;

public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String str) {
        if("hello".equalsIgnoreCase(str)){
            return "hello world";
        }
        else {
            return "hello error";
        }
    }
}
