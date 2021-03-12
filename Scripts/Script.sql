-- 계정권한 부여
	grant all
	on native_jdbc.* 
	to 'user_erp'@'localhost' identified by 'rootroot';
	
	grant File
	on *.*
	to 'user_erp'@'localhost';