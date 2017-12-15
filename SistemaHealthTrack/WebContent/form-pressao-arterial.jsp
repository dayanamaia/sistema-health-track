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
        <div class="main category-pressure">
            <div class="banner"></div>
            <div class="wrp">
                <h2 class="title-page">Adicionar Pressão Arterial</h2>
                <div class="form">
                    <form class="" action="pressao-arterial" method="post">
                    	<input type="hidden" value="cadastrar" name="acao">
                        <div class="form-group">
                            <label for="date" class="form-label">Data</label>
                            <input type="text" name="date" value="" id="date" required title="Por favor digite uma data válida" class="form-input">
                        </div>
                        <div class="form-groups col2">
                            <div class="form-group">
                                <label for="sistotica_maior" class="form-label">Sistótica Maior (mmHg)</label>
                                <input type="tel" name="sistotica_maior" value="" id="sistotica_maior" required title="Por favor digite uma numeração" maxlength="3"  class="form-input number">
                            </div>
                            <div class="form-group">
                                <label for="diastotica_menor" class="form-label">Diastótica Menor (mmHg)</label>
                                <input type="tel" name="diastotica_menor" value="" id="diastotica_menor" required title="Por favor digite uma numeração" maxlength="3" class="form-input number">
                            </div>
                        </div>
                          <div class="form-group">
                              <label for="obs" class="form-label">Observações</label>
                              <textarea name="obs" rows="8" cols="80" class="form-textarea"></textarea>
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