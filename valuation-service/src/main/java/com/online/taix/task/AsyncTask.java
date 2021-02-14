package com.online.taix.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.CompletableFuture;


public class AsyncTask {

    @Async
    public static CompletableFuture<Integer> sum1(){
        System.out.println("Future1" + "--" + 2);
        return new AsyncResult<>(2).completable();
    }

    @Async
    public static CompletableFuture<Integer> sum2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Future2" + "--" + 5);
        return new AsyncResult<>(5).completable();
    }
}
