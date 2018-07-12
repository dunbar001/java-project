<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
		
	}
</SCRIPT>
<div class="pager">
	<s:a href="javascript:to_page('%{custList.firstpage}')">首页</s:a>
	<s:a href="javascript:to_page('%{custList.prepage}')">上一页</s:a>
	<s:iterator begin="%{custList.begin}" end="%{custList.end}" var="i">
		<s:a href="javascript:to_page('%{i}')">${i}</s:a>
	</s:iterator>
	<s:a href="javascript:to_page('%{custList.nextpage}')">下一页</s:a>
	<s:a href="javascript:to_page('%{custList.lastpage}')">尾页</s:a>
</div>
