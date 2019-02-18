<!DOCTYPE html>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<style type="text/css">
	body{
	    /* background-image: url();    */
	    background-size:1500px 800px;
	    background-color: #d5d6933d;
	}
</style>
</head>

<body background="./images/pattern2.jpg">
	<jsp:include page="menu.jsp" />
	<div id="login-overlay" class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">Add amount to your eWallet account</h4>
			</div>

			<div class="modal-body">


				<form action="AddMoneyForm" method="post">
				<input type="hidden" name="profileId" value="${profileId}" />
					<!---form--->

					<div class="form-group">
						<div class="col-xs-12">
							<label for="InputStreetName">Add amount to eWallet</label>
							<div class="input-group">
								<input type="text" class="form-control" name="amount"
									placeholder="Enter amount here" required="required" /> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
							<!----------------------------break------------------------------------------------------------->
							<br>
						</div>
					</div>
					
					<div class="form-group">
						<div class="input-group-addon">
							<input type="submit" name="submit" id="submit" value="Submit"
								class="btn btn-success pull-center">

						</div>
					</div>
				</form>
			</div>
			<!---modal-body--->
		</div>
	</div>


	<script type="text/javascript">
		
	</script>
</body>

</html>
