<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
		
	}
</SCRIPT>
<div class="pager">
	<s:a href="javascript:to_page('%{pList.firstpage}')">首页</s:a>
	<s:a href="javascript:to_page('%{pList.prepage}')">上一页</s:a>
	<s:iterator begin="%{pList.begin}" end="%{pList.end}" var="i">
		<s:a href="javascript:to_page('%{i}')">${i}</s:a>
	</s:iterator>
	<s:a href="javascript:to_page('%{pList.nextpage}')">下一页</s:a>
	<s:a href="javascript:to_page('%{pList.lastpage}')">尾页</s:a>
</div>
