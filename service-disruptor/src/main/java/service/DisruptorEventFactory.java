package service;

import com.lmax.disruptor.EventFactory;

public class DisruptorEventFactory implements EventFactory {
    @Override
    public DisruptorEvent newInstance() {
        return new DisruptorEvent();
    }
}
