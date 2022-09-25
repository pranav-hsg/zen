use employee;
drop table employee_details;
CREATE TABLE IF NOT EXISTS employee_details(
 `version` int NOT NULL default 0,
   `id` BIGINT NOT NULL AUTO_INCREMENT ,
        `employee_id` VARCHAR(100) NOT NULL,
            `employee_name` varchar(45) NOT NULL,
              `employee_phone` varchar(256) NULL DEFAULT NULL ,
                   `employee_address`  varchar(100) default NULL,
                         `created_date` datetime NOT NULL,
                           `created_by` varchar(45) NOT NULL,
                              `last_modified_date` datetime default NULL,
                                 `last_modified_by` varchar(45) default NULL,
                                    PRIMARY KEY (`id`)  )ENGINE=InnoDB;
INSERT INTO `employee`.`employee_details` (`version`, `id`, `employee_id`, `employee_name`, `employee_phone`, `employee_address`, `created_date`, `created_by`) VALUES ('0', '1', '12', 'Shobha', '9486656321', 'koramangala 2nd stage', '2021-10-12 15:34:50', 'MILLER');
