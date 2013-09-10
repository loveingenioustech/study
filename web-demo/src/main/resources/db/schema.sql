drop user web_demo cascade;
create user web_demo identified by web_demo temporary tablespace temp;
grant connect,resource to web_demo;
grant dba to web_demo;
grant drop any table to web_demo with admin option;
alter user web_demo default tablespace users;
alter user web_demo quota unlimited on users;
