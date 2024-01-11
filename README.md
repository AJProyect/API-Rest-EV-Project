Hi! This is my Inditex Evaluation Backend Project.
The App is an API REST with a single controller, you can acces to it with url: /api/products/filtered?salesWeight={double}&stockWeight={double}

I´ve created this app following the Hex-arquitecture and DDD.
Here's de MongoDB Collection I've based on:
id | name | sales_units | stock
1 | V-NECH BASIC SHIRT | 100 | S: 4 / M:9 / L:0

For entities I've created Product wich is the main, and Stock as an aggregation.

There's 3 test created: Unitary, Integration and E2E with rest reassured.
