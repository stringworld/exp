declare @nowkuid int,@nowku nvarchar(200)
select @nowku='华东总库'
select @nowkuid=id from ku where ku=@nowku
--删除不属于总库的商品
delete from produit where id not in(select p.id from produit p left join ku k on p.id_ku=k.id where ku=@nowku)
--初始化商品数量
update produit set shulian=1000
--初始化调拨表
truncate table diaobo
--添加调拨记录:从华东总库调拨到其他库
declare @minpid int,@maxpid int,@minkid int,@maxkid int,@pi int,@ki int,@shulian int
select @minpid=min(id),@maxpid=max(id) from produit
select @minkid=min(id),@maxkid=max(id) from ku
select @pi=@minpid,@shulian=10
while @pi<=@maxpid begin
	declare @pid int,@id_bigclass int,@id_smallclass int,@title nvarchar(200),@huohao nvarchar(200),@danwei nvarchar(200)
	declare @price float,@price2 float,@guige nvarchar(200),@baojin int,@class int,@duihuan int,@tichen_type int,@tichen float
	declare @photo nvarchar(200),@beizhu nvarchar(4000)
	select @pid=0
	select @pid=id,@id_bigclass=id_bigclass,@id_smallclass=id_smallclass,@title=title,@huohao=huohao,@danwei=danwei,@price=price,@price2=price2,@guige=guige,@baojin=baojin,@class=class,@duihuan=duihuan,@tichen_type=tichen_type,@tichen=tichen,@photo=photo,@beizhu=convert(nvarchar(4000),beizhu) from produit where id=@pi
	--判断该id的商品是否存在
	if @pid<>0 begin
		select @ki=@minkid
		while @ki<=@maxkid begin
			declare @kid int,@bigclass nvarchar(200),@smallclass nvarchar(200),@ku_ru nvarchar(200)
			select @kid=0
			select @kid=id,@ku_ru=ku from ku where ku!=@nowku and id=@ki
			--判断该id并且名称不是“华东总库”的仓库是否存在
			if @kid<>0 begin
				select @bigclass=bigclass from bigclass where id=@id_bigclass
				select @smallclass=smallclass from smallclass where id=@id_smallclass
				--添加该仓库商品
				insert into produit(id_bigclass,id_smallclass,title,huohao,id_ku,shulian,danwei,price,price2,guige,baojin,class,duihuan,tichen_type,tichen,photo,beizhu)values(@id_bigclass,@id_smallclass,@title,@huohao,@kid,@shulian,@danwei,@price,@price2,@guige,@baojin,@class,@duihuan,@tichen_type,@tichen,@photo,@beizhu)
				--总库数量减少
				update produit set shulian=shulian-@shulian where id=@pid
				--添加调拨记录
				insert into diaobo(status,id_produit,bigclass,smallclass,title,huohao,id_ku_chu,ku_chu,id_ku_ru,ku_ru,shulian,guige,id_login,login,type,selldate,price,price2,photo,bianhao)values(3,@pid,@bigclass,@smallclass,@title,@huohao,@nowkuid,@nowku,@kid,@ku_ru,@shulian,@guige,1,'连威',0,convert(varchar(100),getdate(),23),@price,@price2,@photo,replace(replace(replace(replace(replace(CONVERT(varchar(100), GETDATE(), 21),':',''),' ',''),'-',''),'/',''),'.','')+substring(convert(varchar(100),rand()),3,5))
			end
			select @ki=@ki+1
		end
	end
	select @pi=@pi+1
end
go

select count(*) from produit;