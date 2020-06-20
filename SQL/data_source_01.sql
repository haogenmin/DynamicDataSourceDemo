/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : data_source_01

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-06-20 09:53:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) DEFAULT NULL,
  `db_source` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '格力空调', 'datasource_01');
INSERT INTO `product` VALUES ('2', '海尔冰箱', 'datasource_01');
INSERT INTO `product` VALUES ('3', '小短裙', 'datasource_01');
INSERT INTO `product` VALUES ('4', '羽绒服', 'datasource_01');
INSERT INTO `product` VALUES ('5', '韩版休闲鞋', 'datasource_01');
INSERT INTO `product` VALUES ('6', '高贵鞋', 'datasource_01');
