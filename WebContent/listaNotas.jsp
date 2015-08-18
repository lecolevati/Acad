<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<div id="cabecalho" align="center">
		<form action="listas" method="post">
			<table border="1">
				
				<tr>
					<td>Código da Disciplina</td>
					<td><input type="text" size="20" name="codigoDisciplina" value="${requestScope.codigoDisciplina}">
					</td>
				</tr>
				<tr>
					<td>Turno</td>
					<td><select name="codigoTurno">
							<option value="1" >Manhã</option>
							<option value="2" >Tarde</option>
							<option value="3" >Noite</option>
							<option value="4" >Integral</option>
					</select></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="Procurar"
						name="Procurar"></td>
				</tr>
			</table>
		</form>
	</div>
	<c:if test="${requestScope.erro ne null}">
		<c:out value="${requestScope.erro}" />
	</c:if>
	<c:if test="${requestScope.listaRegulares ne null}">
	<div id="lista" align="center">
		<table border="4">
			<tr>
				<td colspan="3" align="center"><b><c:out value="${ requestScope.curso}" /></b></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><b><c:out value="${ requestScope.disciplina}" />
					<c:out value=" - " /> <c:out value="${ requestScope.turno}" /></b></td>
			</tr>
			<c:forEach items="${ requestScope.listaRegulares}" var="listaRegulares">
				<c:choose>
					<c:when test="${ listaRegulares.media ge 0}">
						<c:set var="med" scope="session" value="${ listaRegulares.media}"/>
					</c:when>
					<c:otherwise>
						<c:set var="med" scope="session" value="${ 'F'}"/>
					</c:otherwise>
				</c:choose>
				<tr>
					<td><c:out value="${ listaRegulares.numeroDeMatricula}" />
					</td>
					<td><c:out value="${ listaRegulares.nome}" /></td>
					<td><input type="text" name="${ listaRegulares.numeroDeMatricula}" size="5" align="middle"
						value="<c:out value="${ med}" />">
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</c:if>
	<c:if test="${requestScope.listaRegulares eq null}">
	<div id="listavazia" align="center">
		<h1><c:out value="${requestScope.mensagem}" /></h1>
	</div>
	</c:if>
</body>
</html>