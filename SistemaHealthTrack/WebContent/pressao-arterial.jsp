<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js" lang="">
	<%@ include file="_head.jsp" %>
	<body>
      <div id="site" class="inner all-items">
		<%@include file="_header.jsp" %>
          <div class="sidebar">
          	<%@include file="_info-user.jsp" %>
          </div>

          <div class="main">
              <div class="wrp">
                  <div class="category-pressure">
                      <h2 class="title-page">Pressão Arterial</h2>
                      
                      <c:if test="${empty pressao}">
						<%@include file="_list-empty.jsp" %>
                      </c:if>
                      
                      <table class="category-table">
                          <tbody>
						      <c:forEach items="${pressao }" var="p">
						        
                              <tr>
						            <td class="table-date">
						            	<fmt:formatDate value="${p.data.time }" type="both" dateStyle="full" pattern="dd"/>
						            	<span class="small"><fmt:formatDate value="${p.data.time }" type="date" dateStyle="long" pattern="MMMM YYYY"/></span>
						            </td>
                                  <td class="table-icon"><span class="icon"></span></td>
                                  <td class="table-content">
                                      <p>Normal<span class="small">${p.sistoticaMaior }/${p.diastoticaMenor } mm/Hg</span></p>
                                  </td>
                                  <td class="table-support item-admin">
							            <c:url value="pressao-arterial" var="link">
							              <c:param name="acao" value="form-pressao-arterial-editar"/>
							              <c:param name="id" value="${p.id }"/>
							            </c:url>
						                <a href="${link}" title="Editar o item" class="icon edit">Editar o item</a>
						                <button type="button" title="Excluir o item" class="icon delete" data-toggle="modal" data-target="#excluirModal" data-form="pressao-arterial" data-id="${p.id}">Excluir</button>
                                  </td>
                              </tr>
						      </c:forEach>
                          </tbody>
                      </table>
                  </div>
              </div>
          </div>
      		<%@include file="_nav-add-categoria.jsp" %>
      </div>
		<%@ include file="_footer.jsp" %>
	</body>
</html>