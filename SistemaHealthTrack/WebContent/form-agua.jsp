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
        <div class="main category-water">
            <div class="banner"></div>
            <div class="wrp">
                <h2 class="title-page">Adicionar Água</h2>
                <div class="form">
                    <form class="" action="agua.jsp" method="get">
                        <div class="form-group">
                            <label for="date" class="form-label">Data</label>
                            <input type="text" name="date" value="" id="date" required title="Por favor digite uma data válida" class="form-input">
                        </div>
                        <div class="form-group">
                            <label for="qqtd-water" class="form-label">Quantidade (L)</label>
                            <input type="tel" maxlength="1" required title="Por favor digite uma quantidade" name="qqtd-water" value="" id="qtd-water" class="form-input number">
                        </div>
                        <div class="form-group btns">
                            <button name="cancel" title="Cancelar" class="btn cancel">Cancelar</button>
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