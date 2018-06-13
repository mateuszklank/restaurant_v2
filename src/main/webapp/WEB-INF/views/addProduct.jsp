<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Dodawanie</title>
	</head>
	
	<body>
		<section>
			<div class="jumbotron">
				<div class="containter">
					<h1>Edytowanie menu</h1>
					<p>Dodaj nową potrawę</p>
				</div>
			</div>
		</section>
		<section class="container">
			<form:form modelAttribute="newProduct" class="form-horizontal">
				<fieldset>
					<legend>Uzupełnij niezbędne informacje</legend>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="productId">
							<spring:message code="addProduct.form.productId.label"/>
						</label>
						<div class="col-lg-10">
							<form:input id="productId" path="productId" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="productId">Nazwa potrawy</label>
						<div class="col-lg-10">
							<form:input id="name" path="name" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="productId">Cena</label>
						<div class="col-lg-10">
							<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
						</div>
					</div>
					<%--
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="productId">Producent</label>
						<div class="col-lg-10">
							<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
						</div>
					</div>
					--%>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="productId">Kategoria</label>
						<div class="col-lg-10">
							<form:input id="category" path="category" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="productId">Liczba dostępnych</label>
						<div class="col-lg-10">
							<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="description">Opis</label>
						<div class="col-lg-10">
							<form:textarea id="description" path="description" rows="2"/>
						</div>
					</div>
					<%-- 
					<div class="form-group">
						<label class="control-label col-lg-2" for="discontinued">Wycofany</label>
						<div class="col-lg-10">
							<form:checkbox id="discontinued" path="discontinued"/>
						</div>
					</div>
					--%>
					<div class="form-group">
						<label class="control-label col-lg-2" for="vege">Wegetariańskie?</label>
						<div class="col-lg-10">
							<form:checkbox id="vege" path="vege"/>
						</div>
					</div>
					<%--
					<div class="form-group">
						<label class="control-label col-lg-2" for="condition">Stan</label>
						<div class="col-lg-10">
							<form:radiobutton path="condition" value="New"/>Nowy
							<form:radiobutton path="condition" value="Old"/>Używany
							<form:radiobutton path="condition" value="Refurbished"/>Odnowiony
						</div>
					</div>
					--%>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj">
						</div>
					</div>
					
				</fieldset>
			</form:form>
			<div class="jumbotron">
				<a href="<c:url value="/j_spring_security_logout"/>" class="btn btn-danger btn-mini pull-right">
					Wyloguj się
				</a>
			</div>
		</section>
	</body>
	
</html>