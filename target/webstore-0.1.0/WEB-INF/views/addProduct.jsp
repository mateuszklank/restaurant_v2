<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

	<head>
        <title><spring:message code="welcome.title.label"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
        <link href="<c:url value="/resources/styles/bootstrap.min.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/javascript/sidebar.js" />"></script>
	</head>

    <style>
        .alert {
            padding: 0px;
            background-color: #f44336;
            color: white;
        }

        .closebtn {
            margin-left: 15px;
            color: white;
            font-weight: bold;
            float: right;
            font-size: 22px;
            line-height: 20px;
            cursor: pointer;
            transition: 0.3s;
        }

        .closebtn:hover {
            color: black;
        }
        input[type=submit] {
            background-color: black;
            border: none;
            color: white;
        }
    </style>

	<body>
    <!-- Sidebar (hidden by default) -->
    <nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:40%;min-width:300px" id="mySidebar">
        <a href="javascript:void(0)" onclick="w3_close()"
           class="w3-bar-item w3-button"><spring:message code="welcome.close.label"/></a>
        <a href="<spring:url value="/"/>" onclick="w3_close()" class="w3-bar-item w3-button"><spring:message code="welcome.panel.mainpage.label"/></a>
        <a href="<spring:url value="/products"/>" onclick="w3_close()" class="w3-bar-item w3-button"><spring:message code="welcome.menu.label"/></a>
        <a href="<spring:url value="/employees"/>" onclick="w3_close()" class="w3-bar-item w3-button"><spring:message code="welcome.ouremployees.label"/></a>
        <a href="<spring:url value="/contact"/>" onclick="w3_close()" class="w3-bar-item w3-button"><spring:message code="welcome.contact.label"/></a>
        <a href="<spring:url value="/login"/>" onclick="w3_close()" class="w3-bar-item w3-button"><spring:message code="welcome.panel.login.label"/></a>
        <a href="<spring:url value="/panel"/>" onclick="w3_close()" class="w3-bar-item w3-button">Panel</a>
    </nav>

    <!-- Top menu -->
    <div class="w3-top">
        <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
            <div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">☰</div>
            <div class="w3-button w3-padding-16 w3-right"><a href="?language=en">en</a></div>
            <div class="w3-button w3-padding-16 w3-right"><a href="?language=pl">pl</a></div>
            <div class="w3-center w3-padding-16">     <spring:message code="welcome.title.label"/></div>
        </div>
    </div>

    <!-- !PAGE CONTENT! -->
    <div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">

        <!-- About Section -->
        <div class="w3-container w3-padding-32 w3-center">
            <div class="w3-padding-32">
                <h4><b><spring:message code="addProduct.form.title.label"/></b></h4>
                <hr>
                <p><spring:message code="addProduct.form.description.label"/></p>
                <hr>
            </div>
        </div>



        <form:form modelAttribute="newProduct" class="w3-container" enctype="multipart/form-data">
            <div class="w3-container w3-black">
                <h4><spring:message code="addProduct.form.newdish.label"/></h4>
            </div>
            <!--<form:errors path="*" cssClass="alert" element="div"/>-->
            <br>
            <fieldset>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code="addProduct.form.productId.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="productId" path="productId" type="text" class="w3-input"/>
                        <form:errors path="productId" cssClass="alert"/>
                    </div>
                </div>
            </fieldset>
            <br>
            <fieldset>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code="addProduct.form.productName.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="name" path="name" type="text" class="w3-input"/>
                        <form:errors path="name" cssClass="alert"/>
                    </div>
                </div>
            </fieldset>
            <br>
            <fieldset>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code="addProduct.form.productPrice.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="unitPrice" path="unitPrice" type="text" class="w3-input"/>
                        <form:errors path="unitPrice" cssClass="alert"/>
                    </div>
                </div>
            </fieldset>
            <br>
                    <%--
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="productId">Producent</label>
                        <div class="col-lg-10">
                            <form:input id="manufacturer" path="manufacturer" type="text" class="w3-input"/>
                        </div>
                    </div>
                    --%>
            <fieldset>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code="addProduct.form.productCategory.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="category" path="category" type="text" class="w3-input"/>
                        <form:errors path="category" cssClass="alert"/>
                    </div>
                </div>
            </fieldset>
            <br>
            <%--
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code="addProduct.form.productCount.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="unitsInStock" path="unitsInStock" type="text" class="w3-input"/>
                    </div>
                </div>
            --%>
            <fieldset>
                <div class="form-group">
                    <label class="control-label col-lg-2" for="description">
                        <spring:message code="addProduct.form.productDescription.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:textarea id="description" path="description" rows="4" cols="151"/>
                    </div>
                </div>
            </fieldset>
            <br>
                    <%--
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="discontinued">Wycofany</label>
                        <div class="col-lg-10">
                            <form:checkbox id="discontinued" path="discontinued"/>
                        </div>
                    </div>
                    --%>
            <fieldset>
                <div class="form-group">
                    <label class="control-label col-lg-2" for="vege">
                        <spring:message code="addProduct.form.productVege.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:checkbox id="vege" path="vege"/>
                    </div>
                </div>
            </fieldset>
            <br>
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
            <fieldset>
                <div class="form-group">
                    <label class="control-label col-lg-2" for="productImage">
                        <spring:message code="addProduct.form.productImage.label"/> <form:input id="productImage" path="productImage" type="file"/>
                    </label>
                </div>
            </fieldset>
                <%--<div class="w3-center w3-padding-32">
                    <div class="w3-bar">
                        <!--<input class="w3-bar-item w3-black w3-button" type="submit" value="${adding}">-->
                        <input type="submit" name="Dodaj" class="w3-bar-item w3-black w3-button" value="${adding}">
                    </div>
                </div>--%>
            <br>
                <div class="w3-container w3-black">
                    <h4>
                        <spring:message code="addProduct.form.productAdd.label" var="adding"/>
                        <input type="submit" value="${adding}">
                    </h4>
                </div>
        </form:form>

        <section>
            <div class="jumbotron">
                <div class="containter">
                    <a href="<c:url value="/j_spring_security_logout"/>" class="btn btn-danger btn-mini pull-right">
                        <label>
                            <spring:message code="addProduct.form.productLogout.label"/>
                        </label>
                    </a>
                </div>
            </div>
        </section>

        <hr>

        <!-- Footer -->
        <footer class="w3-row-padding w3-padding-32">
            <div class="w3-third">
                <h3><spring:message code="welcome.location.label"/></h3>
                <p>Warszawska 24</p>
                <p>31-155 Kraków</p>
            </div>

            <div class="w3-third">
                <h3><spring:message code="welcome.contact.label"/></h3>
                <p>tel. 695 266 326</p>
                <p>quarionek@gmail.com</p>
            </div>

            <div class="w3-third">
                <h3><spring:message code="welcome.opening.label"/></h3>
                <p><spring:message code="welcome.hours1.label"/></p>
                <p><spring:message code="welcome.hours2.label"/></p>
            </div>
        </footer>
        <div class="w3-container w3-padding-32 w3-center">
            <div class="w3-padding-32">
                <p>© Mateusz Klank 2018</p>
            </div>
        </div>

        <!-- End page content -->
    </div>
    </div>
	</body>
	
</html>