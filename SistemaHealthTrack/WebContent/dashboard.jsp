<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="">
	<%@ include file="_head.jsp" %>
	<body>
      <div id="site" class="inner dashboard">
      	<%@include file="_header.jsp" %>
          <div class="sidebar">
          	<%@include file="_info-user.jsp" %>
          </div>
          <div class="main">
              <div class="wrp">

                  <div class="category-register">
                      <h2 class="title-page">Últimos Registros</h2>
                    <div class="boxes-category">
                        <!-- weight  -->
                        <div class="box-item weight">
                            <div class="box-item-content">
                                <h3 class="category-title">Peso</h3>
                                <div class="category-date">
                                    <span class="date">14</span>
                                    <span class="month">Abril</span>
                                    <span class="year">2017</span>
                                </div>
                                <div class="category-content">
                                    <span class="number-weight headline">60<i>Kg</i></span>
                                </div>
                                <span class="weight-reference weight-before">50</span>
                                <span class="weight-reference weight-after">70</span>
                            </div>
                        </div>
                        <!-- food  -->
                        <div class="box-item food">
                            <div class="box-item-content">
                                <h3 class="category-title">Alimentação</h3>
                                <div class="category-date">
                                    <span class="date">06</span>
                                    <span class="month">Março</span>
                                    <span class="year">2017</span>
                                </div>
                                <div class="category-content">
                                    <span class="category-food headline small">almoço</span>Strogonoff de frango
                                </div>
                            </div>
                        </div>
                        <!-- gym  -->
                        <div class="box-item gym">
                            <div class="box-item-content">
                                <h3 class="category-title">Atividade Física</h3>
                                <div class="category-date">
                                    <span class="date">28</span>
                                    <span class="month">Março</span>
                                    <span class="year">2017</span>
                                </div>
                                <div class="category-content">
                                    <span class="headline">1h30min</span>Natação
                                </div>
                            </div>
                        </div>
                        <!-- blood pressure  -->
                        <div class="box-item blood-pressure">
                            <div class="box-item-content">
                                <h3 class="category-title">Pressão Arterial</h3>
                                <div class="category-date">
                                    <span class="date">06</span>
                                    <span class="month">Março</span>
                                    <span class="year">2017</span>
                                </div>
                                <div class="category-content">
                                    <span class="headline small">130/85 <i>mm/Hg</i></span>Normal Alta
                                </div>
                            </div>
                        </div>
                        <!-- blood glucose  -->
                        <div class="box-item glucose">
                            <div class="box-item-content">
                                <h3 class="category-title">Glicose</h3>
                                <div class="category-date">
                                    <span class="date">14</span>
                                    <span class="month">Abril</span>
                                    <span class="year">2017</span>
                                </div>
                                <div class="category-content">
                                    <span class="headline">70<i>md/dl</i></span>Nível de glicose:<br> Em jejum, sem medicação
                                </div>
                            </div>
                        </div>
                        <!-- colesterol  -->
                        <div class="box-item colesterol">
                            <div class="box-item-content">
                                <h3 class="category-title">Colesterol</h3>
                                <div class="category-date">
                                    <span class="date">03</span>
                                    <span class="month">Março</span>
                                    <span class="year">2017</span>
                                </div>
                                <div class="category-content">
                                    <span class="headline">190<i>md/dal</i></span>Colesterol:<br> Normal
                                </div>
                            </div>
                        </div>
                        <!-- water  -->
                        <div class="box-item water">
                            <div class="box-item-content">
                                <h3 class="category-title">Água</h3>
                                <div class="category-date">
                                    <span class="date">12</span>
                                    <span class="month">Março</span>
                                    <span class="year">2017</span>
                                </div>
                                <div class="category-content">
                                    <span class="headline">2L</span>
                                </div>
                            </div>
                        </div>
                        <!-- colesterol  -->
                        <div class="box-item sleep">
                            <div class="box-item-content">
                                <h3 class="category-title">Horas de sono</h3>
                                <div class="category-date">
                                    <span class="date">24</span>
                                    <span class="month">Março</span>
                                    <span class="year">2017</span>
                                </div>
                                <div class="category-content">
                                    <span class="headline">8H</span>
                                </div>
                            </div>
                        </div>
                    </div>
                  </div>
              </div>
          </div>
          <%@include file="_nav-add-categoria.jsp" %>
      </div>
		<%@ include file="_footer.jsp" %>
	</body>
</html>