# Online Store: eMart and eDepot.
#### By Michael Glushchenko, partnered with Matthew Aragaw, for UCSB CS174A Spring 2022.

Oracle Database implementation of an online store/warehouse. Provides separate interfaces for customers and managers to interact with the eMart database. At key points in the interactions, Matthew's eDepot database is queried for various information.<br />
I worked on the eMart database, as well as the interfaces for customers and managers to interact with the store.<br />

Functionality of the customer interface includes:<br />
  - logging in with their credentials.
  - creating an account if they have no credentials yet.
  - searching through the product catalog by category or name.
  - adding a variable quantity of some item to cart.
  - checking out (completing an order).
  - displaying the previous order for the customer.
  - re-running a previous order.
Functionality of the manager interface includes:<br />
  - logging in with their credentials.
  - print monthly summary of sales statements.
  - adjust customer status according to policy or personal decision.
  - send an order to a manufacturer (who would then send the requested order to Matthew's eDepot warehouse).
  - change the price of an item.
  - delete all sales transactions that are no longer needed for computation of customer status.
Technologies:
  - Database: Oracle.
    - ojdbc11 version 21.5.0.0.<br />
  - Backend: Java.
    - openjdk 18.0.1.1.<br />
  - Build automation tool: Maven Apache.
    - maven-compiler 18.
    - tomcat7-maven-plugin 2.2.

Michael Glushchenko &copy; 2022
