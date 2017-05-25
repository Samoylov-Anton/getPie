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
                    <form class="form" onSubmit="return createShowCase()">
                        <div class="row" style="margin-left:0;">
                            <button class="btn btn-primary pull-left">Сохранить</button>
                        </div>
                        <div>
                            <label for="showCaseName">Название</label>
                            <input type="text" class="form-control" id="showCaseName" name="name" value="${modelValue.name}">
                        </div>
                        <div class="form-group">
                            <label for="sel">Тип витрины</label>
                            <select class="form-control" id="sel" name="type">
                                <option value ="1">Торты</option>
                                <option value ="2">Капкейки</option>
                                <option value ="3">Пироги</option>
                            </select>
                        </div>
                        <div>
                            <label for="showCaseminSum">Минимальная сумма</label>
                            <input type="text" class="form-control" id="showCaseminSum" name="minSum" value="${modelValue.minSum}">
                        </div>
                        <div>
                            <label for="showCaseNote">Описание</label>
                            <textarea class="form-control" rows="3" id="showCaseNote" name="note">${modelValue.note}</textarea>
                        </div>
                    </form>
                    <script type="text/javascript">
                        function createShowCase() {
                            var arr = {id: ${modelValue.id}, name: $('input[name="name"]').val(), minSum: $('input[name="minSum"]').val(),
                                note: $('textarea[name="note"]').val(), showCaseTypeId: $('select[name="type"]').val()};
                            $.ajax({
                                url: '/showCase/edit/action',
                                type: 'POST',
                                data: JSON.stringify(arr),
                                contentType: 'application/json; charset=utf-8',
                                dataType: 'json',

                                success: function(result) {
                                    if (result != null) {
                                        window.location.assign("/showCase/edit/" + result);
                                        return false;
                                    }
                                },
                                error: function() {
                                    console.log("Error");
                                }
                            });
                        }
                    </script>
                        <button type="submit" data-toggle="modal" data-target="#addPhoto" class="btn btn-primary pull-left" style="margin-bottom: 10px;">Добавить фото</button>
                    <div class="modal fade" role="dialog" id="addPhoto" tabindex="-1" aria-labelledby="gridModalLabel"
                         data-backdrop="false" style="background-color: rgba(0, 0, 0, 0.5); display: none;">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content" style="width: 800px; height: 900px;">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                            aria-hidden="true">×</span></button>
                                    <h4 class="modal-title" id="cityModalLabel">Добавить фото</h4></div>
                                <%--<form  class="dropzone">
                                    <div class="fallback">
                                        <input name="file" type="file" multiple />
                                    </div>
                                </form>--%>
                                <form action="/showCase/file-upload/${modelValue.id}" method="POST" enctype="multipart/form-data">
                                    <label class="custom-file-upload" style="display: inline-block; padding: 6px 12px; cursor: pointer;">
                                        <span class="btn btn-primary btn-file">
                                            Выбрать...<input type="file" id="files" name="files" style="display: none;"/>
                                        </span>
                                    </label>
                                    <div id="photo" style="width: 800px; height: 600px;"></div>
                                    <script>
                                        var showFile = (function () {
                                            var fr = new FileReader,
                                                    i = 0,
                                                    files, file;

                                            fr.onload = function (e) {
                                                var p;
                                                if (file.type.match('image.*')) {
                                                    p = '<img class="img-thumbnail" id="p" src="' + e.target.result + '" style="height: 100%; object-fit: cover; display:block; margin:15px auto 25px;">';
                                                    $('#photo').html(p);
                                                }
                                                file = files[++i];
                                                if (file) {
                                                    fr.readAsDataURL(file)
                                                } else {
                                                    i = 0;
                                                }
                                            };

                                            return function (e) {
                                                files = e.target.files;
                                                file = files[i];
                                                if (files) {
                                                    while (i < files.length && !file.type.match('image.*')) {
                                                        file = files[++i];
                                                    }
                                                    if (file) fr.readAsDataURL(files[i])
                                                }
                                            }

                                        })();

                                        document.getElementById('files').addEventListener('change', showFile, false);

                                    </script>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-primary">Сохранить</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-9">
                        <c:forEach items="${modelValue.imageList}" var="imageList">
                            <div class="col-xs-5 col-sm-3">
                                <a rel="lightbox" href="/images/${imageList.image}">
                                    <img src="/images/${imageList.image}" class="img-rounded"
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
