package org.maochen;

import com.google.appengine.api.utils.SystemProperty;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@SuppressWarnings("serial")
public class SiteServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String info = getInfo(req);
        resp.getWriter().println(info);
        // resp.sendRedirect("index.html");
    }

    private String getInfo(HttpServletRequest req) {
        StringBuilder builder = new StringBuilder();

        String time = new Date().toString();
        String clientip = req.getRemoteAddr();
        String agent = req.getHeader("User-Agent");
        int cpucores = Runtime.getRuntime().availableProcessors();
        String os = System.getProperty("os.name").toLowerCase();

        String jvmver = System.getProperty("java.version");
        long jvmmem = Runtime.getRuntime().maxMemory();

        builder.append("Request Time: " + time + "<br/>");
        builder.append("IP: " + clientip + "<br/>");
        builder.append("Agent: " + agent + "<br/>");
        builder.append("<hr />");

        builder.append("CPU Cores: " + cpucores + "<br/>");
        builder.append("OS: " + os + "<br/>");
        builder.append("JVM Version: " + jvmver + "<br/>");
        builder.append("JVM Max Memory Size: " + jvmmem / 1049000 + "MB" + "<br/>");

        builder.append("<hr />");

        String gaeVersion = SystemProperty.version.get();
        builder.append("Google AppEngine Version: " + gaeVersion + "<br/>");
        String appVersion = SystemProperty.applicationVersion.get();
        builder.append("Application Version: " + appVersion + "<br/>");

        return builder.toString();

    }
}
