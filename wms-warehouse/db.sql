CREATE TABLE `tbl_warehouse` (
  `id` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `repertory` int(255) NOT NULL,
  `space` int(255) NOT NULL,
  `status` int(5) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;