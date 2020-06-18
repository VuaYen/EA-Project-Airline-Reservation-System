INSERT INTO `oauth_client_details` (`ID`, `access_token_validity`, `additional_information`, `authorities`, `authorized_grant_types`, `autoapprove`, `client_id`, `client_name`, `client_secret`, `created`, `enabled`, `refresh_token_validity`, `resource_ids`, `scope`, `uuid`, `web_server_redirect_uri`)
VALUES
	(1, 10800, NULL, 'USER', 'password,authorization_code,refresh_token,client_credentials,implicit', NULL, 'cs544-project-client', NULL, '$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', NULL, 1, 2592000, 'resource-server-rest-api', 'read:user,user:id', NULL, 'https://www.getpostman.com/oauth2/callback');

INSERT INTO `account` (`account_type`, `ID`, `email`, `enabled`, `first_name`, `last_name`, `password`, `user_name`)
VALUES
	('ROLE_ADMIN', 1, 'thepham@miu.edu', NULL, 'Admin', 'Mr', '$2b$10$QwKk5pHK1RhFfeFqPiaGx.7XHD/B5Y2LbxtkRJVKVOTZhezdRacwa', 'admin'),
	('ROLE_AGENT', 3, 'yhabtemichael@miu.edu', NULL, 'Yafet', 'Habtem', '$2b$10$QwKk5pHK1RhFfeFqPiaGx.7XHD/B5Y2LbxtkRJVKVOTZhezdRacwa', 'yafet'),
	('ROLE_AGENT', 6, 'aqolta@miu.edu', NULL, 'Andrew', 'Qolta', '$2b$10$QwKk5pHK1RhFfeFqPiaGx.7XHD/B5Y2LbxtkRJVKVOTZhezdRacwa', 'andrew'),
	('ROLE_PASSENGER', 20, 'thepham@miu.edu', NULL, 'Ezra', 'Meadows', '$2b$10$QwKk5pHK1RhFfeFqPiaGx.7XHD/B5Y2LbxtkRJVKVOTZhezdRacwa', 'thepham'),
	('ROLE_AGENT', 21, 'yrteferi@miu.edu', NULL, 'Colby', 'Whitaker', '$2b$10$QwKk5pHK1RhFfeFqPiaGx.7XHD/B5Y2LbxtkRJVKVOTZhezdRacwa', 'robel'),
	('ROLE_PASSENGER', 23, 'ch.nguyen@miu.edu', NULL, 'Alan', 'Ray', '$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', 'chinguyen');