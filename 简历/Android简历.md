## 张涛的个人简历
#### 自我介绍
- **工作经验:** 6 年
- **电话:** 18734772024 
- **邮箱:** milan0518@126.com
- **csdn:** [https://blog.csdn.net/mldxtiejiang](https://blog.csdn.net/mldxtiejiang)
- **github:** [https://github.com/milanxiaotiejiang](https://github.com/milanxiaotiejiang)
- **求职意向:** Android 开发工程师 
- **目前状态:** 在职，一月左右到岗
- **期望薪资:** 22-23k
### 专业技能
* 具备扎实的 Java、Kotlin 基础，掌握 C、C++、Flutter 等编程语言，有良好的面向对象思想和编码风格，了解面向切面编程，并掌握常见的数据结构和算法。
* 熟练掌握主流 Android 架构，掌握插件化、组件化等设计思想，掌握常用的设计模式。
* 熟练掌握主流的 UI 组件，掌握 View 的绘制原理及事件分发机制。
* 熟练掌握 Android 数据存储、三级缓存，掌握 Java 多线程编程。
* 熟练掌握 OkHttp、Retrofit、RxJava、Glide 等主流三方框架，并了解其技术原理。
* 熟练掌握 Handler 消息机制，掌握 Binder 跨进程机制。
* 掌握热修复、插件化技术原理，了解 Android 系统及四大组件的启动流程。
* 对 App 性能优化有一定认知，解决过 OOM、ANR 等异常，优化过 App启动、卡顿等问题。
* 熟练掌握百度、讯飞等人工智能相关的 SDK，掌握三方登录、分享、支付及推送等。
* 熟悉腾讯、环信、网易等即时通讯 SDK。
* 熟练掌握蓝牙、相机等相关开发，掌握 Android 串口，Usb等通信。
* 熟悉 ffmpeg 解码编码等音视频处理相关技术。
* 熟练使用 android profile、Git、Systrace 等常用工具。
### 工作经历
* 深圳三十三天科技有限公司（太原）
2020 年 6 月 - 至今
1. 整理并编写公司基础项目架构，封装常用三方库，编写相关工具类，带领团队学习并推广Kotlin。
2. 完成公司系列项目。
* 北京海风智能科技有限公司
2017 年 5 月 - 2020年5月
1. 主导 Android 平台相关应用软件的需求分析、功能架构、编码和测试。
2. 主导后台系统架构与技术实施方案设计，并对软件系列产品持续维护和升级。
3. 带领团队学习和研究新的移动互联网技术，以满足产品的需求并提升产品质量。
* 普锐斯(北京)科技有限公司
2015 年 3 月 - 2017 年 3 月
1. 完成 IETM 管理平台 Android 端业务的维护。
2. 参与 Cpad 项目 Android 端研发、维护。
### 项目经验
###### 蓝领荟
1. 采用Mvvm架构，Kotlin + Jetpack搭建（DataBinding、ViewModel、LiveData、Navigation、Paging等），Dagger注入，Retrofit + Kotlin coroutines 处理网络，Moshi 处理数据，Room + Mmkv 数据存储，SmartRefresh实现刷新加载，Kotlin DSL管理依赖。
2. 集成 Arouter 分离短视频录制、直播等模块，短视频录制、直播、IM接入腾讯SDK，重构并优化这三个模块，撰写文档。
3. 接入 GsyVideoPlayer 实现视频播放，预加载等功能，优化首页视频列表。
4. 实现 App 内部国际化，实现阅读页面暗黑模式。
5. 集成支付、分享、推送等功能，支付、分享封装成库，撰写文档。
6. 整理并编写 Kotlin 常用扩展工具类。
###### 服务机器人
1. 采用ARouter 组件化项目，分离桌面、语音、人脸识别、串口、导航、用户、设置、网页等多模块，其中语音、网页、串口等模块采用 Aidl 跨进程分离，使用 Room、Mmkv 、XLog 等跨进程存储本地数据。
2. 采用 Mvp 模式架构，Kotlin开发，RxJava2 + Retrofit + OkHttp + Gson 架构网络基础，RxJava2 + Room 搭建本地数据库，Rxlifecycle 管理函数生命周期，采用 Dagger2 分离，Glide 加载图片，Uitra 实现刷新加载。
3. 前后端集成 HanLP 库处理自然语言，结合本地数据库，实现分值匹配字符，准确且快速的匹配本地词库问答。
4. 封装 Android 串口、USB 连接等硬件调用层，并发布到 Bintray。
5. 集成并封装百度、讯飞等人工智能平台语音识别 SDK 和相关问答接口；集成百度人脸识别离线库，实现人脸追踪、人脸打卡、个性化打招呼等功能；自定义相机，实现瘦脸、美白、贴纸等显示效果。
7. 统一项目线程库，构建 Task 并延迟初始化部分任务，完成项目启动优化；配合 LeakCanary、profile 等工具检测内存泄漏、解决页面卡顿现象。
8. 使用 Aspectj 记录并上报听写、合成的话语，记录关键函数调用时间，检测代码中关键信息等。
9. 集成网易云即时通讯、高德地图、友盟等第三方框架。
10. 使用Poi 前后台解析与生成 excel 文件，使用 Jsoup 抓取 html 网页数据。
11. 集成 MPAndroidChat 显示机器人端相关问答情况。
###### 福来来
为社区和物业管理服务而打造的互联网应用平台，Android 端包含业主端与物业端两个 App，业主端提供车辆管理、智慧开锁、家庭安全、账单缴费等功能，物业段包含打卡、巡查等功能。

**福来来:** [https://sj.qq.com/myapp/detail.htm?apkName=com.bandou.fulailai_owner](https://sj.qq.com/myapp/detail.htm?apkName=com.bandou.fulailai_owner)
**福来来物业:**[https://sj.qq.com/myapp/detail.htm?apkName=com.bandou.property.client](https://sj.qq.com/myapp/detail.htm?apkName=com.bandou.property.client)
1. MVP 构构，Rxjava2+Retrofit+Dagger2 完成项目搭建，封装刷新加载、状态管理基础页面。
2. 高德地图实现定位、车辆搜索、路线规划等功能。
3. 集成 Tinker 完成热修复、热更新；配置美团多渠道打包。
4. 集成 zxing 实现二维码扫描；集成极光推送；集成支付宝、微信支付；集成 ShareSDK 完成分享功能。
5. 集成萤石云 SDK，实现视频监控设备预览，集成海康车牌识别系统完成车库出入登记。
6. 集成多种三方门锁接口。
### 教育经历
* 山西大同大学
* 2014 / 7 毕业
* 本科
### 个人爱好及自我评价
**爱好 :**  篮球、台球
**自我评价 :**
* 较强的自学能力和积极对新技术的学习能力，善于思考，独立开发能力强，吃苦耐劳。
* 高度的工作热情、良好的职业道德。
* 具备良好的组织能力和团队协作精神，责任心强。
* 热爱分享