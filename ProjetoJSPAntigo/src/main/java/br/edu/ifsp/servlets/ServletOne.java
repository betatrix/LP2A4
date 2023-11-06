package br.edu.ifsp.servlets;

import br.edu.ifsp.model.Organizador;
import br.edu.ifsp.repository.OrganizadorRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class ServletOne extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/PageOne.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        OrganizadorRepository organizadorRepository = new OrganizadorRepository();
        List<Organizador> organizadores = organizadorRepository.listarOrganizadores();


        String email = req.getParameter("mail");
        String senha = req.getParameter("password");

        for (Organizador organizador : organizadores) {
            if (organizador.getEmail().equals(email) && organizador.getSenha().equals(senha)) {

                HttpSession session = req.getSession();
                session.setAttribute("organizador", organizador);

                res.sendRedirect("PageTwo.jsp");
                return;
            }
        }

        // Caso o login falhe, redirecione de volta para a página de login
        res.sendRedirect("/jsp/PageOne.jsp?error=1");
    }
}

