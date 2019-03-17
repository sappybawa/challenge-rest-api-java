package com.sappy.challengerest.bonus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
// Asynchronous Logging
public class Log4J2AsyncLogger {
    private static Logger logger = LogManager.getLogger();
    public void performSomeTask(String msg){
        logger.info(msg);
    }
}