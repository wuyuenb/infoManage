/*
 Navicat MySQL Data Transfer

 Source Server         : LibManage
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : db_lib

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 20/11/2019 12:59:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type`  (
  `tid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `tname` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '_utf8mb4\\\'ä¸ä¸å¿ä¿®\\\'' COMMENT '类型名',
  `remark` tinyint(4) DEFAULT 1 COMMENT '是否有效',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_type
-- ----------------------------
INSERT INTO `tb_type` VALUES (1, '通识必修', 1);
INSERT INTO `tb_type` VALUES (2, '通识选修', 1);
INSERT INTO `tb_type` VALUES (3, '专业必修', 1);
INSERT INTO `tb_type` VALUES (4, '专业选修', 1);

SET FOREIGN_KEY_CHECKS = 1;
