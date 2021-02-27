package service;

import com.lmax.disruptor.EventHandler;

public class DisruptorEventHandler implements EventHandler {
    @Override
    public void onEvent(Object o, long l, boolean b) throws Exception {
        System.out.println("消费者消费" + l);
    }
}
