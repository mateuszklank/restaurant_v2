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
                <img src="../resources/images/logo.png" alt="Me" class="w3-image" style="display:block;margin:auto" width="800" height="533">
                <div class="w3-padding-32">
                    <h4><b><spring:message code="welcome.about.label"/></b></h4>
                    <h6><i><spring:message code="welcome.about.title.label"/></i></h6>
                    <hr>
                    <p><spring:message code="welcome.about.more.label"/></p>
                    <p><spring:message code="welcome.menu.more.label"/></p>
                    <hr>
                    <!-- Pagination -->
                    <div class="w3-center w3-padding-32">
                        <div class="w3-bar">
                            <a href="<spring:url value="/"/>" class="w3-bar-item w3-black w3-button"><spring:message code="welcome.panel.mainpage.label"/></a>
                            <a href="<spring:url value="/products"/>" class="w3-bar-item w3-button w3-hover-black"><spring:message code="welcome.menu.label"/></a>
                            <a href="<spring:url value="/employees"/>" class="w3-bar-item w3-button w3-hover-black"><spring:message code="welcome.ouremployees.label"/></a>
                            <a href="<spring:url value="/contact"/>" class="w3-bar-item w3-button w3-hover-black"><spring:message code="welcome.contact.label"/></a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="w3-content w3-display-container" style="max-width: 1200px">
                <img class="mySlides" src="../resources/images/mainpage1.png" style="width:100%">
                <img class="mySlides" src="../resources/images/mainpage2.png" style="width:100%">
                <img class="mySlides" src="../resources/images/mainpage3.png" style="width:100%">

                <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
                <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
                <hr>
            </div>

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
    <script>
        // Manual Slideshow - change image on click
        var slideIndex = 1;
        showDivs(slideIndex);

        function plusDivs(n) {
            showDivs(slideIndex += n);
        }

        function showDivs(n) {
            var i;
            var x = document.getElementsByClassName("mySlides");
            if (n > x.length) {slideIndex = 1}
            if (n < 1) {slideIndex = x.length}
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            x[slideIndex-1].style.display = "block";
        }
    </script>
    </body>
</html>