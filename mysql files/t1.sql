use BMS;
delimiter $$
drop trigger if exists t1 $$
create trigger t1 before insert on New_Donor for each row 
begin

if new.Donor_No<0 then
	signal SQLSTATE '11111'
		SET MESSAGE_TEXT = 'invalid donor number';
end if;

if (new.Donor_Name is null) or (length(new.Donor_Name)<2) or (not(new.Donor_Name regexp '^[A-Z a-z]+$')) or (length(new.Donor_Name)>30) then
	signal SQLSTATE '22222'
		SET MESSAGE_TEXT = 'invalid donor name';
end if;

if new.Blood_Group not in('A+','A-','B+','B-','O+','O-','AB+','AB-') then
	signal SQLSTATE '33333'
		SET MESSAGE_TEXT = 'invalid donor blood group';
end if;

if  new.Sex not in('Male','Female')  then
	signal SQLSTATE '44444'
		SET MESSAGE_TEXT = 'invalid donor sex';
end if;

if (new.Age < 0) or (new.Age>122) then
	signal SQLSTATE '55555'
		SET MESSAGE_TEXT = 'invalid donor age',Mysql_errno = 100;
		
end if;



if (new.City is null) or (length(new.City)<3) or (not(new.City regexp '^[A-Z a-z]+$')) or (length(new.City)>20) then
	signal SQLSTATE '77777'
		SET MESSAGE_TEXT = 'invalid city name';
end if;

if (new.Mobile < 1000000000) or (new.Mobile > 9999999999) then
	signal SQLSTATE '88888'
		SET MESSAGE_TEXT = 'invalid donor mobile number';
end if;
end $$
delimiter ;



















