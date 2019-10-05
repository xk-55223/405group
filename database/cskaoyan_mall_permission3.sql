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

 Date: 04/10/2019 23:27:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cskaoyan_mall_permission3
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_permission3`;
CREATE TABLE `cskaoyan_mall_permission3`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission2_id` int(11) NULL DEFAULT NULL,
  `permission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `api` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_permission3
-- ----------------------------
INSERT INTO `cskaoyan_mall_permission3` VALUES (1, 1, 'admin:collect:list', 'GET /admin/collect/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (2, 2, 'admin:feedback:list', 'GET /admin/feedback/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (3, 3, 'admin:user:list', 'GET /admin/user/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (4, 4, 'admin:footprint:list', 'GET /admin/footprint/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (5, 5, 'admin:history:list', 'GET /admin/history/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (6, 6, 'admin:address:list', 'GET /admin/address/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (7, 7, 'admin:groupon:read', 'GET /admin/groupon/listRecord', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (8, 7, 'admin:groupon:update', 'POST /admin/groupon/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (9, 7, 'admin:groupon:delete', 'POST /admin/groupon/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (10, 7, 'admin:groupon:create', 'POST /admin/groupon/create', '添加');
INSERT INTO `cskaoyan_mall_permission3` VALUES (11, 7, 'admin:groupon:list', 'GET /admin/groupon/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (12, 8, 'admin:ad:update', 'POST /admin/ad/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (13, 8, 'admin:ad:read', 'GET /admin/ad/read', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (14, 8, 'admin:ad:delete', 'POST /admin/ad/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (15, 8, 'admin:ad:create', 'POST /admin/ad/create', '添加');
INSERT INTO `cskaoyan_mall_permission3` VALUES (16, 8, 'admin:ad:list', 'GET /admin/ad/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (17, 9, 'admin:topic:update', 'POST /admin/topic/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (18, 9, 'admin:topic:read', 'GET /admin/topic/read', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (19, 9, 'admin:topic:delete', 'POST /admin/topic/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (20, 9, 'admin:topic:create', 'POST /admin/topic/create', '添加');
INSERT INTO `cskaoyan_mall_permission3` VALUES (21, 9, 'admin:topic:list', 'GET /admin/topic/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (22, 10, 'admin:coupon:listuser', 'GET /admin/coupon/listuser', '查询用户');
INSERT INTO `cskaoyan_mall_permission3` VALUES (23, 10, 'admin:coupon:update', 'POST /admin/coupon/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (24, 10, 'admin:coupon:read', 'GET /admin/coupon/read', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (25, 10, 'admin:coupon:delete', 'POST /admin/coupon/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (26, 10, 'admin:coupon:create', 'POST /admin/coupon/create', '添加');
INSERT INTO `cskaoyan_mall_permission3` VALUES (27, 10, 'admin:coupon:list', 'GET /admin/coupon/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (28, 11, 'admin:config:mall:list', 'GET /admin/config/mall', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (29, 11, 'admin:config:mall:updateConfigs', 'POST /admin/config/mall', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (30, 12, 'admin:config:express:updateConfigs', 'POST /admin/config/express', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (31, 12, 'admin:config:express:list', 'GET /admin/config/express', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (32, 13, 'admin:config:order:list', 'GET /admin/config/order', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (33, 13, 'admin:config:order:updateConfigs', 'POST /admin/config/order', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (34, 14, 'admin:config:wx:updateConfigs', 'POST /admin/config/wx', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (35, 14, 'admin:config:wx:list', 'GET /admin/config/wx', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (36, 15, 'index:permission:write', 'POST /admin/index/write', '权限写');
INSERT INTO `cskaoyan_mall_permission3` VALUES (37, 15, 'index:permission:read', 'GET /admin/index/read', '权限读');
INSERT INTO `cskaoyan_mall_permission3` VALUES (38, 16, 'admin:stat:user', 'GET /admin/stat/user', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (39, 17, 'admin:stat:order', 'GET /admin/stat/order', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (40, 18, 'admin:stat:goods', 'GET /admin/stat/goods', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (41, 19, 'admin:admin:update', 'POST /admin/admin/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (42, 19, 'admin:admin:read', 'GET /admin/admin/read', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (43, 19, 'admin:admin:delete', 'POST /admin/admin/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (44, 19, 'admin:admin:create', 'POST /admin/admin/create', '添加');
INSERT INTO `cskaoyan_mall_permission3` VALUES (45, 19, 'admin:admin:list', 'GET /admin/admin/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (46, 20, 'admin:log:list', 'GET /admin/log/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (47, 21, 'admin:role:permission:update', 'POST /admin/role/permissions', '权限变更');
INSERT INTO `cskaoyan_mall_permission3` VALUES (48, 21, 'admin:role:update', 'POST /admin/role/update', '角色编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (49, 21, 'admin:role:read', 'GET /admin/role/read', '角色详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (50, 21, 'admin:role:delete', 'POST /admin/role/delete', '角色删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (51, 21, 'admin:role:permission:get', 'GET /admin/role/permissions', '权限详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (52, 21, 'admin:role:create', 'POST /admin/role/create', '角色添加');
INSERT INTO `cskaoyan_mall_permission3` VALUES (53, 21, 'admin:role:list', 'GET /admin/role/list', '角色查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (54, 22, 'admin:storage:update', 'POST /admin/storage/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (55, 22, 'admin:storage:read', 'POST /admin/storage/read', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (56, 22, 'admin:storage:delete', 'POST /admin/storage/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (57, 22, 'admin:storage:create', 'POST /admin/storage/create', '上传');
INSERT INTO `cskaoyan_mall_permission3` VALUES (58, 22, 'admin:storage:list', 'GET /admin/storage/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (59, 23, 'admin:brand:update', 'POST /admin/brand/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (60, 23, 'admin:brand:read', 'GET /admin/brand/read', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (61, 23, 'admin:brand:delete', 'POST /admin/brand/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (62, 23, 'admin:brand:create', 'POST /admin/brand/create', '添加');
INSERT INTO `cskaoyan_mall_permission3` VALUES (63, 23, 'admin:brand:list', 'GET /admin/brand/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (64, 24, 'admin:order:refund', 'POST /admin/order/refund', '订单退款');
INSERT INTO `cskaoyan_mall_permission3` VALUES (65, 24, 'admin:order:read', 'GET /admin/order/detail', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (66, 24, 'admin:order:ship', 'POST /admin/order/ship', '订单发货');
INSERT INTO `cskaoyan_mall_permission3` VALUES (67, 24, 'admin:order:reply', 'POST /admin/order/reply', '订单商品回复');
INSERT INTO `cskaoyan_mall_permission3` VALUES (68, 24, 'admin:order:list', 'GET /admin/order/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (69, 25, 'admin:keyword:update', 'POST /admin/keyword/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (70, 25, 'admin:keyword:read', 'GET /admin/keyword/read', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (71, 25, 'admin:keyword:delete', 'POST /admin/keyword/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (72, 25, 'admin:keyword:create', 'POST /admin/keyword/create', '添加');
INSERT INTO `cskaoyan_mall_permission3` VALUES (73, 25, 'admin:keyword:list', 'GET /admin/keyword/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (74, 26, 'admin:category:update', 'POST /admin/category/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (75, 26, 'admin:category:read', 'GET /admin/category/read', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (76, 26, 'admin:category:delete', 'POST /admin/category/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (77, 26, 'admin:category:create', 'POST /admin/category/create', '添加');
INSERT INTO `cskaoyan_mall_permission3` VALUES (78, 26, 'admin:category:list', 'GET /admin/category/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (79, 27, 'admin:issue:update', 'POST /admin/issue/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (80, 27, 'admin:issue:delete', 'POST /admin/issue/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (81, 27, 'admin:issue:create', 'POST /admin/issue/create', '添加');
INSERT INTO `cskaoyan_mall_permission3` VALUES (82, 27, 'admin:issue:list', 'GET /admin/issue/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (83, 28, 'admin:goods:read', 'GET /admin/goods/detail', '详情');
INSERT INTO `cskaoyan_mall_permission3` VALUES (84, 28, 'admin:goods:update', 'POST /admin/goods/update', '编辑');
INSERT INTO `cskaoyan_mall_permission3` VALUES (85, 28, 'admin:goods:delete', 'POST /admin/goods/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (86, 28, 'admin:goods:create', 'POST /admin/goods/create', '上架');
INSERT INTO `cskaoyan_mall_permission3` VALUES (87, 28, 'admin:goods:list', 'GET /admin/goods/list', '查询');
INSERT INTO `cskaoyan_mall_permission3` VALUES (88, 29, 'admin:comment:delete', 'POST /admin/comment/delete', '删除');
INSERT INTO `cskaoyan_mall_permission3` VALUES (89, 29, 'admin:comment:list', 'GET /admin/comment/list', '查询');

SET FOREIGN_KEY_CHECKS = 1;
