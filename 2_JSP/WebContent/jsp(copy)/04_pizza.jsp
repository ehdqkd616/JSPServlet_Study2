<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 table {
    border: 1px solid black;
    border-collapse: collapse;
  }
	th, td {
    border: 1px solid black;
    padding: 10px;
 	 }
</style>
</head>
<body>
<form action="/2_JSP/pizza.do" method="post">
	<h2>오늘 날짜<span style="color:pink"><%@ include file="today.jsp" %></span></h2>
	<h2>피자 아카데미</h2>
	<table>
		<tr>
			<th>종류</th>
			<th>이름</th>
			<th>가격</th>
			<th rowspan="12">&ensp;</th>
			<th>종류</th>
			<th>이름</th>
			<th>가격</th>
		</tr>
		<tr>
			<td rowspan="5">피자</td>
			<td>치즈피자</td>
			<td>5000</td>
			<td rowspan="11">사이드</td>
			<td>오븐구이통닭</td>
			<td>9000</td>
		</tr>
		<tr>
			<td>콤비네이션 피자</td>
			<td>6000</td>
			<td>치킨스틱&윙</td>
			<td>4900</td>
		</tr>
		<tr>
			<td>포테이토피자</td>
			<td>7000</td>
			<td>치즈오븐스파게티</td>
			<td>4000</td>
		</tr>
		<tr>
			<td>고구마피자</td>
			<td>7000</td>
			<td>새우링&웨지감자</td>
			<td>3500</td>
		</tr>
		<tr>
			<td>불고기피자</td>
			<td>8000</td>
			<td>갈릭포테이토</td>
			<td>3000</td>
		</tr>
		<tr>
			<td rowspan="6">토핑</td>
			<td>고구마무스</td>
			<td>1000</td>
			<td>콜라</td>
			<td>1500</td>
		</tr>
		<tr>
			<td>콘크림무스</td>
			<td>1500</td>
			<td>사이다</td>
			<td>1500</td>
		</tr>
		<tr>
			<td>파인애플토핑</td>
			<td>2000</td>
			<td>갈릭소스</td>
			<td>500</td>
		</tr>
		<tr>
			<td>치즈토핑</td>
			<td>2000</td>
			<td>피클</td>
			<td>300</td>
		</tr>
		<tr>
			<td>치즈크러스트</td>
			<td>2000</td>
			<td>핫소스</td>
			<td>100</td>
		</tr>
		<tr>
			<td>치즈바이트</td>
			<td>3000</td>
			<td>파마산 치즈가루</td>
			<td>100</td>
		</tr>
	</table>
	<br><br>
	피자 &emsp;:
	<select name="select">
		<option value="치즈피자!5000">치즈피자</option>
		<option value="콤비네이션피자!6000">콤비네이션피자</option>
		<option value="포테이토피자!7000">포테이토피자</option>
		<option value="고구마피자!7000">고구마피자</option>
		<option value="불고기피자!8000">불고기피자</option>
	</select>
	<br>
	토핑 &emsp;:
	<input type="checkbox" id="topping" name="topping" value="고구마무스!1000">고구마무스
	<input type="checkbox" id="topping" name="topping" value="콘크림무스!1500">콘크림무스
	<input type="checkbox" id="topping" name="topping" value="파인애플토핑!2000">파인애플토핑
	<input type="checkbox" id="topping" name="topping" value="치즈토핑!2000">치즈토핑
	<input type="checkbox" id="topping" name="topping" value="치즈크러스트!2000">치즈크러스트
	<input type="checkbox" id="topping" name="topping" value="치즈바이트!3000">치즈바이트
	<br>
	사이드 :
	<input type="checkbox" id="side" name="side" value="오븐구이통닭!9000">오븐구이통닭
	<input type="checkbox" id="side" name="side" value="치킨스틱&윙!4900">치킨스틱&윙
	<input type="checkbox" id="side" name="side" value="치즈오븐스파게티!4000">치즈오븐스파게티
	<input type="checkbox" id="side" name="side" value="새우링&웨지감자!3500">새우링&웨지감자
	<input type="checkbox" id="side" name="side" value="갈릭포테이토!3000">갈릭포테이토
	<input type="checkbox" id="side" name="side" value="콜라!1500">콜라
	<input type="checkbox" id="side" name="side" value="사이다!1500">사이다
	<input type="checkbox" id="side" name="side" value="갈릭소스!500">갈릭소스
	<input type="checkbox" id="side" name="side" value="피클!300">피클
	<input type="checkbox" id="side" name="side" value="핫소스!100">핫소스
	<input type="checkbox" id="side" name="side" value="파마산 치즈가루!100">파마산 치즈가루
	<br>
	<input type="submit" value="확인">
</form>
	<script>
	
	</script>
</body>
</html>