
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
                            <caption>Consultar Reservas</caption>
                            <thead>
                                <tr>
                                    <th>
                                        <form name="formpac" id="formpac" action="SrvConsultarReservas" method="post">

                                            <p>Elija tipo de consulta:<select name="nomConsulta" id="modelo" size="1">
                                                    <option value="fecha" >Fecha</option>
                                                    <option value="cliente" >Cliente</option>
                                                    <option value="coche" >Coche</option>   
                                                </select> 
                                            </p><input type="submit" name="consultar" id="consultar" value="Consultar"/>
                                        </form>
                                    </th>
                                    <th></th>
                                    <th></th>

                                </tr>
                                <tr>
                                    <th>Email</th>
                                    <th>Fecha Fin</th>
                                    <th>Fecha Inicio</th>
                                    <th>ID</th>
                                    <th>Lugar</th>
                                    <th>Matricula</th>
                                </tr>
                            </thead>
                            
                            <tbody id="elementsList">
                                <tr>
                                    <td colspan="3">No hay elementos que mostrar</td>
                                </tr>
                            </tbody>
                        </table>
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