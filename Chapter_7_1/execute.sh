#!/bin/sh

# Recreate the Currency database, CurrencyRate table, and 'appuser' user.

mysql -u root < statements.sql

echo "1. A query that retrieves all the currencies from the database."
mysql -u appuser --password=changeme < query-1.sql

echo "2. A query that retrieves the currency with the abbreviation EUR (or other abbreviation, if you don't have EUR in your database)."
mysql -u appuser --password=changeme < query-2.sql

echo "3. A query that retrieves the number of currencies in the database."
mysql -u appuser --password=changeme < query-3.sql

echo "4. A query that retrieves the currency with the highest exchange rate."
mysql -u appuser --password=changeme < query-4.sql
