package com.dylan.toolsocket.websocket.bean;

public class HelloMessage
{
    private String name;

    public HelloMessage()
    {
    }

    public String getName()
    {
        return name;
    }

    public HelloMessage(String name)
    {
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
