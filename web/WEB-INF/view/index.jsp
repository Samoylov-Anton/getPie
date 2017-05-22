<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags"%>

<page:template>

  <jsp:attribute name="title">getPie</jsp:attribute>

  <jsp:body>

    <div class="container">

    <div class="row row-offcanvas row-offcanvas-right">

      <div id="showCase" class="col-xs-12 col-sm-9">


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
<script type="text/javascript">
  ymaps.ready(function(){
    window.onload = reloadPage();
  });
</script>
