<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="">
<%@ include file="_head.jsp" %>
<body>
	<div id="site" class="account">
	    <header role="header">
	        <div class="logo">
	            <a href="" title="Health Track" class="logo-link">Health Track</a>
	        </div>
	    </header>
          <div class="main">
              <div class="slide">
                  <div class="slide-item" data-img="bg-monitore-exercicios-fisicos.jpg">
                      <div class="slide-info">
                          <h2 class="slide-info-title">Monitore a sua Atividade F�sica</h2>
                      </div>
                  </div>
                  <div class="slide-item" data-img="bg-monitore-sua-alimentacao.jpg">
                      <div class="slide-info">
                          <h2 class="slide-info-title">Monitore a sua alimenta��o</h2>
                      </div>
                  </div>
                  <div class="slide-item" data-img="bg-monitore-sua-saude.jpg">
                      <div class="slide-info">
                          <h2 class="slide-info-title">Monitore a sua sa�de</h2>
                      </div>
                  </div>
              </div>
          </div>

          <div class="sidebar">
              <div class="wrp">
                  <h2 class="title-page">Entrar na conta</h2>
                  <div class="form">
                      <form class="" action="home" method="post">
                          <div class="form-group">
                              <label for="email" class="form-label">E-mail</label>
                              <input type="text" name="email" value="" id="email" class="form-input" required title="Por favor digite um e-mail v�lido">
                          </div>
                          <div class="form-group">
                              <label for="senha" class="form-label">Senha</label>
                              <input type="password" name="password" value="" id="password" class="form-input" minlength="8" maxlength="8" required title="Por favor digite uma senha v�lida">
                          </div>
                          <div class="form-group">
                              <button name="button" title="Entrar" class="btn">Entrar</button>
                          </div>
                      </form>
                  </div>
                  <div class="info-create-account">
                      <p>N�o tem uma conta? <a href="cadastrar.jsp" title="Cadastre-se">Cadastre-se</a>.</p>
                  </div>
              </div>
          </div>
    </div>
<%@ include file="_footer.jsp" %>
</body>
</html>