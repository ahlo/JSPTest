create database if not exists mydb;

use mydb;

drop table if exists posts;

CREATE TABLE `posts` (
    `post_id` INT(11) NOT NULL UNIQUE AUTO_INCREMENT,
    `post_name` VARCHAR(45) NOT NULL,
    `post_type` VARCHAR(45) NOT NULL,
    `post_price` VARCHAR(45) NOT NULL,
    `post_description` VARCHAR(100) DEFAULT NULL,
    `post_creation_date` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`post_id`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;

INSERT INTO `posts`
	(
		`post_name`,
        `post_type`,
        `post_price`,
        `post_description`,
        `post_creation_date`
	)
VALUES
	(
		'Xbox',
        'Games',
        '300.00',
        'Mint Condition',
        null
    );
INSERT INTO `posts`(`post_name`,`post_type`,`post_price`,`post_description`,`post_creation_date`)VALUES('PS3', 'Offer', '400.00', 'Excellent Condition', null);


DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_insert_post`$$

CREATE DEFINER=`admin`@`localhost` PROCEDURE `sp_insert_post`
	(
		IN p_post_name VARCHAR(45),
		IN p_post_type VARCHAR(45),
        IN p_post_price VARCHAR(45),
        IN p_post_description VARCHAR(1000),
        IN p_creation_date VARCHAR(45)     
	)
BEGIN
	INSERT INTO posts
		(
			post_name,
            post_type,
            post_price,
            post_description,
            post_creation_date
		)
	VALUES
		(
			p_post_name,
            p_post_type,
            p_post_price,
            p_post_description,
            p_creation_date
		);
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_get_last_post_id`$$

CREATE DEFINER=`admin`@`localhost` PROCEDURE `sp_get_last_post_id`()
BEGIN
	SELECT post_id FROM posts ORDER BY post_id DESC LIMIT 1;
END$$
DELIMITER ;
