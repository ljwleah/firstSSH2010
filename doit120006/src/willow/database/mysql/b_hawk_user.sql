-- FILENAME:    b_hawk_user.sql
-- CREATEDATE:  2012-02-11

CREATE DATABASE IF NOT EXISTS `hawk`;
COMMIT;

USE `hawk`;
COMMIT;

-- 用户账户信息表
DROP TABLE IF EXISTS `hawk`.`user`;
CREATE TABLE  `hawk`.`user` (
  `username`    varchar(64)  NOT     NULL  COMMENT '用户账户',
  `password`    varchar(64)  NOT     NULL  COMMENT '账户密码',
  `actor`       varchar(20)  NOT     NULL  COMMENT '角色编号',
  `persontb`    varchar(20)  NOT     NULL  COMMENT '用户库表',
  `personid`    varchar(25)  NOT     NULL  COMMENT '用户编号',
  `status`      char(1)      DEFAULT '0'   COMMENT '账户状态',
  `descript`    text         DEFAULT NULL  COMMENT '账户描述',
  `notes`       text         DEFAULT NULL  COMMENT '备注信息',
  `createdate`  datetime     NOT     NULL  COMMENT '创建日期',
  `changedate`  datetime     NOT     NULL  COMMENT '变更日期',
  `changetimes` int(5)       DEFAULT 0     COMMENT '变更次数',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 用户账户信息初始数据
INSERT INTO `hawk`.`user`
(`username`,`password`,`actor`,`persontb`,`personid`,`status`,`descript`,
`notes`,`createdate`,`changedate`,`changetimes`) VALUES 
('admin','123456','admin','teacher','T1510030','0','系统管理员角色','',NOW(),NOW(),0),
('student','123456','student','student','20061118080019','0','学生角色','',NOW(),NOW(),0),
('teacher','123456','teacher','teacher','T1510030','0','教师角色','',NOW(),NOW(),0);
COMMIT;
