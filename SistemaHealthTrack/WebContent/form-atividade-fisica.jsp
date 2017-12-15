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
        <div class="main category-fitness">
            <div class="banner"></div>
            <div class="wrp">
                <h2 class="title-page">Adicionar Atividade Física</h2>
                <div class="form">
                    <form class="" action="atividade-fisica.jsp" method="get">
                        <div class="form-group">
                            <label for="date" class="form-label">Data</label>
                            <input type="text" name="date" value="" id="date" required title="Por favor digite uma data válida" class="form-input">
                        </div>
                        <div class="form-group">
                            <label for="type_fitness" class="form-label">Exercício Físico</label>
                            <div class="form-select">
                                <select name="type_fitnes" required title="Por favor selecione uma opção">
                                    <option value="empty"></option>
                                    <option value="cafe-da-manha">Alongamento</option>
                                    <option value="bale">Balé</option>
                                    <option value="bicicleta">Bicicleta</option>
                                    <option value="caminhada">Caminhada</option>
                                    <option value="crossfit">Crossfit</option>
                                    <option value="danca-de-salao">Dança de salão</option>
                                    <option value="musculacao">Musculação</option>
                                    <option value="patins">Patins</option>
                                    <option value="skate">Skate</option>
                                    <option value="tai-chi-chuan">Tai chi chuan</option>
                                    <option value="treinamento-funcional">Treinamento funcional</option>
                                    <option value="yoga">Yoga</option>
                                    <option value="danca">Dança</option>
                                    <option value="ginastica-aerobica">Ginástica Aeróbica</option>
                                    <option value="ginastica-localizada">Ginástica localizada</option>
                                    <option value="ginastica-olimpica">Ginástica Olímpica</option>
                                    <option value="hidroginastica">Hidroginástica</option>
                                    <option value="power-jump">Power Jump</option>
                                    <option value="pilates">Pilates</option>
                                    <option value="spinning">Spinning</option>
                                    <option value="step">Step</option>
                                    <option value="tenis">Tênis</option>
                                    <option value="basquete">Basquete</option>
                                    <option value="caiaque">Caiaque</option>
                                    <option value="frescobol">Frescobol</option>
                                    <option value="futebol">Futebol</option>
                                    <option value="futvolei">Futvolei</option>
                                    <option value="handebol">Handebol</option>
                                    <option value="mergulho">Mergulho</option>
                                    <option value="natacao">Natação</option>
                                    <option value="rugby">Rugby</option>
                                    <option value="surf">Surf</option>
                                    <option value="volei">Volei</option>
                                    <option value="ciclismo">Ciclismo</option>
                                    <option value="corrida">Corrida</option>
                                    <option value="escalada">Escalada</option>
                                    <option value="lutas-diversas">Lutas diversas</option>
                                    <option value="rafting">Rafting</option>
                                    <option value="rapel">Rapel</option>
                                    <option value="remo">Remo</option>
                                    <option value="squash">Squash</option>
                                    <option value="beisebol">Beisebol</option>
                                    <option value="boliche">Boliche</option>
                                    <option value="equitacao">Equitação</option>
                                    <option value="esqui-aquatico">Esqui Aquático</option>
                                    <option value="esqui-na-neve">Esqui na neve</option>
                                    <option value="golfe">Golfe</option>
                                    <option value="pingue-pongue">Pingue-pongue</option>
                                    <option value="pole-dance">Pole Dance</option>
                                    <option value="pular-corda">Pular corda</option>
                                    <option value="windsurf">Windsurf</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-groups col2">
                            <div class="form-group">
                                <label for="hours" class="form-label">Duração</label>
                                <input type="tel" name="hours" value="" id="hours" required title="Por favor digite uma duração" class="form-input">
                            </div>
                            <div class="form-group">
                                <label for="calorie" class="form-label">Calorias</label>
                                <input type="tel" name="calorie" value="" id="calorie" class="form-input">
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