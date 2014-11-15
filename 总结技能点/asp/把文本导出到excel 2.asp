<%
function exportExcel(thead,tbody,trsp,tdsp)
	Set fs = server.CreateObject("scripting.filesystemobject")
	'--�ļ���
	filename="export.xls"
	filepath=server.MapPath("./")&"\"+filename
	'--���ԭ����EXCEL�ļ����ڵĻ�ɾ����
	if fs.FileExists(filepath) then
		fs.DeleteFile(filepath)
	end if
	set myfile = nothing
	Set xlApplication = Server.CreateObject("Excel.Application")
	xlApplication.Visible = False
	xlApplication.Workbooks.Add
	Set xlWorksheet = xlApplication.Worksheets(1)
	'--�����������д��EXCEL
	ths=split(thead,tdsp)
	for i=0 to ubound(ths)
		xlWorksheet.Cells(i+1).NumberFormatLocal = "@" '����Ϊ�ı���ʽ
		xlWorksheet.Cells(1,i+1).Value=ths(i)
	next
	'--ÿһ����Ϣ
	trs=split(tbody,trsp)
	for i=0 to ubound(trs)
		tds=split(trs(i),tdsp)
		for j=0 to ubound(tds)
			xlWorksheet.Cells(j+1).NumberFormatLocal = "@" '����Ϊ�ı���ʽ
			xlWorksheet.Cells(i+2,j+1).Value="'"&tds(j)
		next
	next
	xlWorksheet.Cells.EntireColumn.AutoFit '�Զ������п�
	xlWorksheet.SaveAs filepath
	xlApplication.Quit
	Set xlWorksheet = Nothing
	Set xlApplication = Nothing
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