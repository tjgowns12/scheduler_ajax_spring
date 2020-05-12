<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function test(){
	location.href="non_ajax";
}

</script>
</head>
<body>non_ajax.jsp<br>
<h1>1</h1><h1>2</h1><h1>3</h1>
<h1>4</h1><h1>5</h1><h1>6</h1>
<h1>7</h1><h1>8</h1><h1>9</h1>
<button type="button" onclick="test()">클릭</button>
<!-- ajax를 사용하지 않고 버튼을 누르면 페이지를 전부 reload시킨다 -->
</body>
</html>