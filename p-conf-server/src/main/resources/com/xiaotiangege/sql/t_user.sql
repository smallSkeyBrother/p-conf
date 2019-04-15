/***********************
 * 用户表  t_user
 **********************/
create table t_user (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '用户姓名',
  `account` varchar(128) NOT NULL COMMENT '用户账号',
  `password` varchar(128) NOT NULL COMMENT '用户密码',
  `email` varchar(512) DEFAULT '' COMMENT '用户邮箱',
  `remark` varchar(512) DEFAULT '' COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_project_name` (`project_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';