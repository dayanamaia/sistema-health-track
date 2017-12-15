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
        <div class="main category-glucose">
            <div class="banner"></div>
            <div class="wrp">
                <h2 class="title-page">Adicionar Glicose</h2>
                <div class="form">
                    <form class="" action="glicose.jsp" method="get">
                        <div class="form-group">
                            <label for="date" class="form-label">Data</label>
                            <input type="text" name="date" value="" id="date" required title="Por favor digite uma data v�lida" class="form-input">
                        </div>
                        <div class="form-group">
                            <label for="level-glucose" class="form-label">N�vel de Glicose (mg/dL)</label>
                            <input type="tel" name="level-glucose" value="" id="level-glucose" required title="Por favor digite uma numera��o" maxlength="3" class="form-input number">
                        </div>
                        <div class="form-group">
                            <label for="time-food" class="form-label">Alimenta��o</label>
                            <div class="form-select">
                                <select name="time_food" required title="Por favor selecione uma op��o">
                                    <option value="empty"></option>
                                    <option value="antes-da-refeicao">Antes da refei��o</option>
                                    <option value="antes-de-dormir">Antes de dormir</option>
                                    <option value="antes-do-almoco">Antes do almo�o</option>
                                    <option value="antes-do-cafe-da-manha">Antes do caf� da manh�</option>
                                    <option value="antes-do-exercicio-fisico">Antes do exerc�cio f�sico</option>
                                    <option value="antes-do-jantar">Antes do jantar</option>
                                    <option value="apos-da-refeicao">Ap�s da refei��o</option>
                                    <option value="apos-de-dormir">Ap�s de dormir</option>
                                    <option value="apos-do-almoco">Ap�s do almo�o</option>
                                    <option value="apos-do-cafe-da-manha">Ap�s do caf� da manh�</option>
                                    <option value="apos-do-exercicio-fisico">Ap�s do exerc�cio f�sico</option>
                                    <option value="apos-do-jantar">Ap�s do jantar</option>
                                    <option value="em-jejum">Em jejum</option>
                                    <option value="ignorar">Ignorar</option>
                                    <option value="sem-jejum">Sem jejum</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="medication" class="form-label">Medica��o</label>
                            <div class="form-select">
                                <select name="medication" required title="Por favor selecione uma op��o">
                                    <option value=""></option>
                                    <option value="antes-da-medicacao">Antes da medica��o</option>
                                    <option value="apos-a-medicacao">Ap�s a medica��o</option>
                                    <option value="sem-medicacao">Sem medica��o</option>
                                    <option value="ignorar">Ignorar</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                              <label for="obs" class="form-label">Observa��es</label>
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