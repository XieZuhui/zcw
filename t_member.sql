/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : zcw

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-08-26 09:03:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginacct` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '登录账号',
  `userpswd` char(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '登录密码',
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '用户名称',
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `authstatus` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '实名认证状态 0 - 未实名认证， 1 - 实名认证申请中， 2 - 已实名认证',
  `usertype` char(1) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '用户类型 0 - 个人， 1 - 企业',
  `realname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实名称',
  `cardnum` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证号码',
  `accttype` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账户类型 0 - 企业， 1 - 个体， 2 - 个人， 3 - 政府',
  `validateCode` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '激活码',
  `createtime` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `activationstatus` int(10) unsigned DEFAULT '0' COMMENT '0未激活，1已激活',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='会员表';

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES ('1', 'Lorem', 'test123', 'ipsum', '无', '0', '0', '李鹏举', '无', '1', null, null, '1');
INSERT INTO `t_member` VALUES ('2', 'amet', 'test123', 'ipametsum', '无', '0', '0', '吴艾米', '无', '1', null, null, '1');
INSERT INTO `t_member` VALUES ('3', 'Nulla', 'test123', 'lina', '无', '0', '0', '李娜', '无', '1', null, null, '1');
INSERT INTO `t_member` VALUES ('4', 'sagittis', 'test123', 'shenties', '无', '0', '0', '沈特中', '无', '1', null, null, '1');
INSERT INTO `t_member` VALUES ('5', 'semper', 'test123', 'shimoste', '无', '0', '0', '石默天', '无', '1', null, null, '1');
INSERT INTO `t_member` VALUES ('6', 'taciti', 'test123', 'tianske', '无', '0', '0', '康池', '无', '1', null, null, '1');
INSERT INTO `t_member` VALUES ('7', 'sodales', 'test123', 'shaodaol', '无', '0', '0', '龙邵道', '无', '1', null, null, '1');
INSERT INTO `t_member` VALUES ('8', 'sociosqu', 'test123', 'soicq', '无', '0', '0', '蔡康强', '无', '1', null, null, '1');
