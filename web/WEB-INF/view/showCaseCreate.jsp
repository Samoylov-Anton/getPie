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
              <input type="text" class="form-control" id="showCaseName" name="name">
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
              <input type="text" class="form-control" id="showCaseminSum" name="minSum">
            </div>
            <div>
              <label for="showCaseNote">Описание</label>
              <textarea class="form-control" rows="3" id="showCaseNote" name="note"></textarea>
            </div>
          </form>
          <script type="text/javascript">
            function createShowCase() {
              var arr = { name: $('input[name="name"]').val(), minSum: $('input[name="minSum"]').val(), note: $('textarea[name="note"]').val(),
                showCaseTypeId: $('select[name="type"]').val()};
              $.ajax({
                url: '/showCase/create/action',
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
