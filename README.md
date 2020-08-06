###安装流程
  - 先安装Erlang，rabbitmq是由Erlang开发，所以需要Erlang的运行环境
  - 官网下载RabbitMQ,本项目使用版本为**3.8.3**
  - 下载插件rabbitmq_delayed_message_exchange插件，文件以ez为后缀，本项目版本为**3.7.x and 3.8.x** <http://www.rabbitmq.com/community-plugins.html>
  - 插件下载完成后，将其放在RabbitMQ安装目录下的plugins目录里
  - 以上步骤完成后，执行命令rabbitmq-plugins enable rabbitmq_delayed_message_exchange