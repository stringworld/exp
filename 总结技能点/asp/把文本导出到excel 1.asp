<%
function exportExcel(thead,tbody,trsp,tdsp)
	if trsp="" then
		trsp=chr(13)
	end if
	if tdsp="" then
		tdsp=chr(9)
	end if
	Set fs = server.CreateObject("scripting.filesystemobject")
	'--�ļ���
	filename="export.xls"
	filepath=server.MapPath("./")&"\"+filename
	'--���ԭ����EXCEL�ļ����ڵĻ�ɾ����
	if fs.FileExists(filepath) then
		fs.DeleteFile(filepath)
	end if
	'--����EXCEL�ļ�
	set myfile = fs.CreateTextFile(filepath,true)
	line=""
	'--�����������д��EXCEL
	ths=split(thead,tdsp)
	for i=0 to ubound(ths)
		line=line&ths(i)&chr(9)
	next
	myfile.writeline line
	'--ÿһ����Ϣ
	trs=split(tbody,trsp)
	for i=0 to ubound(trs)
		tds=split(trs(i),tdsp)
		line=""
		for j=0 to ubound(tds)
			line=line&tds(j)&chr(9)
		next
		myfile.writeline line
	next
	set myfile = nothing
	Set fs=nothing
	exportExcel=filename
end function

'thead="demo"
'tbody="a1`a2`a3|b1`b2`b3"
thead=request.form("thead")
tbody=request.form("tbody")
trsp=request.form("trsp")
tdsp=request.form("tdsp")
if trsp="" then
	trsp="|"
end if
if tdsp="" then
	tdsp="`"
end if
if thead="" and tbody="" then
else
	response.redirect exportExcel(thead,tbody,trsp,tdsp)
end if
response.write "<script>window.close();</script>"
%>