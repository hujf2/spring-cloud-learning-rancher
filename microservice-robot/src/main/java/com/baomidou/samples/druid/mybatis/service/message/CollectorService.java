package com.baomidou.samples.druid.mybatis.service.message;

import io.micrometer.core.instrument.Gauge;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

import java.util.concurrent.atomic.AtomicInteger;

@Service("collectorService")
public class CollectorService {

    static final Counter userCounter = Metrics.counter("user.counter.total", "services", "demo");

    public void processCollectResult() throws InterruptedException {

        while (true) {
            userCounter.increment(1D);
        }
    }
}