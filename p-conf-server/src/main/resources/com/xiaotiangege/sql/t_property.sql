/***********************
 * 项目属性 t_property
 **********************/
create table t_property (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_id` varchar(128) NOT NULL COMMENT '项目id',
  `service_id` varchar(128) NOT NULL COMMENT '服务id',
  `property_key` varchar(128) NOT NULL COMMENT '属性键',
  `property_value` varchar(128) NOT NULL COMMENT '属性值',
  `property_status` char(1) NOT NULL DEFAULT '1' COMMENT '属性状态 1-启用，0-未启用',
  `property_evn` char(1) NOT NULL DEFAULT '1' COMMENT '所属环境， 1-dev, 2-test, 3-prd ',
  `remark` varchar(512) NOT NULL COMMENT '属性备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  INDEX `idx_service_evn` (`service, property_evn`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='项目配置属性表';
