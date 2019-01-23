CREATE DATABASE `warehouse_management_system` CHARACTER SET 'utf8';


CREATE TABLE `tbl_user` (
  `id` varchar(20) NOT NULL,
  `we_chat_id` varchar(20) DEFAULT NULL,
  `qq_id` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `idcard` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `head_img` varchar(255) DEFAULT NULL,
  `like_count` int(255) DEFAULT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_select` (`id`,`we_chat_id`,`qq_id`,`telephone`,`username`,`nickname`,`password`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `warehouse_management_system`.`tbl_user` (`id`, `we_chat_id`, `qq_id`, `telephone`, `username`, `nickname`, `password`, `idcard`, `age`, `birthday`, `email`, `create_time`, `head_img`, `like_count`, `status`) VALUES ('1', '2', '3', '15797934717', '万平平', 'Childwanwan', '123', '362329199709100839', '23', '2019-01-08', '1635679119@qq.com', '2019-01-16 20:45:00', '12456', '2', '0');



CREATE TABLE `tbl_warehouse` (
  `id` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `repertory` int(255) NOT NULL,
  `space` int(255) NOT NULL,
  `status` int(5) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `warehouse_management_system`.`tbl_user_warehouse`  (
  `user_id` varchar(20) NOT NULL,
  `warehouse_id` varchar(20) NOT NULL,
  `login_time` datetime(0) NULL,
  `login_ip` varchar(255) NULL,
  `login_address` varchar(255) NULL,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `warehouse_management_system`.`tbl_user` (`id`),
  CONSTRAINT `warehouse_id` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse_management_system`.`tbl_warehouse` (`id`),
	primary key (user_id,warehouse_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_provider` (
  `id` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `telephone` varchar(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_sequence` (
  `id` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_goods` (
  `id` varchar(20) NOT NULL,
  `sequence_id` varchar(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `damaged_condition` int(255) NOT NULL,
  `provider_id` varchar(20) DEFAULT NULL,
  `goods_description` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sequence_id` (`sequence_id`),
  KEY `provider_id` (`provider_id`),
  CONSTRAINT `provider_id` FOREIGN KEY (`provider_id`) REFERENCES `tbl_provider` (`id`),
  CONSTRAINT `sequence_id` FOREIGN KEY (`sequence_id`) REFERENCES `tbl_sequence` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;