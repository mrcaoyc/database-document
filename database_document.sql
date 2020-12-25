DROP TABLE IF EXISTS `database_configuration`;

CREATE TABLE `database_configuration` (
                                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                          `name` varchar(255) DEFAULT NULL COMMENT '连接名称',
                                          `database_type` tinyint(255) DEFAULT NULL COMMENT '数据库类型：0-mysql，1-sqlserver',
                                          `url` varchar(4000) DEFAULT NULL COMMENT 'jdbcUrl地址',
                                          `username` varchar(255) DEFAULT NULL COMMENT '数据库账号',
                                          `password` varchar(255) DEFAULT NULL COMMENT '数据库密码',
                                          `create_time` bigint(20) NOT NULL COMMENT '创建时间',
                                          `update_time` bigint(20) NOT NULL COMMENT '更新时间',
                                          PRIMARY KEY (`id`),
                                          KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='数据库配置表';



INSERT INTO `database_configuration` VALUES
(1,'db1',0,'jdbc:mysql://192.168.103.31:3307/db1de=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8','root','root',1608283169562,1608283169562),
(2,'db2',0,'jdbc:mysql://192.168.103.31:3307/db2?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8','root','root',1608283169562,1608283169562);