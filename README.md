# WJ_PMS
Wangjing process management system.
- [开发日记](doc/devDiary.md)
- [设计图](design)


## 订单状态
+ 待设计（业务部提交订单后）
+ 正在设计（设计部看到待设计订单，点击开始设计后）
+ 未审核（设计部设计完，上传设计图后，点击结束设计）
  - 设计审核未通过（业务部点击审核不通过，设计部继续设计）
  - 设计审核通过（业务部点击审核通过）
+ 正在排单（计划部看到有审核通过订单，点击开始排单）
+ 待业务审核（计划部排单完成，点击完成排单）
  - 计划审核未通过（业务部点击审核不通过，计划部继续设计）
  - 计划审核通过（业务部点击审核通过）
    + 财务审核未通过（财务部看到计划审核通过订单，点击审核通过）
    + 财务审核通过（财务看到计划审核通过订单，点击审核未通过）
+ 确认生产（计划部看到财务部审核通过，点击确认生产）
+ 印刷主管分别添加子订单（印刷部重新排单，将一个订单（ABC201805220000001）分成多个子订单,如：纸盒子订单（ABC201805220000001A）、扑克正面子订单（ABC201805220000001B）、扑克反面子订单（ABC201805220000001C））
  - 纸盒子订单（待发纸状态）
  - 扑克正面子订单（待发纸状态）
  - 扑克反面子订单（待发纸状态）
+ ============
    + 仓库会看到发纸待发纸子订单（点击开始，正在发纸，发之后点击结束，等待切纸）
      + 切纸部会看到等待切纸子订单（点击开始，正在切纸，切纸后点击结束）
    + 同时晒版部会进行晒版？？？？？？？？？
+ ===========
+ 当一个子订单，切纸晒版后，状态变为准备打印，点击开始，正在打印，点击结束。
  - 当所有子订单都打印结束后，父订单自动打印结束。
  - 当纸盒打印结束后，状态变为手动设置下一个部门
  - 当扑克正面订单和扑克反面订单打印结束后合并为扑克订单（ABC201805220000001BC）,状态为设置为下一个部门
+ 下一个部门可能为：
  - 全检部
  - 过油部
  - 啤机部
  - 分切部
  - 冲角部
  - 黏合部
  - 人工部
+ 机包装箱
+ 待入库
+ 正在入库
+ 已入库
+ 业务申请发货
+ 财务审核
+ 审核完成可申请发货

## 表结构设计
### 用户表（wj_pmg_user)
|字段名|描述|
|:---:|:---:|
|userID|主键|
|userName|用户名|
|password|密码|
|roleID|角色ID|
|flag|是否在用标志位|
|createDate|创建日期|
|updateDate|修改日期|
### 操作记录表（wj_pmg_operate)
|字段名|描述|
|:---:|:---:|
|operateID|主键|
|orderID|订单号|
|operation|操作|
|operator|操作人|
|time|操作时间|
### 订单表（wj_pmg_order)
|字段名|描述|
|:---:|:---:|
|orderID|主键|
|name|名称|
|contract|合同号|
|count|数量|
|paper|用纸|
|size|尺寸|
|require|印刷要求|
|surface_treat|表面处理|
|print_require|印刷要求|
|accessories|配件|
|describe|描述|
### 用户角色表（wj_pmg_roler)
|字段名|描述|
|:---:|:---:|
|roleID|主键|
|name|名称|
### 用户权限表（wj_pmg_grant)
|字段名|描述|
|:---:|:---:|
|grantID|主键|
|name|权限名称|
### 角色权限关系表（wj_pmg_roler_grant_relation）
|字段名|描述|
|:---:|:---:|
|roler_grant_ID|主键|
|rolerID|角色主键|
|grantID|权限主键|
### 用户角色关系表（wj_pmg_user_roler_relation)
|字段名|描述|
|:---:|:---:|
|user_roler_ID|主键|
|userID|用户主键|
|rolerID|角色主键|
### 设计图存储表(wj_pmg_design_pic)
|字段名|描述|
|:---:|:---:|
|designID|主键|
|orderID|订单号|
|path|所在地址|