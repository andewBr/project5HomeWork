package by.javaguru.je.jdbc.servlet;

import by.javaguru.je.jdbc.dto.FlightDto;
import by.javaguru.je.jdbc.servise.FlightService;
import by.javaguru.je.jdbc.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDto> flights = flightService.findAll();
        req.setAttribute("flights", flights);

        req.getRequestDispatcher(JspHelper.getPath("content")).forward(req, resp);

    }
}
