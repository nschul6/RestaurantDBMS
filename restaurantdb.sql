Use restaurantdb;  

set foreign_key_checks=0;

Create TABLE restaurant(
id int NOT NULL,
restaurant_name VARCHAR(255) NOT NULL,
address VARCHAR(255) NOT NULL,
phone VARCHAR(255) NOT NULL,
mgr_ssn VARCHAR(9) NOT NULL,
PRIMARY KEY (id));

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


Create TABLE order_(
id int NOT NULL,
table_id INT NOT NULL,
item_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (table_id) REFERENCES table_(id),
FOREIGN KEY (item_id) REFERENCES food_item(id));


Create TABLE food_item(
id int NOT NULL,
_name VARCHAR(255) NOT NULL,
category VARCHAR(255) NOT NULL,
price DECIMAL(5,2) NOT NULL,
season VARCHAR(255) NOT NULL,
supplier_id VARCHAR(255) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (supplier_id) REFERENCES supplier(id));


Create TABLE employee(
id int NOT NULL,
_name VARCHAR(255) NOT NULL,
ssn VARCHAR(9) NOT NULL,
date_of_hire DATE NOT NULL,
hours DECIMAL(4,2) NOT NULL,
_position VARCHAR(255) NOT NULL,
wage DECIMAL(5,2) NOT NULL,
PRIMARY KEY (id));


set foreign_key_checks=1;


