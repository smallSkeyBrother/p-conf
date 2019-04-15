/***********************
 * 服务表 t_service
 **********************/
create table t_service (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_id` bigint(19) NOT NULL COMMENT '项目id',
  `name` varchar(128) DEFAULT NULL COMMENT '服务名称',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_project_name` (`project_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='服务表';