-- 1. A statement for dropping the previous version of the database, if it exists.
DROP DATABASE IF EXISTS Currency;

-- 2. A statement for creating the database.
CREATE DATABASE Currency;
USE Currency;

-- 3. A statement for creating a table for storing the Currency objects.
CREATE TABLE Currency.CurrencyRate (
	CurrencyRateToUSD varchar(3) NOT NULL,
	CurrencyValueToUSD FLOAT DEFAULT 1.0 NOT NULL,
	PRIMARY KEY (CurrencyRateToUSD)
);

-- 4. Statements for populating the table with data. You should include at least eight currencies with up-to-date exchange rates in the table.
INSERT INTO Currency.CurrencyRate (CurrencyRateToUSD, CurrencyValueToUSD) VALUES('USD', 0.8541);
INSERT INTO Currency.CurrencyRate (CurrencyRateToUSD, CurrencyValueToUSD) VALUES('BRL', 5.3375);
INSERT INTO Currency.CurrencyRate (CurrencyRateToUSD, CurrencyValueToUSD) VALUES('GBP', 0.7462);
INSERT INTO Currency.CurrencyRate (CurrencyRateToUSD, CurrencyValueToUSD) VALUES('JPY', 149.4540);
INSERT INTO Currency.CurrencyRate (CurrencyRateToUSD, CurrencyValueToUSD) VALUES('CHF', 0.7975);
INSERT INTO Currency.CurrencyRate (CurrencyRateToUSD, CurrencyValueToUSD) VALUES('CNY', 7.1323);
INSERT INTO Currency.CurrencyRate (CurrencyRateToUSD, CurrencyValueToUSD) VALUES('KRW', 1409.4600);
INSERT INTO Currency.CurrencyRate (CurrencyRateToUSD, CurrencyValueToUSD) VALUES('ZAR', 17.3288);
INSERT INTO Currency.CurrencyRate (CurrencyRateToUSD, CurrencyValueToUSD) VALUES('EUR', 0.8541);

-- 5. A statement for dropping the user account appuser, if it exists.
DROP USER IF EXISTS 'appuser'@'localhost';

-- 6. A statement for creating the user account appuser.
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'changeme';

-- 7. Statements for granting the privileges to the user account appuser.
GRANT SELECT ON Currency.CurrencyRate TO 'appuser'@'localhost';
GRANT SHOW VIEW ON Currency.* TO 'appuser'@'localhost';

FLUSH PRIVILEGES;
