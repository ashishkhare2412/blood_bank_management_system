use BMS;
delimiter $$
drop trigger if exists t2 $$
create trigger t2 before insert on Sell_To for each row 
begin

if new.Recipient_No<0 then
	signal SQLSTATE '11111'
		SET MESSAGE_TEXT = 'invalid recipient number';
end if;

if (new.Recipient_Name is null) or (length(new.Recipient_Name)<2) or (not(new.Recipient_Name regexp '^[A-Z a-z]+$')) or (length(new.Recipient_Name)>30) then
	signal SQLSTATE '22222'
		SET MESSAGE_TEXT = 'invalid recipient name';
end if;

if new.Blood_Group not in('A+','A-','B+','B-','O+','O-','AB+','AB-') then
	signal SQLSTATE '33333'
		SET MESSAGE_TEXT = 'invalid recipient blood group';
end if;




if (new.Address is null) or (length(new.Address)<3) or (not(new.Address regexp '^[A-Z a-z]+$')) or (length(new.Address)>20) then
	signal SQLSTATE '55555'
		SET MESSAGE_TEXT = 'invalid recipient address';
end if;

if (new.Mobile < 1000000000) or (new.Mobile > 9999999999) then
	signal SQLSTATE '66666'
		SET MESSAGE_TEXT = 'invalid recipient mobile number',mysql_errno = 101;
end if;
end $$
delimiter ;



















