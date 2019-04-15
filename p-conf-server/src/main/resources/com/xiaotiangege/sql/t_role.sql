/***********************
 * 项目表 t_role
 **********************/
create table t_role (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_num` bigint(19) NOT NULL COMMENT '角色编码，001-超级管理员， 002-普通用户',
  `role_name` varchar(128) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='项目配置属性表';
