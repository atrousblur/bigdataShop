<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/bigdataShop/resources/jqcloud/jqcloud.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
    <script type="text/javascript" src="/bigdataShop/resources/jqcloud/jqcloud-1.0.4.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
    	var word_list = [];
    	// db���� ��ȸ�� ����� wordcloud�� ���۵� �� �ֵ��� �۾�
    	<c:forEach var="result" items="${resultList}">
    		var value = new Object();
    		value.text = "${result.content}";
    		value.weight = "${result.count}";
    		word_list.push(value);
    	</c:forEach>
    	$("#comments").jQCloud(word_list);
    });
    </script>
</head>
<body>
	<h1>��ǰ��ۺм�</h1>
	<hr />
	<div  class="col-md-4">
		<table class="table">
			<thead>
				<tr>
					<th>Ű����</th>
					<th>�ݺ�Ƚ��</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="result" items="${tableList}">
					<tr>
						<td>${result.content}</td>
						<td>${result.count}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-md-6">
	  <div id="comments" style="width: 550px; height: 350px; border: 1px solid #ccc;"></div>
	</div>
</body>
</html>