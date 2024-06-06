# android MVP 框架

[TOC]

### 目录说明

```
├── app  入口
|   |── common    常用功能包         
|   |   |── adapter    页面适配器 
|   |   |── api        接口名称定义   
|   |   |── base       基类   
|   |   |── config     当前工程配置信息   
|   |   |── constant   当前工程所有常量声明   
|   |   |── hilt       依赖注入接口与实现类声明   
|   |   |── plugins    第三方插件   
|   |   |── public_business    公共业务接口   
|   |   |── router     当前工程页面+服务路由配置表   
|   |   └── serve      主工程服务配置：中转子工程服务
|   |── page      当前工程所有页面
|   |── util      当前工程所需工具类
|   └── widget    当前工程所需组件
|── business    业务库
|   |── lib_public  公共业务库
|   |── common    常用功能包         
|   |   |── adapter    页面适配器
|   |   |── api        接口名称定义   
|   |   |── base       基类   
|   |   |── config     当前工程配置信息   
|   |   |── constant   当前工程所有常量声明   
|   |   |── hilt       依赖注入接口与实现类声明   
|   |   |── plugins    第三方插件   
|   |   |── public_business    公共业务接口   
|   |   |── router     当前工程页面+服务路由配置表   
|   |   |   |── auth        鉴权业务
|   |   |   |── degrade     页面降级策略
|   |   |   └── interceptor 业务拦截器
|   |   |── serve      公共业务服务
|   |   |   |── get       对外提供服务
|   |   |   |   |── call       服务接口声明
|   |   |   |   └── impl       服务接口实现
|   |   |   └── set       从外界获取服务
|   |── page      全局公共业务页面
|   |── util      全局公共业务工具类
|   |── widget    全局公共业务组件
|   |   *其他业务模块说明：
|   |   *其他业务模块的工程目录结构与公共库业务库一致
|   |── lib_home    主页面模块
|   |── lib_login   登录模块
|   |── lib_me      个人中心模块
|   └── lib_more    其他更多业务模块
|── base    工程底层库               
|   |── base-lib   基类及常用工具类       
|   |   |── call       接口声明
|   |   |   |── hilt       依赖注入接口与实现类声明   
|   |   |   |── listener   普通常用接口声明  
|   |   |   |── mvp        MVP模式接口声明  
|   |   |   |   |── activity         Activity接口声明  
|   |   |   |   |── fragment         Fragment接口声明  
|   |   |   |   └── widget           组件接口声明  
|   |   |── constant   基础功能常量
|   |   |── util       基础常用工具类
|   |   |── view       View基类
|   |   |   |── activity   Activity基类
|   |   |   |── adapter    Adapter适配器基类
|   |   |   |── fragment   Fragment基类
|   |   |   └── widget     组件基类
|   |   |── widget     常用基础组件
|   |   |
|   |── framework   SDK核心库       
|   |   |── FrameWork  SDK核心库初始化 
|   |   └── manager    SDK核心库管理
|── core    核心功能库               
|   |── lib_catch  全局异常拦截       
|   |── lib_db     数据库       
|   |── lib_imgload图片加载库       
|   |── lib_luban  图片压缩库     
|   |── lib_network网络请求库     
|   |── lib_thread 线程池管理库     
|   └── lib_widget 常用基础组件库
```

### 命令创建模板工程参数（脚手架创建模板使用）

>  #参数名#  做为标识，新工程走命令行替换该标识即可
>
> 配置应用桌面名 ---- 主工程 app > res > values > strings.xml > (app_name_release/app_name_debug)
>
> 工程共目录settings.gradle文件  -----  配置内容：rootProject.name = "#PROJECT_NAME#"
> 工程共目录gradle.properties文件  -----   配置内容：PROJECT_NAME="#PROJECT_NAME#"

参数来源：

| 字段           | 说明          | 使用位置                                                     |
| -------------- | ------------- | ------------------------------------------------------------ |
| #PROJECT_NAME# | 工程名        | 1.根目录 gradle.properties 文件  <br/>2.根目录 settings.gradle 文件<br/> 3.主工程app模块资源文件 strings.xml 文件 |
| #PACKAGE_NAME# | applicationId | 1.根目录 compile.properties 文件                             |

示例：

