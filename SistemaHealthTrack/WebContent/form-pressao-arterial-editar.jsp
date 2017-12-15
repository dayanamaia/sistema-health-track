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
        <div class="main category-pressure">
            <div class="banner"></div>
            <div class="wrp">
                <h2 class="title-page">Editar Pressão Arterial</h2>
                <div class="form">
                    <form class="" action="pressao-arterial" method="post">
					    <input type="hidden" value="editar" name="acao">
					    <input type="hidden" value="${pressaoArterial.id }" name="id">
                        <div class="form-group">
                            <label for="date" class="form-label">Data</label>
                            <input type="text" name="date" value="<fmt:formatDate value="${pressaoArterial.data.time }" type="both" pattern="dd/MM/yyyy"/>" id="date" required title="Por favor digite uma data válida" class="form-input">
                        </div>
                        <div class="form-groups col2">
                            <div class="form-group">
                                <label for="sistotica_maior" class="form-label">Sistótica Maior (mmHg)</label>
                                <input type="tel" name="sistotica_maior" value="${pressaoArterial.sistoticaMaior }" id="sistotica_maior" required title="Por favor digite uma numeração" maxlength="3"  class="form-input number">
                            </div>
                            <div class="form-group">
                                <label for="diastotica_menor" class="form-label">Diastótica Menor (mmHg)</label>
                                <input type="tel" name="diastotica_menor" value="${pressaoArterial.diastoticaMenor }" id="diastotica_menor" required title="Por favor digite uma numeração" maxlength="3" class="form-input number">
                            </div>
                        </div>
                          <div class="form-group">
                              <label for="obs" class="form-label">Observações</label>
                              <textarea name="obs" rows="8" cols="80" class="form-textarea">${pressaoArterial.observacao }</textarea>
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