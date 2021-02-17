package com.online.taix.utils;

import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

public class RibbonUtil {

    private static final RandomRule randomRule = new RandomRule();

    private static final RoundRobinRule roundRule = new RoundRobinRule();

    public static RandomRule getRandomRule(){
        return randomRule;
    }

    public static RoundRobinRule getRoundRule(){
        return roundRule;
    }
}
