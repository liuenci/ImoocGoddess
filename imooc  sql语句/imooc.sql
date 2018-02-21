/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : imooc

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2015-01-14 00:06:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for imooc_goddess
-- ----------------------------
DROP TABLE IF EXISTS `imooc_goddess`;
CREATE TABLE `imooc_goddess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `create_user` varchar(30) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_user` varchar(30) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `isdel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imooc_goddess
-- ----------------------------
INSERT INTO `imooc_goddess` VALUES ('1', '小溪', '1', '22', '2000-12-12', 'xiaoxi@163.com', '13911111111', 'ADMIN', '2015-01-08', 'ADMIN', '2015-01-08', '0');
