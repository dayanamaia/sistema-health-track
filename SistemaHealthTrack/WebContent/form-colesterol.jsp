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
        <div class="main category-cholesterol">
            <div class="banner"></div>
            <div class="wrp">
                <h2 class="title-page">Adicionar Colesterol</h2>
                <div class="form">
                    <form class="" action="colesterol" method="post">
                    	<input type="hidden" value="cadastrar" name="acao">
                        <div class="form-group">
                            <label for="date" class="form-label">Data</label>
                            <input type="text" name="date" value="" id="date" required title="Por favor digite uma data válida" class="form-input">
                        </div>
                        <div class="form-group">
                            <label for="total-cholesterol" class="form-label">Colesterol Total (mg/dl)</label>
                            <input type="tel" name="total-cholesterol" value="" id="total-cholesterol" required title="Por favor digite uma numeração" maxlength="3" class="form-input number">
                        </div>
                        <div class="form-groups col3">
                            <div class="form-group">
                                <label for="triglicerides" class="form-label">Triglicérides (mg/dl)</label>
                                <input type="tel" name="triglicerides" value="" id="triglicerides" required title="Por favor digite uma numeração" maxlength="3" class="form-input number">
                            </div>
                            <div class="form-group">
                                <label for="ldl" class="form-label">LDL (mg/dl)</label>
                                <input type="tel" name="ldl" value="" id="ldl" required title="Por favor digite uma numeração" maxlength="3" class="form-input number">
                            </div>
                            <div class="form-group">
                                <label for="hdl" class="form-label">HDL (mg/dl)</label>
                                <input type="tel" name="hdl" value="" id="hdl" required title="Por favor digite uma numeração" maxlength="3" class="form-input number">
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