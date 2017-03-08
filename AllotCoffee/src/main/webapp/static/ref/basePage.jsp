<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="text-align: center;">

			<c:if test="${page.pageNo>1 }">
			<<a href="${pageScope.url }?pageNo=1">首页</a>
			<a href="${pageScope.url }?pageNo=${page.pageNo-1 }">上一页</a>
			</c:if>
			您现在在第【${page.pageNo }】页
			共${page.pageTotal }页
			共${page.totalRecoards }条记录
			跳转到第<input type="text" class="shortInput" id="goPageNo" value="${page.pageNo }"/>页
		
			<c:if test="${page.pageNo<page.pageTotal }">
			<a href="${pageScope.url }?pageNo=${page.pageNo+1 }">下一页</a>
			<a href="${pageScope.url }?pageNo=${page.pageTotal}">末页</a>
			</c:if>
	
	<script type="text/javascript">
		$(function(){
			$("#goPageNo").change(function(){
				var pageNo=this.value;
				pageNo=$.trim(pageNo);
				if(pageNo==null||pageNo==""||isNaN(pageNo)){
					this.value=this.defalutValue;
					return;
				}
				var url="${pageContext.request.contextPath}/${pageScope.url}?pageNo="+this.value;
				window.location.href=url;
			});
		});
	</script>
</div>