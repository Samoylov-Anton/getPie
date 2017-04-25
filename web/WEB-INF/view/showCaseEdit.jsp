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
                    <button type="submit" class="btn btn-primary pull-left" style="margin-bottom: 10px;">Сохранить</button>
                </div>
                <div class="col-xs-12 col-sm-9">
                    <form>
                        <div class="form-group">
                            <label for="showCaseName">Название</label>
                            <input type="text" class="form-control" id="showCaseName" name="name" value="${modelValue.name}">
                        </div>
                        <div class="form-group">
                            <label for="showCaseminSum">Минимальная сумма</label>
                            <input type="text" class="form-control" id="showCaseminSum" name="minSum">
                        </div>
                        <div class="form-group">
                            <label for="showCaseNote">Описание</label>
                            <textarea class="form-control" rows="5" id="showCaseNote" name="note"></textarea>
                        </div>
                    </form>
                        <button type="submit" data-toggle="modal" data-target="#addPhoto" class="btn btn-primary pull-left" style="margin-bottom: 10px;">Добавить фото</button>
                    <div class="modal fade" role="dialog" id="addPhoto" tabindex="-1" aria-labelledby="gridModalLabel"
                         data-backdrop="false" style="background-color: rgba(0, 0, 0, 0.5); display: none;">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                            aria-hidden="true">×</span></button>
                                    <h4 class="modal-title" id="cityModalLabel">Добавить фото</h4></div>
                                <form action="/file-upload/${modelValue.id}" class="dropzone">
                                    <div class="fallback">
                                        <input name="file" type="file" multiple />
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-9">
                        <c:forEach items="${modelValue.imageList}" var="imageList">
                            <div class="col-xs-5 col-sm-3">
                                <a rel="lightbox" href="${imageList.image}">
                                    <img src="${imageList.image}" class="img-rounded"
                                         style="height: 150px; width: 150px; display: block;">
                                </a>
                            </div>
                        </c:forEach>
                    </div>

                </div><!--/.col-xs-12.col-sm-9-->

                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
                    <div class="jumbotron">
                        <p>Разделы:</p>

                    </div>
                </div>
            </div><!--/row-->
        </div><!--/.container-->
    </jsp:body>

</page:template>
