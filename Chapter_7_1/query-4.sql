-- 4. A query that retrieves the currency with the highest exchange rate.

SELECT * FROM Currency.CurrencyRate ORDER BY CurrencyValueToUSD DESC LIMIT 1;
