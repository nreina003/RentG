<%-- 
    Document   : eliminarReserva
    Created on : 06-ene-2019, 18:32:53
    Author     : ADMIN
--%>

<%@page import="packBD.GestorClientes"%>
<%@page import="packModelo.Reserva"%>
<%@page import="packBD.GestorReservas"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="packBD.GestorClientes"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <table>
        <span id="logTitulo">Consulta de reservas de 
            <% String pEmail = (String) session.getAttribute("Email");
            String nombreCliente = GestorClientes.getInstance().getNombre(pEmail);%>
            <%= nombreCliente%> 
        </span> <br>
        <form action="SrvEliminarReserva" name="eliminar" method="post">
            <span class="textoFormulario">
                Citas pendientes:
                <% ArrayList<Reserva> ReservasPendientes = GestorReservas.getInstance().buscarReservasPendientes(pEmail);%>
            </span> 
            <% if (ReservasPendientes.size() == 0) { %> <br> <span class="textoFormulario"> No tiene reservas pendientes </span> <%} else {%>
            <div class="textoFormulario" align="center">
                <th>Email</th>
                <th>Fecha Fin</th>
                <th>Fecha Inicio</th>                                   
                <th>Lugar</th>
                <th>Matricula</th>
                <th>Coche Recogido</th>
                <th>Coche Entregado</th>
                <th>Pago Extra</th>
                <th>Retraso</th>
                </tr>
                <%
                    for (int i = 0; i < ReservasPendientes.size(); i++) {
                %>
                <td> 
                    <input type="radio" value="<%=ReservasPendientes.get(i).getIdReserva()%>" name = "RIdReserva"  > <%= ReservasPendientes.get(i).getIdReserva()%>
                </td>
                <  <tr class="textoFormulario">
                    <th><%= ReservasPendientes.get(i).getEmail()%></th>
                    <th><%= ReservasPendientes.get(i).getFechaFin()%></th>
                    <th><%= ReservasPendientes.get(i).getFechaInicio()%></th>
                    <th><%= ReservasPendientes.get(i).getLugar()%></th>
                    <th><%= ReservasPendientes.get(i).getMatricula()%></th>
                    <th><%= ReservasPendientes.get(i).getCocheRecogido()%></th>
                    <th><%= ReservasPendientes.get(i).getCocheEntregado()%></th>
                    <th><%= ReservasPendientes.get(i).getPagoExtra()%></th>
                    <th><%= ReservasPendientes.get(i).getRetraso()%></th>
                </tr> <% } %><% }%> 
                </table>
            </div>
            </html>
