/***********************
 * 环境表 t_environment
 **********************/
create table t_environment (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_id` bigint(19) NOT NULL COMMENT '项目编号',
  `project_name` varchar(128) NOT NULL COMMENT '项目名称',
  `project_evn` varchar(128) NOT NULL COMMENT '配置环境， dev-开发， test-测试， prd-生产',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_project_name` (`project_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='配置环境表';
