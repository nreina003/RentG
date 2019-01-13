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

                                String fecha = request.getParameter("fecha");
                                System.out.println("fecha");
                                System.out.println(fecha);

                                System.out.println(SvrConsultarReservas.getInstance().buscarReservasPorFecha(fecha));
                                ArrayList<Reserva> reservas = SvrConsultarReservas.getInstance().buscarReservasPorFecha(fecha);


                            %>   

                            <% if (reservas.size() == 0) {
                                    System.out.println(reservas);
                            %> <br> 
                            <span class="textoFormulario">no hay reservas o no ha introducido una matricula en el paso anterior </span> <%} else {%>
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
                            <form action="SvrEliminarReserva" name="eliminar1" method="post">
                                <%
                                    for (int i = 0; i < reservas.size(); i++) {
                                        System.out.println(reservas);
                                %>   
                                <tr class="textoFormulario">
                                    <th><%= reservas.get(i).getIdReservas()%></th>
                                    <th><%= reservas.get(i).getEmail()%></th>
                                    <th><%= reservas.get(i).getFechaFin()%></th>
                                    <th><%= reservas.get(i).getFechaInicio()%></th>
                                    <th><%= reservas.get(i).getLugar()%></th>
                                    <th><%= reservas.get(i).getMatricula()%></th>
                                    <th><%= reservas.get(i).getCocheRecogido()%></th>
                                    <th><%= reservas.get(i).getCocheEntregado()%></th>
                                    <th><%= reservas.get(i).getPagoExtra()%></th>
                                    <th><%= reservas.get(i).getRetraso()%></th>
                                    <th><input type="radio" value="<%=reservas.get(i).getIdReservas()%>" name = "idr" id="idr"  > <%= reservas.get(i).getIdReservas()%></th>

                                </tr>
                                <% } %><% }%> <br> 
                                <input type="submit" name="eliminar" id="eliminar" value="Eliminar"/>
                            </form>
                        </table>
                        <span class="textoFormulario">
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