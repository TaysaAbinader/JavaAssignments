DROP DATABASE IF EXISTS Currency;

CREATE DATABASE Currency;
USE Currency;

CREATE TABLE Currency.CurrencyRate (
        CurrencyRateToUSD varchar(3) NOT NULL,
        CurrencyValueToUSD FLOAT DEFAULT 1.0 NOT NULL,
        PRIMARY KEY (CurrencyRateToUSD)
);

INSERT INTO Currency.CurrencyRate (CurrencyRateToUSD, CurrencyValueToUSD) VALUES('USD', 1.0);
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
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

GRANT CREATE ON Currency.* TO 'appuser'@'localhost';
GRANT ALTER ON Currency.* TO 'appuser'@'localhost';
GRANT SELECT ON Currency.* TO 'appuser'@'localhost';
GRANT INSERT ON Currency.* TO 'appuser'@'localhost';
GRANT SHOW VIEW ON Currency.* TO 'appuser'@'localhost';

FLUSH PRIVILEGES;
