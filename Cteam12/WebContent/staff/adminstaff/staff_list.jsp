<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">職員管理システム</c:param>
    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">職員管理</h2>
            <form method="get">
                <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                    <div class="col-4">
                        <label class="form-label" for="staff-f1-input">職員ID</label>
                        <input type="number" class="form-control" id="staff-f1-input" name="f1" value="${f1}" placeholder="職員IDを入力">
                    </div>
                    <div class="col-4">
                        <label class="form-label" for="staff-f2-input">氏名</label>
                        <input type="text" class="form-control" id="staff-f2-input" name="f2" value="${f2}" placeholder="氏名を入力">
                    </div>
                    <div class="col-4">
                        <label class="form-label" for="staff-f3-input">役割</label>
                        <input type="text" class="form-control" id="staff-f3-input" name="f3" value="${f3}" placeholder="役割を入力">
                    </div>
                    <div class="col-2 text-center mt-3">
                        <button class="btn btn-secondary" id="filter-button">絞込み</button>
                    </div>
                    <div class="mt-2 text-warning">${errors.get("f1")}</div>
                </div>
            </form>
            <c:if test="${empty staffs}">
    			<div>Debug: staffs is empty or null</div>
			</c:if>


            <c:choose>
                <c:when test="${not empty staffs}">
                    <div>検索結果：${staffs.size()}件</div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>職員ID</th>
                                <th>氏名</th>
                                <th>役割</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="staff" items="${staffs}">
							    <tr>
							        <td>${staff.staffId}</td> <!-- staffId のプロパティ名を確認 -->
							        <td>${staff.staffName}</td> <!-- staffName のプロパティ名を確認 -->
							        <td>${staff.staffRole}</td> <!-- staffRole のプロパティ名を確認 -->
							        <td>
							            <a href="StaffUpdate.action?staffId=${staff.staffId}">変更</a>
							        </td>
							    </tr>
							</c:forEach>

                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <div>職員情報が存在しませんでした</div>
                </c:otherwise>
            </c:choose>
        </section>
    </c:param>
</c:import>
