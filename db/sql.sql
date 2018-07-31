CREATE TABLE  user
(
  id                INTEGER NOT NULL PRIMARY KEY,
  name              VARCHAR(255) NOT NULL  UNIQUE,
  display_name      VARCHAR(255),
  id_no             VARCHAR(50) UNIQUE,
  password          VARCHAR(255) NOT NULL,
  birthday          VARCHAR(255),
  sex               VARCHAR(1),
  phone             VARCHAR(50),
  mobile            VARCHAR(50),
  qq                VARCHAR(50),
  we_chat           VARCHAR(50),
  department_id     VARCHAR(50),
  secret            VARCHAR(255) ,
  mail              VARCHAR(50),
  state             VARCHAR(1) NOT NULL,
  create_by         VARCHAR(255),
  create_time       DATETIME,
  update_by         VARCHAR(255),
  update_time       DATETIME
);


CREATE TABLE department
(
  id                INTEGER NOT NULL PRIMARY KEY,
  department_name   VARCHAR(255),
  department_code   VARCHAR(50),
  state             VARCHAR(1),
  create_by         VARCHAR(255),
  create_time       DATETIME,
  update_by         VARCHAR(255),
  update_time       DATETIME
);

CREATE TABLE  role
(
  id                INTEGER NOT NULL PRIMARY KEY,
  role_code           VARCHAR(50) UNIQUE,
  role_name         VARCHAR(50) UNIQUE,
  state             VARCHAR(1),
  create_by         VARCHAR(255),
  create_time       DATETIME,
  update_by         VARCHAR(255),
  update_time       DATETIME
);

CREATE TABLE user_role(
  id                INTEGER NOT NULL PRIMARY KEY,
  user_id           INTEGER NOT NULL,
  role_id           INTEGER NOT NULL,
  create_by         VARCHAR(255),
  create_time       DATETIME,
  update_by         VARCHAR(255),
  update_time       DATETIME
);

CREATE TABLE permission
(
  id                INTEGER NOT NULL PRIMARY KEY,
  permission_name   VARCHAR(255) UNIQUE,
  permission_code   VARCHAR(50) UNIQUE,
  content           VARCHAR(500),
  describe_info     VARCHAR(500),
  state             VARCHAR(1),
  create_by         VARCHAR(255),
  create_time       DATETIME,
  update_by         VARCHAR(255),
  update_time       DATETIME
);

CREATE TABLE role_permission
(
  id                INTEGER NOT NULL PRIMARY KEY,
  role_id           INTEGER NOT NULL,
  permission_id     INTEGER NOT NULL,
  state             VARCHAR(1),
  create_by         VARCHAR(255),
  create_time       DATETIME,
  update_by         VARCHAR(255),
  update_time       DATETIME
);

CREATE TABLE exception
(
  id                INTEGER NOT NULL PRIMARY KEY,
  exception_code    VARCHAR(50),
  message           VARCHAR(255),
  order_id          VARCHAR(255),
  employee_id       VARCHAR(50),
  create_by         VARCHAR(255),
  create_time       DATETIME,
  update_by         VARCHAR(255),
  update_time       DATETIME
);


CREATE TABLE orders
(
  id                INTEGER NOT NULL PRIMARY KEY,
  order_name        VARCHAR(255),
  order_code        VARCHAR(50),
  contract_no       VARCHAR(255),
  count             VARCHAR(255),
  paperType         VARCHAR(255),
  width             VARCHAR(255),
  lengths           VARCHAR(255),
  print_require     VARCHAR(2000),
  out_side_hander   VARCHAR(2000),
  package_require   VARCHAR(2000),
  parts             VARCHAR(2000),
  design_pic_path   VARCHAR(2000),
  sub_order_info    VARCHAR(2000),
  describe_info     VARCHAR(2000),
  status            VARCHAR(1),
  create_by         VARCHAR(255),
  create_time       DATETIME,
  update_by         VARCHAR(255),
  update_time       DATETIME
);

CREATE TABLE box_order
(
  id                INTEGER PRIMARY KEY,
  box_order_name    VARCHAR(255),
  box_order_code    VARCHAR(50),
  parent_order_id   INTEGER NOT NULL ,
  version_house     VARCHAR(500),
  open_paper        VARCHAR(500),
  print             VARCHAR(500),
  out_side_hander   VARCHAR(500),
  box_beer          VARCHAR(500),
  box_sticky        VARCHAR(500),
  state             VARCHAR(1),
  describe_info     VARCHAR(2000),
  create_by         VARCHAR(255),
  create_time       DATETIME,
  update_by         VARCHAR(255),
  update_time       DATETIME
);

CREATE TABLE card_order
(
  id                INTEGER PRIMARY KEY ,
  card_order_name   VARCHAR(255) NOT NULL UNIQUE ,
  code              VARCHAR(50) NOT NULL UNIQUE ,
  parent_order_id   INTEGER NOT NULL ,
  version_house     VARCHAR(500),
  open_paper        VARCHAR(500),
  print             VARCHAR(500),
  out_side_hander   VARCHAR(500),
  open_card         VARCHAR(500),
  blunt_card        VARCHAR(500),
  describe_info     VARCHAR(200),
  status            VARCHAR(1),
  create_by         VARCHAR(255),
  create_time       DATETIME,
  update_by         VARCHAR(255),
  update_time       DATETIME
);

CREATE TABLE order_state_router
(
  id                INTEGER NOT NULL PRIMARY KEY ,
  state_name        VARCHAR(100) NOT NULL UNIQUE ,
  next_state_name   VARCHAR(100) NOT NULL UNIQUE ,
  state             VARCHAR(1),
  create_by         VARCHAR(2000),
  create_time       DATETIME,
  update_by         VARCHAR(2000),
  update_time       DATETIME
);