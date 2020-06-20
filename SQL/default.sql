/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : default

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-06-20 09:53:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `datasource_info`
-- ----------------------------
DROP TABLE IF EXISTS `datasource_info`;
CREATE TABLE `datasource_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `datasource_key` varchar(50) NOT NULL,
  `driver_class_name` varchar(300) NOT NULL,
  `jdbc_url` varchar(300) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datasource_info
-- ----------------------------
INSERT INTO `datasource_info` VALUES ('1', 'firstDataSource', 'com.mysql.cj.jdbc.Driver', 'jdbc:mysql://127.0.0.1:3306/data_source_01?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true', 'root', '123456');
INSERT INTO `datasource_info` VALUES ('2', 'secondDataSource', 'com.mysql.cj.jdbc.Driver', 'jdbc:mysql://127.0.0.1:3306/data_source_02?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true', 'root', '123456');
INSERT INTO `datasource_info` VALUES ('8', 'threeDataSource', 'com.mysql.cj.jdbc.Driver', 'jdbc:mysql://127.0.0.1:3306/data_source_03?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true', 'root', '123456');

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
INSERT INTO `product` VALUES ('1', '格力空调', 'datasource_default');
INSERT INTO `product` VALUES ('2', '海尔冰箱', 'datasource_default');
INSERT INTO `product` VALUES ('3', '小短裙', 'datasource_default');
INSERT INTO `product` VALUES ('4', '羽绒服', 'datasource_default');
INSERT INTO `product` VALUES ('5', '韩版休闲鞋', 'datasource_default');
INSERT INTO `product` VALUES ('6', '高贵鞋', 'datasource_default');
