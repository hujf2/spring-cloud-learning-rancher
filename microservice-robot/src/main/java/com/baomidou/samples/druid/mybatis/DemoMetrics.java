package com.baomidou.samples.druid.mybatis;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author elnvo
 * TODO: junfeng 2020/2/15  2020/2/17
 */
public class DemoMetrics implements MeterBinder {

    public Counter myCounter;
    public AtomicInteger myGauge = new AtomicInteger(0);


    @Override
    public void bindTo(MeterRegistry meterRegistry) {



        myCounter = Counter.builder("alibaba.com.counter")
                .tags(new String[]{"tag10", "val10","tag20", "val20"})
                .description("Counter of Action")
                .register(meterRegistry);

        Gauge.builder("alibaba.com.gauge", myGauge, c -> c.get())
                .tags(new String[]{"tag30", "val30","tag40", "val50"})
                .description("demo of custom meter binder")
                .register(meterRegistry);


    }


    public AtomicInteger getMyGauge() {
        return myGauge;
    }

    public void setMyGauge(AtomicInteger myGauge) {
        this.myGauge = myGauge;
    }

    public Counter getMyCounter() {
        return myCounter;
    }

    public void setMyCounter(Counter myCounter) {
        this.myCounter = myCounter;
    }


}