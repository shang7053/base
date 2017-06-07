/*
Navicat MySQL Data Transfer

Source Server         : 开发机器152
Source Server Version : 50718
Source Host           : 172.16.41.152:3306
Source Database       : data_sync

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-01 17:14:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for l_sync
-- ----------------------------
DROP TABLE IF EXISTS `l_sync`;
CREATE TABLE `l_sync` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sync_code` varchar(255) DEFAULT NULL COMMENT '同步码',
  `sync_event_count` int(11) DEFAULT NULL COMMENT '同步事件数量',
  `sync_time` bigint(20) DEFAULT NULL COMMENT '同步时间：20160203121212',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同步记录表';

-- ----------------------------
-- Records of l_sync
-- ----------------------------

-- ----------------------------
-- Table structure for l_sync_d
-- ----------------------------
DROP TABLE IF EXISTS `l_sync_d`;
CREATE TABLE `l_sync_d` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sync_code` varchar(255) DEFAULT NULL COMMENT '同步码',
  `sync_event_count` int(255) DEFAULT NULL COMMENT '同步事件数量',
  `sync_time` bigint(20) DEFAULT NULL COMMENT '同步时间：20160203121212',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同步记录表';

-- ----------------------------
-- Records of l_sync_d
-- ----------------------------

-- ----------------------------
-- Table structure for l_sync_h
-- ----------------------------
DROP TABLE IF EXISTS `l_sync_h`;
CREATE TABLE `l_sync_h` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sync_code` varchar(255) DEFAULT NULL COMMENT '同步码',
  `sync_event_count` int(255) DEFAULT NULL COMMENT '同步事件数量',
  `sync_time` bigint(20) DEFAULT NULL COMMENT '同步时间：20160203121212',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同步记录表';

-- ----------------------------
-- Records of l_sync_h
-- ----------------------------

-- ----------------------------
-- Table structure for l_sysytem_log
-- ----------------------------
DROP TABLE IF EXISTS `l_sysytem_log`;
CREATE TABLE `l_sysytem_log` (
  `lid` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  `param` text COMMENT '参数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- ----------------------------
-- Records of l_sysytem_log
-- ----------------------------

-- ----------------------------
-- Table structure for m_sync_statistics
-- ----------------------------
DROP TABLE IF EXISTS `m_sync_statistics`;
CREATE TABLE `m_sync_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prosessing` int(11) DEFAULT NULL COMMENT '是否处理中0否1是',
  `sync_time_start` bigint(20) DEFAULT NULL COMMENT '同步开始时间',
  `sync_time_end` bigint(20) DEFAULT NULL COMMENT '同步结束时间',
  `s_type` int(255) DEFAULT NULL COMMENT '统计类型0小时1天',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_s_type` (`s_type`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='同步统计中间变量表';

-- ----------------------------
-- Records of m_sync_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for r_rule_function
-- ----------------------------
DROP TABLE IF EXISTS `r_rule_function`;
CREATE TABLE `r_rule_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `fid` int(11) DEFAULT NULL COMMENT '链接id',
  `is_on` int(11) DEFAULT NULL COMMENT '是否启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  KEY `fk_r_rule_function_t_function_1` (`fid`),
  KEY `fk_r_rule_function_t_rule_1` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=412 DEFAULT CHARSET=utf8 COMMENT='角色链接关系表';

-- ----------------------------
-- Records of r_rule_function
-- ----------------------------
INSERT INTO `r_rule_function` VALUES ('233', '2', '128', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('234', '2', '129', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('235', '2', '130', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('236', '2', '131', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('237', '2', '132', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('238', '2', '133', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('239', '2', '134', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('240', '2', '135', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('241', '2', '136', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('242', '2', '137', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('243', '2', '138', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('244', '2', '139', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('245', '2', '140', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('246', '2', '141', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('247', '2', '142', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('248', '2', '143', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('249', '2', '144', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('250', '2', '145', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('251', '2', '146', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('252', '2', '147', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('253', '2', '148', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('254', '2', '149', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('255', '2', '150', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('256', '2', '29', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('257', '2', '30', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('258', '2', '31', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('259', '2', '33', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('260', '2', '35', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('261', '2', '37', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('262', '2', '39', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('263', '2', '40', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('264', '2', '41', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('265', '2', '42', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('266', '2', '43', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('267', '2', '44', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('268', '2', '45', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('269', '2', '46', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('270', '2', '47', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('271', '2', '48', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('272', '2', '49', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('273', '2', '50', '1', '2017-05-31 15:40:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('274', '2', '51', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('275', '2', '52', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('276', '2', '53', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('277', '2', '54', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('278', '2', '56', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('279', '2', '60', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('280', '2', '61', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('281', '2', '62', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('282', '2', '63', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('283', '2', '64', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('284', '2', '65', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('285', '2', '66', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('286', '2', '67', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('287', '2', '68', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('288', '2', '69', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('289', '2', '70', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('290', '2', '72', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('291', '2', '73', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('292', '2', '74', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('293', '2', '75', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('294', '2', '76', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('295', '2', '77', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('296', '2', '78', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('297', '2', '79', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('298', '2', '80', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('299', '2', '81', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('300', '2', '82', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('301', '2', '83', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('302', '2', '84', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('303', '2', '85', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('304', '2', '86', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('305', '2', '87', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('306', '2', '88', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('307', '2', '89', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('308', '2', '90', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('309', '2', '91', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('310', '2', '92', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('311', '2', '93', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('312', '2', '94', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('313', '2', '95', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('314', '2', '96', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('315', '2', '97', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('316', '2', '98', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('317', '2', '99', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('318', '2', '100', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('319', '2', '101', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('320', '2', '102', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('321', '2', '103', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('322', '2', '104', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('323', '2', '105', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('324', '2', '106', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('325', '2', '107', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('326', '2', '108', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('327', '2', '126', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('328', '2', '127', '1', '2017-05-31 15:40:47', null, '0');
INSERT INTO `r_rule_function` VALUES ('341', '3', '128', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('342', '3', '129', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('343', '3', '131', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('344', '3', '132', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('345', '3', '133', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('346', '3', '134', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('347', '3', '136', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('348', '3', '137', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('349', '3', '138', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('350', '3', '139', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('351', '3', '141', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('352', '3', '142', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('353', '3', '143', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('354', '3', '144', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('355', '3', '145', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('356', '3', '146', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('357', '3', '147', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('358', '3', '148', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('359', '3', '60', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('360', '3', '61', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('361', '3', '62', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('362', '3', '63', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('363', '3', '64', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('364', '3', '65', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('365', '3', '66', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('366', '3', '67', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('367', '3', '68', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('368', '3', '69', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('369', '3', '70', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('370', '3', '72', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('371', '3', '73', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('372', '3', '74', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('373', '3', '75', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('374', '3', '76', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('375', '3', '77', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('376', '3', '78', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('377', '3', '79', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('378', '3', '80', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('379', '3', '81', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('380', '3', '82', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('381', '3', '84', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('382', '3', '85', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('383', '3', '86', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('384', '3', '87', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('385', '3', '88', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('386', '3', '89', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('387', '3', '90', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('388', '3', '91', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('389', '3', '92', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('390', '3', '93', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('391', '3', '94', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('392', '3', '96', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('393', '3', '97', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('394', '3', '98', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('395', '3', '99', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('396', '3', '101', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('397', '3', '102', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('398', '3', '103', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('399', '3', '104', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('400', '3', '105', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('401', '3', '106', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('402', '3', '107', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('403', '3', '126', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('404', '3', '127', '1', '2017-05-31 15:42:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('405', '3', '151', '1', '2017-06-01 16:23:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('406', '2', '151', '1', '2017-06-01 16:23:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('407', '3', '152', '1', '2017-06-01 16:24:16', null, '0');
INSERT INTO `r_rule_function` VALUES ('408', '2', '152', '1', '2017-06-01 16:24:16', null, '0');
INSERT INTO `r_rule_function` VALUES ('409', '3', '153', '1', '2017-06-01 16:24:33', null, '0');
INSERT INTO `r_rule_function` VALUES ('410', '2', '153', '1', '2017-06-01 16:24:33', null, '0');
INSERT INTO `r_rule_function` VALUES ('411', '2', '154', '1', '2017-06-01 17:13:45', null, '0');

-- ----------------------------
-- Table structure for r_user_rule
-- ----------------------------
DROP TABLE IF EXISTS `r_user_rule`;
CREATE TABLE `r_user_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `is_on` int(11) DEFAULT NULL COMMENT '是否冻结0否1是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  KEY `fk_r_user_rule_t_rule_1` (`rid`),
  KEY `fk_r_user_rule_t_user_1` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of r_user_rule
-- ----------------------------
INSERT INTO `r_user_rule` VALUES ('8', '1', '2', '1', '2016-07-18 12:10:47', null, '0');
INSERT INTO `r_user_rule` VALUES ('9', '1', '3', '1', '2017-05-31 15:47:48', null, '0');
INSERT INTO `r_user_rule` VALUES ('11', '2', '3', '1', '2017-05-31 16:06:15', null, '0');

-- ----------------------------
-- Table structure for s_system_settings
-- ----------------------------
DROP TABLE IF EXISTS `s_system_settings`;
CREATE TABLE `s_system_settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `config_name` varchar(255) DEFAULT NULL COMMENT '名',
  `config_value` varchar(255) DEFAULT NULL COMMENT '值',
  `rmark` varchar(255) DEFAULT NULL COMMENT '说明',
  `is_on` int(11) DEFAULT NULL COMMENT '是否可用0否1是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='系统配置表';

-- ----------------------------
-- Records of s_system_settings
-- ----------------------------
INSERT INTO `s_system_settings` VALUES ('1', 'error_pw_count', '12', '登录重试次数', '1', '2016-07-14 16:32:04', '2016-07-18 17:45:20', '5');
INSERT INTO `s_system_settings` VALUES ('6', 'tablesize', '10', '表格每页默认数据', '1', '2016-07-20 17:00:06', null, '0');
INSERT INTO `s_system_settings` VALUES ('7', 'sync_version', '0.0.1', '同步版本号', '1', '2017-04-12 10:27:45', null, '0');

-- ----------------------------
-- Table structure for t_canal
-- ----------------------------
DROP TABLE IF EXISTS `t_canal`;
CREATE TABLE `t_canal` (
  `canal_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `canal_name` varchar(255) DEFAULT NULL COMMENT 'canal名称',
  `canal_ip` varchar(255) DEFAULT NULL COMMENT 'ip',
  `canal_port` varchar(255) DEFAULT NULL COMMENT '端口',
  `canal_destination` varchar(255) DEFAULT NULL COMMENT '主题',
  `canal_subscribe` varchar(255) DEFAULT NULL COMMENT '过滤器',
  `is_zookeeper` int(255) DEFAULT NULL COMMENT '是否zookeeper',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_on` int(255) DEFAULT '1' COMMENT '是否启用',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`canal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='canal列表';

-- ----------------------------
-- Records of t_canal
-- ----------------------------

-- ----------------------------
-- Table structure for t_column
-- ----------------------------
DROP TABLE IF EXISTS `t_column`;
CREATE TABLE `t_column` (
  `col_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字段id',
  `tab_id` int(11) DEFAULT NULL COMMENT '表id',
  `col_name` varchar(255) DEFAULT NULL COMMENT '字段名称',
  `col_note` varchar(255) DEFAULT NULL COMMENT '字段备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_on` int(255) DEFAULT '1' COMMENT '是否启用',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`col_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='字段表';

-- ----------------------------
-- Records of t_column
-- ----------------------------

-- ----------------------------
-- Table structure for t_datasource
-- ----------------------------
DROP TABLE IF EXISTS `t_datasource`;
CREATE TABLE `t_datasource` (
  `ds_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ds_name` varchar(255) DEFAULT '' COMMENT '数据源名称',
  `ds_ip` varchar(255) DEFAULT NULL COMMENT 'ip',
  `ds_port` varchar(255) DEFAULT NULL COMMENT '端口',
  `ds_dbname` varchar(255) DEFAULT NULL COMMENT '数据库名称',
  `ds_uname` varchar(255) DEFAULT NULL COMMENT '用户名',
  `ds_pwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `ds_status` int(255) DEFAULT '1' COMMENT '数据源状态，0失效，1正常',
  `validate_time` datetime DEFAULT NULL COMMENT '验证时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_on` int(255) DEFAULT '1' COMMENT '是否启用',
  `version` int(255) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ds_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='数据源表';

-- ----------------------------
-- Records of t_datasource
-- ----------------------------

-- ----------------------------
-- Table structure for t_function
-- ----------------------------
DROP TABLE IF EXISTS `t_function`;
CREATE TABLE `t_function` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '链接id',
  `fname` varchar(255) DEFAULT NULL COMMENT '链接名称',
  `furl` varchar(255) DEFAULT NULL COMMENT '链接url',
  `pfid` int(11) DEFAULT NULL COMMENT '父链接id',
  `menu_type` int(255) DEFAULT NULL COMMENT '菜单级别1一级菜单2二级菜单3组件菜单',
  `sort` int(255) DEFAULT NULL COMMENT '排序',
  `is_on` int(11) DEFAULT NULL COMMENT '是否冻结0否1是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8 COMMENT='连接表';

-- ----------------------------
-- Records of t_function
-- ----------------------------
INSERT INTO `t_function` VALUES ('29', '系统设置', 'javascript:;', '0', '1', '9', '1', '2016-07-13 09:59:08', '2016-07-13 09:59:11', '0');
INSERT INTO `t_function` VALUES ('30', '角色管理', 'ruleController/turnrule.do', '29', '2', '1', '1', '2016-07-13 10:00:18', '2016-07-13 10:00:21', '0');
INSERT INTO `t_function` VALUES ('31', '链接管理', 'functionController/turnFunction.do', '29', '2', '2', '1', '2016-07-13 11:55:45', '2016-07-13 11:55:47', '0');
INSERT INTO `t_function` VALUES ('33', '用户管理', 'userController/turnuser.do', '29', '2', '4', '1', '2016-07-14 09:31:34', '2016-07-14 15:54:02', '1');
INSERT INTO `t_function` VALUES ('35', '系统参数', 'settingsController/turnSettings.do', '29', '2', '5', '1', '2016-07-14 16:14:21', null, '0');
INSERT INTO `t_function` VALUES ('37', '系统消息', 'noticeController/turnnotice.do', '29', '2', '5', '0', '2016-07-15 10:06:02', '2017-04-07 10:39:59', '1');
INSERT INTO `t_function` VALUES ('39', '日志查询', 'systemLogsController/turnSystemLogs.do', '29', '2', '6', '1', '2016-07-21 09:45:37', '2017-05-15 10:31:43', '2');
INSERT INTO `t_function` VALUES ('40', '查看', 'userlist/turnmodalgetinfo.do', '33', '4', '1', '1', '2016-07-21 13:58:55', null, '0');
INSERT INTO `t_function` VALUES ('41', '赋予', 'userlist/turnmodal.do', '33', '4', '2', '1', '2016-07-21 13:59:22', null, '0');
INSERT INTO `t_function` VALUES ('42', '禁用', 'userlist/freezeuser.do', '33', '4', '3', '1', '2016-07-21 13:59:46', '2016-07-21 14:02:44', '1');
INSERT INTO `t_function` VALUES ('43', '启用', 'userlist/startuser.do', '33', '4', '4', '1', '2016-07-21 14:00:57', '2016-07-21 14:09:44', '3');
INSERT INTO `t_function` VALUES ('44', '重置密码', 'userlist/restpassword.do', '33', '4', '5', '1', '2016-07-21 14:01:37', null, '0');
INSERT INTO `t_function` VALUES ('45', '设为已读', 'noticelist/setread.do', '37', '4', '1', '1', '2016-07-21 14:14:48', null, '0');
INSERT INTO `t_function` VALUES ('46', '查看', 'rulelist/turnmodalgetinfo.do', '30', '4', '1', '1', '2016-07-21 14:15:19', null, '0');
INSERT INTO `t_function` VALUES ('47', '赋予', 'rulelist/turnmodal.do', '30', '4', '2', '1', '2016-07-21 14:15:46', null, '0');
INSERT INTO `t_function` VALUES ('48', '禁用', 'rulelist/freezerule.do', '30', '4', '3', '1', '2016-07-21 14:16:04', null, '0');
INSERT INTO `t_function` VALUES ('49', '编辑', 'settingslist/changvalue.do', '35', '4', '1', '1', '2016-07-21 14:16:29', null, '0');
INSERT INTO `t_function` VALUES ('50', '禁用', 'settingslist/forbidden.do', '35', '4', '2', '1', '2016-07-21 14:16:43', null, '0');
INSERT INTO `t_function` VALUES ('51', '启用', 'settingslist/startSettings.do', '35', '4', '3', '1', '2016-07-21 14:17:01', null, '0');
INSERT INTO `t_function` VALUES ('52', '新建用户', 'userlist/createuser.do', '33', '4', '6', '1', '2016-07-21 14:20:25', null, '0');
INSERT INTO `t_function` VALUES ('53', '新建配置', 'settingslist/createsettings.do', '35', '4', '4', '1', '2016-07-21 14:20:48', null, '0');
INSERT INTO `t_function` VALUES ('54', '新建角色', 'rulelist/createrule.do', '30', '4', '4', '1', '2016-07-21 14:21:07', null, '0');
INSERT INTO `t_function` VALUES ('56', '启用', 'rulelist/userule.do', '30', '4', '5', '1', '2017-03-29 10:13:17', '2017-03-29 10:40:58', '1');
INSERT INTO `t_function` VALUES ('60', '同步', 'javascript:;', '0', '1', '1', '1', '2017-03-29 10:22:48', null, '0');
INSERT INTO `t_function` VALUES ('61', '规则', 'javascript:;', '0', '1', '2', '1', '2017-03-29 10:23:06', null, '0');
INSERT INTO `t_function` VALUES ('62', '配置', 'javascript:;', '0', '1', '3', '1', '2017-03-29 10:23:22', null, '0');
INSERT INTO `t_function` VALUES ('63', '监控&分析', 'javascript:;', '0', '1', '4', '1', '2017-03-29 10:23:35', null, '0');
INSERT INTO `t_function` VALUES ('64', '同步列表', 'iSync/tosyncList.do', '60', '2', '1', '1', '2017-03-29 10:24:05', '2017-05-24 11:28:14', '1');
INSERT INTO `t_function` VALUES ('65', '同步规则列表', 'regularController/turnRegular.do', '61', '2', '1', '1', '2017-03-29 10:24:24', '2017-05-31 14:50:42', '2');
INSERT INTO `t_function` VALUES ('66', '数据表规则配置', 'regularTableController/turnRegularTable.do', '61', '2', '2', '1', '2017-03-29 10:24:45', '2017-05-21 14:22:42', '1');
INSERT INTO `t_function` VALUES ('67', '字段规则配置', 'regularColumnController/turnRegularColumn.do', '61', '2', '3', '1', '2017-03-29 10:25:13', '2017-05-19 22:32:11', '1');
INSERT INTO `t_function` VALUES ('68', '数据源配置', 'dataSourceController/turnDataSource.do', '62', '2', '1', '1', '2017-03-29 10:25:28', '2017-05-11 11:25:47', '1');
INSERT INTO `t_function` VALUES ('69', '流向配置', 'sinkController/turnSink.do', '62', '2', '4', '1', '2017-03-29 10:25:42', '2017-05-17 19:40:03', '2');
INSERT INTO `t_function` VALUES ('70', 'canal配置', 'canalController/turnCanal.do', '62', '2', '5', '1', '2017-03-29 10:25:53', '2017-05-18 15:49:36', '2');
INSERT INTO `t_function` VALUES ('72', 'kafka监控', 'http://172.16.41.152:8089', '63', '2', '2', '1', '2017-03-29 10:26:27', '2017-05-24 14:46:49', '2');
INSERT INTO `t_function` VALUES ('73', 'dubbo监控', 'http://172.16.41.152:8081', '63', '2', '3', '1', '2017-03-29 10:27:04', '2017-05-24 14:46:25', '1');
INSERT INTO `t_function` VALUES ('74', '小时数据分析', 'iSyncHour/tosyncHour.do', '63', '2', '4', '1', '2017-03-29 10:27:21', '2017-05-18 11:29:59', '2');
INSERT INTO `t_function` VALUES ('75', '告警', 'javascript:;', '0', '1', '5', '1', '2017-03-29 10:27:46', null, '0');
INSERT INTO `t_function` VALUES ('76', '告警', 'noticeController/turnnotice.do', '75', '2', '1', '1', '2017-03-29 10:27:55', '2017-04-07 10:39:14', '1');
INSERT INTO `t_function` VALUES ('77', '表配置', 'dataSourceTableController/turnDataSourceTable.do', '62', '2', '2', '1', '2017-05-17 13:34:51', null, '0');
INSERT INTO `t_function` VALUES ('78', '新建表配置', 'dataSourceTableController/turnCreateTable.do', '77', '4', '1', '1', '2017-05-17 13:37:17', null, '0');
INSERT INTO `t_function` VALUES ('79', '查看表详情', 'dataSourceTableController/turnDataSourceTableInfo.do', '77', '4', '2', '1', '2017-05-17 13:37:54', null, '0');
INSERT INTO `t_function` VALUES ('80', '修改表配置', 'dataSourceTableController/changvalue.do', '77', '4', '3', '1', '2017-05-17 13:38:33', null, '0');
INSERT INTO `t_function` VALUES ('81', '启用表配置', 'dataSourceTableController/switchon.do', '77', '4', '4', '1', '2017-05-17 13:39:00', null, '0');
INSERT INTO `t_function` VALUES ('82', '禁用表配置', 'dataSourceTableController/switchoff.do', '77', '4', '5', '1', '2017-05-17 13:39:21', null, '0');
INSERT INTO `t_function` VALUES ('83', '删除表配置', 'dataSourceTableController/deleteTableConfig.do', '77', '4', '6', '1', '2017-05-17 13:39:50', null, '0');
INSERT INTO `t_function` VALUES ('84', '新建数据源配置', 'dataSourceController/turnCreateDataSource.do', '68', '4', '1', '1', '2017-05-17 14:19:24', null, '0');
INSERT INTO `t_function` VALUES ('85', '验证数据源配置', 'dataSourceController/validate.do', '68', '4', '2', '1', '2017-05-17 14:19:55', null, '0');
INSERT INTO `t_function` VALUES ('86', '查看数据源配置', 'dataSourceController/turnDataSourceInfo.do', '68', '4', '3', '1', '2017-05-17 14:20:19', '2017-05-17 14:20:46', '1');
INSERT INTO `t_function` VALUES ('87', '修改数据源配置', 'dataSourceController/changvalue.do', '68', '4', '4', '1', '2017-05-17 14:21:08', null, '0');
INSERT INTO `t_function` VALUES ('88', '启用数据源配置', 'dataSourceController/startSettings.do', '68', '4', '5', '1', '2017-05-17 14:21:32', null, '0');
INSERT INTO `t_function` VALUES ('89', '禁用数据源配置', 'dataSourceController/forbidden.do', '68', '4', '6', '1', '2017-05-17 14:21:56', null, '0');
INSERT INTO `t_function` VALUES ('90', '字段配置', 'tableFieldController/turnTableField.do', '62', '2', '3', '1', '2017-05-17 15:10:17', null, '0');
INSERT INTO `t_function` VALUES ('91', '新建字段配置', 'tableFieldController/turnCreateField.do', '90', '4', '1', '1', '2017-05-17 15:12:10', null, '0');
INSERT INTO `t_function` VALUES ('92', '查看字段配置', 'tableFieldController/turnFieldInfo.do', '90', '4', '2', '1', '2017-05-17 15:12:42', null, '0');
INSERT INTO `t_function` VALUES ('93', '启用字段配置', 'tableFieldController/switchon.do', '90', '4', '3', '1', '2017-05-17 15:13:09', null, '0');
INSERT INTO `t_function` VALUES ('94', '禁用字段配置', 'tableFieldController/switchoff.do', '90', '4', '4', '1', '2017-05-17 15:13:35', null, '0');
INSERT INTO `t_function` VALUES ('95', '删除字段配置', 'tableFieldController/deleteFieldConfig.do', '90', '4', '5', '1', '2017-05-17 15:14:00', null, '0');
INSERT INTO `t_function` VALUES ('96', '新增流向配置', 'sinkController/turnCreateSink.do', '69', '4', '1', '1', '2017-05-17 19:41:48', null, '0');
INSERT INTO `t_function` VALUES ('97', '查看流向配置', 'sinkController/turnSinkInfo.do', '69', '4', '2', '1', '2017-05-17 19:42:19', null, '0');
INSERT INTO `t_function` VALUES ('98', '启用流向配置', 'sinkController/switchon.do', '69', '4', '3', '1', '2017-05-17 19:42:46', '2017-05-18 09:45:16', '1');
INSERT INTO `t_function` VALUES ('99', '禁用流向配置', 'sinkController/switchoff.do', '69', '4', '4', '1', '2017-05-17 19:43:10', '2017-05-18 09:45:22', '1');
INSERT INTO `t_function` VALUES ('100', '删除流向配置', 'sinkController/deleteSinkConfig.do', '69', '4', '5', '1', '2017-05-17 19:43:33', '2017-05-18 09:45:29', '1');
INSERT INTO `t_function` VALUES ('101', '修改流向配置', 'sinkController/changevalue.do', '69', '4', '7', '1', '2017-05-18 11:52:48', null, '0');
INSERT INTO `t_function` VALUES ('102', '天数据分析', 'iSyncDay/tosyncDay.do', '63', '2', '5', '1', '2017-05-18 15:39:48', null, '0');
INSERT INTO `t_function` VALUES ('103', '新建canal配置', 'canalController/turnCreateCanal.do', '70', '4', '1', '1', '2017-05-18 16:03:47', null, '0');
INSERT INTO `t_function` VALUES ('104', '查看canal配置', 'canalController/turnCanalInfo.do', '70', '4', '2', '1', '2017-05-18 16:10:02', null, '0');
INSERT INTO `t_function` VALUES ('105', '修改canal配置', 'canalController/changevalue.do', '70', '4', '3', '1', '2017-05-18 16:10:30', null, '0');
INSERT INTO `t_function` VALUES ('106', '启用canal配置', 'canalController/switchon.do', '70', '4', '4', '1', '2017-05-18 16:10:52', null, '0');
INSERT INTO `t_function` VALUES ('107', '禁用canal配置', 'canalController/switchoff.do', '70', '4', '5', '1', '2017-05-18 16:11:19', null, '0');
INSERT INTO `t_function` VALUES ('108', '删除canal配置', 'canalController/deleteCanalConfig.do', '70', '4', '6', '1', '2017-05-18 16:12:10', null, '0');
INSERT INTO `t_function` VALUES ('126', '新建规则列表配置', 'regularController/turnCreateRegular.do', '65', '4', '1', '1', '2017-05-24 13:22:55', '2017-05-24 13:31:12', '1');
INSERT INTO `t_function` VALUES ('127', '查看规则列表配置	', 'regularController/turnRegularInfo.do', '65', '4', '2', '1', '2017-05-24 13:23:22', '2017-05-24 13:31:23', '1');
INSERT INTO `t_function` VALUES ('128', '启用规则列表配置', 'regularController/switchon.do', '65', '4', '3', '1', '2017-05-24 13:23:53', null, '0');
INSERT INTO `t_function` VALUES ('129', '禁用规则列表配置', 'regularController/switchoff.do', '65', '4', '4', '1', '2017-05-24 13:24:16', null, '0');
INSERT INTO `t_function` VALUES ('130', '删除规则列表配置', 'regularController/deleteRegularConfig.do', '65', '4', '5', '1', '2017-05-24 13:24:45', null, '0');
INSERT INTO `t_function` VALUES ('131', '新建规则列表配置', 'regularTableController/turnCreateRegularTable.do', '66', '4', '1', '1', '2017-05-24 13:25:21', '2017-05-24 13:35:26', '1');
INSERT INTO `t_function` VALUES ('132', '查看规则列表配置', 'regularTableController/turnRegularTableInfo.do', '66', '4', '2', '1', '2017-05-24 13:25:44', '2017-05-24 13:35:52', '1');
INSERT INTO `t_function` VALUES ('133', '启用规则列表配置', 'regularTableController/switchon.do', '66', '4', '3', '1', '2017-05-24 13:26:04', '2017-05-24 13:36:05', '1');
INSERT INTO `t_function` VALUES ('134', '禁用规则列表配置', 'regularTableController/switchoff.do', '66', '4', '4', '1', '2017-05-24 13:26:30', '2017-05-24 13:36:20', '1');
INSERT INTO `t_function` VALUES ('135', '删除规则列表配置	', 'regularTableController/deleteRegularTableConfig.do', '66', '4', '5', '1', '2017-05-24 13:27:28', '2017-05-24 13:36:35', '1');
INSERT INTO `t_function` VALUES ('136', '查看字段配置', 'regularColumnController/turnRegularColumnInfo.do', '67', '4', '1', '1', '2017-05-24 13:28:10', null, '0');
INSERT INTO `t_function` VALUES ('137', '修改字段配置', 'regularColumnController/changvalue.do', '67', '4', '2', '1', '2017-05-24 13:28:36', null, '0');
INSERT INTO `t_function` VALUES ('138', '启用字段配置	', 'regularColumnController/switchon.do', '67', '4', '3', '1', '2017-05-24 13:29:16', null, '0');
INSERT INTO `t_function` VALUES ('139', '禁止字段配置', 'regularColumnController/switchoff.do', '67', '4', '4', '1', '2017-05-24 13:29:39', null, '0');
INSERT INTO `t_function` VALUES ('140', '删除字段配置', 'regularColumnController/deleteRegularColumnConfig.do', '67', '4', '5', '1', '2017-05-24 13:30:32', null, '0');
INSERT INTO `t_function` VALUES ('141', '新建字段配置', 'regularColumnController/turnCreateRegularColumn.do', '67', '4', '6', '1', '2017-05-24 13:30:57', '2017-05-24 13:39:51', '1');
INSERT INTO `t_function` VALUES ('142', '查看', 'noticeController/turnNoticesInfo.do', '76', '4', '1', '1', '2017-05-24 14:22:41', null, '0');
INSERT INTO `t_function` VALUES ('143', '设为已读', 'noticelist/setread.do', '76', '4', '2', '1', '2017-05-24 14:23:03', null, '0');
INSERT INTO `t_function` VALUES ('144', '配置', 'iSync/toSyncConfigInfo.do', '64', '4', '1', '1', '2017-05-25 12:53:10', null, '0');
INSERT INTO `t_function` VALUES ('145', '详情', 'iSync/toSyncinfo.do', '64', '4', '2', '1', '2017-05-25 12:53:26', null, '0');
INSERT INTO `t_function` VALUES ('146', '修改', 'iSync/toEditSync.do', '64', '4', '3', '1', '2017-05-25 12:53:43', null, '0');
INSERT INTO `t_function` VALUES ('147', '启用', 'iSync/startSettings.do', '64', '4', '4', '1', '2017-05-25 12:54:01', null, '0');
INSERT INTO `t_function` VALUES ('148', '禁用', 'iSync/forbidden.do', '64', '4', '5', '1', '2017-05-25 12:54:15', null, '0');
INSERT INTO `t_function` VALUES ('149', '删除', 'iSync/deleteSync.do', '64', '4', '6', '1', '2017-05-25 12:54:30', null, '0');
INSERT INTO `t_function` VALUES ('150', '删除数据源', 'dataSourceController/delds.do', '68', '4', '7', '1', '2017-05-31 15:32:38', null, '0');
INSERT INTO `t_function` VALUES ('151', '丢失数据', 'lostDataController/turnlostdata.do', '75', '2', '2', '1', '2017-06-01 16:23:47', null, '0');
INSERT INTO `t_function` VALUES ('152', '查看详情', 'lostDataController/turnLostDataInfo.do', '151', '4', '1', '1', '2017-06-01 16:24:16', null, '0');
INSERT INTO `t_function` VALUES ('153', '设为已处理', 'lostDataController/setStatus.do', '151', '4', '2', '1', '2017-06-01 16:24:33', null, '0');
INSERT INTO `t_function` VALUES ('154', '删除', 'lostDataController/delLostData.do', '151', '4', '3', '1', '2017-06-01 17:13:11', null, '0');

-- ----------------------------
-- Table structure for t_notifications
-- ----------------------------
DROP TABLE IF EXISTS `t_notifications`;
CREATE TABLE `t_notifications` (
  `nid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sync_code` varchar(255) DEFAULT NULL COMMENT '同步码',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `context` text COMMENT '正文',
  `is_read` int(11) DEFAULT NULL COMMENT '是否已读0否1是',
  `is_email` int(255) DEFAULT NULL COMMENT '是否已发邮件',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `read_time` datetime DEFAULT NULL COMMENT '已读时间',
  `version` int(255) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息提醒表';

-- ----------------------------
-- Records of t_notifications
-- ----------------------------

-- ----------------------------
-- Table structure for t_reg_column
-- ----------------------------
DROP TABLE IF EXISTS `t_reg_column`;
CREATE TABLE `t_reg_column` (
  `reg_col_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字段规则id',
  `col_id` int(11) DEFAULT NULL COMMENT '字段id',
  `col_reg_name` varchar(255) DEFAULT NULL COMMENT '字段规则名称',
  `col_reg` varchar(255) DEFAULT NULL COMMENT '字段规则，json，如：[{"symbol":">","value":"100"},{"symbol":"!=","value":"101"}]',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_on` int(255) DEFAULT '1',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`reg_col_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='字段规则表';

-- ----------------------------
-- Records of t_reg_column
-- ----------------------------

-- ----------------------------
-- Table structure for t_reg_table
-- ----------------------------
DROP TABLE IF EXISTS `t_reg_table`;
CREATE TABLE `t_reg_table` (
  `reg_tab_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表规则id',
  `tab_id` int(11) DEFAULT NULL COMMENT '表id',
  `reg_tab_name` varchar(255) DEFAULT NULL COMMENT '表规则名称',
  `reg_col_ids` varchar(255) DEFAULT NULL COMMENT '字段规则ids，如：1,2,3,4',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_on` int(255) DEFAULT '1',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`reg_tab_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='表规则表';

-- ----------------------------
-- Records of t_reg_table
-- ----------------------------

-- ----------------------------
-- Table structure for t_regular
-- ----------------------------
DROP TABLE IF EXISTS `t_regular`;
CREATE TABLE `t_regular` (
  `reg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '规则id',
  `reg_name` varchar(255) DEFAULT NULL COMMENT '规则名称',
  `ds_id` int(11) DEFAULT NULL COMMENT '数据源id',
  `tab_id` int(11) DEFAULT NULL COMMENT '表id',
  `sync_col` text COMMENT '同步字段，json，如:[{"src":"id","target":"id"},{"src":"name","target":"name"}]',
  `reg` varchar(255) DEFAULT NULL COMMENT '同步规则，json，如：[{"reg_tab_id":1,"sink_id":1},{"reg_tab_id":2,"sink_id":2}]',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_on` int(255) DEFAULT '1' COMMENT '是否启用',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`reg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='规则表';

-- ----------------------------
-- Records of t_regular
-- ----------------------------

-- ----------------------------
-- Table structure for t_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_rule`;
CREATE TABLE `t_rule` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rname` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `is_on` int(11) DEFAULT NULL COMMENT '是否冻结0否1是',
  `is_recive_notice` int(255) DEFAULT NULL COMMENT '是否接收消息0否1是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_rule
-- ----------------------------
INSERT INTO `t_rule` VALUES ('2', '开发', '1', '1', '2016-07-08 11:27:09', '2017-03-29 10:11:07', '5');
INSERT INTO `t_rule` VALUES ('3', '测试', '1', '1', '2017-05-31 15:41:06', null, '0');

-- ----------------------------
-- Table structure for t_sink
-- ----------------------------
DROP TABLE IF EXISTS `t_sink`;
CREATE TABLE `t_sink` (
  `sink_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流向id',
  `sink_name` varchar(255) DEFAULT NULL COMMENT '流向名称',
  `sink_type` int(255) DEFAULT NULL COMMENT '流向类型0：db，1：kafka',
  `ds_id` int(11) DEFAULT NULL COMMENT '数据源id',
  `tab_id` int(11) DEFAULT NULL COMMENT '流向表id',
  `sink_ip` varchar(255) DEFAULT NULL COMMENT 'ip',
  `sink_port` varchar(255) DEFAULT NULL COMMENT '端口',
  `sink_topic` varchar(255) DEFAULT NULL COMMENT '主题',
  `sink_uname` varchar(255) DEFAULT NULL COMMENT '用户名',
  `sink_pwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_on` int(255) DEFAULT '1' COMMENT '是否启用',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`sink_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='流向表';

-- ----------------------------
-- Records of t_sink
-- ----------------------------

-- ----------------------------
-- Table structure for t_sync
-- ----------------------------
DROP TABLE IF EXISTS `t_sync`;
CREATE TABLE `t_sync` (
  `sync_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '同步id',
  `sync_code` varchar(255) DEFAULT NULL COMMENT '同步码',
  `sync_note` varchar(255) DEFAULT NULL COMMENT '同步备注',
  `canal_id` int(11) DEFAULT NULL COMMENT 'canalid',
  `reg_id` int(11) DEFAULT NULL COMMENT '规则id',
  `recive_email` varchar(255) DEFAULT NULL COMMENT '告警邮件收件人，多个以分号分割',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_on` int(255) DEFAULT '1' COMMENT '是否启用',
  `version` int(255) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`sync_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='同步表';

-- ----------------------------
-- Records of t_sync
-- ----------------------------

-- ----------------------------
-- Table structure for t_sync_lost_data
-- ----------------------------
DROP TABLE IF EXISTS `t_sync_lost_data`;
CREATE TABLE `t_sync_lost_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sync_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '同步码',
  `lost_type` int(11) DEFAULT NULL COMMENT '丢失类型，0，异常；1，未匹配规则',
  `sink_id` int(11) DEFAULT NULL COMMENT '流向id',
  `event_type` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '同步类型',
  `row_data` text CHARACTER SET utf8 COMMENT '数据',
  `ex` text CHARACTER SET utf8 COMMENT '异常信息',
  `data_status` int(11) DEFAULT NULL COMMENT '数据状态，0，未处理；1，已处理',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='数据丢失表';

-- ----------------------------
-- Records of t_sync_lost_data
-- ----------------------------

-- ----------------------------
-- Table structure for t_table
-- ----------------------------
DROP TABLE IF EXISTS `t_table`;
CREATE TABLE `t_table` (
  `tab_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ds_id` int(11) DEFAULT NULL COMMENT '数据源id',
  `tab_name` varchar(255) DEFAULT NULL COMMENT '表名称',
  `tab_note` varchar(255) DEFAULT NULL COMMENT '表备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_on` int(11) DEFAULT '1' COMMENT '是否启用',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`tab_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='表';

-- ----------------------------
-- Records of t_table
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `passwordcode` varchar(255) NOT NULL COMMENT '密码',
  `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `tel` varchar(255) DEFAULT NULL COMMENT '手机号',
  `is_on` int(11) DEFAULT NULL COMMENT '是否启用，0否1是',
  `error_pw_count` int(11) DEFAULT NULL COMMENT '密码错误重试次数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表\r\n';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'c4ca4238a0b923820dcc509a6f75849b', '尚成才', 'shangchengcai@voole.com', '18701691135', '1', '12', '2016-07-07 16:50:40', '2017-06-01 16:24:10', '2017-06-01 16:25:07', '375');
INSERT INTO `t_user` VALUES ('2', 'tester', 'c4ca4238a0b923820dcc509a6f75849b', '张俊龙', 'zhangjunlong@voole.com', '110110110', '1', '12', '2017-05-31 15:33:31', '2017-05-31 16:05:38', '2017-05-31 16:06:34', '10');
