/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80027
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2022-01-21 17:27:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_tbl
-- ----------------------------
DROP TABLE IF EXISTS `order_tbl`;
CREATE TABLE `order_tbl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `commodity_code` varchar(255) DEFAULT NULL,
  `count` int DEFAULT '0',
  `money` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of order_tbl
-- ----------------------------
INSERT INTO `order_tbl` VALUES ('4', 'U100000', 'C100000', '30', '3000');
INSERT INTO `order_tbl` VALUES ('5', 'U100000', 'C100000', '30', '3000');
INSERT INTO `order_tbl` VALUES ('7', '1', 'product-1', '1', '5');
INSERT INTO `order_tbl` VALUES ('8', '1', 'product-1', '1', '5');
INSERT INTO `order_tbl` VALUES ('9', '1', 'product-1', '1', '5');
INSERT INTO `order_tbl` VALUES ('10', '1', 'product-1', '1', '5');
INSERT INTO `order_tbl` VALUES ('11', '1', 'product-1', '1', '5');
INSERT INTO `order_tbl` VALUES ('12', '1', 'product-1', '1', '5');
INSERT INTO `order_tbl` VALUES ('13', '1', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('15', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('17', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('18', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('22', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('23', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('26', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('27', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('30', 'U100000', 'product-2', '1', '5');
INSERT INTO `order_tbl` VALUES ('31', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('32', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('33', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('34', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('35', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('36', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('37', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('43', 'U100000', 'C100000', '1', '5');
INSERT INTO `order_tbl` VALUES ('44', 'U100000', 'C100000', '1', '5');
