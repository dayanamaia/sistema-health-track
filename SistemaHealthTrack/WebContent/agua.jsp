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
                  <div class="category-water">
                      <h2 class="title-page">Água</h2>

                      <table class="category-table">
                          <tbody>
                              <tr>
                                  <td class="table-date">01 <span class="small">Agosto 2017</span></td>
                                  <td class="table-icon"><span class="icon"></span></td>
                                  <td class="table-content">
                                      <p>2L</p>
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