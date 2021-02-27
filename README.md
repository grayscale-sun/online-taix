# online-taix
网约车项目实战 
1.nacos注册中心 
2.zuul网关 
3.feign服务间调用，集成rabbion，hystrix

<h4>计费引擎:valuation-service

<h4>完成派单服务:dispatch-service 定时任务Task
<h5>司机抢单，派单引擎分配订单进入redis，key-value，map

<h4>网关灰度发布 
<h5>zuul + ribbon 根据用户权限(规则)，匹配服务版本(元数据)

<h4>ribbon 自定义rule实现灰度发布(无网关)

<h4>nacos灰度发布由spring-boot-nacos-auto-grayscale-release-0.0.1.RELEASE完成，通过注解@EnableGrayscaleRelease自动注入。

<h4>disruptor 最快单线程mq

<h4>activemq
