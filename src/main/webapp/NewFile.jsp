<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>This is list</h2>
	<s:iterator status="stat" value="newsList">
		<s:property value="heading" />
		<s:property value="description" />
		<s:property value="newsId" />
		<s:property value="userId" />
		<br />
	</s:iterator>

	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js">
		
	</script>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$.ajax({
						url : "getAllNewsList",
						dataType : "application/json",
						success : function(JSONdata) {
							alert("hello");
							var data = $.parseJSON(JSONdata);
							$(data).each(
							function(index, value) {
								$('#myModalBody').append("<div class='panel panel-primary'><div class='panel-heading'> >>"
										+data[index].heading+"</div><div class='panel-body'><p>"
										+data[index].description+"</p><p><a href="
										+data[index].newsFile+">Download attachment</a></p></div></div>");
							});

						}
					});
				});
	</script>
	<div id="myModalBody"></div>
</body>
</html>