declare @ѧʱ tinyint
declare @ѧ�� tinyint
set  @ѧʱ= 64
set  @ѧ�� = 
case floor(@ѧʱ/30)
    when 1 then  1
    when 2 then  2
    when 3 then  3
    when 4 then  4
    when 5 then  5
    else  0
end
print @ѧ�� 