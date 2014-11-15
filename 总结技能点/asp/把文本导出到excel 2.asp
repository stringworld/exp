<%
function exportExcel(thead,tbody,trsp,tdsp)
	Set fs = server.CreateObject("scripting.filesystemobject")
	'--文件名
	filename="export.xls"
	filepath=server.MapPath("./")&"\"+filename
	'--如果原来的EXCEL文件存在的话删除它
	if fs.FileExists(filepath) then
		fs.DeleteFile(filepath)
	end if
	set myfile = nothing
	Set xlApplication = Server.CreateObject("Excel.Application")
	xlApplication.Visible = False
	xlApplication.Workbooks.Add
	Set xlWorksheet = xlApplication.Worksheets(1)
	'--将表的列名先写入EXCEL
	ths=split(thead,tdsp)
	for i=0 to ubound(ths)
		xlWorksheet.Cells(i+1).NumberFormatLocal = "@" '处理为文本格式
		xlWorksheet.Cells(1,i+1).Value=ths(i)
	next
	'--每一行信息
	trs=split(tbody,trsp)
	for i=0 to ubound(trs)
		tds=split(trs(i),tdsp)
		for j=0 to ubound(tds)
			xlWorksheet.Cells(j+1).NumberFormatLocal = "@" '处理为文本格式
			xlWorksheet.Cells(i+2,j+1).Value="'"&tds(j)
		next
	next
	xlWorksheet.Cells.EntireColumn.AutoFit '自动调整列宽
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