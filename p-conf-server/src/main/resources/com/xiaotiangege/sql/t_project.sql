/***********************
 * 项目表 t_project
 **********************/
create table t_project (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department` varchar(128) NOT NULL COMMENT '部门',
  `project_name` varchar(128) NOT NULL COMMENT '项目编号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_project_name` (`project_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='项目表';
