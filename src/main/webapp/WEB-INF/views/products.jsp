<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Menu</title>
	</head>
	
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Menu</h1>
					<p>Lista wszystkich dostępnych dań</p>
				</div>
			</div>
		</section>
		<section class="container">
			<div class="row">
				<c:forEach items="${products}" var="product">
					<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
						<div class="thumbnail">
							<img src="<c:url value="/resources/images/${product.productId}.png"></c:url>" alt="image" style="width:100%"/>
							<div class="caption">
								<h3>${product.name}</h3>
								<p>${product.description}</p>
								<p>${product.unitPrice} zł</p>
								<%--
								<p>Liczba dostępnych sztuk: ${product.unitsInStock}</p>
								--%>
								<p>
									<a href="<spring:url value="/products/product?id=${product.productId}"/>" class="btn btn-primary">
										<span class="glyphicon-info-sign glyphicon"/></span>
										Szczegóły
									</a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</body>
	
</html>