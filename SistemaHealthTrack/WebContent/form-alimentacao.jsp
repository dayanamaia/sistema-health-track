<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js" lang="">
	<%@ include file="_head.jsp" %>
	<body>
      <div id="site" class="inner admim-items">
		<%@include file="_header.jsp" %>
          <div class="sidebar">
          	<%@include file="_info-user.jsp" %>
          </div>
        <div class="main category-food">
            <div class="banner"></div>
            <div class="wrp">
                <h2 class="title-page">Adicionar Alimentação</h2>
                <div class="form">
                    <form class="" action="alimentacao" method="post">
                        <input type="hidden" value="form-alimentacao-cadastrar" name="acao">
                        <div class="form-group">
                            <label for="date" class="form-label">Data</label>
                            <input type="text" name="date" value="" id="date" required title="Por favor digite uma data válida" class="form-input">
                        </div>
                        <!-- <div class="form-group">
                            <label for="type_meal" class="form-label">Categoria da refeição</label>
                            <div class="form-select">
                                <select name="type_meal" class="select_category" required title="Por favor selecione uma opção">
                                    <option value="empty"></option>
                                    <option value="cafe-da-manha">Café da manhã</option>
                                    <option value="almoco">Almoço</option>
                                    <option value="janta">Janta</option>
                                    <option value="lanche">Lanche</option>
                                </select>
                            </div>
                        </div>-->
                        <div class="form-group">
                            <label for="type_food" class="form-label">Categoria do alimento</label>
                            <div class="form-select">
                                <select name="type_food" class="select_category" required title="Por favor selecione uma opção">
                                    <option value="empty"></option>
							        <c:forEach items="${categoriaAlimentacao }" var="ca">
							          <option value="${ca.id }" >${ca.nome }</option>
							        </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name-food" class="form-label">Nome do alimento</label>
                            <input type="text" name="name-food" value="" id="name-food" maxlength="80" required title="Por favor digite o nome do alimento" class="form-input">
                        </div>
                        <div class="form-groups col2">
                            <div class="form-group">
                                <label for="qtd-food" class="form-label">Quantidade (gramas)</label>
                                <input type="tel" maxlength="4" required title="Por favor digite uma quantidade" name="qtd-food" value="" id="qtd-food" class="form-input number">
                            </div>
                            <div class="form-group">
                                <label for="calorie" class="form-label">Calorias</label>
                                <input type="tel" name="calorie" value="" id="calorie" maxlength="3" required title="Por favor digite uma caloria" class="form-input number">
                            </div>
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