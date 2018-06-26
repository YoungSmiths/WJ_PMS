
CREATE TABLE pms_user_info
(
  id               INT AUTO_INCREMENT                           COMMENT '主鍵'    PRIMARY KEY,
  user_name        VARCHAR(32)                        NOT NULL  COMMENT '用戶名',
  secret           VARCHAR(50)                        NOT NULL  COMMENT '密碼',
  telephone        VARCHAR(20)                        NULL      COMMENT '手機號',
  sex              TINYINT(1) DEFAULT '1'             NOT NULL  COMMENT '性別',
  age              INT                                NULL      COMMENT '年齡',
  address          VARCHAR(500)                       NULL      COMMENT '地址',
  is_configuration TINYINT(1) DEFAULT '0'             NULL      COMMENT '是否可配置',
  create_by        VARCHAR(50)                        NULL      COMMENT '創建人',
  date_created     DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '創建日期',
  update_by        VARCHAR(50)                        NULL      COMMENT '更新人',
  date_updated     DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '更新日期',
  CONSTRAINT pms_user_info_id_uindex
  UNIQUE (id),
  CONSTRAINT pms_user_user_info_name_uindex
  UNIQUE (user_name)
)
  COMMENT '用戶表';

CREATE TABLE pms_role_info
(
  id               INT AUTO_INCREMENT                           COMMENT '主鍵'    PRIMARY KEY,
  role_name        VARCHAR(32)                        NOT NULL  COMMENT '角色名',
  is_using           VARCHAR(50)                      NOT NULL  COMMENT '是否在用',
  create_by        VARCHAR(50)                        NULL      COMMENT '創建人',
  date_created     DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '創建日期',
  update_by        VARCHAR(50)                        NULL      COMMENT '更新人',
  date_updated     DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '更新日期',
  CONSTRAINT pms_role_info_id_uindex
  UNIQUE (id),
  CONSTRAINT pms_role_info_user_name_uindex
  UNIQUE (role_name)
)
  COMMENT '角色表';

CREATE TABLE pms_permission_info
(
  id               INT AUTO_INCREMENT                           COMMENT '主鍵'    PRIMARY KEY,
  name             VARCHAR(50)                        NOT NULL  COMMENT '權限名',
  code             VARCHAR(32)                        NOT NULL  COMMENT '編碼',
  content          VARCHAR(500)                       NULL      COMMENT '內容',
  describe_info    VARCHAR(500)                       NULL      COMMENT '描述',
  is_using         INT                                NULL      COMMENT '是否在用',
  create_by        VARCHAR(50)                        NULL      COMMENT '創建人',
  date_created     DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '創建日期',
  update_by        VARCHAR(50)                        NULL      COMMENT '更新人',
  date_updated     DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '更新日期',
  CONSTRAINT pms_permission_info_id_uindex
  UNIQUE (id),
  CONSTRAINT pms_permission_info_name_uindex
  UNIQUE (name)
)
  COMMENT '权限表';

CREATE TABLE pms_base_orders
(
  id                INT AUTO_INCREMENT                           COMMENT '主鍵'    PRIMARY KEY,
  name              VARCHAR(50)                        NOT NULL  COMMENT '訂單名',
  code              VARCHAR(32)                        NOT NULL  COMMENT '編碼',
  contract          VARCHAR(500)                       NOT NULL  COMMENT '合同號',
  count             INT(10)                            NULL      COMMENT '數量',
  paperType         VARCHAR(500)                       NULL      COMMENT '用纸类型',
  width             VARCHAR(50)                        NULL      COMMENT '扑克宽度',
  lengths           VARCHAR(50)                        NULL      COMMENT '扑克长度',
  print_require     VARCHAR(500)                       NULL      COMMENT '打印要求',
  out_side_hander   VARCHAR(500)                       NULL      COMMENT '表面处理',
  package_require   VARCHAR(500)                       NULL      COMMENT '包装要求',
  parts             VARCHAR(500)                       NULL      COMMENT '配件',
  describe_info     VARCHAR(200)                       NULL      COMMENT '描述',
  status            VARCHAR(10)                        NOT NULL  COMMENT '狀態',
  create_by         VARCHAR(50)                        NULL      COMMENT '創建人',
  date_created      DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '創建日期',
  update_by         VARCHAR(50)                        NULL      COMMENT '更新人',
  date_updated      DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '更新日期',
  CONSTRAINT pms_base_orders_id_uindex
  UNIQUE (id),
  CONSTRAINT pms_base_orders_name_uindex
  UNIQUE (name)
)
  COMMENT '訂單基表';

  CREATE TABLE pms_card_orders
