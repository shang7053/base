/*
Navicat MySQL Data Transfer

Source Server         : ysjcenter
Source Server Version : 50711
Source Host           : 172.16.40.25:3306
Source Database       : vdc_center

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-07-21 14:25:34
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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- ----------------------------
-- Records of l_sysytem_log
-- ----------------------------
INSERT INTO `l_sysytem_log` VALUES ('28', '1', '/ruleController/addRuleAndFunction.do', '{\"is_recive_notice\":[\"1\"],\"rname\":[\"dsfdsfsd\"],\"is_on\":[\"1\"],\"fids\":[\"\"]}', '2016-07-21 09:30:51');
INSERT INTO `l_sysytem_log` VALUES ('29', '1', '/functionController/deleteFunction.do', '{\"fid\":[\"38\"],\"version\":[\"1\"]}', '2016-07-21 09:45:03');
INSERT INTO `l_sysytem_log` VALUES ('30', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"日志查询\"],\"menu_type\":[\"2\"],\"pfid\":[\"29\"],\"is_on\":[\"1\"],\"furl\":[\"systemLogsController/turnSystemLogs.do\"],\"sort\":[\"6\"],\"version\":[\"\"],\"menu_type_name\":[\"一级菜单\"],\"pfname\":[\"系统设置\"]}', '2016-07-21 09:45:37');
INSERT INTO `l_sysytem_log` VALUES ('31', '1', '/loginController/loginout.do', '{}', '2016-07-21 09:45:42');
INSERT INTO `l_sysytem_log` VALUES ('32', '1', '/extra_lock.do', '{}', '2016-07-21 10:05:46');
INSERT INTO `l_sysytem_log` VALUES ('33', '1', '/extra_lock.do', '{}', '2016-07-21 10:28:03');
INSERT INTO `l_sysytem_log` VALUES ('34', '1', '/loginController/unlock.do', '{\"passwordcode\":[\"1\"]}', '2016-07-21 10:34:28');
INSERT INTO `l_sysytem_log` VALUES ('35', '1', '/tologin.do', '{}', '2016-07-21 12:43:25');
INSERT INTO `l_sysytem_log` VALUES ('36', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"查看\"],\"menu_type\":[\"4\"],\"pfid\":[\"33\"],\"is_on\":[\"1\"],\"furl\":[\"userlist/turnmodalgetinfo.do\"],\"sort\":[\"1\"],\"version\":[\"\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 13:58:55');
INSERT INTO `l_sysytem_log` VALUES ('37', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"赋予\"],\"menu_type\":[\"4\"],\"pfid\":[\"33\"],\"is_on\":[\"1\"],\"furl\":[\"userlist/turnmodal.do\"],\"sort\":[\"2\"],\"version\":[\"\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 13:59:22');
INSERT INTO `l_sysytem_log` VALUES ('38', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"禁用\"],\"menu_type\":[\"3\"],\"pfid\":[\"33\"],\"is_on\":[\"1\"],\"furl\":[\"userlist/freezeuser.do\"],\"sort\":[\"3\"],\"version\":[\"\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 13:59:46');
INSERT INTO `l_sysytem_log` VALUES ('39', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"启用\"],\"menu_type\":[\"3\"],\"pfid\":[\"33\"],\"is_on\":[\"1\"],\"furl\":[\"userlist/startuser.do\"],\"sort\":[\"4\"],\"version\":[\"\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 14:00:57');
INSERT INTO `l_sysytem_log` VALUES ('40', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"重置密码\"],\"menu_type\":[\"4\"],\"pfid\":[\"33\"],\"is_on\":[\"1\"],\"furl\":[\"userlist/restpassword.do\"],\"sort\":[\"5\"],\"version\":[\"\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 14:01:37');
INSERT INTO `l_sysytem_log` VALUES ('41', '1', '/functionController/updateFunction.do', '{\"fid\":[\"43\"],\"fname\":[\"启用\"],\"pfid\":[\"33\"],\"menu_type\":[\"4\"],\"furl\":[\"userlist/startuser.do\"],\"is_on\":[\"1\"],\"sort\":[\"4\"],\"version\":[\"0\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 14:02:29');
INSERT INTO `l_sysytem_log` VALUES ('42', '1', '/functionController/updateFunction.do', '{\"fid\":[\"43\"],\"fname\":[\"启用\"],\"pfid\":[\"33\"],\"menu_type\":[\"4\"],\"furl\":[\"userlist/startuser.do\"],\"is_on\":[\"1\"],\"sort\":[\"4\"],\"version\":[\"0\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 14:02:29');
INSERT INTO `l_sysytem_log` VALUES ('43', '1', '/functionController/updateFunction.do', '{\"fid\":[\"42\"],\"fname\":[\"禁用\"],\"pfid\":[\"33\"],\"menu_type\":[\"4\"],\"furl\":[\"userlist/freezeuser.do\"],\"is_on\":[\"1\"],\"sort\":[\"3\"],\"version\":[\"0\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 14:02:44');
INSERT INTO `l_sysytem_log` VALUES ('44', '1', '/functionController/updateFunction.do', '{\"fid\":[\"43\"],\"fname\":[\"启用\"],\"pfid\":[\"33\"],\"menu_type\":[\"4\"],\"furl\":[\"userlist/startuser.do\"],\"is_on\":[\"0\"],\"sort\":[\"4\"],\"version\":[\"1\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 14:08:19');
INSERT INTO `l_sysytem_log` VALUES ('45', '1', '/functionController/updateFunction.do', '{\"fid\":[\"43\"],\"fname\":[\"启用\"],\"pfid\":[\"33\"],\"menu_type\":[\"4\"],\"furl\":[\"userlist/startuser.do\"],\"is_on\":[\"1\"],\"sort\":[\"4\"],\"version\":[\"2\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 14:09:44');
INSERT INTO `l_sysytem_log` VALUES ('46', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"设为已读\"],\"menu_type\":[\"4\"],\"pfid\":[\"37\"],\"is_on\":[\"1\"],\"furl\":[\"noticelist/setread.do\"],\"sort\":[\"1\"],\"version\":[\"\"],\"pfname\":[\"系统消息\"]}', '2016-07-21 14:14:48');
INSERT INTO `l_sysytem_log` VALUES ('47', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"查看\"],\"menu_type\":[\"4\"],\"pfid\":[\"30\"],\"is_on\":[\"1\"],\"furl\":[\"rulelist/turnmodalgetinfo.do\"],\"sort\":[\"1\"],\"version\":[\"\"],\"pfname\":[\"角色管理\"]}', '2016-07-21 14:15:19');
INSERT INTO `l_sysytem_log` VALUES ('48', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"赋予\"],\"menu_type\":[\"4\"],\"pfid\":[\"30\"],\"is_on\":[\"1\"],\"furl\":[\"rulelist/turnmodal.do\"],\"sort\":[\"2\"],\"version\":[\"\"],\"pfname\":[\"角色管理\"]}', '2016-07-21 14:15:46');
INSERT INTO `l_sysytem_log` VALUES ('49', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"禁用\"],\"menu_type\":[\"4\"],\"pfid\":[\"30\"],\"is_on\":[\"1\"],\"furl\":[\"rulelist/freezerule.do\"],\"sort\":[\"3\"],\"version\":[\"\"],\"pfname\":[\"角色管理\"]}', '2016-07-21 14:16:04');
INSERT INTO `l_sysytem_log` VALUES ('50', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"编辑\"],\"menu_type\":[\"4\"],\"pfid\":[\"35\"],\"is_on\":[\"1\"],\"furl\":[\"settingslist/changvalue.do\"],\"sort\":[\"1\"],\"version\":[\"\"],\"pfname\":[\"系统参数\"]}', '2016-07-21 14:16:29');
INSERT INTO `l_sysytem_log` VALUES ('51', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"禁用\"],\"menu_type\":[\"4\"],\"pfid\":[\"35\"],\"is_on\":[\"1\"],\"furl\":[\"settingslist/forbidden.do\"],\"sort\":[\"2\"],\"version\":[\"\"],\"pfname\":[\"系统参数\"]}', '2016-07-21 14:16:43');
INSERT INTO `l_sysytem_log` VALUES ('52', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"启用\"],\"menu_type\":[\"4\"],\"pfid\":[\"35\"],\"is_on\":[\"1\"],\"furl\":[\"settingslist/startSettings.do\"],\"sort\":[\"3\"],\"version\":[\"\"],\"pfname\":[\"系统参数\"]}', '2016-07-21 14:17:01');
INSERT INTO `l_sysytem_log` VALUES ('53', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"新建用户\"],\"pfid\":[\"33\"],\"menu_type\":[\"4\"],\"furl\":[\"userlist/createuser.do\"],\"is_on\":[\"1\"],\"sort\":[\"6\"],\"version\":[\"\"],\"pfname\":[\"用户管理\"]}', '2016-07-21 14:20:25');
INSERT INTO `l_sysytem_log` VALUES ('54', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"新建配置\"],\"pfid\":[\"35\"],\"menu_type\":[\"4\"],\"furl\":[\"settingslist/createsettings.do\"],\"is_on\":[\"1\"],\"sort\":[\"4\"],\"version\":[\"\"],\"pfname\":[\"系统参数\"]}', '2016-07-21 14:20:48');
INSERT INTO `l_sysytem_log` VALUES ('55', '1', '/functionController/insertFunction.do', '{\"fid\":[\"\"],\"fname\":[\"新建角色\"],\"pfid\":[\"30\"],\"menu_type\":[\"4\"],\"furl\":[\"rulelist/createrule.do\"],\"is_on\":[\"1\"],\"sort\":[\"4\"],\"version\":[\"\"],\"pfname\":[\"角色管理\"]}', '2016-07-21 14:21:07');

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
  KEY `fk_r_rule_function_t_rule_1` (`rid`),
  CONSTRAINT `fk_r_rule_function_t_function_1` FOREIGN KEY (`fid`) REFERENCES `t_function` (`fid`),
  CONSTRAINT `fk_r_rule_function_t_rule_1` FOREIGN KEY (`rid`) REFERENCES `t_rule` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8 COMMENT='角色链接关系表';

-- ----------------------------
-- Records of r_rule_function
-- ----------------------------
INSERT INTO `r_rule_function` VALUES ('1', '1', '1', '1', '2016-07-08 11:28:34', '2016-07-08 11:28:37', '0');
INSERT INTO `r_rule_function` VALUES ('3', '1', '2', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('4', '1', '3', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('5', '1', '4', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('6', '1', '5', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('7', '1', '6', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('8', '1', '7', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('9', '1', '8', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('10', '1', '9', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('11', '1', '10', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('12', '1', '11', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('13', '1', '12', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('14', '1', '13', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('15', '1', '14', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('16', '1', '15', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('17', '1', '16', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('18', '1', '17', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('19', '1', '18', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('20', '1', '19', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('21', '1', '20', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('22', '1', '21', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('23', '1', '22', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('24', '1', '23', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('25', '1', '24', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('26', '1', '25', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('27', '1', '26', '1', '2016-07-08 11:28:50', '2016-07-08 11:28:50', '0');
INSERT INTO `r_rule_function` VALUES ('29', '1', '27', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `r_rule_function` VALUES ('30', '1', '28', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `r_rule_function` VALUES ('31', '1', '29', '1', '2016-07-13 10:00:43', '2016-07-13 10:00:45', '0');
INSERT INTO `r_rule_function` VALUES ('32', '1', '30', '1', '2016-07-13 10:00:47', '2016-07-13 10:00:48', '0');
INSERT INTO `r_rule_function` VALUES ('33', '1', '31', '1', '2016-07-13 11:55:59', '2016-07-13 11:56:01', '0');
INSERT INTO `r_rule_function` VALUES ('34', '1', '33', '1', '2016-07-14 15:54:45', '2016-07-14 15:54:47', '0');
INSERT INTO `r_rule_function` VALUES ('35', '1', '35', '1', '2016-07-14 16:15:25', '2016-07-14 16:15:29', '0');
INSERT INTO `r_rule_function` VALUES ('36', '1', '37', '1', '2016-07-15 10:06:25', '2016-07-15 10:06:28', '0');
INSERT INTO `r_rule_function` VALUES ('77', '2', '1', '1', '2016-07-15 14:48:39', null, '0');
INSERT INTO `r_rule_function` VALUES ('78', '2', '9', '1', '2016-07-15 14:48:39', null, '0');
INSERT INTO `r_rule_function` VALUES ('79', '1', '4', '1', '2016-07-15 16:14:22', null, '0');
INSERT INTO `r_rule_function` VALUES ('80', '1', '5', '1', '2016-07-15 16:14:22', null, '0');
INSERT INTO `r_rule_function` VALUES ('81', '1', '8', '1', '2016-07-15 16:14:22', null, '0');
INSERT INTO `r_rule_function` VALUES ('82', '1', '2', '1', '2016-07-15 16:15:13', null, '0');
INSERT INTO `r_rule_function` VALUES ('83', '1', '4', '1', '2016-07-15 16:15:13', null, '0');
INSERT INTO `r_rule_function` VALUES ('84', '1', '6', '1', '2016-07-15 16:15:13', null, '0');
INSERT INTO `r_rule_function` VALUES ('85', '1', '7', '1', '2016-07-15 16:15:13', null, '0');
INSERT INTO `r_rule_function` VALUES ('86', '1', '3', '1', '2016-07-15 16:21:16', null, '0');
INSERT INTO `r_rule_function` VALUES ('87', '1', '5', '1', '2016-07-15 16:21:16', null, '0');
INSERT INTO `r_rule_function` VALUES ('88', '1', '7', '1', '2016-07-15 16:21:16', null, '0');
INSERT INTO `r_rule_function` VALUES ('89', '1', '2', '1', '2016-07-15 16:23:39', null, '0');
INSERT INTO `r_rule_function` VALUES ('90', '1', '5', '1', '2016-07-15 16:23:39', null, '0');
INSERT INTO `r_rule_function` VALUES ('91', '1', '7', '1', '2016-07-15 16:23:39', null, '0');
INSERT INTO `r_rule_function` VALUES ('92', '1', '2', '1', '2016-07-15 16:24:35', null, '0');
INSERT INTO `r_rule_function` VALUES ('93', '1', '3', '1', '2016-07-15 16:24:35', null, '0');
INSERT INTO `r_rule_function` VALUES ('94', '1', '3', '1', '2016-07-15 16:27:06', null, '0');
INSERT INTO `r_rule_function` VALUES ('95', '1', '5', '1', '2016-07-15 16:27:06', null, '0');
INSERT INTO `r_rule_function` VALUES ('96', '1', '7', '1', '2016-07-15 16:27:06', null, '0');
INSERT INTO `r_rule_function` VALUES ('97', '1', '3', '1', '2016-07-15 16:27:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('98', '1', '4', '1', '2016-07-15 16:27:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('99', '1', '6', '1', '2016-07-15 16:27:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('100', '4', '4', '1', '2016-07-18 09:43:02', null, '0');
INSERT INTO `r_rule_function` VALUES ('101', '4', '5', '1', '2016-07-18 09:43:02', null, '0');
INSERT INTO `r_rule_function` VALUES ('102', '4', '6', '1', '2016-07-18 09:43:02', null, '0');
INSERT INTO `r_rule_function` VALUES ('103', '4', '8', '1', '2016-07-18 09:43:02', null, '0');
INSERT INTO `r_rule_function` VALUES ('106', '12', '4', '1', '2016-07-20 17:55:00', null, '0');
INSERT INTO `r_rule_function` VALUES ('107', '12', '5', '1', '2016-07-20 17:55:00', null, '0');
INSERT INTO `r_rule_function` VALUES ('108', '1', '39', '1', '2016-07-21 09:45:37', null, '0');
INSERT INTO `r_rule_function` VALUES ('109', '2', '39', '1', '2016-07-21 09:45:37', null, '0');
INSERT INTO `r_rule_function` VALUES ('110', '1', '40', '1', '2016-07-21 13:58:55', null, '0');
INSERT INTO `r_rule_function` VALUES ('111', '2', '40', '1', '2016-07-21 13:58:55', null, '0');
INSERT INTO `r_rule_function` VALUES ('112', '1', '41', '1', '2016-07-21 13:59:22', null, '0');
INSERT INTO `r_rule_function` VALUES ('113', '2', '41', '1', '2016-07-21 13:59:22', null, '0');
INSERT INTO `r_rule_function` VALUES ('114', '1', '42', '1', '2016-07-21 13:59:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('115', '2', '42', '1', '2016-07-21 13:59:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('116', '1', '43', '1', '2016-07-21 14:00:57', null, '0');
INSERT INTO `r_rule_function` VALUES ('117', '2', '43', '1', '2016-07-21 14:00:57', null, '0');
INSERT INTO `r_rule_function` VALUES ('118', '1', '44', '1', '2016-07-21 14:01:37', null, '0');
INSERT INTO `r_rule_function` VALUES ('119', '2', '44', '1', '2016-07-21 14:01:37', null, '0');
INSERT INTO `r_rule_function` VALUES ('120', '1', '45', '1', '2016-07-21 14:14:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('121', '2', '45', '1', '2016-07-21 14:14:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('122', '1', '46', '1', '2016-07-21 14:15:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('123', '2', '46', '1', '2016-07-21 14:15:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('124', '1', '47', '1', '2016-07-21 14:15:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('125', '2', '47', '1', '2016-07-21 14:15:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('126', '1', '48', '1', '2016-07-21 14:16:04', null, '0');
INSERT INTO `r_rule_function` VALUES ('127', '2', '48', '1', '2016-07-21 14:16:04', null, '0');
INSERT INTO `r_rule_function` VALUES ('128', '1', '49', '1', '2016-07-21 14:16:29', null, '0');
INSERT INTO `r_rule_function` VALUES ('129', '2', '49', '1', '2016-07-21 14:16:29', null, '0');
INSERT INTO `r_rule_function` VALUES ('130', '1', '50', '1', '2016-07-21 14:16:43', null, '0');
INSERT INTO `r_rule_function` VALUES ('131', '2', '50', '1', '2016-07-21 14:16:43', null, '0');
INSERT INTO `r_rule_function` VALUES ('132', '1', '51', '1', '2016-07-21 14:17:01', null, '0');
INSERT INTO `r_rule_function` VALUES ('133', '2', '51', '1', '2016-07-21 14:17:01', null, '0');
INSERT INTO `r_rule_function` VALUES ('134', '1', '52', '1', '2016-07-21 14:20:25', null, '0');
INSERT INTO `r_rule_function` VALUES ('135', '2', '52', '1', '2016-07-21 14:20:25', null, '0');
INSERT INTO `r_rule_function` VALUES ('136', '1', '53', '1', '2016-07-21 14:20:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('137', '2', '53', '1', '2016-07-21 14:20:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('138', '1', '54', '1', '2016-07-21 14:21:07', null, '0');
INSERT INTO `r_rule_function` VALUES ('139', '2', '54', '1', '2016-07-21 14:21:07', null, '0');

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
  KEY `fk_r_user_rule_t_user_1` (`uid`),
  CONSTRAINT `fk_r_user_rule_t_rule_1` FOREIGN KEY (`rid`) REFERENCES `t_rule` (`rid`),
  CONSTRAINT `fk_r_user_rule_t_user_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`)
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
INSERT INTO `s_system_settings` VALUES ('2', 'asdasd', '222', '2222', '1', '2016-07-18 18:04:12', '2016-07-18 18:10:00', '2');
INSERT INTO `s_system_settings` VALUES ('3', 'ewewr', '2323', '2323', '1', '2016-07-18 18:04:41', '2016-07-20 10:08:41', '2');
INSERT INTO `s_system_settings` VALUES ('4', '333', '333', '333', '0', '2016-07-20 10:08:34', null, '0');
INSERT INTO `s_system_settings` VALUES ('5', '11', '11', '11', '1', '2016-07-20 15:00:26', null, '0');
INSERT INTO `s_system_settings` VALUES ('6', 'tablesize', '5', '表格每页默认数据', '1', '2016-07-20 17:00:06', null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='连接表';

-- ----------------------------
-- Records of t_function
-- ----------------------------
INSERT INTO `t_function` VALUES ('1', '部署', 'javascript:;', '0', '1', '1', '1', '2016-07-08 11:28:12', '2016-07-08 11:28:17', '0');
INSERT INTO `t_function` VALUES ('2', '服务管理', 'javascript:;', '0', '1', '2', '1', '2016-07-08 11:28:15', '2016-07-08 11:28:20', '0');
INSERT INTO `t_function` VALUES ('3', '监控', 'javascript:;', '0', '1', '3', '1', '2016-07-08 13:19:49', '2016-07-08 13:20:03', '0');
INSERT INTO `t_function` VALUES ('4', '节点管理', 'javascript:;', '0', '1', '4', '1', '2016-07-08 13:19:52', '2016-07-08 13:20:05', '0');
INSERT INTO `t_function` VALUES ('5', '文件管理', 'javascript:;', '0', '1', '5', '1', '2016-07-08 13:19:54', '2016-07-08 13:20:07', '0');
INSERT INTO `t_function` VALUES ('6', '数据备份', 'javascript:;', '0', '1', '6', '1', '2016-07-08 13:19:56', '2016-07-08 13:20:10', '0');
INSERT INTO `t_function` VALUES ('7', '日志', 'javascript:;', '0', '1', '7', '1', '2016-07-08 13:19:59', '2016-07-08 13:20:12', '0');
INSERT INTO `t_function` VALUES ('8', '用户', 'javascript:;', '0', '1', '8', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:15', '0');
INSERT INTO `t_function` VALUES ('9', '资源单元', 'http://www.taobao.com', '1', '2', '1', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('10', '扩容', 'http://www.taobao.com', '1', '2', '2', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('11', '新节点', 'http://www.taobao.com', '1', '2', '3', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('12', '管理指令', 'http://www.taobao.com', '2', '2', '1', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('13', '汇报指令', 'http://www.taobao.com', '2', '2', '2', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('14', '指令历史', 'http://www.taobao.com', '2', '2', '3', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('15', '最近状态', 'http://www.taobao.com', '3', '2', '1', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('16', '报警信息', 'http://www.taobao.com', '3', '2', '2', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('17', '报告', 'http://www.taobao.com', '3', '2', '3', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('18', '拓扑', 'http://www.taobao.com', '4', '2', '1', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('19', '节点文件', 'http://www.taobao.com', '4', '2', '2', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('20', '上传备份计划', 'http://www.taobao.com', '6', '2', '1', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('21', '审批备份计划', 'http://www.taobao.com', '6', '2', '2', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('22', '执行备份计划', 'http://www.taobao.com', '6', '2', '3', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('23', '停止定时备份', 'http://www.taobao.com', '6', '2', '4', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('24', '历史日志查询', 'http://www.taobao.com', '7', '2', '1', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('25', '节点日志查询', 'http://www.taobao.com', '7', '2', '2', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('26', '日志管理报告', 'http://www.taobao.com', '7', '2', '3', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('27', '资源单元', 'http://www.taobao.com', '10', '3', '1', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('28', '节点', 'http://www.taobao.com', '10', '3', '2', '1', '2016-07-08 13:20:01', '2016-07-08 13:20:01', '0');
INSERT INTO `t_function` VALUES ('29', '系统设置', 'javascript:;', '0', '1', '9', '1', '2016-07-13 09:59:08', '2016-07-13 09:59:11', '0');
INSERT INTO `t_function` VALUES ('30', '角色管理', 'ruleController/turnrule.do', '29', '2', '1', '1', '2016-07-13 10:00:18', '2016-07-13 10:00:21', '0');
INSERT INTO `t_function` VALUES ('31', '链接管理', 'functionController/turnFunction.do', '29', '2', '2', '1', '2016-07-13 11:55:45', '2016-07-13 11:55:47', '0');
INSERT INTO `t_function` VALUES ('33', '用户管理', 'userController/turnuser.do', '29', '2', '4', '1', '2016-07-14 09:31:34', '2016-07-14 15:54:02', '1');
INSERT INTO `t_function` VALUES ('35', '系统参数', 'settingsController/turnSettings.do', '29', '2', '5', '1', '2016-07-14 16:14:21', null, '0');
INSERT INTO `t_function` VALUES ('37', '系统消息', 'noticeController/turnnotice.do', '29', '2', '5', '1', '2016-07-15 10:06:02', null, '0');
INSERT INTO `t_function` VALUES ('39', '日志查询', 'systemLogsController/turnSystemLogs.do', '29', '2', '6', '1', '2016-07-21 09:45:37', null, '0');
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
INSERT INTO `t_rule` VALUES ('1', '运维', '1', '1', '2016-07-08 10:26:43', '2016-07-08 10:26:45', '0');
INSERT INTO `t_rule` VALUES ('2', '开发', '0', '1', '2016-07-08 11:27:09', '2016-07-15 12:23:30', '1');
INSERT INTO `t_rule` VALUES ('3', '23423', '0', '0', '2016-07-15 16:14:22', null, '0');
INSERT INTO `t_rule` VALUES ('4', 'asdasdasd', '0', '0', '2016-07-15 16:15:13', '2016-07-18 09:44:04', '3');
INSERT INTO `t_rule` VALUES ('5', '34434534', '0', '0', '2016-07-15 16:21:16', null, '0');
INSERT INTO `t_rule` VALUES ('6', '345345435', '1', '1', '2016-07-15 16:23:39', null, '0');
INSERT INTO `t_rule` VALUES ('7', '32434', '1', '1', '2016-07-15 16:24:35', null, '0');
INSERT INTO `t_rule` VALUES ('8', '特使斯蒂芬', '1', '1', '2016-07-15 16:27:06', null, '0');
INSERT INTO `t_rule` VALUES ('9', '电风扇地方', '1', '1', '2016-07-15 16:27:38', null, '0');
INSERT INTO `t_rule` VALUES ('10', '4234324324', '1', '1', '2016-07-15 16:29:30', null, '0');
INSERT INTO `t_rule` VALUES ('11', 'sadsad', '1', '1', '2016-07-15 16:29:47', null, '0');
INSERT INTO `t_rule` VALUES ('12', 'ewewr', '1', '1', '2016-07-15 16:30:49', null, '0');
INSERT INTO `t_rule` VALUES ('13', 'dsfdsfsd', '1', '1', '2016-07-21 09:30:51', null, '0');

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
INSERT INTO `t_user` VALUES ('1', '1', 'c4ca4238a0b923820dcc509a6f75849b', '尚成才', 'shangchengcai@voole.com', '18701691135', '1', '12', '2016-07-07 16:50:40', '2016-07-21 22:18:35', '2016-07-21 14:21:13', '104');
INSERT INTO `t_user` VALUES ('2', '2', '202cb962ac59075b964b07152d234b70', '尚成才', '644624156@qq.com', '2', '1', null, '2016-07-18 15:10:22', '2016-07-18 23:19:23', null, '1');
INSERT INTO `t_user` VALUES ('3', 'as', 'e10adc3949ba59abbe56e057f20f883e', 'sds', 'sad', 'sadas', '1', null, '2016-07-20 13:49:07', null, null, '0');
