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
        StringBuffer buf = new StringBuffer();

        String time = new Date().toString();
        String clientip = req.getRemoteAddr();

        int cpucores = Runtime.getRuntime().availableProcessors();
        String os = System.getProperty("os.name").toLowerCase();

        String jvmver = System.getProperty("java.version");
        long jvmmem = Runtime.getRuntime().maxMemory();

        buf.append("Request Time: " + time + "<br/>");
        buf.append("IP: " + clientip + "<br/>");
        buf.append("<hr />");

        buf.append("CPU Cores: " + cpucores + "<br/>");
        buf.append("OS: " + os + "<br/>");
        buf.append("JVM Version: " + jvmver + "<br/>");
        buf.append("JVM Max Memory Size: " + jvmmem / 1049000 + "MB" + "<br/>");

        buf.append("<hr />");

        String gaeVersion = SystemProperty.version.get();
        buf.append("Google AppEngine Version: " + gaeVersion + "<br/>");
        String appVersion = SystemProperty.applicationVersion.get();
        buf.append("Application Version: " + appVersion + "<br/>");

        return buf.toString();

    }
}
