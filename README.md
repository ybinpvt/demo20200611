#一、docker中服务的启动
##1.启动MySQL
```bash
[root@localhost ~]# docker run --name mysql01 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d a9d292c0363b
```
--name:别名

-p:端口映射 机器端口:容器端口

-e:指定root用户的密码

-d:后台运行，守护进程


```bash
[root@localhost ~]# docker start mysql01
```
##2.启动redis
```bash
[root@localhost ~]# docker run -d -p 6379:6379   --name="myredis"  redis 28918503e49d
```
```bash
[root@localhost ~]# docker start redis01
```
##3.启动mongodb
```bash
[root@localhost ~]# docker run -p 27017:27017 -v /data/mongo:/data/db --name mongodb -d mongo
```