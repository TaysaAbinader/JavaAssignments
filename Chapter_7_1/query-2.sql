-- 2. A query that retrieves the currency with the abbreviation EUR (or other abbreviation, if you don't have EUR in your database).

SELECT * FROM Currency.CurrencyRate WHERE CurrencyRateToUSD = 'EUR';
