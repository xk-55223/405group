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

 Date: 04/10/2019 23:27:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cskaoyan_mall_permission2
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_permission2`;
CREATE TABLE `cskaoyan_mall_permission2`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission1_id` int(11) NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_permission2
-- ----------------------------
INSERT INTO `cskaoyan_mall_permission2` VALUES (1, 1, '用户收藏');
INSERT INTO `cskaoyan_mall_permission2` VALUES (2, 1, '意见反馈');
INSERT INTO `cskaoyan_mall_permission2` VALUES (3, 1, '会员管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (4, 1, '用户足迹');
INSERT INTO `cskaoyan_mall_permission2` VALUES (5, 1, '搜索历史');
INSERT INTO `cskaoyan_mall_permission2` VALUES (6, 1, '收货地址');
INSERT INTO `cskaoyan_mall_permission2` VALUES (7, 2, '团购管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (8, 2, '广告管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (9, 2, '专题管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (10, 2, '优惠券管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (11, 3, '商城配置');
INSERT INTO `cskaoyan_mall_permission2` VALUES (12, 3, '运费配置');
INSERT INTO `cskaoyan_mall_permission2` VALUES (13, 3, '订单配置');
INSERT INTO `cskaoyan_mall_permission2` VALUES (14, 3, '小程序配置');
INSERT INTO `cskaoyan_mall_permission2` VALUES (15, 4, '权限测试');
INSERT INTO `cskaoyan_mall_permission2` VALUES (16, 5, '用户统计');
INSERT INTO `cskaoyan_mall_permission2` VALUES (17, 5, '订单统计');
INSERT INTO `cskaoyan_mall_permission2` VALUES (18, 5, '商品统计');
INSERT INTO `cskaoyan_mall_permission2` VALUES (19, 6, '管理员管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (20, 6, '操作日志');
INSERT INTO `cskaoyan_mall_permission2` VALUES (21, 6, '角色管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (22, 6, '对象存储');
INSERT INTO `cskaoyan_mall_permission2` VALUES (23, 7, '品牌管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (24, 7, '订单管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (25, 7, '关键词');
INSERT INTO `cskaoyan_mall_permission2` VALUES (26, 7, '类目管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (27, 7, '通用问题');
INSERT INTO `cskaoyan_mall_permission2` VALUES (28, 8, '商品管理');
INSERT INTO `cskaoyan_mall_permission2` VALUES (29, 8, '评论管理');

SET FOREIGN_KEY_CHECKS = 1;
