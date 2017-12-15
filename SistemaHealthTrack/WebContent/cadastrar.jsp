<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="">
	<%@ include file="_head.jsp" %>
	<body>
		<div id="site" class="signup">
	          <header role="header">
	              <div class="logo">
	                  <a href="index.jsp" title="Health Track" class="logo-link">Health Track</a>
	              </div>
	          </header>
	          <div class="sidebar">
	              <div class="info-page">
	                  <h2 class="info-page-title">Cadastrar uma conta</h2>
	                  <p>Cadastre-se para saber mais como monitorar a sua saúde :)</p>
	              </div>
	          </div>
	
          <div class="main">
              <div class="wrp">
                  <h2 class="title-page">Cadastre uma conta</h2>
                  <div class="form">
                      <form class="" action="dashboard.jsp" method="get">
                          <div class="form-group">
                              <label for="name" class="form-label">Nome Completo</label>
                              <input type="text" name="name value="" id="name" minlength="8" maxlength="100" required title="Por favor digite o seu nome completo" class="form-input">
                          </div>
                          <div class="form-group">
                              <label for="date" class="form-label">Data de Nascimento</label>
                              <input type="text" name="date" value="" id="date" required data-rule-date="true" title="Por favor digite sua data de nascimento" class="form-input">
                          </div>
                          <div class="form-group">
                              <label for="height" class="form-label">Atura</label>
                              <input type="tel" name="height" value="" id="height" minlength="4" maxlength="4" required title="Por favor digite sua altura" class="form-input">
                          </div>
                          <div class="form-group input-check">
                              <p class="form-label">Sexo</p>
                              <input id="male" value="male" name="sexo" type="radio" required title="Por favor selecione uma opção" class="custom-checkbox">
                              <label for="male" class="custom-checkbox-label">Masculino</label>
                              <input id="female" value="female" name="sexo" type="radio" required title="Por favor selecione uma opção" class="custom-checkbox">
                              <label for="female" class="custom-checkbox-label">Feminino</label>
                          </div>
                          <div class="form-group">
                              <label for="email" class="form-label">E-mail</label>
                              <input type="text" name="email" value="" id="email" required title="Por favor digite um e-mail válido" class="form-input">
                          </div>
                          <div class="form-group">
                              <label for="password" class="form-label">Senha</label>
                              <input type="password" name="password" value="" id="password" minlength="8" maxlength="8" required title="Por favor digite uma senha válida" class="form-input" class="form-input">
                          </div>
                          <div class="form-group">
                              <label for="repeat_password" class="form-label">Repetir a Senha</label>
                              <input type="password" name="repeat_password" value="" id="repeat_password" minlength="8" maxlength="8" equalto="#password" required title="Por favor digite uma senha válida" class="form-input">
                          </div>
                          <div class="form-group">
                              <button name="button" title="Cadastrar" class="btn">Cadastrar</button>
                          </div>
                      </form>
                  </div>
                  <div class="info-create-account">
                      <p>Já possui uma conta? <a href="index.jsp" title="Entra na conta">Entrar na conta</a>.</p>
                  </div>
              </div>
	<%@ include file="_footer.jsp" %>
	</body>
</html>