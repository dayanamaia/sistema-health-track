<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js" lang="">
	<%@ include file="_head.jsp" %>
	<body>
      <div id="site" class="inner edit-items">
		<%@include file="_header.jsp" %>
          <div class="sidebar">
          	<%@include file="_info-user.jsp" %>
          </div>
        <div class="main category-cholesterol">
            <div class="banner"></div>
            <div class="wrp">
                <h2 class="title-page">Editar Colesterol</h2>
                <div class="form">
                    <form class="" action="colesterol" method="post">
					    <input type="hidden" value="editar" name="acao">
					    <input type="hidden" value="${colesterol.id }" name="id">
                        <div class="form-group">
                            <label for="date" class="form-label">Data</label>
                            <input type="text" name="date" value="<fmt:formatDate value="${colesterol.data.time }" type="both" pattern="dd/MM/yyyy"/>" id="date" required title="Por favor digite uma data válida" class="form-input">
                        </div>
                        <div class="form-group">
                            <label for="total-cholesterol" class="form-label">Colesterol Total (mg/dl)</label>
                            <input type="tel" name="total-cholesterol" value="${colesterol.colesterolTotal }" id="total-cholesterol" required title="Por favor digite uma numeração" maxlength="3" class="form-input number">
                        </div>
                        <div class="form-groups col3">
                            <div class="form-group">
                                <label for="triglicerides" class="form-label">Triglicérides (mg/dl)</label>
                                <input type="tel" name="triglicerides" value="${colesterol.triglicerides }" id="triglicerides" required title="Por favor digite uma numeração" maxlength="3" class="form-input number">
                            </div>
                            <div class="form-group">
                                <label for="ldl" class="form-label">LDL (mg/dl)</label>
                                <input type="tel" name="ldl" value="${colesterol.ldl }" id="ldl" required title="Por favor digite uma numeração" maxlength="3" class="form-input number">
                            </div>
                            <div class="form-group">
                                <label for="hdl" class="form-label">HDL (mg/dl)</label>
                                <input type="tel" name="hdl" value="${colesterol.hdl }" id="hdl" required title="Por favor digite uma numeração" maxlength="3" class="form-input number">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="obs" class="form-label">Observações</label>
                            <textarea name="obs" rows="8" cols="80" class="form-textarea">${colesterol.observacao }</textarea>
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