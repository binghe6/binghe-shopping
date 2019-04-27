#商品表
DROP TABLE IF EXISTS `base_item`;
CREATE TABLE `base_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id，同时也是商品编号',
  `title` varchar(100) NOT NULL COMMENT '商品标题',
  `sell_point` varchar(150) DEFAULT NULL COMMENT '商品卖点',
  `price` decimal(20,0) NOT NULL COMMENT '商品价格，单位为：分',
  `num` int(10) NOT NULL COMMENT '库存数量',
  `barcode` varchar(30) DEFAULT NULL COMMENT '商品条形码',
  `image` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `cid` bigint(20) NOT NULL COMMENT '所属类目，叶子类目',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '商品状态，1-正常，2-下架，3-删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  KEY `updated` (`update_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品表';

#商品类目表
DROP TABLE IF EXISTS `base_item_cat`;
CREATE TABLE `base_item_cat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `parent_id` bigint(20) NOT NULL COMMENT '父类目ID=0时，代表的是一级的类目',
  `name` varchar(50) NOT NULL COMMENT '类目名称',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态。0-不可用，1-可用',
  `sort_order` int(4) NOT NULL COMMENT '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `parent_flag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '该类目是否为父类目，1-父目录，0-不是父目录',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `index_parent_id` (`parent_id`) USING BTREE,
  KEY `index_sort_order` (`sort_order`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1183 DEFAULT CHARSET=utf8 COMMENT='商品类目';

#商品描述
DROP TABLE IF EXISTS `base_item_desc`;
CREATE TABLE `base_item_desc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `item_desc` text COMMENT '商品描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品描述表';
