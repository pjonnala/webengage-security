create table employee ( 
    emp_id int(11) not null  auto_increment,
	password varchar(45) not null,
	name varchar(35) not null,
	title varchar(30) not null,
	location varchar (50) not null,
	email varchar (50) not null,
	work_phone  varchar(30) not null, 
	home_phone varchar (12),
	cell_phone varchar (12),
	add_ts timestamp,
	upd_ts timestamp default 0,
	active tinyint(1) not null default 1,	
primary key(emp_id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `employee_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  KEY `emp_id_fk_idx` (`emp_id`),
  CONSTRAINT `emp_id_fk` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `hrmsdb`.`employee` (`password`, `name`, `title`, `location`, `email`, `work_phone`, `home_phone`, `cell_phone`, `active`) 
VALUES ('default password', 'Joan Rivers', 'HR Analyst', 'Houston,Texas', 'jrivers@webengage.com', '281-220-2123', '281-675-5642', '281-341-2345', '1');


INSERT INTO `hrmsdb`.`employee` (`password`, `name`, `title`, `location`, `email`, `work_phone`, `home_phone`, `cell_phone`, `active`) 
VALUES ('default password', 'Janis Joplin', 'HR Analyst', 'Houston,Texas', 'jjoplin@webengage.com', '281-215-3456', '281-675-5642', '281-341-3456', '1');

INSERT INTO `hrmsdb`.`employee` (`password`, `name`, `title`, `location`, `email`, `work_phone`, `home_phone`, `cell_phone`, `active`) 
VALUES ('default password', 'Rober Redford', 'HR Benefits Coordinator', 'Austin,Texas', 'rredford@webengage.com', '512-215-3456', '512-675-5642', '512-341-3456', '1');

INSERT INTO `hrmsdb`.`employee` (`password`, `name`, `title`, `location`, `email`, `work_phone`, `home_phone`, `cell_phone`, `active`) 
VALUES ('default password', 'Jack Freeman', 'Marketing Specialist', 'Austin,Texas', 'mfreeman@webengage.com', '512-787-3456', '512-787-5642', '512-787-4642', '1');

INSERT INTO `hrmsdb`.`employee` (`password`, `name`, `title`, `location`, `email`, `work_phone`, `home_phone`, `cell_phone`, `active`) 
VALUES ('default password', 'Morgan Freeman', 'Creative Director', 'Los Angeles,Californis', 'mfreeman@webengage.com', '310-215-3456', '310-675-5642', '310-341-3456', '1');

INSERT INTO `hrmsdb`.`employee` (`password`, `name`, `title`, `location`, `email`, `work_phone`, `home_phone`, `cell_phone`, `active`) 
VALUES ('default password', 'Stanley Kubrick', 'Film Director', 'Stamford,Connecticut', 'skubrick@webengage.com', '203-215-3456', '203-675-5642', '203-341-3456', '1');

INSERT INTO `hrmsdb`.`employee_role` (`emp_id`, `role`) VALUES ('5', 'ROLE_HR');
INSERT INTO `hrmsdb`.`employee_role` (`emp_id`, `role`) VALUES ('6', 'ROLE_HR');
INSERT INTO `hrmsdb`.`employee_role` (`emp_id`, `role`) VALUES ('7', 'ROLE_HR');
INSERT INTO `hrmsdb`.`employee_role` (`emp_id`, `role`) VALUES ('8', 'ROLE_USER');
INSERT INTO `hrmsdb`.`employee_role` (`emp_id`, `role`) VALUES ('9', 'ROLE_USER');
INSERT INTO `hrmsdb`.`employee_role` (`emp_id`, `role`) VALUES ('10', 'ROLE_USER');
INSERT INTO `hrmsdb`.`employee_role` (`emp_id`, `role`) VALUES ('11', 'ROLE_USER');
