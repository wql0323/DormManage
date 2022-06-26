<%--
  Created by IntelliJ IDEA.
  User: Wql00
  Date: 2021/7/17
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
    $(document).ready(function(){
        $("ul li:eq(1)").addClass("active");
    });
</script>

<div class="data_list">
    <div class="data_list_title">
        缺勤详情
    </div>
    <div>
        <table class="table table-striped table-bordered table-hover datatable">
            <thead>
            <tr>
                <th>日期</th>
                <th>学号</th>
                <th>姓名</th>
                <th>宿舍楼</th>
                <th>寝室</th>
                <th>备注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach  varStatus="i" var="recordListWithNumber" items="${recordListWithNumber }">
                <tr>
                    <td>${recordListWithNumber.date}</td>
                    <td>${recordListWithNumber.stuNum }</td>
                    <td>${recordListWithNumber.studentName }</td>
                    <td>${recordListWithNumber.dormBuildName==null?"无":recordListWithNumber.dormBuildName }</td>
                    <td>${recordListWithNumber.dormName }</td>
                    <td>${recordListWithNumber.detail }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div align="center"><font color="red">${error }</font></div>
</div>