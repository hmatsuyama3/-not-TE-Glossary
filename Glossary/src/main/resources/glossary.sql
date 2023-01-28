CREATE TABLE terms(
term_id serial PRIMARY KEY,
term varchar(100) NOT NULL,
definition varchar(1000));

CREATE TABLE unit(
unit_id serial PRIMARY KEY,
unit varchar(100) NOT NULL);

CREATE TABLE term_unit(
term_id int,
unit_id int,
CONSTRAINT fk_term
	FOREIGN KEY(term_id)
	REFERENCES terms(term_id),
CONSTRAINT fk_unit
	FOREIGN KEY(unit_id)
	REFERENCES unit(unit_id));

COPY terms(term, definition)
FROM 'C:\Users\hxm10\Documents\GitHub\-not-TE-Glossary\Glossary\src\main\resources\Mod2_term_table.csv'
DELIMITER ','
CSV HEADER;

COPY unit(unit)
FROM 'C:\Users\hxm10\Documents\GitHub\-not-TE-Glossary\Glossary\src\main\resources\Mod2_unit_table.csv'
DELIMITER ','
CSV HEADER;

COPY term_unit(term_id, unit_id)
FROM 'C:\Users\hxm10\Documents\GitHub\-not-TE-Glossary\Glossary\src\main\resources\Mod2_term_unit_table.csv'
DELIMITER ','
CSV HEADER;