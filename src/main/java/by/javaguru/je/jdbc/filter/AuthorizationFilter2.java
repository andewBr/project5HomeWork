package by.javaguru.je.jdbc.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/restricted/*")
public class AuthorizationFilter2 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpRequest.getUserPrincipal() == null || !httpRequest.isUserInRole("admin")) {

            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Session Closed</title></head>");
            out.println("<body>");
            out.println("<h1>We close session</h1>");
            out.println("<h2>Unknown user</h2>");
            out.println("</body>");
            out.println("</html>");

            return;
        }

        if (!hasAccessToProject(httpRequest)) {
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access to this project is forbidden");
            return;
        }

        chain.doFilter(request, response);
    }

    private boolean hasAccessToProject(HttpServletRequest request) {
        System.out.println("hasAccessToProject");
        return request.getUserPrincipal() != null;
    }
}