/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Automovil;
import Modelo.Crud;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author DAW-A
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100)      // 100 MB

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    String path = "";

    public void init(ServletConfig config) {
        path = config.getServletContext().getRealPath("").
                concat(File.separator).concat("img");

    }

    final int NUM_LINEAS_PAGINA = 6;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "";

        if (action.compareToIgnoreCase("mostrar") == 0) {
            int pag = 1;
            int offset = 0;
            ArrayList paginas = new ArrayList();
            List<Automovil> listaAutomoviles = Crud.getAutomoviles();

            if (request.getParameter("pag") != null) {
                pag = Integer.parseInt(request.getParameter("pag"));
                offset = (pag - 1) * NUM_LINEAS_PAGINA;
            }
            int num_pag = (int) Math.ceil(listaAutomoviles.size() / (double) NUM_LINEAS_PAGINA);
            listaAutomoviles = Crud.getAutomovilesPaginado(NUM_LINEAS_PAGINA, offset);
            for (int i = 1; i <= num_pag; i++) {
                paginas.add(i);
            }

            request.setAttribute("lista", listaAutomoviles);
            request.setAttribute("pag", pag);
            request.setAttribute("num_pag", num_pag);
            request.setAttribute("paginas", paginas);
            RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
            rd.forward(request, response);

        } else if (action.compareToIgnoreCase("mostrarRest") == 0) {
            int pag = 1;
            int offset = 0;
            ArrayList paginas = new ArrayList();
            List<Automovil> listaAutomoviles = Crud.getAutomoviles();

            if (request.getParameter("pag") != null) {
                pag = Integer.parseInt(request.getParameter("pag"));
                offset = (pag - 1) * NUM_LINEAS_PAGINA;
            }
            int num_pag = (int) Math.ceil(listaAutomoviles.size() / (double) NUM_LINEAS_PAGINA);
            listaAutomoviles = Crud.getAutomovilesPaginado(NUM_LINEAS_PAGINA, offset);
            for (int i = 1; i <= num_pag; i++) {
                paginas.add(i);
            }

            request.setAttribute("lista", listaAutomoviles);
            request.setAttribute("pag", pag);
            request.setAttribute("num_pag", num_pag);
            request.setAttribute("paginas", paginas);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarRest.html");
            rd.forward(request, response);

        } else if (action.compareToIgnoreCase("borrar") == 0) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (Crud.deleteAutomovil(id) > 0) {
                request.setAttribute("msg", "alertify.success('Automóvil borrado correctamente');");
            } else {
                request.setAttribute("msg", "alertify.error('No se ha podido borrar el automóvil');");
            }
            int pag = 1;
            int offset = 0;
            ArrayList paginas = new ArrayList();
            List<Automovil> listaAutomoviles = Crud.getAutomoviles();

            if (request.getParameter("pag") != null) {
                pag = Integer.parseInt(request.getParameter("pag"));
                offset = (pag - 1) * NUM_LINEAS_PAGINA;
            }
            int num_pag = (int) Math.ceil(listaAutomoviles.size() / (double) NUM_LINEAS_PAGINA);
            listaAutomoviles = Crud.getAutomovilesPaginado(NUM_LINEAS_PAGINA, offset);
            for (int i = 1; i <= num_pag; i++) {
                paginas.add(i);
            }

            request.setAttribute("lista", listaAutomoviles);
            request.setAttribute("pag", pag);
            request.setAttribute("num_pag", num_pag);
            request.setAttribute("paginas", paginas);
            RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
            rd.forward(request, response);

        } else if (action.compareToIgnoreCase("actualizar") == 0) {
            int id = Integer.parseInt(request.getParameter("id"));
            Automovil a = Crud.getAutomovil(id);
            request.setAttribute("a", a);
            RequestDispatcher rd = request.getRequestDispatcher("actualizar.jsp");
            rd.forward(request, response);

        } else if (action.compareToIgnoreCase("actualizarDatos") == 0) {
            int id = Integer.parseInt(request.getParameter("id"));
            String categoria = request.getParameter("categoria");
            int precio = Integer.parseInt(request.getParameter("precio"));
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            int fab = Integer.parseInt(request.getParameter("fab"));
            String foto = this.subirArchivo(request, response);
            Automovil a = new Automovil(id, categoria, precio, marca, modelo, fab, foto);
            request.setAttribute("a", a);
            if (Crud.updateAutomovil(a) > 0) {
                request.setAttribute("msg", "alertify.success('Automóvl actualizado correctamente');");
            } else {
                request.setAttribute("msg", "alertify.error('No se ha podido actualizar el automóvil');");
            }
            RequestDispatcher rd = request.getRequestDispatcher("actualizar.jsp");
            rd.forward(request, response);

        } else if (action.compareToIgnoreCase("insertar") == 0) {
            RequestDispatcher rd = request.getRequestDispatcher("insertar.jsp");
            rd.forward(request, response);

        } else if (action.compareToIgnoreCase("insertarDatos") == 0) {
            String categoria = request.getParameter("categoria");
            int precio = Integer.parseInt(request.getParameter("precio"));
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            int fab = Integer.parseInt(request.getParameter("fab"));
            String foto = this.subirArchivo(request, response);
            Automovil a = new Automovil(categoria, precio, marca, modelo, fab, foto);
            Crud.insertAutomovil(a);
            int pag = 1;
            int offset = 0;
            ArrayList paginas = new ArrayList();
            List<Automovil> listaAutomoviles = Crud.getAutomoviles();

            if (request.getParameter("pag") != null) {
                pag = Integer.parseInt(request.getParameter("pag"));
                offset = (pag - 1) * NUM_LINEAS_PAGINA;
            }
            int num_pag = (int) Math.ceil(listaAutomoviles.size() / (double) NUM_LINEAS_PAGINA);
            listaAutomoviles = Crud.getAutomovilesPaginado(NUM_LINEAS_PAGINA, offset);
            for (int i = 1; i <= num_pag; i++) {
                paginas.add(i);
            }

            request.setAttribute("lista", listaAutomoviles);
            request.setAttribute("pag", pag);
            request.setAttribute("num_pag", num_pag);
            request.setAttribute("paginas", paginas);
            RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
            rd.forward(request, response);

        } else {
            response.sendRedirect("index.html");
//            RequestDispatcher rd = request.getRequestDispatcher("index.html");
//            rd.forward(request, response);
        }
    }

    public String subirArchivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // path = request.getServletContext().getRealPath("").concat(File.separator).concat("ficheros");
        Part filePart = request.getPart("foto"); // Obtiene el archivo el input en el form se llama imagen
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

        //InputStream fileContent = filePart.getInputStream(); //Lo transforma en InputStream
        //String path="/archivos/";
        File uploads = new File(path); //Carpeta donde se guardan los archivos
        uploads.mkdirs(); //Crea los directorios necesarios
        File file = File.createTempFile("cod" + "" + "-", "-" + fileName, uploads); //Evita que hayan dos archivos con el mismo nombre

        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        //return file.getPath();
        String archivo = file.getName();
        return archivo;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
