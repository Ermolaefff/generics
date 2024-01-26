package com.stambul.test.subclasses;

import com.stambul.test.generics.GenericEventFinish;
import com.stambul.test.generics.GenericEventStart;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//@Service
public interface JobInterface<T> {
    Object getLaunchRequirements();
    void onApplicationEventStart(GenericEventStart<T> event);
    void onApplicationEventFinish(GenericEventFinish<T> event);
}
