package servlets;

import jakarta.persistence.Query;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import org.hibernate.Session;
import util.HibernateUtil;



import java.io.IOException;
import java.util.List;


    @WebServlet(value = "/especificarCliente")
    public class EspecificarClienteServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String emailParaBuscar = request.getParameter("email"); // Recupera o email da solicitação

            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM clientes c WHERE c.email = :email";

            org.hibernate.query.Query<Cliente> query = session.createQuery(hql, Cliente.class);
            query.setParameter("email", emailParaBuscar);

            List<Cliente> clientes = query.list();
            session.close();

            if (!clientes.isEmpty()) {
                request.setAttribute("cliente", clientes.get(0));
                RequestDispatcher dispatcher = request.getRequestDispatcher("ProcurarCliente.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().write("Cliente não encontrado.");
            }
        }
    }
