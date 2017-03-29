/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : data_sync

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-03-29 10:47:01
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- ----------------------------
-- Records of l_sysytem_log
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
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8 COMMENT='角色链接关系表';

-- ----------------------------
-- Records of r_rule_function
-- ----------------------------
INSERT INTO `r_rule_function` VALUES ('78', '2', '38', '1', '2016-07-15 14:48:39', null, '0');
INSERT INTO `r_rule_function` VALUES ('109', '2', '39', '1', '2016-07-21 09:45:37', null, '0');
INSERT INTO `r_rule_function` VALUES ('111', '2', '40', '1', '2016-07-21 13:58:55', null, '0');
INSERT INTO `r_rule_function` VALUES ('113', '2', '41', '1', '2016-07-21 13:59:22', null, '0');
INSERT INTO `r_rule_function` VALUES ('115', '2', '42', '1', '2016-07-21 13:59:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('117', '2', '43', '1', '2016-07-21 14:00:57', null, '0');
INSERT INTO `r_rule_function` VALUES ('119', '2', '44', '1', '2016-07-21 14:01:37', null, '0');
INSERT INTO `r_rule_function` VALUES ('121', '2', '45', '1', '2016-07-21 14:14:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('123', '2', '46', '1', '2016-07-21 14:15:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('125', '2', '47', '1', '2016-07-21 14:15:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('127', '2', '48', '1', '2016-07-21 14:16:04', null, '0');
INSERT INTO `r_rule_function` VALUES ('129', '2', '49', '1', '2016-07-21 14:16:29', null, '0');
INSERT INTO `r_rule_function` VALUES ('131', '2', '50', '1', '2016-07-21 14:16:43', null, '0');
INSERT INTO `r_rule_function` VALUES ('133', '2', '51', '1', '2016-07-21 14:17:01', null, '0');
INSERT INTO `r_rule_function` VALUES ('135', '2', '52', '1', '2016-07-21 14:20:25', null, '0');
INSERT INTO `r_rule_function` VALUES ('137', '2', '53', '1', '2016-07-21 14:20:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('139', '2', '54', '1', '2016-07-21 14:21:07', null, '0');
INSERT INTO `r_rule_function` VALUES ('141', '2', '55', '1', '2017-03-29 09:50:22', null, '0');
INSERT INTO `r_rule_function` VALUES ('142', '2', '29', '1', '2017-03-29 10:10:35', null, '0');
INSERT INTO `r_rule_function` VALUES ('143', '2', '30', '1', '2017-03-29 10:10:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('144', '2', '31', '1', '2017-03-29 10:10:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('145', '2', '32', '1', '2017-03-29 10:10:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('146', '2', '33', '1', '2017-03-29 10:10:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('147', '2', '34', '1', '2017-03-29 10:10:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('148', '2', '35', '1', '2017-03-29 10:10:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('149', '2', '36', '1', '2017-03-29 10:10:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('150', '2', '37', '1', '2017-03-29 10:10:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('151', '2', '56', '1', '2017-03-29 10:13:17', null, '0');
INSERT INTO `r_rule_function` VALUES ('155', '2', '60', '1', '2017-03-29 10:22:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('156', '2', '61', '1', '2017-03-29 10:23:06', null, '0');
INSERT INTO `r_rule_function` VALUES ('157', '2', '62', '1', '2017-03-29 10:23:22', null, '0');
INSERT INTO `r_rule_function` VALUES ('158', '2', '63', '1', '2017-03-29 10:23:35', null, '0');
INSERT INTO `r_rule_function` VALUES ('159', '2', '64', '1', '2017-03-29 10:24:05', null, '0');
INSERT INTO `r_rule_function` VALUES ('160', '2', '65', '1', '2017-03-29 10:24:24', null, '0');
INSERT INTO `r_rule_function` VALUES ('161', '2', '66', '1', '2017-03-29 10:24:45', null, '0');
INSERT INTO `r_rule_function` VALUES ('162', '2', '67', '1', '2017-03-29 10:25:13', null, '0');
INSERT INTO `r_rule_function` VALUES ('163', '2', '68', '1', '2017-03-29 10:25:28', null, '0');
INSERT INTO `r_rule_function` VALUES ('164', '2', '69', '1', '2017-03-29 10:25:42', null, '0');
INSERT INTO `r_rule_function` VALUES ('165', '2', '70', '1', '2017-03-29 10:25:53', null, '0');
INSERT INTO `r_rule_function` VALUES ('166', '2', '71', '1', '2017-03-29 10:26:12', null, '0');
INSERT INTO `r_rule_function` VALUES ('167', '2', '72', '1', '2017-03-29 10:26:27', null, '0');
INSERT INTO `r_rule_function` VALUES ('168', '2', '73', '1', '2017-03-29 10:27:04', null, '0');
INSERT INTO `r_rule_function` VALUES ('169', '2', '74', '1', '2017-03-29 10:27:21', null, '0');
INSERT INTO `r_rule_function` VALUES ('170', '2', '75', '1', '2017-03-29 10:27:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('171', '2', '76', '1', '2017-03-29 10:27:55', null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of r_user_rule
-- ----------------------------
INSERT INTO `r_user_rule` VALUES ('7', '1', '1', '1', '2016-07-18 12:10:47', null, '0');
INSERT INTO `r_user_rule` VALUES ('8', '1', '2', '1', '2016-07-18 12:10:47', null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统配置表';

-- ----------------------------
-- Records of s_system_settings
-- ----------------------------
INSERT INTO `s_system_settings` VALUES ('1', 'error_pw_count', '12', '登录重试次数', '1', '2016-07-14 16:32:04', '2016-07-18 17:45:20', '5');
INSERT INTO `s_system_settings` VALUES ('6', 'tablesize', '10', '表格每页默认数据', '1', '2016-07-20 17:00:06', null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='连接表';

-- ----------------------------
-- Records of t_function
-- ----------------------------
INSERT INTO `t_function` VALUES ('29', '系统设置', 'javascript:;', '0', '1', '9', '1', '2016-07-13 09:59:08', '2016-07-13 09:59:11', '0');
INSERT INTO `t_function` VALUES ('30', '角色管理', 'ruleController/turnrule.do', '29', '2', '1', '1', '2016-07-13 10:00:18', '2016-07-13 10:00:21', '0');
INSERT INTO `t_function` VALUES ('31', '链接管理', 'functionController/turnFunction.do', '29', '2', '2', '1', '2016-07-13 11:55:45', '2016-07-13 11:55:47', '0');
INSERT INTO `t_function` VALUES ('33', '用户管理', 'userController/turnuser.do', '29', '2', '4', '1', '2016-07-14 09:31:34', '2016-07-14 15:54:02', '1');
INSERT INTO `t_function` VALUES ('35', '系统参数', 'settingsController/turnSettings.do', '29', '2', '5', '1', '2016-07-14 16:14:21', null, '0');
INSERT INTO `t_function` VALUES ('37', '系统消息', 'noticeController/turnnotice.do', '29', '2', '5', '1', '2016-07-15 10:06:02', null, '0');
INSERT INTO `t_function` VALUES ('39', '日志查询', 'systemLogsController/turnSystemLogs.do', '29', '2', '6', '0', '2016-07-21 09:45:37', '2017-03-29 10:13:34', '1');
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
INSERT INTO `t_function` VALUES ('64', '同步列表', 'javascript:;', '60', '2', '1', '1', '2017-03-29 10:24:05', null, '0');
INSERT INTO `t_function` VALUES ('65', '规则列表', 'javascript:;', '61', '2', '1', '1', '2017-03-29 10:24:24', null, '0');
INSERT INTO `t_function` VALUES ('66', '数据表规则配置', 'javascript:;', '61', '2', '2', '1', '2017-03-29 10:24:45', null, '0');
INSERT INTO `t_function` VALUES ('67', '字段规则配置', 'javascript:;', '61', '2', '3', '1', '2017-03-29 10:25:13', null, '0');
INSERT INTO `t_function` VALUES ('68', '数据源配置', 'javascript:;', '62', '2', '1', '1', '2017-03-29 10:25:28', null, '0');
INSERT INTO `t_function` VALUES ('69', '流向配置', 'javascript:;', '62', '2', '2', '1', '2017-03-29 10:25:42', null, '0');
INSERT INTO `t_function` VALUES ('70', '同步配置', 'javascript:;', '62', '2', '3', '1', '2017-03-29 10:25:53', null, '0');
INSERT INTO `t_function` VALUES ('71', '日同步数据分析', 'javascript:;', '63', '2', '1', '1', '2017-03-29 10:26:12', null, '0');
INSERT INTO `t_function` VALUES ('72', 'kafka监控', 'javascript:;', '63', '2', '2', '1', '2017-03-29 10:26:27', null, '0');
INSERT INTO `t_function` VALUES ('73', 'dubbo监控', 'http://www.jd.com', '63', '2', '3', '1', '2017-03-29 10:27:04', null, '0');
INSERT INTO `t_function` VALUES ('74', '小时数据分析', 'javascript:;', '63', '2', '4', '1', '2017-03-29 10:27:21', null, '0');
INSERT INTO `t_function` VALUES ('75', '告警', 'javascript:;', '0', '1', '5', '1', '2017-03-29 10:27:46', null, '0');
INSERT INTO `t_function` VALUES ('76', '告警', 'javascript:;', '75', '2', '1', '1', '2017-03-29 10:27:55', null, '0');

-- ----------------------------
-- Table structure for t_notifications
-- ----------------------------
DROP TABLE IF EXISTS `t_notifications`;
CREATE TABLE `t_notifications` (
  `nid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `context` varchar(255) DEFAULT NULL COMMENT '正文',
  `is_read` int(11) DEFAULT NULL COMMENT '是否已读0否1是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `read_time` datetime DEFAULT NULL COMMENT '已读时间',
  `version` int(255) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='消息提醒表';

-- ----------------------------
-- Records of t_notifications
-- ----------------------------
INSERT INTO `t_notifications` VALUES ('1', '消息1', '如果参数 start 与 stop 相等，那么该方法返回的就是一个空串（即长度为 0 的字符串）。如果 start 比 stop 大，那么该方法在提取子串之前会先交换这两个参数。', '0', '2016-07-08 16:50:52', '2016-07-15 14:49:49', '2');
INSERT INTO `t_notifications` VALUES ('2', '警告2', '如果参数 start 与 stop 相等，那么该方法返回的就是一个空串（即长度为 0 的字符串）。如果 start 比 stop 大，那么该方法在提取子串之前会先交换这两个参数。', '1', '2016-07-08 16:51:22', '2016-07-20 15:03:30', '3');
INSERT INTO `t_notifications` VALUES ('3', '消息3', '如果参数 start 与 stop 相等，那么该方法返回的就是一个空串（即长度为 0 的字符串）。如果 start 比 stop 大，那么该方法在提取子串之前会先交换这两个参数。', '1', '2016-07-12 14:20:01', '2016-07-20 11:06:30', '3');
INSERT INTO `t_notifications` VALUES ('4', '消息4', '消息4如果参数 start 与 stop 相等，那么该方法返回的就是一个空串（即长度为 0 的字符串）。如果 start 比 stop 大，那么该方法在提取子串之前会先交换这两个参数。', '1', '2016-07-12 14:20:04', '2016-07-20 11:06:28', '3');
INSERT INTO `t_notifications` VALUES ('5', '消息5', '消息5如果参数 start 与 stop 相等，那么该方法返回的就是一个空串（即长度为 0 的字符串）。如果 start 比 stop 大，那么该方法在提取子串之前会先交换这两个参数。', '1', '2016-07-12 14:20:06', '2016-07-20 11:06:27', '3');
INSERT INTO `t_notifications` VALUES ('6', '消息6', '消息6如果参数 start 与 stop 相等，那么该方法返回的就是一个空串（即长度为 0 的字符串）。如果 start 比 stop 大，那么该方法在提取子串之前会先交换这两个参数。', '1', '2016-07-12 14:20:09', '2016-07-20 11:06:25', '3');
INSERT INTO `t_notifications` VALUES ('7', '消息7', '消息7如果参数 start 与 stop 相等，那么该方法返回的就是一个空串（即长度为 0 的字符串）。如果 start 比 stop 大，那么该方法在提取子串之前会先交换这两个参数。', '1', '2016-07-12 14:20:11', '2016-07-20 11:06:23', '3');
INSERT INTO `t_notifications` VALUES ('8', '消息8', '消息8如果参数 start 与 stop 相等，那么该方法返回的就是一个空串（即长度为 0 的字符串）。如果 start 比 stop 大，那么该方法在提取子串之前会先交换这两个参数。', '1', '2016-07-12 14:20:14', '2016-07-20 11:06:21', '3');
INSERT INTO `t_notifications` VALUES ('9', '消息9', '消息9如果参数 start 与 stop 相等，那么该方法返回的就是一个空串（即长度为 0 的字符串）。如果 start 比 stop 大，那么该方法在提取子串之前会先交换这两个参数。', '1', '2016-07-12 14:20:16', '2016-07-12 15:41:39', '1');
INSERT INTO `t_notifications` VALUES ('10', '消息10', '消息10如果参数 start 与 stop 相等，那么该方法返回的就是一个空串（即长度为 0 的字符串）。如果 start 比 stop 大，那么该方法在提取子串之前会先交换这两个参数。', '1', '2016-07-12 14:20:18', '2016-07-20 10:16:56', '2');
INSERT INTO `t_notifications` VALUES ('11', '消息11', '阿萨大苏打', '1', '2016-07-12 14:39:02', '2016-07-12 15:40:26', '1');
INSERT INTO `t_notifications` VALUES ('12', '消息12', '阿萨大苏打撒', '1', '2016-07-12 14:40:05', '2016-07-12 15:39:19', '1');
INSERT INTO `t_notifications` VALUES ('13', '消息13', '阿萨大苏打', '1', '2016-07-12 14:41:54', '2016-07-12 15:31:52', '1');
INSERT INTO `t_notifications` VALUES ('14', '消息14', '撒打算打算', '1', '2016-07-12 14:46:43', '2016-07-12 15:39:06', '1');
INSERT INTO `t_notifications` VALUES ('15', '消息15', '撒撒旦撒', '1', '2016-07-12 14:51:54', '2016-07-12 15:31:13', '1');
INSERT INTO `t_notifications` VALUES ('16', '消息16', '撒撒旦撒', '1', '2016-07-12 14:54:13', '2016-07-12 15:37:02', '1');
INSERT INTO `t_notifications` VALUES ('17', '消息17', 'asdas', '1', '2016-07-12 14:55:28', '2016-07-12 15:31:03', '1');
INSERT INTO `t_notifications` VALUES ('18', '消息18', 'asdas', '1', '2016-07-12 14:57:48', '2016-07-12 15:28:49', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_rule
-- ----------------------------
INSERT INTO `t_rule` VALUES ('2', '开发', '1', '1', '2016-07-08 11:27:09', '2017-03-29 10:11:07', '5');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表\r\n';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', 'c4ca4238a0b923820dcc509a6f75849b', '尚成才', 'shangchengcai@voole.com', '18701691135', '1', '12', '2016-07-07 16:50:40', '2017-03-29 10:43:04', '2017-03-29 10:43:04', '138');
INSERT INTO `t_user` VALUES ('2', '2', '202cb962ac59075b964b07152d234b70', '尚成才', '644624156@qq.com', '2', '1', null, '2016-07-18 15:10:22', '2016-07-18 23:19:23', null, '1');
INSERT INTO `t_user` VALUES ('3', 'as', 'e10adc3949ba59abbe56e057f20f883e', 'sds', 'sad', 'sadas', '1', null, '2016-07-20 13:49:07', null, null, '0');
