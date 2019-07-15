package org.wm.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: javaee
 * @description:
 *              servlet可以作为响应输出，打印拼凑出HTML页面（已经没有人这么做了）
 *              使用时需要在 /WEB-INF/web.xml中进行配置
 *              <servlet>
 *                  <servlet-name>MyServlet</servlet-name>
 *                  <servlet-class>org.wm.servlet.MyServlet</servlet-class>
 *              </servlet>
 *              <servlet-mapping>
 *                  <servlet-name>MyServlet</servlet-name>
 *                  <url-pattern>/LoginCheck</url-pattern>
 *              </servlet-mapping>
 * @author: Mr.Wang
 * @create: 2019-07-10 20:33
 **/
public class GenerateHTML extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>测试Servlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<p>用servlet生成HTML</p>");
        out.print("</body>");
        out.print("</html>");

        out.flush();
        out.close();
    }
}
