
DROP TABLE IF EXISTS demo_user;
DROP TABLE IF EXISTS demo_timeline;
DROP TABLE IF EXISTS demo_business_customer;

CREATE TABLE demo_user (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL DEFAULT '',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);


CREATE TABLE demo_timeline (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL DEFAULT '',
  micro_blog VARCHAR(500) NOT NULL DEFAULT '',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);


CREATE TABLE demo_business_customer (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  customer VARCHAR(50),
  mobile_phone VARCHAR(20),
  city varchar(20),
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);
