package com.udemy.controlclientes.controllers;

import com.udemy.controlclientes.datos.ClienteDao;
import com.udemy.controlclientes.dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String accion = request.getParameter("accion");
        if (accion == null) {
            accionDefault(request, response);
            return;
        }

        switch (accion) {
            case "insertar":
                insertarCliente(request, response);
                break;
            case "modificar":
                modificarCliente(request, response);
                break;
            default:
                accionDefault(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
            accionDefault(request, response);
            return;
        }

        switch (accion) {
            case "editar":
                editarCliente(request, response);
                break;
            case "eliminar":
                eliminarCliente(request, response);
                break;
            default:
                accionDefault(request, response);
        }
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        saldoTotal = clientes.stream().map((cliente) -> cliente.getSaldo()).reduce(saldoTotal, (accumulator, _item) -> accumulator + _item);

        return saldoTotal;
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !saldoString.trim().equals("")) {
            saldo = Double.parseDouble(saldoString);
        }

        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        new ClienteDao().insert(cliente);

        accionDefault(request, response);
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDao().getAll();

        request.getSession().setAttribute("clientes", clientes);
        request.getSession().setAttribute("totalClientes", clientes.size());
        request.getSession().setAttribute("saldoTotal", calcularSaldoTotal(clientes));
        response.sendRedirect("clientes.jsp");
        //request("clientes.jsp").forward(request, response);
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idClienteStr = request.getParameter("idCliente");
        Cliente cliente = new ClienteDao().getById(new Cliente(Long.parseLong(idClienteStr)));
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/WEB-INF/paginas/cliente/editarCliente.jsp").forward(request, response);
        
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idClienteStr = request.getParameter("idCliente");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !saldoString.trim().equals("")) {
            saldo = Double.parseDouble(saldoString);
        }
        Long idCliente = Long.parseLong(idClienteStr);

        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        new ClienteDao().update(cliente);

        accionDefault(request, response);
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idClienteStr = request.getParameter("idCliente");
        Long idCliente = Long.parseLong(idClienteStr);

        Cliente cliente = new Cliente(idCliente);
        new ClienteDao().delete(cliente);
        
        accionDefault(request, response);
    }
}
