use BMS;
delimiter $$
drop procedure if exists p1 $$
create procedure p1(out a1 int ,out a2 int ,out b1 int ,out b2 int ,out o1 int ,out o2 int ,out ab1 int ,out ab2 int )
begin

set a1 = (select count(*) from New_Donor where Blood_Group = "A+") ;
set a2 = (select count(*) from New_Donor where Blood_Group = "A-") ;
set b1 = (select count(*) from New_Donor where Blood_Group = "B+") ;
set b2 = (select count(*) from New_Donor where Blood_Group = "B-") ;
set o1 = (select count(*) from New_Donor where Blood_Group = "O+") ;
set o2 = (select count(*) from New_Donor where Blood_Group = "O-") ;
set ab1 = (select count(*) from New_Donor where Blood_Group = "AB+") ;
set ab2 = (select count(*) from New_Donor where Blood_Group = "AB-") ;


end $$
delimiter ;