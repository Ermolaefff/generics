package com.stambul.test.generics;

import com.stambul.tools.TimeTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Publisher implements Runnable {
    private final Logger logger = Logger.getLogger(this.getClass());
    private final ThreadPoolTaskScheduler scheduler;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public Publisher(
            ApplicationEventPublisher eventPublisher,
            @Qualifier("initScheduler") ThreadPoolTaskScheduler scheduler
    ) {
        this.eventPublisher = eventPublisher;
        this.scheduler = scheduler;
    }

    @PostConstruct
    private void init() {
        scheduler.schedule(this, TimeTools.toInstant("PT1S"));
    }

    @Override
    public void run() {
        logger.info("start(String)");
        eventPublisher.publishEvent(new GenericEventStart<>(String.class));
        logger.info("finish(String)");
        eventPublisher.publishEvent(new GenericEventFinish<>(String.class));

        logger.info("start(Integer)");
        eventPublisher.publishEvent(new GenericEventStart<>(Integer.class));
        logger.info("finish(Integer)");
        eventPublisher.publishEvent(new GenericEventFinish<>(Integer.class));
    }
}
