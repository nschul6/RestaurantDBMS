Use restaurantdb; 

set foreign_key_checks=0;/*foreign key checks are for initializing tables
 of a new database*/

Create TABLE restaurant(
id int NOT NULL,
restaurant_name VARCHAR(255) NOT NULL,
address VARCHAR(255) NOT NULL,
phone VARCHAR(255) NOT NULL,
mgr_ssn VARCHAR(9) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (mgr_ssn) REFERENCES manager(ssn));

Create TABLE supplier(
id int NOT NULL,
supplier_name VARCHAR(255) NOT NULL,
address VARCHAR(255) NOT NULL,
phone VARCHAR(255) NOT NULL,
PRIMARY KEY (id));

Create TABLE table_(
id int NOT NULL,
size INT NOT NULL,
waiter_id INT NOT NULL,
num_people INT NOT NULL,
PRIMARY KEY (id));

Create TABLE check_ (
check_id int NOT NULL,
table_id INT NOT NULL,
total DECIMAL(6,2) NOT NULL,
PRIMARY KEY (id));


Create TABLE order_(
id int NOT NULL,
check_id INT NOT NULL,
item_id INT NOT NULL,
PRIMARY KEY (id));

Create TABLE drink_order(
id int NOT NULL,
check_id INT NOT NULL,
drink_id INT NOT NULL,
scan_id INT NOT NULL,
PRIMARY KEY (id));


Create TABLE bar(
id int NOT NULL,
PRIMARY KEY(id));


Create TABLE bartender(
id int NOT NULL,
PRIMARY KEY (id));

Create TABLE bar_tab(
id int NOT NULL,
last_name VARCHAR(255) NOT NULL,
Scan_ID VARCHAR(255) NOT NULL,
credit_card_no VARCHAR(16) NOT NULL,
total DECIMAL(6,2) NOT NULL,
PRIMARY KEY (id));

Create TABLE waiting_list(
id int NOT NULL,
party_size INT NOT NULL,
num_high_chairs INT NOT NULL,
last_name VARCHAR(255) NOT NULL,
entry_time TIMESTAMP NOT NULL,
quoted_time TIMESTAMP NOT NULL,
status VARCHAR(255) NOT NULL,
PRIMARY KEY (id));


Create TABLE menu(
id int NOT NULL,
_name VARCHAR(255) NOT NULL,
category VARCHAR(255) NOT NULL,
price DECIMAL(5,2) NOT NULL,
season VARCHAR(255) NOT NULL,
supplier_id VARCHAR(255) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (supplier_id) REFERENCES supplier(id));

Create TABLE drink_item(
id int NOT NULL,
_name VARCHAR(255) NOT NULL,
category VARCHAR(255) NOT NULL,
price DECIMAL(5,2) NOT NULL,
season VARCHAR(255) NOT NULL,
supplier_id VARCHAR(255) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (season) REFERENCES menu(season),
FOREIGN KEY (supplier_id) REFERENCES supplier(id));


Create TABLE waiter(
id int NOT NULL,
PRIMARY KEY (id));


Create TABLE hostess(
id int NOT NULL,
PRIMARY KEY (id));

Create TABLE employee(
id int NOT NULL,
_name VARCHAR(255) NOT NULL,
ssn VARCHAR(9) NOT NULL,
date_of_hire DATE NOT NULL,
hours DECIMAL(4,2) NOT NULL,
_position VARCHAR(255) NOT NULL,
wage DECIMAL(5,2) NOT NULL,
PRIMARY KEY (id));

Create TABLE employee_login(
id VARCHAR(15) NOT NULL,
user_email VARCHAR(255) NOT NULL,
FOREIGN KEY (id) REFERENCES employee (id),
PRIMARY KEY (id));

set foreign_key_checks=1;

