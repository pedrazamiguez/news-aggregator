-- Connect to MySQL server as root.
-- > mysql -uroot -p

-- Enter the root password.
-- >

-- Create database.
CREATE DATABASE newsaggregator character set utf8mb4 collate utf8mb4_bin;

-- Create user.
CREATE USER 'newsaggregator'@'%' IDENTIFIED BY 'ic9d3L!Hq^54';

-- Grant privileges.
GRANT ALL PRIVILEGES ON newsaggregator.* TO 'newsaggregator'@'%';

-- Apply changes.
FLUSH PRIVILEGES;
