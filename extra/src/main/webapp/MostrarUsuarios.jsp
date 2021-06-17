<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Helados</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<section id="main-content">
    <div class="login">
        <form method="post" name="contras">
            <label>Contraseña: </label>

            <input type="text" name="contr">
            <% String contrasena = request.getParameter("contr");%>

        </form>
        <form method="post" name="tabla">

            <table border="2">
                <tr>
                    <td><h3>idEmpleado</h3></td>
                    <td><h3>Nombre</h3></td>
                    <td><h3>Contraseña</h3></td>
                    <td><h3>Puesto</h3></td>
                    <td><h3>Sueldo</h3></td>
                </tr>
                <%
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String url = "jdbc:mysql://localhost/extra";
                        String username = "root";
                        String password = "Patopato612:";
                        String query = "select * from usuario where contra='"+contrasena+"'";
                        Connection conn = DriverManager.getConnection(url, username, password);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {

                %>
                <tr>
                    <td><%=rs.getInt("idusuario") %>
                    </td>
                    <td><%=rs.getString("nombre") %>
                    </td>
                    <td><%=rs.getString("contra") %>
                    </td>
                    <td><%=rs.getString("puesto") %>
                    </td>
                    <td><%=rs.getString("sueldo") %>
                    </td>
                </tr>
                <%

                    }
                %>
            </table>
            <a href="index.html">Volver a la página Principal</a>
            <%
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            %>

        </form>
    </div>
</section>
<footer id="main-footer">
    <h3>Arturo Imanol Andrade Aguilar</h3>
</footer>
</body>
</html>
