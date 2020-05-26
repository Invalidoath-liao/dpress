# dpress
基于多域名的博客系统

基于Halo 博客系统改造

## dpress1.0 beta版本
1：支持多域名  
2：模板使用数据库存储  
3：可在线配置数据库  
4：基于dactor框架开发，前端交易和管理端交易都基于异步进行开发
5：兼容halo模板
6:支持一键安装，在线配置数据库地址  
7:支持瞬时高并发  

**如果喜欢，请多多分享！！多多Star！！**

----

## 技术框架

| 框架             | 说明                           | 官网                                                         |
| ---------------- | ------------------------------ | ------------------------------------------------------------ |
| Spring Framework | 轻量级(相对而言)的Java开发框架 | https://spring.io/projects/spring-framework                  |
| Spring Boot      | Java Web开发脚手架             | https://spring.io/projects/spring-boot                       |
| Freemarker       | 视图模板引擎                   | [https://freemarker.apache.org](https://freemarker.apache.org/) |
| FastJSON         | JSON解析库                     | [FastJson](https://github.com/alibaba/fastjson/wiki)         |
| lombok           | 代码生成器                     | [https://projectlombok.org](https://projectlombok.org/)      |
| Druid            | 数据库链接池                   |                                                              |
| Dactor           | 基于协程的简单易用的编程框架   | https://github.com/allon2/dactor                             |
| jetcache         | 缓存框架                       | https://github.com/alibaba/jetcache                          |
| Mybatis          | ORM框架                        | https://mybatis.org/mybatis-3/                               |
| Vue              | 一套构建用户界面的渐进式框架   | https://vuejs.org/                                           |
## 功能列表
- 仪表盘

- 文章管理

- 页面管理

- 附件管理

- 评论管理

- 主题管理，系统自带两套主题模板

- 主题编辑

- 用户信息

- 系统管理

## 编译源代码

  ​		如果你是直接下载项目war包，请跳过此步骤。代码克隆到本地后，你可以使用命令行工具或者IDEA对项目源码进行编译，命令如下：

```
gradle clean build
```


## 快速开始

### 下载最新的 Dpress 安装包

```bash
curl -L https://github.com/allon2/dpress/releases/download/v1.2.0/dpress-latest.jar --output dpress-latest.war
```

或者

```bash
wget https://github.com//allon2/dpress/releases/download/v1.2.0/dpress-latest.jar -O dpress-latest.war
```

### 启动 Dpress

```bash
java -jar dpress-latest.war
```


## 安装步骤
1:浏览器中输入http://localhost:8090  
2:填写数据库信息  
![1590030875.png](https://i.loli.net/2020/05/21/AekuDhgwTpP1vlB.png)   
3:填写个人信息  
![1590031992.png](https://i.loli.net/2020/05/21/OVu7CXRm4FzAgDh.png)     
4:填写博客信息  
![1590032029.png](https://i.loli.net/2020/05/21/MKZc7vSHNUFVxzl.png)     
5:安装完成后，会自动跳转到管理端页面。
![1590032559.png](https://i.loli.net/2020/05/21/hqsX6URQLafYJey.png)      
6:管理端首页  
![1590032806.png](https://i.loli.net/2020/05/21/sltjYrxIEbJZpa4.png)    




