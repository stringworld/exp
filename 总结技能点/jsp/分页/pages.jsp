<%@page pageEncoding="gbk"%>
						<%if(pageCount>0){%>
						<div class="pages">
							<%
							int showPageNO=5;//显示的最大页数
							//计算页码的范围
							int beginNO=0;//起始页码
							int endNO=0;//结束页码
							if(pageCount>showPageNO){
								if(pageNO>pageCount-showPageNO/2){
									beginNO=pageCount-showPageNO+1;
									endNO=pageCount;
								}else if(pageNO>showPageNO/2){
									beginNO=pageNO-(showPageNO-1)/2;
									endNO=pageNO+showPageNO/2;
								}else{
									beginNO=1;
									endNO=showPageNO;
								}
							}else{
								beginNO=1;
								endNO=pageCount;
							}
							if(pageNO<=1)out.print("上一页");
							else out.print("<a href='javascript:changePage("+(pageNO-1)+");'>上一页</a>");
							for(int i=beginNO;i<=endNO;i++)
								if(i==pageNO)out.print("<a style='font-weight:bold;color:#f00;'>"+i+"</a>");
								else out.print("<a href='javascript:changePage("+i+");'>"+i+"</a>");
							if(pageNO>=pageCount)out.print("下一页");
							else out.print("<a href='javascript:changePage("+(pageNO+1)+");'>下一页</a>");
							%>
							<input type="hidden" id="pageCount" value="<%=pageCount %>"/>
							共<%=pageCount %>页&nbsp;&nbsp;
							转到第&nbsp;<input class="pageNO" id="txt_pageNO" type="text" maxlength="3" onkeydown="if(event.keyCode==13)checkPageNO()"/>&nbsp;页
							<a href="javascript:checkPageNO();">查询</a>
						</div>
						<script>
							//检查页码输入
							function checkPageNO(){
								var pageNO=parseInt(document.getElementById("txt_pageNO").value);
								if(isNaN(pageNO)){
									document.getElementById("txt_pageNO").select();
									alert("请输入正整数！");
									return;
								}
								var pageCount=parseInt(document.getElementById("pageCount").value);
								if(pageNO<1||pageNO>pageCount){
									document.getElementById("txt_pageNO").select();
									alert("超出范围，请重新输入！");
									return;
								}
								changePage(pageNO);
							}
						</script>
						<%}%>