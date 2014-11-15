declare @学时 tinyint
declare @学分 tinyint
set  @学时= 64
set  @学分 = 
case floor(@学时/30)
    when 1 then  1
    when 2 then  2
    when 3 then  3
    when 4 then  4
    when 5 then  5
    else  0
end
print @学分 