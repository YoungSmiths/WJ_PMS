# 开发日记
## 2018.5.18
表弟突然找我，怪点子比较的他，又在想什么？原来他想给自己公司做一个业务流程监控的系统，达到一个业务流程监控和绩效考核的作用。本来没多大兴趣，因为去年他还让我做一个微信兑奖的公众号，最后也不了了之了。
没一会给我发了一个他自己做的[思维导图](望京印刷内部生产管理（绩效）系统.xmind),然后说了他的想法，虽然画的不咋地，但是我能看明白，也知道他这次想做什么，感觉这个系统还是有必要做的，于是就开始一起合计了。
## 2018.5.19
去上当众讲话课程去了。
## 2018.5.20
大概整理了一下，[手画的流程图](temp/1385965045.jpg)，他也真理了一遍,[这是他做的](/home/youngsmith/桌面/望京生产流程图.pdf)。也是没谁了，这图也只能看明白大概意思，不过画成这样还算不错。嘿嘿嘿。。。
## 2018.5.21 ～ 2018.5.25
利用下班回家时间整理需求，因为不会原型设计的软件，也懒得去搞ps，所以只能靠画图一张张的画了。
- [第一版概要图](design/望京设计图1.1)
- [第二版详细设计图](design/望京设计图1.2)
最后说一句，累死哥哥了。。。有点理解人家说的创业者的不容易了
## 2018.5.25
```
人逢喜事还真有点类呀！
昨天邵文龙说有个爬虫的项目看我能不能接，今天又讨论了一下，
可能有点眉目了。这周累死我了，公司里两个项目来回折腾，效率变慢了，
回到家又接着讨论需求绘图啊。不过挺充实，这样也蛮好的，到床上很快就能睡着。
想早一点挣一顿钱养我家的猪，傻笑傻笑的，开心的，快乐的。
加油加油加油。。。
```
## 2018.5.28 ～ 2018.6.4
调查搭建后端框架
## 2018.6.4 ～ 2018.6.12
這段時間公司一直忙，新項目直接用的另外一個項目的框架，和部分代碼，有點亂，花了很長時間把整個項目重新翻了一遍。
###好處：
- Spring 和 Mybatis 的結合使用，以及Mybatis的自動生成代碼；
- 目錄框架zTree有了解，（這裏應該用不上)
- 用戶認證磨礦設計（人工設計的，我覺得還是用權限認證框架比較穩妥，如：Spring security, Apache shiro 等）
## 2018.8.1 
这段时间忙死了，只能早上早起断断续续的敲一敲代码。现在基本上思路已经确定下来，用户管理模块，订单模块以及权限部分。

## 2018.8.10
下一步任务：

    - 操作记录
    - 图片处理
    - 子订（扑克、纸盒）单增删改
    - 权限控制
    - 子订单控制
    
    
 ## 日志
    + 2018.10.8     提交所有代码
    + 2018.10.9     初始化数据。见[data](data/)
    + 2018.10.10    员工操作：开始、暂停、结束、更多操作。
        - 更多操作逻辑稍微复杂：涉及到父订单更多操作，子订单更多操作，正在操作和暂停操作的状态恢复等问题。
        - 将更多操作设计为两个接口：父订单的更多操作，子订单的更多操作。目的是为了减轻后端sql复杂度
        - 无论开始还是暂停，点击更多操作，直接回显操作记录即可。
    + 2018.10.11    更多操作，操作（开始，结束，暂停)开发完成
        - 业务逻辑简单化。
        - 操作有前端传操作标识（01-开始；02-暂停；02-结束）
        - 更多操作。根据订单当前的状态确定：
            - 状态为**05，路由表中找到该状态对应的下一个操作。（这里有问题，路由表中只记录了操作之间的路由，没有涉及到状态）
            - 状态为**00,**03或者**04，路由表中找到该操作的对应下一个操作。
            - 状态为**01或者**02，操作记录表中找到该订单的最新记录
        - 有个疑问：
            - 开始操作在操作记录表增加一条记录a
            - 结束操作在操作记录表更新记录a
            - 那么问题来了，暂停如何处理
    + 2018.10.12    完善更多操作，测试post
    