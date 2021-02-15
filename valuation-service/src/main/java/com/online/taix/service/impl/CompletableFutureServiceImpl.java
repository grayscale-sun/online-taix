package com.online.taix.service.impl;

import com.online.taix.service.CompletableFutureService;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureServiceImpl implements CompletableFutureService {
    public static void main(String[] args) {

        CompletableFuture<Integer> completable = new AsyncResult<>(1).completable();
        CompletableFuture<Integer> Future1 = CompletableFuture.supplyAsync(CompletableFutureServiceImpl::sum1);
        CompletableFuture<Integer> Future2 = CompletableFuture.supplyAsync(CompletableFutureServiceImpl::sum2);

        CompletableFuture<Integer> Future3 = Future1.thenCombine(Future2, (sum1, sum2) -> {
            return sum1 + sum2;
        });

        Integer join = completable.thenCombine(Future3, (a, b) -> {
            System.out.println("Future3" + "--" + a);
            return a + b;
        }).join();

        System.out.println("Final" + "--" + join);

    }

    static Integer sum1() {
        System.out.println("Future1" + "--" + 2);
        return 2;
    }
    static Integer sum2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Future2" + "--" + 5);
        return 5;
    }
}
