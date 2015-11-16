-- FILENAME:    a_hawk_student.sql
-- CREATEDATE:  2012-02-11

CREATE DATABASE IF NOT EXISTS `hawk`;
COMMIT;

USE `hawk`;
COMMIT;

-- 创建学生信息表 --
DROP TABLE IF EXISTS `hawk`.`student`;
CREATE TABLE `hawk`.`student` (
  `id`          varchar(25) NOT NULL      COMMENT '学生证号',
  `province`    char(6)     NOT NULL      COMMENT '学校省份',
  `school`      varchar(20) NOT NULL      COMMENT '所在学校',
  `grade`       char(4)     NOT NULL      COMMENT '所在年级',
  `schoolclass` char(1)     NOT NULL      COMMENT '所在班级',
  `department`  char(5)     NOT NULL      COMMENT '所在院系',
  `major`       char(5)     NOT NULL      COMMENT '所学专业',
  `degree`      char(2)     NOT NULL      COMMENT '学业级别',
  `name`        varchar(25) NOT NULL      COMMENT '学生姓名',
  `sex`         char(1)     NOT NULL      COMMENT '学生性别',
  `birthday`    datetime    DEFAULT NULL  COMMENT '出生日期',
  `mobile`      varchar(20) DEFAULT NULL  COMMENT '手机号码',
  `phone`       varchar(20) DEFAULT NULL  COMMENT '宿舍电话',
  `email`       varchar(50) NOT NULL      COMMENT '电子邮件',
  `qq`          varchar(15) DEFAULT NULL  COMMENT 'QQ号码',
  `notes`       text        DEFAULT NULL  COMMENT '备注信息',
  `createdate`  datetime    NOT NULL      COMMENT '增加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 学生信息初始数据  --
INSERT INTO `hawk`.`student`
(`id`,`province`,`school`,`grade`,`schoolclass`,`department`,`major`,`name`,
`sex`,`birthday`,`mobile`,`phone`,`email`,`qq`,`notes`,`degree`,`createdate`)
VALUES 
('20061118080017','210000','10165','2006','4','10001','10003', '蒋亮','M',
    '1987-05-09','13591828135','0411-85992730',
    'jiangliang_a@163.com','1243605845','','48',NOW()),
('20061118080019','210000','10165','2006','4','10001','10003','任鹏跃','M',
    '1987-12-12','15142481968','0411-85991818',
    'rpy228@yahoo.com.cn','1243605845','','48',NOW()),
('20061807010003','210000','10165','2006','1','10001','10001','杨茜','F',
    '1988-08-29','15040470207','0411-85992671',
    'liulangde_mao@163.com','1243605845','','48',NOW());
COMMIT;
