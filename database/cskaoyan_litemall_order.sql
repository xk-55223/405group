/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : mall_405

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 04/10/2019 23:36:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cskaoyan_litemall_order
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_litemall_order`;
CREATE TABLE `cskaoyan_litemall_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unpaid` int(11) NULL DEFAULT NULL,
  `unconfirm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_litemall_order
-- ----------------------------
INSERT INTO `cskaoyan_litemall_order` VALUES (1, '42', 41, '42');

SET FOREIGN_KEY_CHECKS = 1;
