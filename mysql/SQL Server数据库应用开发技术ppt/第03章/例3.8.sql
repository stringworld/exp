declare  @职称nchar(3)
declare  @计酬int
set @职称= '讲师'
set @计酬= 
case 
    when @职称='教授' then 45
    when @职称='副教授' then 40
    when @职称='讲师' then 35
    when @职称='助教' then 30
end
print @计酬