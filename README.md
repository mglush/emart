# SQL Database Design of an Online Store.
#### By Michael Glushchenko, for UCSB CS174A Spring 2022 (Database Management Systems).
###### Partnered with Matthew Aragaw.
Oracle Database implementation of an online store/warehouse system. The project provides separate interfaces for customers and managers to interact with the eMart database. At key points in the interactions, Matthew's eDepot database is queried for various information. 

I worked on the eMart database, as well as the interfaces for customers and managers to interact with the store. These are supposed to be alternate ways to login into the website and interract with the product (as opposed to loggin in as a vendor and seeing the warehouse interface). 

## Table of Contents.
* [How To Run](https://github.com/mglush/emart/blob/main/README.md#how-to-run)
* [Customer Interface Functionality](https://github.com/mglush/emart/blob/main/README.md#customer-interface-functionality)
* [Manager Interface Functionality](https://github.com/mglush/emart/blob/main/README.md#manager-interface-functionality)
* [eMart Database Functionality](https://github.com/mglush/emart/blob/main/README.md#emart-database-functionality)
* [Technologies Used](https://github.com/mglush/emart/blob/main/README.md#technologies-used)

## How to Run
~~~
git clone git@github.com:mglush/emart.git     # clone repository.
cd emart                                      # enter repository folder.
mvn clean && mvn tomcat7:run                  # run the store on localhost
~~~
You can then access the website login page at http://localhost:8080/emart or http://localhost:8080/emart/index.html

## Customer Interface Functionality
  - log in with credentials.
  - create an account if user not yet a customer.
  - search through the product catalog by category by any criteria.
  - add products to cart (for checkout later).
  - check out (comeplete an order with products in the cart).
  - display the previous order for the customer.
  - re-run a previous order for a given customer.

## Manager Interface Functionality
  - log in with credentials.
  - print monthly summary of sales statements.
  - adjust customer status (bypassing company policy) *(not yet implemented)*.
  - send an order to a manufacturer (bypassing company policy) *(not yet implemented)*.
  - change the price of an item (bypassing company policy).
  - delete all sales transactions that are no longer needed for computation of customer status.

## eMart Database Functionality
  - automatically recomputes customer status according to their order history.
  - automatically sends a replenishment request to a manufacturer when there are 3 low-inventory items in the store made by that manufacturer.
  - allows for the change of company policy regarding how much discount to give to customers of certain status.
  - keeps data of all orders and when each item was added to cart within that order, to properly apply company policy to correct timeframes.

## Technologies Used
  - Database: Oracle.
    - ojdbc11 21.5.0.0.<br />
  - Backend: Java.
    - openjdk 18.0.1.1.<br />
  - Build automation tool: Maven Apache.
    - maven-compiler 18.
    - tomcat7-maven-plugin 2.2.

Michael Glushchenko &copy; 2022
