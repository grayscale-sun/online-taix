package service;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisruptorMain {
    public static void main(String[] args) {

        int bufferSize = 1024;

        //消费者
        DisruptorEventFactory factory = new DisruptorEventFactory();
        Disruptor disruptor =
                new Disruptor(factory,bufferSize,Executors.defaultThreadFactory(),
                        ProducerType.MULTI,new BlockingWaitStrategy());
        disruptor.handleEventsWith(new DisruptorEventHandler());
        disruptor.start();

        //生产者
        final RingBuffer ringBuffer = disruptor.getRingBuffer();
        final DisruptorProvider disruptorProvider = new DisruptorProvider(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for(long i = 0;i<100;i++){
            byteBuffer.putLong(0,i);
            disruptorProvider.onData(byteBuffer);
        }
        //关闭disruptor和线程池
        disruptor.shutdown();
    }
}

