package com.stambul.test.subclasses;

import com.stambul.test.generics.GenericEventFinish;
import com.stambul.test.generics.GenericEventStart;
import org.apache.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public abstract class JobAbstract<T> implements JobInterface<T> {
    private final Logger logger = Logger.getLogger(this.getClass());


    @Async("listenersExecutor")
    @EventListener
    @Override
    public void onApplicationEventStart(GenericEventStart<T> event) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Start: " + event.getResolvableType());
    }

    @Async("listenersExecutor")
    @EventListener
    @Override
    public void onApplicationEventFinish(GenericEventFinish<T> event) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Finish: " + event.getResolvableType());
    }
}

