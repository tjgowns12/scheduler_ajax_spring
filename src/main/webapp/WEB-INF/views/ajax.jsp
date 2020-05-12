<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function get_(){
	$.ajax({
		url:"ajax_result",
		type:"GET",
		success:function(data){
			$("#result").text(data[0].name)
			console.log("성공")
			showUsers(data);
		},
		error:function(){
			console.log("실패")
		}
	});
}
function post_(){
	$.ajax({
		url:"ajax_result",
		type:"POST",
		success:function(data){
			$("#result").text(data)
			console.log("성공")
		},
		error:function(){
			console.log("실패")
		}
	});
}
function put_(){
	$.ajax({
		url:"ajax_result",
		type:"PUT",
		success:function(data){
			$("#result").text(data)
			console.log("성공")
		},
		error:function(){
			console.log("실패")
		}
	});
}
function del_(){
	$.ajax({
		url:"ajax_result",
		type:"DELETE",
		success:function(data){
			$("#result").text(data)
			console.log("성공")
		},
		error:function(){
			console.log("실패")
		}
	});
}
function showUsers(list){
	let html="<table border='1'>";
	html+="<tr><th>아이디</th><th>나이</th></tr>"
	$.each(list,function(index,item){
		html +="<tr>";
		html +="<td style='cursor:pointer;'onclick='user(\""+item.name+"\")'>"+item.name+"</td>";
		html +="<td>"+item.age+"</td>";
		html +="</tr>";
	})
	html +="</table>"
	$("#showUsers").html(html);
}
function user(userName){
	console.log("클릭 이름:"+userName)
	$.ajax({
		url:"user?name="+userName,
		type:"GET",
		success:function(data){
			$("#result").text(data[0].name)
			console.log("성공")
			showUsers(data);
		},
		error:function(){
			console.log("실패")
		}
	});
}

</script>
<!-- user?name=? 과 달리 경로로 보내는 방법 user/ -->
<!-- list가 가지고 있는 값이 하나씩 순차적으로 소진할 때 까지 반복된다 -->
<!--type=요청하는 방식으로 어노테이션을 따라간다-->
<!-- Controller에서 돌려주는 리턴값이 data로 돌아온다  -->


</head>
<body>ajax.jsp<br>
<h1>1</h1><h1>2</h1><h1>3</h1>
<h1>4</h1><h1>5</h1><h1>6</h1>
<h1>7</h1><h1>8</h1><h1>9</h1>
<button type="button" onclick="get_()">get</button>
<button type="button" onclick="post_()">post</button>
<button type="button" onclick="put_()">put</button>
<button type="button" onclick="del_()">del</button>
<label id="result">0</label>
<hr>
<div id="showUsers">

</div>
</body>
</html>