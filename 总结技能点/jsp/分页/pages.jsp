<%@page pageEncoding="gbk"%>
						<%if(pageCount>0){%>
						<div class="pages">
							<%
							int showPageNO=5;//��ʾ�����ҳ��
							//����ҳ��ķ�Χ
							int beginNO=0;//��ʼҳ��
							int endNO=0;//����ҳ��
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
							if(pageNO<=1)out.print("��һҳ");
							else out.print("<a href='javascript:changePage("+(pageNO-1)+");'>��һҳ</a>");
							for(int i=beginNO;i<=endNO;i++)
								if(i==pageNO)out.print("<a style='font-weight:bold;color:#f00;'>"+i+"</a>");
								else out.print("<a href='javascript:changePage("+i+");'>"+i+"</a>");
							if(pageNO>=pageCount)out.print("��һҳ");
							else out.print("<a href='javascript:changePage("+(pageNO+1)+");'>��һҳ</a>");
							%>
							<input type="hidden" id="pageCount" value="<%=pageCount %>"/>
							��<%=pageCount %>ҳ&nbsp;&nbsp;
							ת����&nbsp;<input class="pageNO" id="txt_pageNO" type="text" maxlength="3" onkeydown="if(event.keyCode==13)checkPageNO()"/>&nbsp;ҳ
							<a href="javascript:checkPageNO();">��ѯ</a>
						</div>
						<script>
							//���ҳ������
							function checkPageNO(){
								var pageNO=parseInt(document.getElementById("txt_pageNO").value);
								if(isNaN(pageNO)){
									document.getElementById("txt_pageNO").select();
									alert("��������������");
									return;
								}
								var pageCount=parseInt(document.getElementById("pageCount").value);
								if(pageNO<1||pageNO>pageCount){
									document.getElementById("txt_pageNO").select();
									alert("������Χ�����������룡");
									return;
								}
								changePage(pageNO);
							}
						</script>
						<%}%>