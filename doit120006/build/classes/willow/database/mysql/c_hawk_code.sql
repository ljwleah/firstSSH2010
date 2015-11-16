-- FILENAME:    c_hawk_code.sql
-- CREATEDATE:  2012-02-13

CREATE DATABASE IF NOT EXISTS `hawk`;
COMMIT;

USE `hawk`;
COMMIT;

-- 省市编码信息表
DROP TABLE IF EXISTS `hawk`.`province`;
CREATE TABLE `hawk`.`province` (
  `id`    char(6)     NOT NULL      COMMENT '代码编号',
  `upid`  char(6)     DEFAULT NULL  COMMENT '上级代码',
  `name`  text        NOT NULL      COMMENT '代码名称',
  `abb`   varchar(10) DEFAULT NULL  COMMENT '查询缩写',
  `type`  varchar(10) NOT NULL      COMMENT '代码类型',
  PRIMARY KEY   (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='省市编码信息表';

-- 省市编码数据
INSERT INTO `hawk`.`province` (`id`,`name`,`type`) VALUES 
 ('110000','北京市','leaf'),
 ('120000','天津市','leaf'),
 ('130000','河北省','leaf'),
 ('140000','山西省','leaf'),
 ('150000','内蒙古','leaf'),
 ('210000','辽宁省','leaf'),
 ('220000','吉林省','leaf'),
 ('230000','黑龙江省','leaf'),
 ('310000','上海市','leaf'),
 ('320000','江苏省','leaf'),
 ('330000','浙江省','leaf'),
 ('340000','安徽省','leaf'),
 ('350000','福建省','leaf'),
 ('360000','江西省','leaf'),
 ('370000','山东省','leaf'),
 ('410000','河南省','leaf'),
 ('420000','湖北省','leaf'),
 ('430000','湖南省','leaf'),
 ('440000','广东省','leaf'),
 ('450000','广西','leaf'),
 ('460000','海南省','leaf'),
 ('500000','重庆市','leaf'),
 ('510000','四川省','leaf'),
 ('520000','贵州省','leaf'),
 ('530000','云南省','leaf'),
 ('540000','西藏','leaf'),
 ('610000','陕西省','leaf'),
 ('620000','甘肃省','leaf'),
 ('630000','青海省','leaf'),
 ('640000','宁夏','leaf'),
 ('650000','新疆','leaf'),
 ('710000','台湾省','leaf'),
 ('720000','香港','leaf'),
 ('730000','澳门','leaf'),
 ('Z00000','外国','leaf');
COMMIT;

-- 学校编码信息表
DROP TABLE IF EXISTS `hawk`.`school`;
CREATE TABLE `hawk`.`school` (
  `id`    varchar(20) NOT NULL      COMMENT '代码编号',
  `upid`  varchar(20) DEFAULT NULL  COMMENT '上级代码',
  `name`  text        NOT NULL      COMMENT '代码名称',
  `abb`   varchar(10) DEFAULT NULL  COMMENT '查询缩写',
  `type`  varchar(10) NOT NULL      COMMENT '代码类型',
  PRIMARY KEY   (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='学校编码表';

-- 学校编码数据
INSERT INTO `hawk`.`school` (`id`,`upid`,`name`,`type`) VALUES 
('10165','210000','辽宁师范大学', 'leaf'),
('A0001','210000','华信公司', 'leaf');
COMMIT;

-- 院系编码信息表
DROP TABLE IF EXISTS `hawk`.`department`;
CREATE TABLE `hawk`.`department` (
  `id`    char(5)     NOT NULL      COMMENT '代码编号',
  `upid`  char(5)     DEFAULT NULL  COMMENT '上级代码',
  `name`  text        NOT NULL      COMMENT '代码名称',
  `abb`   varchar(10) DEFAULT NULL  COMMENT '查询缩写',
  `type`  varchar(10) NOT NULL      COMMENT '代码类型',
  PRIMARY KEY   (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='院系编码表';

-- 院系编码数据
INSERT INTO `hawk`.`department` (`id`,`upid`,`name`,`type`) VALUES 
 ('10001','10165','计算机与信息技术学院','leaf'),
 ('20001','10165','成教学院','leaf'),
 ('30001','10165','海华学院','leaf'),
 ('A0001','A0001','华信计算机培训中心','leaf');
COMMIT;

-- 专业编码信息表
DROP TABLE IF EXISTS `hawk`.`major`;
CREATE TABLE `hawk`.`major` (
  `id`    char(5)     NOT NULL      COMMENT '代码编号',
  `upid`  char(5)     DEFAULT NULL  COMMENT '上级代码',
  `name`  text        NOT NULL      COMMENT '代码名称',
  `abb`   varchar(10) DEFAULT NULL  COMMENT '查询缩写',
  `type`  varchar(10) NOT NULL      COMMENT '代码类型',
  PRIMARY KEY   (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='专业编码表';

-- 专业编码数据
INSERT INTO `hawk`.`major` (`id`,`upid`,`name`,`type`) VALUES 
 ('10001','10001','计算机教育','leaf'),
 ('10002','10001','计算机应用','leaf'),
 ('10003','10001','动画与游戏','leaf'),
 ('10004','10001','日语强化','leaf'),
 ('10005','10001','广播电视','leaf'),
 ('10006','10001','教育应用','leaf'),
 ('10007','20001','计算机应用','leaf'),
 ('10008','30001','计算机应用','leaf');
COMMIT;

-- 年级编码信息表
DROP TABLE IF EXISTS `hawk`.`grade`;
CREATE TABLE `hawk`.`grade` (
  `id`    char(4)     NOT NULL      COMMENT '代码编号',
  `upid`  char(4)     DEFAULT NULL  COMMENT '上级代码',
  `name`  text        NOT NULL      COMMENT '代码名称',
  `abb`   varchar(10) DEFAULT NULL  COMMENT '查询缩写',
  `type`  varchar(10) NOT NULL      COMMENT '代码类型',
  PRIMARY KEY   (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='年级编码表';

-- 年级编码数据
INSERT INTO `hawk`.`grade` (`id`,`name`,`type`) VALUES 
 ('0000','不分级','leaf'),
 ('2005','2005级','leaf'),
 ('2006','2006级','leaf'),
 ('2007','2007级','leaf'),
 ('2008','2008级','leaf'),
 ('2009','2009级','leaf'),
 ('2010','2010级','leaf'),
 ('2011','2011级','leaf'),
 ('2012','2012级','leaf'),
 ('2013','2013级','leaf'),
 ('2014','2014级','leaf'),
 ('2015','2015级','leaf'),
 ('2016','2016级','leaf'),
 ('2017','2017级','leaf'),
 ('2018','2018级','leaf'),
 ('2019','2019级','leaf'),
 ('2020','2020级','leaf'),
 ('2021','2021级','leaf'),
 ('2022','2022级','leaf'),
 ('2023','2023级','leaf'),
 ('2024','2024级','leaf'),
 ('2025','2025级','leaf'),
 ('2026','2026级','leaf'),
 ('2027','2027级','leaf'),
 ('2028','2028级','leaf'),
 ('2029','2029级','leaf'),
 ('2030','2030级','leaf');
COMMIT;

-- 班级编码信息表
DROP TABLE IF EXISTS `hawk`.`schoolclass`;
CREATE TABLE `hawk`.`schoolclass` (
  `id`    char(1)     NOT NULL      COMMENT '代码编号',
  `upid`  char(1)     DEFAULT NULL  COMMENT '上级代码',
  `name`  text        NOT NULL      COMMENT '代码名称',
  `abb`   varchar(10) DEFAULT NULL  COMMENT '查询缩写',
  `type`  varchar(10) NOT NULL      COMMENT '代码类型',
  PRIMARY KEY   (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='班级编码表';

-- 班级编码数据
INSERT INTO `hawk`.`schoolclass` (`id`,`name`,`type`) VALUES 
 ('1','1班','leaf'),
 ('2','2班','leaf'),
 ('3','3班','leaf'),
 ('4','4班','leaf'),
 ('5','5班','leaf'),
 ('6','6班','leaf'),
 ('7','7班','leaf'),
 ('8','8班','leaf'),
 ('9','9班','leaf'),
 ('A','A班','leaf'),
 ('B','B班','leaf'),
 ('C','C班','leaf'),
 ('D','D班','leaf'),
 ('E','E班','leaf'),
 ('F','F班','leaf');
COMMIT;

-- 性别编码信息表
DROP TABLE IF EXISTS `hawk`.`sex`;
CREATE TABLE `hawk`.`sex` (
  `id`    char(1)     NOT NULL      COMMENT '代码编号',
  `upid`  char(1)     DEFAULT NULL  COMMENT '上级代码',
  `name`  varchar(10) NOT NULL      COMMENT '代码名称',
  `abb`   varchar(10) DEFAULT NULL  COMMENT '查询缩写',
  `type`  varchar(10) NOT NULL      COMMENT '代码类型',
  PRIMARY KEY   (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='性别编码表';

-- 性别编码数据
INSERT INTO `hawk`.`sex` (`id`,`name`,`type`) VALUES 
 ('F','女','leaf'),
 ('M','男','leaf');
COMMIT;

-- 学业级别编码信息表
DROP TABLE IF EXISTS `hawk`.`degree`;
CREATE TABLE `hawk`.`degree` (
  `id`    char(2)     NOT NULL      COMMENT '代码编号',
  `upid`  char(2)     DEFAULT NULL  COMMENT '上级代码',
  `name`  text        NOT NULL      COMMENT '代码名称',
  `abb`   varchar(10) DEFAULT NULL  COMMENT '查询缩写',
  `type`  varchar(10) NOT NULL      COMMENT '代码类型',
  PRIMARY KEY   (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='学业级别编码表';

-- 学业级别编码数据
INSERT INTO `hawk`.`degree` (`id`,`name`,`type`) VALUES 
 ('41','幼儿园','leaf'),
 ('42','小学生','leaf'),
 ('43','初中生','leaf'),
 ('44','高中生','leaf'),
 ('45','技校生','leaf'),
 ('46','中专生','leaf'),
 ('47','专科生','leaf'),
 ('48','大学生','leaf'),
 ('49','研究生','leaf'),
 ('4A','博士生','leaf'),
 ('4B','博士后','leaf'),
 ('4C','社会生','leaf');
COMMIT;

-- 用户角色编码信息表
DROP TABLE IF EXISTS `hawk`.`actor`;
CREATE TABLE `hawk`.`actor` (
  `id`        varchar(20) NOT     NULL  COMMENT '角色编号',
  `upid`      varchar(20) DEFAULT NULL  COMMENT '上级代码',
  `name`      text        DEFAULT NULL  COMMENT '角色名称',
  `abb`       varchar(10) DEFAULT NULL  COMMENT '查询缩写',
  `type`      varchar(10) NOT     NULL  COMMENT '代码类型',
  `descript`  text        DEFAULT NULL  COMMENT '角色描述',
  `notes`     text        DEFAULT NULL  COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='用户角色编码表';

-- 用户角色编码数据
INSERT INTO `hawk`.`actor`
(`id`,`name`,`type`) VALUES 
('admin','系统管理员功能','leaf'),
('student','学生功能','leaf'),
('teacher','教师功能','leaf');
COMMIT;

