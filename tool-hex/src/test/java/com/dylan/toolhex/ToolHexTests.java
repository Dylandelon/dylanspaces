package com.dylan.toolhex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class ToolHexTests {
    private static final Logger logger = LogManager.getLogger(ToolHexTests.class);

    @Test
    public void contextLoads() {
        logger.info("test:{}",0xffffffff);
    }
    @Test
    public void contextLoads2() {
        byte b = -1;
        logger.info("21test:{}",(int)(char)b);
        logger.info("22test:{}",(int)(char)(b&0xff));
    }

}
