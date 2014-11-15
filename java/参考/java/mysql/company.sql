/*
Navicat MySQL Data Transfer

Source Server         : localhost_3305
Source Server Version : 50173
Source Host           : localhost:3305
Source Database       : company

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2014-05-02 22:04:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employeeId` char(32) NOT NULL DEFAULT '' COMMENT '标识',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` char(2) DEFAULT NULL COMMENT '性别',
  `age` int(10) unsigned DEFAULT NULL COMMENT '年龄',
  `birthdate` datetime DEFAULT NULL COMMENT '出生日期',
  `image` varchar(200) DEFAULT NULL COMMENT '图片',
  `descr` text COMMENT '描述',
  `sortOrder` int(10) unsigned DEFAULT '100' COMMENT '排序',
  `visible` bit(1) DEFAULT b'1' COMMENT '是否显示',
  `commitTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`employeeId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='员工';

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('f75e96344624424691e677b4179f207b', '测试员工f75', '未知', '16', null, null, '范德萨电风扇', '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('96092d42648848199c3b1828d75943a2', '测试员工960', '未知', '76', '2014-05-15 00:00:00', '', '', '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('e1aeb12762364c778c86ce09d0826df2', '测试员工e1a', '未知', '91', null, null, null, '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('092ef82936774882abbd63eedfd88374', '测试员工092', '男', '47', null, null, null, '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('daea0378c4b0480bbd787e7672eb5111', '测试员工dae', '未知', '25', null, null, null, '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('661c466e279a42199ee52153579b0ae4', 'test00', '女', '22', '2014-04-16 00:00:00', '', 'fdsa', '101', '\0', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('c92a4857c2014c57b0c3b9861a843992', '测试员工c92', '未知', '5', null, null, null, '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('f70fc2813e374c87b28488b33c10df8b', '测试员工f70', '未知', '77', null, null, null, '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('2ca12f7d94e248efad54f33c85d6b123', '测试员工2ca', '未知', '97', null, null, '反倒萨芬范德萨', '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('4f3c8c44062640ac8bcf1e7127b1785e', '杨名', '男', '30', '2014-05-07 00:00:00', '', '描述', '201', '', '2014-05-02 12:21:08');
INSERT INTO `employee` VALUES ('73b7fc6298ff4f028157abede72d757b', '测试员工73b', '未知', '83', null, null, null, '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('26687487abe94555b998bace7eb75371', '测试员工266', '未知', '36', null, null, null, '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('f8c4a09db2234122bf7bb108d5939df8', 'test1', '女', '55', '2014-04-10 00:00:00', '发大水', '', '200', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('0f4868833e5e4be5a21c1f50530fce80', '测试员工0f4', '未知', '41', null, null, null, '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('b13ea378ca6046e09d9fe2602212e8c3', '测试员工b13', '未知', '4', null, null, null, '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('1ac0d2d48bba4064b36a0852b8361562', '测试员工1ac', '未知', '62', null, '', '', '100', '\0', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('d945d489049e4afa9399938203be9784', '测试员工d94', '未知', '21', null, null, null, '100', '', '2014-04-29 12:06:10');
INSERT INTO `employee` VALUES ('8a196c463d084739bde1f65a656c2985', '测试员工', '未知', '73', null, null, null, '100', '', '2014-04-29 18:42:30');
INSERT INTO `employee` VALUES ('1c2b9088ca5740c7ab364892ab84472d', 'abcd', '男', '22', '2014-04-15 00:00:00', '', 'abc', '105', '', '2014-04-30 00:34:16');
INSERT INTO `employee` VALUES ('c4afb2df4548434ab9d17818f264ce3a', '新测试', '男', '100', '2014-04-30 00:00:00', '', '', '200', '\0', '2014-04-30 22:51:30');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
