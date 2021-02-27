package service;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.core.annotation.Order;

import java.nio.ByteBuffer;

public class DisruptorProvider {

    private final RingBuffer<DisruptorEvent> ringBuffer;

    public DisruptorProvider(RingBuffer<DisruptorEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer){
        final long sequence = ringBuffer.next();
        try{
            final DisruptorEvent disruptorEvent = ringBuffer.get(sequence);
            disruptorEvent.setValue(byteBuffer.getLong(0));
            System.out.println("生产者生产:" + sequence);
        }finally {
            ringBuffer.publish(sequence);
        }
    }

}
