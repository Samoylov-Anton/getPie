<!DOCTYPE html>
<%@tag description="Template Site tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@attribute name="title" fragment="true"%>
<html>
<head>
    <title>
        <jsp:invoke fragment="title"/>
    </title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <link href="${bootstrap}" rel="stylesheet"/>

    <!-- Custom CSS -->
    <spring:url value="/resources/css/offcanvas.css" var="starterTemplate"/>
    <link href="${starterTemplate}" rel="stylesheet"/>

    <spring:url value="/resources/css/flat-ui.css" var="flatCss"/>
    <link href="${flatCss}" rel="stylesheet"/>

    <!-- Custom Fonts -->
    <%--<spring:url value="/resources/css/font-awesome.min.css" var="fontawesome"/>
    <link href="${fontawesome}" rel="stylesheet"/>--%>

    <!-- jQuery -->
    <spring:url value="/resources/js/jquery-2.1.4.min.js" var="jqueryjs"/>
    <script src="${jqueryjs}"></script>

    <!-- Bootstrap Core JavaScript -->
    <spring:url value="/resources/js/bootstrap.min.js" var="js"/>
    <script src="${js}"></script>

    <!--lighbox-->
    <spring:url value="/resources/lightbox/css/lightbox.css" var="lightboxCss"/>
    <link href="${lightboxCss}" rel="stylesheet"/>

    <spring:url value="/resources/lightbox/js/lightbox.js" var="lightboxJs"/>
    <script src="${lightboxJs}"></script>

    <spring:url value="/resources/js/main.js" var="mainJs"/>
    <script src="${mainJs}" charset="utf-8"></script>

</head>

<body>
<!-- Navigation -->
<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">GetPie</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Главная</a></li>
                <li><a href="/profile">Профиль</a></li>
                <li><a href="/contact">Контакты</a></li>
            </ul>
            <a id="city" data-toggle="modal" data-target="#cityModal"></a>
            <div class="modal fade" role="dialog" id="cityModal" tabindex="-1" aria-labelledby="gridModalLabel"
                 data-backdrop="false" style="background-color: rgba(0, 0, 0, 0.5); display: none;">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">×</span></button>
                            <h4 class="modal-title" id="cityModalLabel">Выбрать город</h4></div>
                        <form class="form">
                            <div class="modal-body">
                                <div class="radio">
                                    <label><input type="radio" name="optradio" value="77">Москва</label>
                                </div>
                                <div class="radio">
                                    <label><input type="radio" name="optradio" value="16">Казань</label>
                                </div>
                                <div class="radio">
                                    <label><input type="radio" name="optradio">Option 3</label>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" onclick="show();">Выбрать</button>
                            </div>
                        </form>

                </div>
            </div>
        </div>
            <button type="button" class="btn btn-primary pull-right" style="margin-top:10px;">Войти</button>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->

<jsp:doBody/>


<div class="container">
    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright 2017</p>
            </div>
        </div>
    </footer>
</div>

</body>
<script src="http://api-maps.yandex.ru/2.0-stable/?load=package.standard&lang=ru_RU" type="text/javascript">
</script>
<script type="text/javascript">
    ymaps.ready(function(){
        window.onload = reloadPage();
    });
</script>
</html>
