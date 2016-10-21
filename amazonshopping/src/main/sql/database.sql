
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL,
  `first_name` text NOT NULL,
  `last_name` text NOT NULL,
  `email_add` text NOT NULL,
  `name` text,
  `dob` date DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
  
CREATE TABLE IF NOT EXISTS `bill_address` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `line_1` text NOT NULL,
  `line_2` text,
  `city_name` text NOT NULL,
  `zip_code` text NOT NULL,
  `state_name` text NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `bill_address`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `bill_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


CREATE TABLE IF NOT EXISTS `ship_address` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `line_1` text NOT NULL,
  `line_2` text,
  `city_name` text NOT NULL,
  `zip_code` text NOT NULL,
  `state_name` text NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `ship_address`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `ship_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


CREATE TABLE IF NOT EXISTS `card_info` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `card_no` text NOT NULL,
  `card_type` text,
  `expiry_month` text,
  `code_no` text NOT NULL,
  `full_name` text NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `card_info`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `card_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


CREATE TABLE IF NOT EXISTS `tran_info` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `card_no` text NOT NULL,
  `card_type` text,
  `full_name` text NOT NULL,
  `amount` decimal(11,0) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `tran_info`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `tran_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


CREATE TABLE IF NOT EXISTS `tran_detail` (
  `id` int(11) NOT NULL,
  `tran_info` int(11) NOT NULL,
  `item_name` text,
  `item_qty` int(11),
  `amount` decimal(11,0) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `tran_detail`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `tran_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


CREATE  TABLE users (
  username VARCHAR(64) NOT NULL ,
  password VARCHAR(64) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(64) NOT NULL,
  role varchar(64) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

INSERT INTO users(username,password,enabled)
VALUES ('admin','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);
INSERT INTO users(username,password,enabled)
VALUES ('user','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);

INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('user', 'ROLE_USER');


create table administrator (
	id int auto_increment,
    name varchar(30) not null,
    password varchar(30) not null,
    primary key(id)
);

