package com.online.taix.controller;


import com.online.taix.task.AsyncTask;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/valuation")
public class TestController {


    @PostMapping("/test")
    public Integer test(){

        final CompletableFuture<Integer> Future1 = AsyncTask.sum1();

        final CompletableFuture<Integer> Future3 = CompletableFuture.supplyAsync(()->{
            System.out.println("Future3" + "--" + 3);
            return 3;
        });

        final Integer join = Future3.thenCombine(Future1, (a, b) -> {
            return a + b;
        }).join();

       return join;
    }

}
