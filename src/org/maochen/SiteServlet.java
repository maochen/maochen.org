package org.maochen;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SiteServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        resp.sendRedirect("www/index.html");
    }
}
