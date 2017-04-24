<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>

    <jsp:attribute name="title">getPie</jsp:attribute>

    <jsp:body>

        <div class="container">

            <div class="row row-offcanvas row-offcanvas-right">

                <div class="col-xs-12 col-sm-9">

                    <div class="jumbotron">
                        <div class="row">

                            <img src="${modelValue.avatar}" class="img-rounded pull-left" style="height: 100px; width: 100px;margin-right: 5px;"/>
                            <p>${modelValue.note}</p>

                        </div>
                    </div>

                    <div class="bs-example bs-example-tabs" data-example-id="togglable-tabs">
                        <ul class="nav nav-tabs" id="myTabs" role="tablist">
                            <li role="presentation" class="active"><a href="#photo" role="tab" id="profile-tab" data-toggle="tab" aria-controls="photo">Фото</a></li>
                            <li role="presentation"><a href="#chat" id="chats-tab" role="tab" data-toggle="tab" aria-controls="chat">Чат</a></li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade in active" role="tabpanel" id="photo" aria-labelledby="profile-tab" style="margin-top: 10px;">
                                <div class="jumbotron" style="padding-bottom: 5px; padding-top: 8px;">
                                    <div class="row">
                                        <c:forEach items="${modelValue.imageList}" var="showImage">
                                            <div class="col-xs-5 col-sm-3"><a rel="lightbox" href="${showImage.image}">
                                                <img src="${showImage.image}" class="img-rounded"
                                                     style="height: 150px; width: 150px; display: block;">
                                            </a></div>

                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" role="tabpanel" id="chat" aria-labelledby="chats-tab">

                                <!--main content start-->
                                <section id="main-content">
                                    <section class="wrapper site-min-height">
                                        <!-- page start-->
                                        <div class="panel panel-default">
                                            <div class="panel-body">
                                                <div class="chat-room mt">
                                                    <div class="chat-room-head">
                                                        <a href="#profile"><span class="glyphicon glyphicon-arrow-left"/></a>
                                                    </div>
                                                    <div class="mid-side fixed-panel">
                                                        <div class="group-rom">
                                                            <div class="first-part">Mark Simmons</div>
                                                            <div class="second-part">Fantastic job, love it :)</div>
                                                            <div class="third-part">12:32</div>
                                                        </div>
                                                        <div class="group-rom last-group">
                                                            <div class="first-part odd">Sam Soffes</div>
                                                            <div class="second-part">Thanks!!</div>
                                                            <div class="third-part">12:33</div>
                                                        </div>
                                                    </div>
                                                    <footer>
                                                        <div class="chat-txt">
                                                            <input type="text" class="form-control">
                                                        </div>
                                                        <button type="button" class="btn btn-primary">Отправить</button>
                                                    </footer>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- page end-->
                                    </section><! --/wrapper -->
                                </section><!-- /MAIN CONTENT -->
                            </div>
                        </div>
                    </div>

                </div><!--/.col-xs-12.col-sm-9-->
                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
                    <div class="jumbotron">
                        <p>Разделы:</p>

                    </div>
                </div>
            </div>
            <!--/row-->

        </div><!--/.container-->
    </jsp:body>

</page:template>
