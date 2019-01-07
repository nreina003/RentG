<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="packBD.*"%>
<%@page import="packModelo.*"%>
<%@page import="packServlets.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>

        <title>Consultar Reservas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="img/favicon.png" />
        <link rel="stylesheet" href="css/index.css">
        <script src="js/consultarReservas.js"></script>
    </head>
    <body>
        <header id="cabeceralogo">
            <div>
                <h1>RENTG02</h1>
            </div>
        </header>
        <nav id="menuprincipal">
            <div>
                <ul>
                    <li><a href="reservaLogeado.jsp">Reservar</a></li>
                    <li><a href="contactoLog.jsp">Contacto</a></li>
                    <li>
                        <form action="SvrLogoff" method="post">   
                            <button type="submit" id="logoff">Cerrar Sesión</button>
                        </form>
                    </li>
                </ul>
            </div>
        </nav>
        <main>
            <div>
                <section id="articulosprincipales">

                    <div id="elements">
                        <table>

                            <thead>

                            </thead>

                            <span id="logTitulo">Consulta de reservas 
                                
                            </span> <br>


                            <% 
                               System.out.println( SvrConsultarReservas.getInstance().buscarReservasPorEmail());
                                ArrayList<Reserva> reservas = SvrConsultarReservas.getInstance().buscarReservasPorEmail();
                                                        System.out.println(reservas);

                            %>   
                         
                            <% if (reservas.size() == 0) {  
                               System.out.println(reservas);
                            %> <br> 
                            <span class="textoFormulario">no hay reservas </span> <%} else {%>
                            <tr align="center" border=1>
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
                                for (int i = 0; i < reservas.size(); i++) {
                                       System.out.println(reservas);
                            %>   
                            <tr class="textoFormulario">
                                <th><%= reservas.get(i).getEmail()%></th>
                                <th><%= reservas.get(i).getFechaFin()%></th>
                                <th><%= reservas.get(i).getFechaInicio()%></th>
                                <th><%= reservas.get(i).getLugar()%></th>
                                <th><%= reservas.get(i).getMatricula()%></th>
                                <th><%= reservas.get(i).getCocheRecogido()%></th>
                                <th><%= reservas.get(i).getCocheEntregado()%></th>
                                <th><%= reservas.get(i).getPagoExtra()%></th>
                                <th><%= reservas.get(i).getRetraso()%></th>
                            </tr>
                            <% } %><% }%> <br> 
                        </table>
                        <span class="textoFormulario">
                            Reservas Pendientes:
                            <table>
                                
                                 <% String f = (String) session.getAttribute("email");%>
                                <% ArrayList<Reserva> reservasPendientes = SvrConsultarReservas.getInstance().buscarReservasPendientes(f);%>
                        </span> 
                        <% if (reservasPendientes.size() == 0) { %> <br> <span class="textoFormulario"> No tiene Reservas pendientes </span> <%} else {%>
                        <tr align="center" border=1>
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
                            for (int i = 0; i < reservasPendientes.size(); i++) {
                        %>   
                        <tr class="textoFormulario">
                            <th><%= reservasPendientes.get(i).getEmail()%></th>
                            <th><%= reservasPendientes.get(i).getFechaFin()%></th>
                            <th><%= reservasPendientes.get(i).getFechaInicio()%></th>
                            <th><%= reservasPendientes.get(i).getLugar()%></th>
                            <th><%= reservasPendientes.get(i).getMatricula()%></th>
                            <th><%= reservasPendientes.get(i).getCocheRecogido()%></th>
                            <th><%= reservasPendientes.get(i).getCocheEntregado()%></th>
                            <th><%= reservasPendientes.get(i).getPagoExtra()%></th>
                            <th><%= reservasPendientes.get(i).getRetraso()%></th>
                        </tr>
                        <% } %><% }%> <br> 
                        </table>
                    </div>
            </div>

        </section>
        <aside id="infoadicional">
            <h1>Nuestras oficinas</h1>
            <p>Vitoria</p>
            <p>Donostia</p>
            <p>Bilbo</p>
            <div id="logo">
                <img src="img/favicon.png" alt="Logo" />
            </div>
        </aside>
        <div class="recuperar"></div>
    </div>
</main>
<footer id="pielogo">
    <div>
        <section class="seccionpie">
            <h1>Sitio Web</h1>
            <p><a href="index.jsp">Principal</a></p>
            <p><a href="fotos.jsp">Fotos</a></p>
            <p><a href="videos.jsp">Videos</a></p>
        </section>
        <section class="seccionpie">
            <h1>Ayuda</h1>
            <p><a href="contacto.jsp">Contacto</a></p>
        </section>
        <section class="seccionpie">
            <address>Vitoria, País Vasco</address>
            <small>&copy; Derechos Reservados 2018</small>
        </section>
        <div class="recuperar"></div>
    </div>
</footer>
</body>
</html>