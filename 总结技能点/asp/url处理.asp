<%@ LANGUAGE = VBScript %>
<!-- #include file="../inc/md5.asp" -->
<script language="JScript" runat="Server">
      function toObject(json) {
            return eval("("+json+")");
      }
</script>
<%
Function GetHttpPage(Url,CharType)
      'On Error Resume Next
      Dim curlpath : curlpath = Mid(Url,1,Instr(8, Url, "/"))
      Dim Http : Set Http=Server.CreateObject("Microsoft.XMLHTTP")  ' Microsoft.XMLHTTP  - MSXML2.ServerXMLHTTP
      Http.Open "Get", Url, False, "", ""
        Http.setRequestHeader "Referer", curlpath
      Http.Send()
      'Response.write Http.ResponseBody
      If Http.readystate<>4 Then GetHttpPage = "" : Exit Function
      GetHttpPage = BytesToBstr(Http.ResponseBody, CharType)
      Set Http = Nothing
      If Err then GetHttpPage = "" : Err.Clear
      'Response.write GetHttpPage
End Function
Function BytesToBstr(Body,Cset)
      Dim ObjStream : Set ObjStream = Server.CreateObject("ADODB.Stream")
      ObjStream.Type = 1
      ObjStream.Mode =3
      ObjStream.Open
      ObjStream.Write Body
      ObjStream.Position = 0
      ObjStream.Type = 2
      ObjStream.Charset = Cset
      BytesToBstr = ObjStream.ReadText
      ObjStream.Close : Set ObjStream = Nothing
End Function
'参数
sbs_id="103388888888888"
card_no=""
type1=1
sdate=request("sdate")
edate=request("edate")
page=request("page")
tm= DateDiff("s", "1970-1-1 8:00:00", Now())
private_key="adcdd57a39ecd6454eb35dc35b351c27"
sign=LCase(MD5(sbs_id&card_no&type1&sdate&edate&page&tm&private_key))
url="http://api.huitouke.cn/view_invoice?sbs_id="&sbs_id&"&card_no="&card_no&"&type="&type1&"&sdate="&sdate&"&edate="&edate&"&page="&page&"&t="&tm&"&sign="&sign
'转义字符处理
wstr=GetHttpPage(url,"utf-8")
'转成json对象
set obj=toObject(wstr)
set data=obj.data
'过滤信息

'response.write "{num:0}"
%>