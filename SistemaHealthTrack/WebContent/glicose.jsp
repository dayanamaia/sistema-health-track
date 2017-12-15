<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="">
	<%@ include file="_head.jsp" %>
	<body>
      <div id="site" class="inner all-items">
		<%@include file="_header.jsp" %>
          <div class="sidebar">
          	<%@include file="_info-user.jsp" %>
          </div>

          <div class="main">
              <div class="wrp">
                  <div class="category-glucose">
                      <h2 class="title-page">Glicose</h2>

                      <table class="category-table">
                          <tbody>
                              <tr>
                                  <td class="table-date">24 <span class="small">Abril 2017</span></td>
                                  <td class="table-icon"><span class="icon"></span></td>
                                  <td class="table-content">
                                      <p>Nível de glicose: 70mg/dL <span class="small">Em jejum <i>&bull;</i> Sem medicação</span></p>
                                  </td>
                                  <td class="table-support item-admin">
                                      <a href="" title="Editar o item" class="icon edit">Editar o item</a>
                                      <a href="" title="Excluir o item" class="icon delete">Excluir o item</a>
                                  </td>
                              </tr>
                          </tbody>
                      </table>
                  </div>
              </div>
          </div>
      	<%@include file="_nav-add-categoria.jsp" %>
      </div>
		<%@ include file="_footer.jsp" %>
	</body>
</html>