(
  id                INT AUTO_INCREMENT                           COMMENT '主鍵'    PRIMARY KEY,
  name              VARCHAR(50)                        NOT NULL  COMMENT '訂單名',
  code              VARCHAR(32)                        NOT NULL  COMMENT '編碼',
  parent_order_id   VARCHAR(32)                        NOT NULL  COMMENT '父訂單ID',
  version_house     VARCHAR(500)                       NOT NULL  COMMENT '版房',
  open_paper        VARCHAR(500)                       NULL      COMMENT '開紙',
  print             VARCHAR(500)                       NULL      COMMENT '印刷',
  out_side_hander   VARCHAR(500)                       NULL      COMMENT '表面处理',
  open_card         VARCHAR(500)                       NULL      COMMENT '开牌',
  blunt_card        VARCHAR(500)                       NULL      COMMENT '冲牌',
  describe_info     VARCHAR(200)                       NULL      COMMENT '描述',
  status            VARCHAR(10)                        NOT NULL  COMMENT '狀態',
  create_by         VARCHAR(50)                        NULL      COMMENT '創建人',
  date_created      DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '創建日期',
  update_by         VARCHAR(50)                        NULL      COMMENT '更新人',
  date_updated      DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '更新日期',
  CONSTRAINT pms_card_orders_id_uindex
  UNIQUE (id),
  CONSTRAINT pms_card_orders_name_uindex
  UNIQUE (name)
)
  COMMENT '卡牌子訂單表';

  CREATE TABLE pms_box_orders
(
  id                INT AUTO_INCREMENT                           COMMENT '主鍵'    PRIMARY KEY,
  name              VARCHAR(50)                        NOT NULL  COMMENT '扑克名称',
  code              VARCHAR(32)                        NOT NULL  COMMENT '編碼',
  parent_order_id   VARCHAR(32)                        NOT NULL  COMMENT '父訂單ID',
  version_house     VARCHAR(500)                       NOT NULL  COMMENT '版房',
  open_paper        VARCHAR(500)                       NULL      COMMENT '開紙',
  print             VARCHAR(500)                       NULL      COMMENT '印刷',
  out_side_hander   VARCHAR(500)                       NULL      COMMENT '表面处理',
  box_beer          VARCHAR(500)                       NULL      COMMENT '啤盒',
  box_sticky        VARCHAR(500)                       NULL      COMMENT '粘盒',
  describe_info     VARCHAR(200)                       NULL      COMMENT '描述',
  status            VARCHAR(10)                        NOT NULL  COMMENT '狀態',
  create_by         VARCHAR(50)                        NULL      COMMENT '創建人',
  date_created      DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '創建日期',
  update_by         VARCHAR(50)                        NULL      COMMENT '更新人',
  date_updated      DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '更新日期',
  CONSTRAINT pms_box_orders_id_uindex
  UNIQUE (id),
  CONSTRAINT pms_box_orders_name_uindex
  UNIQUE (name)
)
  COMMENT '紙盒子訂單表';

  CREATE TABLE pms_operation_history
(
  id                INT AUTO_INCREMENT                           COMMENT '主鍵'    PRIMARY KEY,
  order_id          VARCHAR(50)                        NOT NULL  COMMENT '订单ID',
  permission_id     VARCHAR(32)                        NOT NULL  COMMENT '权限ID',
  content           VARCHAR(32)                        NOT NULL  COMMENT '操作内容',
  operator          VARCHAR(32)                        NOT NULL  COMMENT '操作人',
  describe_info     VARCHAR(200)                       NULL      COMMENT '描述',
  create_by         VARCHAR(50)                        NULL      COMMENT '創建人',
  date_created      DATETIME DEFAULT CURRENT_TIMESTAMP NULL      COMMENT '創建日期'
)
  COMMENT '操作记录表';

