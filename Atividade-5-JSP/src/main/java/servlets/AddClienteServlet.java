package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import model.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FormatarData;
import util.HibernateUtil;


import java.io.IOException;
import java.util.Date;

@WebServlet(name = "RegistrationServelet", urlPatterns = "/AddCliente")
public class AddClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        Date dataDeNascimento = FormatarData.formatarData(req.getParameter("dataNascimento"));
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");

        System.out.println("Nome: " + nome);
        System.out.println("Sobrenome: " + sobrenome);
        System.out.println("Data de Nascimento: " + dataDeNascimento);
        System.out.println("CPF: " + cpf);
        System.out.println("Email: " + email);

        Cliente cliente = new Cliente(nome, sobrenome, dataDeNascimento, cpf, email);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(cliente);

        transaction.commit();

        resp.sendRedirect("ListarCliente");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("cadCliente.jsp");
        dispatcher.forward(req, resp);
    }
}