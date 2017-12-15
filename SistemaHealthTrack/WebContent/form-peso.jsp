<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="">
	<%@ include file="_head.jsp" %>
	<body>
      <div id="site" class="inner admim-items">
		<%@include file="_header.jsp" %>
          <div class="sidebar">
          	<%@include file="_info-user.jsp" %>
          </div>
          <div class="main category-weight">
              <div class="banner"></div>
              <div class="wrp">
                  <h2 class="title-page">Adicionar Peso</h2>
                  <div class="form">
                      <form class="" action="peso" method="post">
                      <input type="hidden" value="cadastrar" name="acao">
                      <div class="form-groups col2">
                          <div class="form-group">
                              <label for="date" class="form-label">Data</label>
                              <input type="text" name="date" value="" id="date" required title="Por favor digite uma data válida" class="form-input">
                          </div>
                          <div class="form-group">
                              <label for="weight" class="form-label">Peso (Kg)</label>
                              <input type="tel" name="weight" value="" id="weight" maxlength="6" required title="Por favor digite o seu peso" class="form-input">
                          </div>
                      </div>
                          <div class="form-group btns">
                              <button name="cancel" title="Cancelar"  class="btn cancel">Cancelar</button>
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