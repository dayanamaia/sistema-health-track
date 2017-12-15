<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html class="no-js" lang="">
	<%@ include file="_head.jsp" %>
	<body>
      <div id="site" class="inner edit-items">
		<%@include file="_header.jsp" %>
          <div class="sidebar">
          	<%@include file="_info-user.jsp" %>
          </div>
          <div class="main category-weight">
              <div class="banner"></div>
              <div class="wrp">
                  <h2 class="title-page">Editar Peso</h2>
                  <div class="form">
                      <form class="" action="peso" method="post">
					    <input type="hidden" value="editar" name="acao">
					    <input type="hidden" value="${peso.id }" name="id">
                      <div class="form-groups col2">
                          <div class="form-group">
                              <label for="date" class="form-label">Data</label>
                              <input type="text" name="date" value="<fmt:formatDate value="${peso.data.time }" type="both" pattern="dd/MM/yyyy"/>" id="date" required title="Por favor digite uma data válida" class="form-input">
                          </div>
                          <div class="form-group">
                              <label for="weight" class="form-label">Peso (Kg)</label>
                              <input type="tel" name="weight" value="${peso.peso }" id="weight" maxlength="6" required title="Por favor digite o seu peso" class="form-input">
                          </div>
                      </div>
                          <div class="form-group btns">
                              <a href="peso?acao=listar" title="Cancelar"  class="btn cancel">Cancelar</a>
                              <button name="add" title="Adicionar" class="btn">Adicionar</button> 	
                          </div>
                      </form>
                  </div>
              </div>
          </div>
      </div>
		<%@ include file="_footer.jsp" %>
	</body>
</html>