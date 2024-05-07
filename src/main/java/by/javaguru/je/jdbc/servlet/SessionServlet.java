package by.javaguru.je.jdbc.servlet;

import by.javaguru.je.jdbc.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Session")
public class SessionServlet extends HttpServlet {

    private final static String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        var user = session.getAttribute(USER);
        if (user == null)
            user = UserDto.builder()
                    .id(5)
                    .email("aaa@aaa.ru")
                    .build();

        session.setAttribute(USER, user);
    }
}
