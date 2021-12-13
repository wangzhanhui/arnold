# arnold-cloud
init
1、turbine：
进入看板：http://localhost:18882/turbine/hystrix
三种方式：
a、默认集群：clusterNameExpression和clusterConfig需要配置default
http://localhost:18882/turbine/turbine.stream 
b、指定集群：clusterNameExpression注释掉，clusterConfig配置eureka-server中的服务名称(大写)
http://localhost:18882/turbine/turbine.stream?cluster=FEIGN
c、指定服务：对应服务有配置hystrix即可，
http://localhost:18881/actuator/hystrix.stream
