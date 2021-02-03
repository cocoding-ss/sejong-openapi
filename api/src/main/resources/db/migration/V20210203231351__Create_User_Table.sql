USE `sejong_openapi`;

CREATE TABLE IF NOT EXISTS `users` (
    `user_id` BIGINT NOT NULL AUTO_INCREMENT,

    `email` VARCHAR(255) NOT NULL,
    `stdNum` VARCHAR(255) NOT NULL,
    `stdDepartment` VARCHAR(255) NOT NULL,

    `clientId` VARCHAR(255) NOT NULL,
    `clientSecret` VARCHAR(255) NOT NULL,

    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME DEFAULT NULL,
    `deleted_at` DATETIME DEFAULT NULL,
    `created_by` BIGINT DEFAULT NULL,
    `updated_by` BIGINT DEFAULT NULL,

    PRIMARY KEY (`user_id`)
);

CREATE INDEX `email_index` ON `users` (`email`);
CREATE INDEX `stdNum_index` ON `users` (`stdNum`);

CREATE INDEX `keypair_index` ON `users` (`clientId`, `clientSecret`);
