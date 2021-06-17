package Servlets;

import Control.Conexion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "RegistrarUsuario", value = "/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
    private Statement set;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom, contra, puesto, sueldo;
        Connection con = null;

        nom = request.getParameter("neim");
        contra = request.getParameter("contr");
        puesto = request.getParameter("pu");
        sueldo = request.getParameter("su");

        try {
            con = Conexion.getConexion();
            set = con.createStatement();

            String q = "insert into usuario "
                    + "(nombre, contra, puesto, sueldo) "
                    + "values ('" + nom + "', '" + contra + "', '"+ puesto +"', '"+ sueldo +"')";

            //ejecutar la sentencia
            set.executeUpdate(q);
            System.out.println("Registro exitoso");
            response.sendRedirect("index.html");
        }catch (SQLException sq) {
            System.out.println("Error al agregar al usuario: " + sq.getMessage());
        }finally {
            try {
                con.close();
                set.close();
            }catch (SQLException sq){
                System.out.println("Error: "+sq.getMessage());
            }
        }
    }
}
