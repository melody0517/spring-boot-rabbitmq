###安装流程
  - 先安装Erlang，rabbitmq是由Erlang开发，所以需要Erlang的运行环境
  - 官网下载RabbitMQ,本项目使用版本为**3.8.3**
  - 下载插件rabbitmq_delayed_message_exchange插件，文件以ez为后缀，本项目版本为**3.7.x and 3.8.x** <http://www.rabbitmq.com/community-plugins.html>
  - 插件下载完成后，将其放在RabbitMQ安装目录下的plugins目录里
  - 以上步骤完成后，执行命令rabbitmq-plugins enable rabbitmq_delayed_message_exchange
  
###死信队列的弊端
  在我们的项目有两种需要延时消息的场景，
  - 是15分钟内用户未支付关闭订单
  - 活动在预定时间结束，在活动创建时就会发一条延时消息
  
  订单超时取消使用死信队列做延时消息没有问题，但是活动状态更新出现了问题，死信队列是顺序消费，先进的消息不消费，后面的消息就无法消费，有的活动是后创建的，但是结束时间比较靠前，
  导致无法及时更新订单状态，使用延时插件可以解决这个问题。
  
###延时插件原理
  该类型消息支持延迟投递机制,接收到消息后并未立即将消息投递至目标队列中，而是存储在mnesia(一个分布式数据系统)表中，并且当前节点是磁盘节点，那么节点重启后，消息还能保留。
  检测消息延迟时间，如达到可投递时间时并将其通过x-delayed-type类型标记的交换机类型投递至目标队列。但是要注意的是，如果集群中只有一个磁盘节点，如果说磁盘节点丢失，
  或者节点上的插件失效。意味着消息将会丢失。

###延时插件磁盘瓶颈
  由于延时插件是将消息先保存在交换机，达到可投递时间才投递至目标队列，所以不得不考虑消息堆积后磁盘的承受能力，目前我们采用的是延时和定时任务配合使用的策略，定时任务每隔两小时
  扫描一次，将接下来两小时内结束的活动以延时消息的形式发送给mq，这样可以很大程度减小mq所在服务器磁盘的压力，而且两小时对于定时任务来说也不会有压力，当然也可以将rabbitmq集群部署来解决这个问题。     
  

###使用mqtt插件实现发布/订阅功能
  系统公告、通知可以在用户在线时实时推送给用户，不需要用户在首页进行刷新页面而获取，若用户不在线，持久化处理后的数据在用户登录后立即拉取。
  准备工作：启动rabbitmq的插件，执行rabbitmq-plugins enable rabbitmq_mqtt，rabbitmq-plugins enable rabbitmq_web_mqtt
  
  本项目访问**localhost:8082/page/enter**进入首页，通过修改index.html中的订阅topic来订阅不同的主题
  本地post请求**http://localhost:8082/notice/create**，参数为 {"title":"系统更新公告","message":"角色模块进行更新","senderId":17,"senderName":"史佳男","receiveType":1,"receive":"全网"}，
  模拟发布公告，receiveType值为1对应topic为public，值为2时对应topic为admin，值为3时对应topic为handler