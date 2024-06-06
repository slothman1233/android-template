# business_MVP  业务生成

[TOC]

> 不用添加'lib_'前缀 会自动添加
>


参数来源：

| 字段           | 说明          | 使用位置                                                     |
| -------------- | ------------- | ------------------------------------------------------------ |
| cjjc_business_cjjc | 业务名称   |  |

示例：

```json
{"cjjc_business_cjjc":"业务名称"}
```

步骤：

1.安装Node https://blog.csdn.net/qq_40712862/article/details/120231621 (node 需要 16.13.0 以上版本)

2.cmd 执行命令

```
切换公司npm源：
npm config set registry https://nexus.ops.hncjjc.cn/repository/npm-group/

安装脚手架：
npm i -g @cjjc/cjjc-cli
```


3.创建模板项目步骤(注意工程创建位置是命令控制台打开的位置)

​	3.1 使用管理员权限打开命令控制台 

​		文档：https://jingyan.baidu.com/article/a681b0de02b8047a19434647.html

​	3.2 报错：因为在此系统上禁止运行脚本。

​		解决方案：https://www.cnblogs.com/jackadam/p/15704911.html

​		运行命令：set-executionpolicy remotesigned 

​	3.3 执行创建命令

​		cjjc-cli create 业务名称

​	3.4 选择框架选项

​	3.5 选择 android_business_mvp 

​	3.6 输入 {"cjjc_business_cjjc":"业务名称"} 回车即可

4.在项目中添加引用

​	4.1 最外层项目的 settings.gradle 添加对应的include

​	4.2在app的build.gradle 添加 对应的 implementation
