package com.online.taix.rule;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import com.online.taix.utils.OnlineThreadLocal;
import com.online.taix.utils.RibbonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class NacosRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public Server choose(Object key) {

        //获取当前应用自身集群名
        BaseLoadBalancer loadBalancer = (BaseLoadBalancer)this.getLoadBalancer();
        //获取ThreadLocal version
        final Map map = OnlineThreadLocal.get();
        //获取目标应用的应用名
        String name = loadBalancer.getName();
        NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
        try {
            //根据目标应用名查询目标应用实例集合
            List<Instance> allInstances = namingService.getAllInstances(name);
            for (Instance instance : allInstances) {
                if (instance.isHealthy() && instance.isEnabled()) {
                    Map<String, String> metadata = instance.getMetadata();
                    String valueVersionName = metadata.get("version");
                    //调用时选择同集群的实例
                    if (valueVersionName.equals(map.get("version"))) {
                        return new NacosServer(instance);
                    }
                }
            }
        } catch (NacosException e) {
            e.printStackTrace();
        }

        //走默认轮询算法
        final RoundRobinRule roundRule = RibbonUtil.getRoundRule();
        final Server chooseserver = roundRule.choose(loadBalancer,key);
        return chooseserver;
    }

}
