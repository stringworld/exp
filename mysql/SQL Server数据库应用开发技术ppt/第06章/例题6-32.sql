CREATE TABLE 用户表(
	id int IDENTITY(100,1) NOT NULL PRIMARY KEY,
	用户名 varchar(11)  NOT NULL,
	密码 varchar(10)  NOT NULL,
	用户类型 varchar(20)  NULL,
)

