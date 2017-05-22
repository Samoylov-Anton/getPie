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

                            <img src="${profileValue.avatar}" class="img-rounded pull-left" style="height: 100px; width: 100px;margin-right: 5px;"/>
                            <p>${profileValue.note}</p>
                            <div class="row pull-right" style="margin-top:10px;">
                                <div class="btn-group open">
                                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Действия <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="bs-example bs-example-tabs" data-example-id="togglable-tabs">
                        <ul class="nav nav-tabs" id="myTabs" role="tablist">
                            <li role="presentation" class="active"><a href="#chats" id="chats-tab" role="tab" data-toggle="tab" aria-controls="chats" aria-expanded="true">Чаты</a></li>
                            <li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile">Витрины</a></li>
                            <li role="presentation"><a href="#info" role="tab" id="info-tab" data-toggle="tab" aria-controls="info">Информация</a></li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade in active" role="tabpanel" id="chats" aria-labelledby="chats-tab">

                                <!--main content start-->
                                <section id="main-content">
                                    <section class="wrapper site-min-height">
                                        <!-- page start-->
                                        <div class="chat-room mt">
                                            <aside class="mid-side">

                                                <div class="room-desk">

                                                    <div class="room-box">
                                                        <h5 class="text-primary"><a href="chat_room.html">Dashboard</a></h5>
                                                        <p>We talk here about our dashboard. No support given.</p>
                                                        <p><span class="text-muted">Admin :</span> Marcel Newman | <span class="text-muted">Members :</span> 98 | <span class="text-muted">Last Activity :</span> 2 min ago</p>
                                                    </div>
                                                    <div class="room-box">
                                                        <h5 class="text-primary"><a href="chat_room.html">Support</a></h5>
                                                        <p>Support chat for Dashgum. Purchase ticket needed.</p>
                                                        <p><span class="text-muted">Admin :</span> Marcel Newman | <span class="text-muted">Member :</span> 44 | <span class="text-muted">Last Activity :</span> 15 min ago</p>
                                                    </div>
                                                    <div class="room-box">
                                                        <h5 class="text-primary"><a href="chat_room.html">MaxFront</a></h5>
                                                        <p>Technical support for our front-end. No customization.</p>
                                                        <p><span class="text-muted">Admin :</span> Marcel Newman | <span class="text-muted">Member :</span> 22 | <span class="text-muted">Last Activity :</span> 15 min ago</p>
                                                    </div>
                                                </div>
                                            </aside>

                                        </div>
                                        <!-- page end-->
                                    </section><! --/wrapper -->
                                </section><!-- /MAIN CONTENT -->
                            </div>
                            <div class="tab-pane fade" role="tabpanel" id="profile" aria-labelledby="profile-tab">
                                <button class="btn btn-primary pull-right" style="margin-top:10px;" onclick="window.location.href='/showCase/create'">Добавить витрину</button>
                                <c:forEach items="${profileValue.caseModelList}" var="showCaseList">
                                <div class="jumbotron">
                                    <div class="panel panel-default" style="margin-top: 10px;">
                                    <div class="panel-body">
                                        <span><p>${showCaseList.name}</p></span>
                                        <button class="btn btn-primary pull-right" style="margin-top:10px;" onclick="window.location.href='/showCase/edit/${showCaseList.id}'">Редактировать</button>
                                    </div>
                                   </div>
                                </div>
                                 </c:forEach>
                            </div>
                            <div class="tab-pane fade" role="tabpanel" id="info" aria-labelledby="info-tab">
                                <p>
                                    Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.
                                </p>
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