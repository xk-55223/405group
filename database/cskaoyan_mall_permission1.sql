/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : project2_mall

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 04/10/2019 23:27:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cskaoyan_mall_permission1
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_permission1`;
CREATE TABLE `cskaoyan_mall_permission1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_permission1
-- ----------------------------
INSERT INTO `cskaoyan_mall_permission1` VALUES (1, '用户管理');
INSERT INTO `cskaoyan_mall_permission1` VALUES (2, '推广管理');
INSERT INTO `cskaoyan_mall_permission1` VALUES (3, '配置管理');
INSERT INTO `cskaoyan_mall_permission1` VALUES (4, '其他');
INSERT INTO `cskaoyan_mall_permission1` VALUES (5, '统计管理');
INSERT INTO `cskaoyan_mall_permission1` VALUES (6, '系统管理');
INSERT INTO `cskaoyan_mall_permission1` VALUES (7, '商城管理');
INSERT INTO `cskaoyan_mall_permission1` VALUES (8, '商品管理');

SET FOREIGN_KEY_CHECKS = 1;
