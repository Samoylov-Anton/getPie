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
          <c:forEach items="${showCaseList}" var="entry">
          <div class="jumbotron" style="padding-bottom: 5px;">
            <div class="row">
            <img src="${entry.avatar}" class="img-rounded pull-left" style="height: 50px; width: 50px;margin-right: 5px;"/>
            <span style="height: 50px;">${entry.note}</span>
            </div>
            <div class="row" style="margin-top: 5px;">
              <c:forEach items="${entry.imageList}" var="imageList">
                <div class="col-xs-5 col-sm-3">
                  <a rel="lightbox" href="${imageList.image}">
                    <img src="${imageList.image}" class="img-rounded" style="height: 150px; width: 150px; display: block;">
                  </a>
                </div>
              </c:forEach>
              <div class="row pull-left" style="margin-top:10px;">
                <p>
                <span class="glyphicon glyphicon-rub" aria-hidden="true">${entry.minSum}</span>
                <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true">${entry.like}</span>
                </p>
              </div>
            </div>
          </div>
          </c:forEach>

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
