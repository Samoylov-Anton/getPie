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
          <form class="form">
            <div class="row" style="margin-left:0;">
            <button class="btn btn-primary pull-left" onclick="createShowCase()">Сохранить</button>
              </div>
            <div>
              <label for="showCaseName">Название</label>
              <input type="text" class="form-control" id="showCaseName" name="name">
            </div>
            <div>
              <label for="showCaseminSum">Минимальная сумма</label>
              <input type="text" class="form-control" id="showCaseminSum" name="minSum">
            </div>
            <div>
              <label for="showCaseNote">Описание</label>
              <textarea class="form-control" rows="5" id="showCaseNote" name="note"></textarea>
            </div>
          </form>
          <script>
            function createShowCase() {
              $.ajax({
                url: '/showCase/create/action',
                type: 'POST',
                data: 'name=' + $('input[name="name"]').val() + '&minSum=' + $('input[name="minSum"]').val() + '&note=' + $('input[name="note"]').val(),

                success: function(result) {
                  if (result != null) {
                    window.location = "/showCase/edit/" + result;
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
