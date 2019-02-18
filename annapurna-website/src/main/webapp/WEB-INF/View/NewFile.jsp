<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Annapurna</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>
.box {
	height: 250px;
	overflow: hidden;
}

body {
	background-size: 1500px 800px;
	background-color: #d5d6933d;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form action="search">
					Search : <input name="search"
						placeholder="Search By Food or Restaurant"> <input
						type="submit" value="Search">
				</form>
			</div>
			<div class="col-md-6">
				<form action="searchByCity">
					Search : <input name="search"
						placeholder="Search Restaurant By City Or State Or Country">
					<input type="submit" value="Search">
				</form>
			</div>
		</div>
		<br>
		<div class="row">
			<core:forEach var="restaurant" items="${list}" varStatus="listStatus">
				<div class="col-md-4">
					<div class="thumbnail">
						<a href="/foodItems?restaurantId=${restaurant.restaurantId}">
							<core:forEach var="photos" items="${restaurant.photos}"
								varStatus="status">
								<core:if test="${status.index==0}">
									<div class='box'>
										<img class="img" alt="image" src="${photos}" width="100%">
									</div>
								</core:if>
							</core:forEach>
							<h4>
								<a href="/foodItems?restaurantId=${restaurant.restaurantId}">${restaurant.name}</a>
								<input value="ratings${listStatus.index}" id="ratings${listStatus.index}" />
								<%-- <input type="hidden" id="rate${listStatus.index}" value="${ratings.value}" />
								<input type="hidden" id="rate${listStatus.index}" value="${ratings.value}" /> --%>
							</h4>
							<h5>${restaurant.type}
								&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="#">Reviews-${fn:length(restaurant.reviews)}</a>
							</h5>
							
								<core:forEach var="ratings" items="${restaurant.ratings}" varStatus="status">
										<input type="hidden" id="rate${status.index}" value="${ratings.value}" />
								</core:forEach>
								
								<!-- <script type="text/javascript">
									var individualRating = 0;
									for (i = 0; i < ${fn:length(restaurant.ratings)}; i++) { 
										var rate = document.getElementById("rate"+i).value;
										individualRating = parseInt(rate) + parseInt(individualRating);
									}
								</script> -->
						</a>
					</div>
				</div>
			</core:forEach>

			<script type="text/javascript">
				for (i = 0; i < ${fn:length(list)}; i++) { 
					var individualRating = 0;
					for (j = 0; j < ${fn:length(i.ratings)}; j++) { 
						var rate = document.getElementById("rate"+j).value;
						alert("1 "+rate);
						individualRating = parseInt(rate) + parseInt(individualRating);
						alert("2 "+individualRating);
					}
					alert("3 "+individualRating);
					//alert(document.getElementById("ratings"+i).value=individualRating);
				 }  
			</script>
		</div>
	</div>

</body>
</html>