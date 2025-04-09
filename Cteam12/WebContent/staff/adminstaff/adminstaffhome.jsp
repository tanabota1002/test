<%-- ログインJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/staffcommon/base.jsp">
	<c:param name="title">
		ぽシステム
	</c:param>


	<c:param name="content">

	    <h1>AdminStaffHOME</h1>
			<a class="nav-item px-2" href="StaffList.action">職員一覧</a>

	</c:param>
</c:import>