/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : dubbo-demo3

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2022-06-09 15:48:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `sex` tinyint DEFAULT '0' COMMENT '0：男(默认)  1：女  ',
  `age` int DEFAULT NULL COMMENT '年龄',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`user_id`),
  KEY `index_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'mzl', '88888', '0', '23', '13652707142');
INSERT INTO `user` VALUES ('3', 'gqy', '88888', '1', '21', '13652707142');
INSERT INTO `user` VALUES ('4', 'lisi', '88888', '0', '22', '13688888889');
INSERT INTO `user` VALUES ('6', 'xiaohua', '77777', '1', '25', '13688888889');
