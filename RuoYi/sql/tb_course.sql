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

 Date: 20/11/2019 12:59:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
  `cid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程编号',
  `cname` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
  `ctime` int(11) DEFAULT 12 COMMENT '课时',
  `tid` int(11) DEFAULT NULL COMMENT '课程类型编号',
  `cstatus` tinyint(4) DEFAULT 1 COMMENT '1-开课  0-没开课',
  `cterm` int(11) DEFAULT 1 COMMENT '开课学期',
  `cpoint` float DEFAULT 0 COMMENT '课程学分',
  `cdemo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '课程备注',
  `cpic` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '课程图片',
  `remark` tinyint(4) DEFAULT 1 COMMENT '是否有效',
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `tid`(`tid`) USING BTREE,
  CONSTRAINT `tb_course_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `tb_type` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES ('B361L03800', '线性代数A', 32, 1, 1, 1, 2, '', '2.jpg', 1);
INSERT INTO `tb_course` VALUES ('B441L03900', '英语3', 52, 1, 1, 3, 3, '', '1.jpg', 1);

SET FOREIGN_KEY_CHECKS = 1;
