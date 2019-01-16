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
