-- user_info
create table  `user_info`
(
  `id`              NUMERIC(32) not null comment '编号',
  `display_name`    VARCHAR(100) not null comment '姓名',
  `code`            VARCHAR(50) comment '编码',
  `id_no`           VARCHAR(32) comment '身份证',
  `birthday`        VARCHAR(50) comment '生日',
  `sex`             VARCHAR(1) comment '性别:0男：1女',
  `phone`           VARCHAR(32) comment '手机号',
  `qq`              VARCHAR(32) comment 'QQ号',
  `secret`          VARCHAR(100) comment '密码',
  `state`           BIT comment '状态：0在用 1弃用',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
create unique index `IDU_user_info_code` on `user_info`(`code`);
alter table `user_info` comment= '员工表 公司员工信息';

-- exception_info
create table  `exception_info`
(
  `id`              NUMERIC(32) not null comment '编号',
  `exception_code`  VARCHAR(50) comment '异常编码',
  `message`         VARCHAR(1000) comment '异常信息',
  `order_id`        INT comment '订单ID',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `exception_info`
  add constraint `PK_exception_info_id` primary key (`id`);
alter table `exception_info` comment= '异常信息表 项目异常信息表';

-- order_info
create table  `order_info`
(
  `id`              NUMERIC(32) not null comment '编号',
  `order_name`      VARCHAR(100) comment '订单名称',
  `order_code`      VARCHAR(50) comment '订单编号',
  `contract_no`     VARCHAR(100) comment '合同号',
  `count`           INT comment '数量',
  `paper_type`      VARCHAR(500) comment '纸张类型',
  `width`           VARCHAR(500) comment '扑克宽度',
  `lengths`         VARCHAR(500) comment '扑克长度',
  `print_require`   VARCHAR(1000) comment '打印要求',
  `out_side_handler` VARCHAR(1000) comment '表面处理',
  `package_require` VARCHAR(1000) comment '包装要求',
  `parts`           VARCHAR(1000) comment '配件',
  `design_pic_path` VARCHAR(1000) comment '设计图地址',
  `describe_info`   VARCHAR(1000),
  `state`           VARCHAR(50) comment '状态',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `order_info`
  add constraint `PK_order_info_id` primary key (`id`);
create unique index `IDU_order_info_order_code` on `order_info`(`order_code`);
create unique index `IDU_order_info_contrac_no9C38` on `order_info`(`contract_no`);
alter table `order_info` comment= '订单表 公司订单信息';

-- department_info
create table  `department_info`
(
  `id`              NUMERIC(32) not null comment '编号',
  `department_name` VARCHAR(100) comment '部门名称',
  `department_code` VARCHAR(50) comment '部门编号',
  `state`           BIT comment '状态：0在用 1弃用',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `department_info`
  add constraint `PK_department_info_id` primary key (`id`);
create unique index `IDU_departmnfo_departmodeF483` on `department_info`(`department_code`);
alter table `department_info` comment= '部门表 公司部门信息';

-- box_orders_info
/*
警告: 字段名可能非法 - status
*/
create table  `box_orders_info`
(
  `Id`              NUMERIC(32) not null comment '编号',
  `box_order_name`  VARCHAR(50) comment '扑克名称',
  `box_order_code`  VARCHAR(32) comment '編碼',
  `version_house`   VARCHAR(500) comment '版房',
  `open_paper`      VARCHAR(500) comment '開紙',
  `print`           VARCHAR(500) comment '印刷',
  `out_side_hander` VARCHAR(500) comment '表面处理',
  `box_beer`        VARCHAR(500) comment '啤盒',
  `box_sticky`      VARCHAR(500) comment '粘盒',
  `status`          VARCHAR(50) comment '状态',
  `describe_info`   VARCHAR(200) comment '描述',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `box_orders_info`
  add constraint `PK_box_orders_info_Id` primary key (`Id`);
create unique index `IDU_box_ordnfo_box_ordode3C51` on `box_orders_info`(`box_order_code`);
alter table `box_orders_info` comment= '紙盒子订单表';

-- card_orders_info
/*
警告: 字段名可能非法 - status
*/
create table  `card_orders_info`
(
  `id`              NUMERIC(32) not null comment '编号',
  `card_order_name` VARCHAR(50) comment '訂單名',
  `card_order_code` VARCHAR(32) comment '编码',
  `version_house`   VARCHAR(500) comment '版房',
  `open_paper`      VARCHAR(500) comment '开纸',
  `print`           VARCHAR(500) comment '印刷',
  `out_side_hander` VARCHAR(500) comment '表面处理',
  `open_card`       VARCHAR(500) comment '开牌',
  `blunt_card`      VARCHAR(500) comment '冲牌',
  `describe_info`   VARCHAR(200) comment '描述',
  `status`          VARCHAR(50) comment '状态',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `card_orders_info`
  add constraint `PK_card_orders_info_id` primary key (`id`);
create unique index `IDU_card_ornfo_card_orodeB539` on `card_orders_info`(`card_order_code`);
alter table `card_orders_info` comment= '卡牌子訂單表';

-- role_info
create table  `role_info`
(
  `id`              NUMERIC(32) not null comment '编号',
  `role_name`       VARCHAR(100) comment '角色名',
  `role_code`       VARCHAR(50) comment '编码',
  `state`           BIT comment '状态：0在用 1弃用',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `role_info`
  add constraint `PK_role_info_id` primary key (`id`);
create unique index `IDU_role_info_role_code` on `role_info`(`role_code`);
alter table `role_info` comment= '角色表';

-- permission_info
create table  `permission_info`
(
  `id`              NUMERIC(32) not null comment '编号',
  `permission_name` VARCHAR(100) comment '权限名称',
  `permission_code` VARCHAR(50) comment '编码',
  `content`         VARCHAR(2000) comment '內容',
  `describe_info`   VARCHAR(500) comment '描述',
  `state`           BIT comment '状态：0在用 1弃用',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `permission_info`
  add constraint `PK_permission_info_id` primary key (`id`);
create unique index `IDU_permissnfo_permissodeF4FE` on `permission_info`(`permission_code`);
alter table `permission_info` comment= '权限表';

-- role_permission_relation
create table  `role_permission_relation`
(
  `id`              NUMERIC(32) not null comment '编号',
  `role_id`         VARCHAR(32) comment '角色ID',
  `permission_id`   VARCHAR(32) comment '权限ID',
  `state`           BIT comment '状态：0在用 1弃用',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `role_permission_relation`
  add constraint `PK_role_peion_id10EF` primary key (`id`);
alter table `role_permission_relation` comment= '角色权限关系表';

-- order_operate_record_info
create table  `order_operate_record_info`
(
  `Id`              NUMERIC(32) not null comment '编号',
  `action_code`     VARCHAR(50) comment '操作ID',
  `action_name`     VARCHAR(100) comment '操作名称',
  `order_id`        INT comment '订单ID',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `order_operate_record_info`
  add constraint `PK_order_onfo_Id2179` primary key (`Id`);
create unique index `IDU_order_onfo_action_ode3512` on `order_operate_record_info`(`action_code`);
alter table `order_operate_record_info` comment= '操作记录表';

-- router_info
create table  `router_info`
(
  `id`              NUMERIC(32) not null comment '编号',
  `code`            VARCHAR(50) comment '路由编码',
  `next_code`       VARCHAR(50) comment '下一状态',
  `state`           BIT comment '状态：0在用 1弃用',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `router_info`
  add constraint `PK_router_info_id` primary key (`id`);
alter table `router_info` comment= '路由表 一个路由编码，职能对应一个状态编码，可对应多个下一状态编码';

-- base_directory_info
/*
警告: 字段名可能非法 - type
*/
create table  `base_directory_info`
(
  `id`              VARCHAR(32) not null comment '编号',
  `type`            VARCHAR(50) comment '类型',
  `code`            VARCHAR(50) comment '编码',
  `name`            VARCHAR(100) comment '名称',
  `state`           BIT comment '状态：0在用 1弃用',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `base_directory_info`
  add constraint `PK_base_dinfo_id6354` primary key (`id`);
alter table `base_directory_info` comment= '数据词典';

-- user_department_relation
create table  `user_department_relation`
(
  `Id`              NUMERIC(32) not null comment '编号',
  `uesr_id`         NUMERIC(32) comment '父编号',
  `department_id`   NUMERIC(32) comment '关联编号',
  `state`           BIT comment '状态：0在用 1弃用',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `user_department_relation`
  add constraint `PK_user_deion_IdB1B9` primary key (`Id`);
alter table `user_department_relation` comment= '用户部门关系表';

-- user_role_relation
create table  `user_role_relation`
(
  `Id`              NUMERIC(32) not null comment '编号',
  `user_id`         NUMERIC(32) comment '父编号',
  `role_id`         NUMERIC(32) comment '关联编号',
  `state`           BIT comment '状态：0在用 1弃用',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `user_role_relation`
  add constraint `PK_user_role_relation_Id` primary key (`Id`);
alter table `user_role_relation` comment= '用户角色关系表';

-- orders_relation
create table  `orders_relation`
(
  `id`              NUMERIC(32) not null comment '编号',
  `order_id`        NUMERIC(32) comment '订单ID',
  `parent_id`       NUMERIC(32) comment '父订单ID',
  `state`           BIT comment '状态：0在用 1弃用',
  `create_by`       VARCHAR(100) comment '创建人',
  `create_time`     DATETIME comment '创建时间',
  `update_by`       VARCHAR(100) comment '更新人',
  `update_time`     DATETIME comment '更新时间'
);
alter  table `orders_relation`
  add constraint `PK_orders_relation_id` primary key (`id`);
alter table `orders_relation` comment= '订单关系表';