```json
{"#PROJECT_NAME#":"ARC_DEMO","#PACKAGE_NAME#":"com.cjjc.demo"}
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

​		cjjc-cli create 工程名

​	3.4 选择框架选项

​	3.5 选择android_mvp框架

​	3.6 输入{#PROJECT_NAME#:"工程名",#PACKAGE_NAME#:包名"} 回车即可

### 签名配置说明

1. 签名文件存放位置：
   工程根目录。 例如：``arcdemo.jks``
2. 签名文件配置位置：
   工程根目录：``gradle.properties``文件 的 ``keystore ``模块信息



### 全局重要环境及开关配置

> 配置位置：工程共目录``gradle.properties``文件
>

1. 网络请求地址环境
   环境名：DEV、Test、PTest、Production
   地址名：NET_环境名_BASE_URL="地址"
2.   接口请求加密
   字段：IS_环境名_ENCRYPTION  ---- true 开启  false 关闭
3.   全局异常拦截开关
   字段：CRASH_SWITCH_环境名  ----  true 开启  false 关闭 
4. 全局日志开关
   字段：LOG_SWITCH_环境名  ----  true 开启  false 关闭  

### 是否启用Debug模块单独调试模式

> 配置位置：工程共目录``common.gradle``文件
>

1. 字段：``isModuleDebug``  ---- true 开启  false 关闭  



### 业务工程创建流程

1. 创建位置 ``business ``文件夹下

2. 在``business``文件右键创建Module
   *注意这里的业务工程需选择应用(Application)级别工程,不是``Android Library``工程
   命名规范：工程名：lib_业务名  包名：``com.cjjc.lib``_业务名

3. 在工程main文件夹下创建debug文件夹,并将``AndroidManifest.xml``文件复制一份到其中。

4. 将原``AndroidManifest.xml``中的``application``标签属性全部删除

   ```java
   //示例：删除前
   <application
       android:allowBackup="true"
       android:icon="@mipmap/ic_launcher"
       android:label="@string/app_name"
       android:roundIcon="@mipmap/ic_launcher_round"
       android:supportsRtl="true"
       android:theme="@style/Theme.ArcDemo">
       <activity
            android:name=".page.login.LoginActivity"
            android:exported="true"/>
   </application>
   
   //示例：删除后
   <application>
       <activity
           android:name=".page.login.LoginActivity"
           android:exported="true"/>
   </application>
   ```

   

5. 删除资源文件中默认生成的应用名 ``app_name``
   位置： 工程名>``src``>``main``>``res``>``values``>``strings.xml``>``(app_name``字段)

6. build.gradle 文件修改 直接复制下面示例覆盖全部内容即可

   ```java
   apply from:"${rootProject.rootDir}/common.gradle"
   
   android {
   
   }
   
   dependencies {
       if (!project.isModuleDebug) {
           implementation project(path: ':base:base-lib')  //基础库
           implementation project(path: ':core:lib_widget') //组件库
           implementation project(path: ':business:lib_public') //公共业务库
           //根据需要 添加更多...
       }
   }
   ```



### 子工程添加aar依赖库

1. 配置位置

   工程根目录 build.gradle 文件中 如下示例

   ```java
    repositories{
               flatDir {
                   dirs 'libs', '../business/lib_home/libs','更多工程libs相对路径'
               }
          }
   ```

2. 在对应工程引用aar库

   ```java
   implementation(name: 'aar文件名', ext: 'aar')
   ```

   

### 全局统一配置build.gradle

1. 配置位置 ---- 工程根目录 ``common.gradle`` 文件



### 全局统一添加依赖库

1. 配置位置 ---- 工程根目录 ``lib.gradle`` 文件



### 项目版本号,包名配置

1. 配置位置 ---- 工程根目录 ``compile.properties`` 文件

2. 包名``applicationId``配置

   会自动拼接 版本类型 示例：
   	配置包名：``com.cjjc.demo``
       	实际包名：(目的：两个版本可以同时在一个设备上安装)
           	``release``版：``com.cjjc.demo.release``
           	``debug``版：``com.cjjc.demo.debug``

### 用户信息+Token

> *注意 所有业务模块配置信息 ``Config``业务模块名``Info``文件 受保护状态  不允许外界直接访问,只能由 ``Config``业务模块名 文件提供访问

1. 属于公共业务 存放在 ``business``>``lib_public``>``config``>``ConfigPublicInfo`` 中

   

### 第三方SDK秘钥配置

配置位置 ---- ``business ``>`` lib_public ``>`` constant ``>`` ConstantSDKPublic``



### 公共业务接口

1.位置：模块>``common``>``public_business``

2.写法：使用 ``CJJC MVP PublicBusiness Template`` 模板创建

3.用法：

*注意：

​		与普通MVP一致，但是回调需要单独写，不能写在原``View``接口上(避免使用的地方实现冗余接口)，回调通过``Presenter``层方法参数回调；

​		``Presenter``层不能使用mView(会出现View类型转换问题)。

3.1. Activity公共业务示例：

```java
@AndroidEntryPoint
@Route(path = ARouterPathMain.APP_MAIN.HY_SPLASH_ACTIVITY)
public class SplashActivity extends MyActivityBusinessMvp<SplashPresenter> implements SplashInterface.View{

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }
	
    //注入公共业务Presenter
    @Inject
    NetPresenter netPresenter;

    @Override
    public void afterOnCreate(Bundle savedInstanceState) {
        super.afterOnCreate(savedInstanceState);
        //初始化公共业务Presenter
        netPresenter.onCreateActivity(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void init() {
        //调用公共业务接口
        netPresenter.getPublicConfig(new NetInterface.PublicConfigViews() {
            @Override
            public void getPublicConfigTest() {
                LogUtil.xLoge("测试成功................");
           }
        });
    }

    @Override
    protected void initListener() {
    }
}
```

3.2.Fragment公共业务示例：

```java
@AndroidEntryPoint
@Route(path = ARouterPathHome.APP_HOME.PATH_HOME_FRAGMENT)
public class HomeFragment extends MyFragmentBusinessMvp<HomePresenter> implements HomeInterface.View{

    //注入公共业务Presenter
    @Inject
    NetPresenter netPresenter;

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            //初始化公共业务Presenter
            netPresenter.onCreateFragment(this);
        }

    @Override
    protected int getViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        //调用公共业务接口
        netPresenter.getPublicConfig(new NetInterface.PublicConfigViews() {
            @Override
            public void getPublicConfigTest() {
                LogUtil.xLoge("测试成功................");
            }
        });
    }

    @Override
    protected void initListener() {

    }
}
```

