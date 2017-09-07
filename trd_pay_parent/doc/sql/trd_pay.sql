/*
Navicat MySQL Data Transfer

Source Server         : 开发机器5
Source Server Version : 50718
Source Host           : 172.16.40.5:3306
Source Database       : trd_pay

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-07 13:59:46
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

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
  KEY `fk_r_rule_function_t_function_1` (`fid`) USING BTREE,
  KEY `fk_r_rule_function_t_rule_1` (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1658 DEFAULT CHARSET=utf8 COMMENT='角色链接关系表';

-- ----------------------------
-- Records of r_rule_function
-- ----------------------------
INSERT INTO `r_rule_function` VALUES ('1411', '3', '128', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1412', '3', '129', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1413', '3', '131', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1414', '3', '132', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1415', '3', '133', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1416', '3', '134', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1417', '3', '136', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1418', '3', '137', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1419', '3', '138', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1420', '3', '139', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1421', '3', '141', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1422', '3', '142', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1423', '3', '143', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1424', '3', '144', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1425', '3', '145', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1426', '3', '146', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1427', '3', '147', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1428', '3', '148', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1429', '3', '151', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1430', '3', '152', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1431', '3', '153', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1433', '3', '156', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1434', '3', '158', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1436', '3', '160', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1437', '3', '161', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1438', '3', '60', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1439', '3', '61', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1440', '3', '62', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1441', '3', '63', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1442', '3', '64', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1443', '3', '65', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1444', '3', '66', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1445', '3', '67', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1446', '3', '68', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1447', '3', '69', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1448', '3', '70', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1449', '3', '72', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1450', '3', '73', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1452', '3', '75', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1453', '3', '76', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1454', '3', '77', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1455', '3', '78', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1456', '3', '79', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1457', '3', '80', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1458', '3', '81', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1459', '3', '82', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1460', '3', '84', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1461', '3', '85', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1462', '3', '86', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1463', '3', '87', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1464', '3', '88', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1465', '3', '89', '1', '2017-07-18 12:19:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1466', '3', '90', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1467', '3', '91', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1468', '3', '92', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1469', '3', '93', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1470', '3', '94', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1471', '3', '96', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1472', '3', '97', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1473', '3', '98', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1474', '3', '99', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1475', '3', '101', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1477', '3', '103', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1478', '3', '104', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1479', '3', '105', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1480', '3', '106', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1481', '3', '107', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1482', '3', '126', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1483', '3', '127', '1', '2017-07-18 12:19:15', null, '0');
INSERT INTO `r_rule_function` VALUES ('1484', '2', '29', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1485', '2', '30', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1486', '2', '31', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1487', '2', '33', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1488', '2', '35', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1489', '2', '37', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1490', '2', '39', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1491', '2', '40', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1492', '2', '41', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1493', '2', '42', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1494', '2', '43', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1495', '2', '44', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1496', '2', '45', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1497', '2', '46', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1498', '2', '47', '1', '2017-07-18 12:19:19', null, '0');
INSERT INTO `r_rule_function` VALUES ('1499', '2', '48', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1500', '2', '49', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1501', '2', '50', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1502', '2', '51', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1503', '2', '52', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1504', '2', '53', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1505', '2', '54', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1506', '2', '56', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1507', '2', '60', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1508', '2', '61', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1509', '2', '62', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1510', '2', '63', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1511', '2', '64', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1512', '2', '65', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1513', '2', '66', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1514', '2', '67', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1515', '2', '68', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1516', '2', '69', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1517', '2', '70', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1518', '2', '72', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1519', '2', '73', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1521', '2', '75', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1522', '2', '76', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1523', '2', '77', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1524', '2', '78', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1525', '2', '79', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1526', '2', '80', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1527', '2', '81', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1528', '2', '82', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1529', '2', '83', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1530', '2', '84', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1531', '2', '85', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1532', '2', '86', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1533', '2', '87', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1534', '2', '88', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1535', '2', '89', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1536', '2', '90', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1537', '2', '91', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1538', '2', '92', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1539', '2', '93', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1540', '2', '94', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1541', '2', '95', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1542', '2', '96', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1543', '2', '97', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1544', '2', '98', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1545', '2', '99', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1546', '2', '100', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1547', '2', '101', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1549', '2', '103', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1550', '2', '104', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1551', '2', '105', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1552', '2', '106', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1553', '2', '107', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1554', '2', '108', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1555', '2', '126', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1556', '2', '127', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1557', '2', '128', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1558', '2', '129', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1559', '2', '130', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1560', '2', '131', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1561', '2', '132', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1562', '2', '133', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1563', '2', '134', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1564', '2', '135', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1565', '2', '136', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1566', '2', '137', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1567', '2', '138', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1568', '2', '139', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1569', '2', '140', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1570', '2', '141', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1571', '2', '142', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1572', '2', '143', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1573', '2', '144', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1574', '2', '145', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1575', '2', '146', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1576', '2', '147', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1577', '2', '148', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1578', '2', '149', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1579', '2', '150', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1580', '2', '151', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1581', '2', '152', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1582', '2', '153', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1583', '2', '154', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1585', '2', '156', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1586', '2', '158', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1588', '2', '160', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1589', '2', '161', '1', '2017-07-18 12:19:20', null, '0');
INSERT INTO `r_rule_function` VALUES ('1591', '3', '164', '1', '2017-07-19 10:47:58', null, '0');
INSERT INTO `r_rule_function` VALUES ('1592', '2', '164', '1', '2017-07-19 10:47:58', null, '0');
INSERT INTO `r_rule_function` VALUES ('1593', '3', '165', '1', '2017-07-19 10:50:09', null, '0');
INSERT INTO `r_rule_function` VALUES ('1594', '2', '165', '1', '2017-07-19 10:50:09', null, '0');
INSERT INTO `r_rule_function` VALUES ('1595', '3', '166', '1', '2017-07-19 17:14:00', null, '0');
INSERT INTO `r_rule_function` VALUES ('1596', '2', '166', '1', '2017-07-19 17:14:00', null, '0');
INSERT INTO `r_rule_function` VALUES ('1597', '3', '167', '1', '2017-07-19 17:15:36', null, '0');
INSERT INTO `r_rule_function` VALUES ('1598', '2', '167', '1', '2017-07-19 17:15:36', null, '0');
INSERT INTO `r_rule_function` VALUES ('1599', '3', '168', '1', '2017-07-19 17:16:08', null, '0');
INSERT INTO `r_rule_function` VALUES ('1600', '2', '168', '1', '2017-07-19 17:16:08', null, '0');
INSERT INTO `r_rule_function` VALUES ('1601', '3', '169', '1', '2017-07-19 17:16:53', null, '0');
INSERT INTO `r_rule_function` VALUES ('1602', '2', '169', '1', '2017-07-19 17:16:53', null, '0');
INSERT INTO `r_rule_function` VALUES ('1603', '3', '170', '1', '2017-07-19 17:17:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('1604', '2', '170', '1', '2017-07-19 17:17:38', null, '0');
INSERT INTO `r_rule_function` VALUES ('1605', '3', '171', '1', '2017-07-19 17:18:08', null, '0');
INSERT INTO `r_rule_function` VALUES ('1606', '2', '171', '1', '2017-07-19 17:18:08', null, '0');
INSERT INTO `r_rule_function` VALUES ('1607', '3', '172', '1', '2017-07-19 17:48:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('1608', '2', '172', '1', '2017-07-19 17:48:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('1609', '3', '173', '1', '2017-07-25 14:10:50', null, '0');
INSERT INTO `r_rule_function` VALUES ('1610', '2', '173', '1', '2017-07-25 14:10:50', null, '0');
INSERT INTO `r_rule_function` VALUES ('1611', '3', '174', '1', '2017-07-25 14:11:45', null, '0');
INSERT INTO `r_rule_function` VALUES ('1612', '2', '174', '1', '2017-07-25 14:11:45', null, '0');
INSERT INTO `r_rule_function` VALUES ('1613', '3', '175', '1', '2017-07-25 14:13:16', null, '0');
INSERT INTO `r_rule_function` VALUES ('1614', '2', '175', '1', '2017-07-25 14:13:16', null, '0');
INSERT INTO `r_rule_function` VALUES ('1615', '3', '176', '1', '2017-07-25 14:13:50', null, '0');
INSERT INTO `r_rule_function` VALUES ('1616', '2', '176', '1', '2017-07-25 14:13:50', null, '0');
INSERT INTO `r_rule_function` VALUES ('1617', '3', '177', '1', '2017-07-25 14:14:29', null, '0');
INSERT INTO `r_rule_function` VALUES ('1618', '2', '177', '1', '2017-07-25 14:14:29', null, '0');
INSERT INTO `r_rule_function` VALUES ('1619', '3', '178', '1', '2017-07-25 14:15:16', null, '0');
INSERT INTO `r_rule_function` VALUES ('1620', '2', '178', '1', '2017-07-25 14:15:16', null, '0');
INSERT INTO `r_rule_function` VALUES ('1621', '3', '179', '1', '2017-07-25 14:15:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('1622', '2', '179', '1', '2017-07-25 14:15:46', null, '0');
INSERT INTO `r_rule_function` VALUES ('1623', '3', '180', '1', '2017-07-26 17:30:11', null, '0');
INSERT INTO `r_rule_function` VALUES ('1624', '2', '180', '1', '2017-07-26 17:30:11', null, '0');
INSERT INTO `r_rule_function` VALUES ('1625', '3', '181', '1', '2017-07-31 14:56:32', null, '0');
INSERT INTO `r_rule_function` VALUES ('1626', '2', '181', '1', '2017-07-31 14:56:32', null, '0');
INSERT INTO `r_rule_function` VALUES ('1627', '4', '75', '1', '2017-08-17 09:08:33', null, '0');
INSERT INTO `r_rule_function` VALUES ('1628', '4', '60', '1', '2017-08-17 09:08:33', null, '0');
INSERT INTO `r_rule_function` VALUES ('1629', '4', '61', '1', '2017-08-17 09:08:33', null, '0');
INSERT INTO `r_rule_function` VALUES ('1630', '4', '62', '1', '2017-08-17 09:08:33', null, '0');
INSERT INTO `r_rule_function` VALUES ('1631', '4', '63', '1', '2017-08-17 09:08:33', null, '0');
INSERT INTO `r_rule_function` VALUES ('1632', '5', '62', '1', '2017-08-17 09:16:23', null, '0');
INSERT INTO `r_rule_function` VALUES ('1633', '5', '63', '1', '2017-08-17 09:16:23', null, '0');
INSERT INTO `r_rule_function` VALUES ('1638', '3', '184', '1', '2017-08-18 14:21:07', null, '0');
INSERT INTO `r_rule_function` VALUES ('1639', '2', '184', '1', '2017-08-18 14:21:07', null, '0');
INSERT INTO `r_rule_function` VALUES ('1640', '3', '185', '1', '2017-08-18 14:21:22', null, '0');
INSERT INTO `r_rule_function` VALUES ('1641', '2', '185', '1', '2017-08-18 14:21:22', null, '0');
INSERT INTO `r_rule_function` VALUES ('1642', '3', '186', '1', '2017-08-18 14:21:35', null, '0');
INSERT INTO `r_rule_function` VALUES ('1643', '2', '186', '1', '2017-08-18 14:21:35', null, '0');
INSERT INTO `r_rule_function` VALUES ('1644', '3', '187', '1', '2017-08-18 14:21:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('1645', '2', '187', '1', '2017-08-18 14:21:48', null, '0');
INSERT INTO `r_rule_function` VALUES ('1646', '3', '188', '1', '2017-08-21 16:58:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1647', '2', '188', '1', '2017-08-21 16:58:14', null, '0');
INSERT INTO `r_rule_function` VALUES ('1648', '3', '189', '1', '2017-08-22 09:20:51', null, '0');
INSERT INTO `r_rule_function` VALUES ('1649', '2', '189', '1', '2017-08-22 09:20:51', null, '0');
INSERT INTO `r_rule_function` VALUES ('1650', '3', '190', '1', '2017-08-22 09:21:37', null, '0');
INSERT INTO `r_rule_function` VALUES ('1651', '2', '190', '1', '2017-08-22 09:21:37', null, '0');
INSERT INTO `r_rule_function` VALUES ('1652', '3', '191', '1', '2017-08-22 09:22:00', null, '0');
INSERT INTO `r_rule_function` VALUES ('1653', '2', '191', '1', '2017-08-22 09:22:00', null, '0');
INSERT INTO `r_rule_function` VALUES ('1654', '3', '192', '1', '2017-08-28 15:23:25', null, '0');
INSERT INTO `r_rule_function` VALUES ('1655', '2', '192', '1', '2017-08-28 15:23:25', null, '0');
INSERT INTO `r_rule_function` VALUES ('1656', '3', '193', '1', '2017-08-29 09:58:00', null, '0');
INSERT INTO `r_rule_function` VALUES ('1657', '2', '193', '1', '2017-08-29 09:58:00', null, '0');

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
  KEY `fk_r_user_rule_t_rule_1` (`rid`) USING BTREE,
  KEY `fk_r_user_rule_t_user_1` (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of r_user_rule
-- ----------------------------
INSERT INTO `r_user_rule` VALUES ('11', '2', '3', '1', '2017-05-31 16:06:15', null, '0');
INSERT INTO `r_user_rule` VALUES ('12', '3', '2', '1', '2017-07-13 17:17:09', null, '0');
INSERT INTO `r_user_rule` VALUES ('13', '3', '3', '1', '2017-07-13 17:17:09', null, '0');
INSERT INTO `r_user_rule` VALUES ('14', '1', '2', '1', '2017-07-18 11:20:27', null, '0');
INSERT INTO `r_user_rule` VALUES ('15', '1', '3', '1', '2017-07-18 11:20:27', null, '0');
INSERT INTO `r_user_rule` VALUES ('16', '1', '5', '1', '2017-08-17 09:16:23', null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='系统配置表';

-- ----------------------------
-- Records of s_system_settings
-- ----------------------------
INSERT INTO `s_system_settings` VALUES ('1', 'error_pw_count', '12', '登录重试次数', '1', '2016-07-14 16:32:04', '2017-07-27 15:09:43', '6');
INSERT INTO `s_system_settings` VALUES ('6', 'tablesize', '10', '表格每页默认数据', '1', '2016-07-20 17:00:06', null, '0');
INSERT INTO `s_system_settings` VALUES ('7', 'sync_version', '0.0.1', '同步版本号', '1', '2017-04-12 10:27:45', null, '0');
INSERT INTO `s_system_settings` VALUES ('8', 'homelimit', '10', '首页排行显示数', '1', '2017-07-19 13:46:28', '2017-07-19 13:50:56', '1');

-- ----------------------------
-- Table structure for t_flush_db
-- ----------------------------
DROP TABLE IF EXISTS `t_flush_db`;
CREATE TABLE `t_flush_db` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `last_ping_date` datetime DEFAULT NULL COMMENT '上次ping通时间',
  `flush_cache_interval` int(11) DEFAULT NULL COMMENT '间隔时间失效时间',
  `interval_unit` int(11) DEFAULT NULL COMMENT '间隔时间失效单位，1年，2月，3周，5天，10小时，12分钟，13秒',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_on` int(255) DEFAULT NULL COMMENT '是否启动',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1 COMMENT='服务器宕机后刷新缓存中间变量记录表';

-- ----------------------------
-- Records of t_flush_db
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
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8 COMMENT='连接表';

-- ----------------------------
-- Records of t_function
-- ----------------------------
INSERT INTO `t_function` VALUES ('29', '系统设置', 'javascript:;', '0', '1', '9', '1', '2016-07-13 09:59:08', '2017-06-05 15:56:51', '1');
INSERT INTO `t_function` VALUES ('30', '角色管理', 'ruleController/turnrule.do', '29', '2', '1', '1', '2016-07-13 10:00:18', '2016-07-13 10:00:21', '0');
INSERT INTO `t_function` VALUES ('31', '链接管理', 'functionController/turnFunction.do', '29', '2', '2', '1', '2016-07-13 11:55:45', '2016-07-13 11:55:47', '0');
INSERT INTO `t_function` VALUES ('33', '用户管理', 'userController/turnuser.do', '29', '2', '4', '1', '2016-07-14 09:31:34', '2016-07-14 15:54:02', '1');
INSERT INTO `t_function` VALUES ('35', '系统参数', 'settingsController/turnSettings.do', '29', '2', '5', '1', '2016-07-14 16:14:21', null, '0');
INSERT INTO `t_function` VALUES ('37', '系统消息', 'noticeController/turnnotice.do', '29', '2', '5', '0', '2016-07-15 10:06:02', '2017-04-07 10:39:59', '1');
INSERT INTO `t_function` VALUES ('39', '日志查询', 'systemLogsController/turnSystemLogs.do', '29', '2', '6', '1', '2016-07-21 09:45:37', '2017-07-24 10:28:47', '3');
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
INSERT INTO `t_function` VALUES ('72', 'kafka监控', 'http://172.16.40.5:8089', '63', '2', '6', '1', '2017-03-29 10:26:27', '2017-07-19 10:48:49', '4');
INSERT INTO `t_function` VALUES ('73', 'dubbo监控', 'http://172.16.40.5:8081', '63', '2', '5', '1', '2017-03-29 10:27:04', '2017-07-19 10:48:42', '3');
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
INSERT INTO `t_function` VALUES ('156', '新建同步', 'iSync/addSync.do', '64', '4', '7', '1', '2017-06-15 13:57:06', null, '0');
INSERT INTO `t_function` VALUES ('157', '中间变量', 'variableController/turnvariable.do', '63', '2', '6', '1', '2017-07-11 14:08:36', null, '0');
INSERT INTO `t_function` VALUES ('158', '统计计算变量管理', 'syncstatisticsController/turnsyncstatistics.do', '63', '2', '4', '1', '2017-07-13 17:26:16', '2017-07-19 10:48:35', '5');
INSERT INTO `t_function` VALUES ('160', '删除', 'syncstatisticsController/delsyncstatistics.do', '158', '4', '2', '1', '2017-07-14 14:59:43', '2017-07-17 16:35:58', '1');
INSERT INTO `t_function` VALUES ('161', '编辑', 'syncstatisticsController/changevalue.do', '158', '4', '3', '1', '2017-07-14 15:01:18', '2017-07-17 16:36:13', '1');
INSERT INTO `t_function` VALUES ('164', '新建', 'syncstatisticsController/addsyncstatistics.do', '158', '4', '5', '0', '2017-07-19 10:47:58', '2017-07-19 10:49:23', '1');
INSERT INTO `t_function` VALUES ('165', '详情', 'syncstatisticsController/turnsyncstatisticsInfo.do', '158', '4', '3', '1', '2017-07-19 10:50:09', null, '0');
INSERT INTO `t_function` VALUES ('166', '心跳缓存配置', 'flushdbController/turnFlushDb.do', '29', '2', '7', '1', '2017-07-19 17:14:00', '2017-08-29 14:42:29', '1');
INSERT INTO `t_function` VALUES ('167', '查看', 'flushdbController/turnFlushDbInfo.do', '166', '4', '1', '1', '2017-07-19 17:15:36', null, '0');
INSERT INTO `t_function` VALUES ('168', '编辑', 'flushdbController/changvalue.do', '166', '4', '2', '1', '2017-07-19 17:16:08', null, '0');
INSERT INTO `t_function` VALUES ('169', '启用', 'flushdbController/startSettings.do', '166', '4', '3', '1', '2017-07-19 17:16:53', null, '0');
INSERT INTO `t_function` VALUES ('170', '禁用', 'flushdbController/forbidden.do', '166', '4', '4', '1', '2017-07-19 17:17:38', null, '0');
INSERT INTO `t_function` VALUES ('171', '删除', 'flushdbController/delFlushDb.do', '166', '4', '5', '1', '2017-07-19 17:18:08', null, '0');
INSERT INTO `t_function` VALUES ('172', '新建', 'flushdbController/addFlushDb.do', '166', '4', '6', '1', '2017-07-19 17:48:48', '2017-07-20 11:03:54', '1');
INSERT INTO `t_function` VALUES ('173', '项目配置', 'projectController/turnProject.do', '62', '2', '6', '1', '2017-07-25 14:10:50', null, '0');
INSERT INTO `t_function` VALUES ('174', '新建', 'projectController/turnCreateProject.do', '173', '4', '1', '1', '2017-07-25 14:11:45', '2017-07-25 14:16:49', '1');
INSERT INTO `t_function` VALUES ('175', '查看', 'projectController/turnProjectInfo.do', '173', '4', '2', '1', '2017-07-25 14:13:16', null, '0');
INSERT INTO `t_function` VALUES ('176', '编辑', 'projectController/changvalue.do', '173', '4', '3', '1', '2017-07-25 14:13:50', '2017-07-25 14:14:43', '1');
INSERT INTO `t_function` VALUES ('177', '启用', 'projectController/startSettings.do', '173', '4', '4', '1', '2017-07-25 14:14:29', null, '0');
INSERT INTO `t_function` VALUES ('178', '禁用', 'projectController/forbidden.do', '173', '4', '5', '1', '2017-07-25 14:15:16', null, '0');
INSERT INTO `t_function` VALUES ('179', '删除', 'projectController/delproject.do', '173', '4', '6', '1', '2017-07-25 14:15:46', null, '0');
INSERT INTO `t_function` VALUES ('180', '修改规则列表同步', 'regularTableController/changvalue.do', '66', '4', '6', '1', '2017-07-26 17:30:11', null, '0');
INSERT INTO `t_function` VALUES ('181', '编辑', 'regularController/changvalue.do', '65', '4', '6', '1', '2017-07-31 14:56:32', null, '0');
INSERT INTO `t_function` VALUES ('184', '部署', 'iSync/deploy.do', '64', '4', '8', '1', '2017-08-18 14:21:07', null, '0');
INSERT INTO `t_function` VALUES ('185', '启动', 'iSync/start.do', '64', '4', '9', '1', '2017-08-18 14:21:22', null, '0');
INSERT INTO `t_function` VALUES ('186', '停止', 'iSync/stop.do', '64', '4', '11', '1', '2017-08-18 14:21:35', null, '0');
INSERT INTO `t_function` VALUES ('187', '重启', 'iSync/restart.do', '64', '4', '12', '1', '2017-08-18 14:21:48', null, '0');
INSERT INTO `t_function` VALUES ('188', '分析', 'analysis/turnAnalysis.do', '63', '2', '1', '1', '2017-08-21 16:58:14', null, '0');
INSERT INTO `t_function` VALUES ('189', '项目异常记录', 'errorController/turnError.do', '75', '2', '3', '1', '2017-08-22 09:20:51', '2017-08-29 10:55:26', '1');
INSERT INTO `t_function` VALUES ('190', '详情', 'errorController/turnErrorInfo.do', '189', '4', '1', '1', '2017-08-22 09:21:37', null, '0');
INSERT INTO `t_function` VALUES ('191', '删除', 'errorController/delError.do', '189', '4', '2', '1', '2017-08-22 09:22:00', null, '0');
INSERT INTO `t_function` VALUES ('192', '修改', 'dataSourceTableController/changvalue.do', '90', '4', '6', '1', '2017-08-28 15:23:25', null, '0');
INSERT INTO `t_function` VALUES ('193', '重发', 'errorController/resend.do', '189', '4', '2', '1', '2017-08-29 09:58:00', null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=555 DEFAULT CHARSET=utf8 COMMENT='消息提醒表';

-- ----------------------------
-- Records of t_notifications
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_rule
-- ----------------------------
INSERT INTO `t_rule` VALUES ('2', '开发', '1', '1', '2016-07-08 11:27:09', '2017-03-29 10:11:07', '5');
INSERT INTO `t_rule` VALUES ('3', '测试', '1', '1', '2017-05-31 15:41:06', null, '0');
INSERT INTO `t_rule` VALUES ('4', '普通用户', '1', '1', '2017-08-17 09:08:32', null, '0');
INSERT INTO `t_rule` VALUES ('5', '噗', '0', '1', '2017-08-17 09:16:23', '2017-08-17 11:18:33', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='表';

-- ----------------------------
-- Records of t_table
-- ----------------------------
INSERT INTO `t_table` VALUES ('14', '16', 't_canal', '测试同步源表', '2017-08-28 12:16:29', null, '1', '0');
INSERT INTO `t_table` VALUES ('15', '17', 't_canal', '测试同步源表', '2017-08-28 12:31:02', null, '1', '0');
INSERT INTO `t_table` VALUES ('16', '18', 't_canal', '测试同步源表', '2017-08-28 12:31:08', null, '1', '0');

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
INSERT INTO `t_user` VALUES ('1', 'admin', 'c4ca4238a0b923820dcc509a6f75849b', '尚成才', 'shangchengcai@voole.com', '18701691135', '1', '12', '2016-07-07 16:50:40', '2017-09-07 11:48:21', '2017-09-07 11:49:31', '1319');
INSERT INTO `t_user` VALUES ('2', 'tester', 'c4ca4238a0b923820dcc509a6f75849b', '张俊龙', 'zhangjunlong@voole.com', '110110110', '0', '12', '2017-05-31 15:33:31', '2017-08-17 10:13:35', '2017-06-15 13:57:38', '22');
INSERT INTO `t_user` VALUES ('3', 'joe', '4124bc0a9335c27f086f24ba207a4912', '刘一杰', 'liuyijie@voole.com', '110', '1', '12', '2017-07-13 17:17:01', '2017-07-18 19:22:23', '2017-07-18 11:24:18', '8');
