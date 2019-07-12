package org.wm.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @program: javaee
 * @description:
 *              设置中文的三种方式
 *
 *              第三种：
 *                  修改Tomcat中的配置文件(Server.xml)
 *                  <Connector port="8080" protocol="HTTP/1.1"
 *                                  connectionTimeout="20000"
 *                                  redirectPort="8443" URIEncoding="utf-8" />
 * @author: Mr.Wang
 * @create: 2019-07-11 14:59
 **/
public class MyServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        //第一种
        //req.setCharacterEncoding("utf-8");

        String userName = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        //第二种
        byte[] bytes = userName.getBytes("iso-8859-1");
        userName = new String(bytes,"utf-8");

        System.out.println(userName+"------"+pwd);

        if (userName.contains("sxt")){
            System.out.println("true");
            req.getRequestDispatcher("/admin/success.jsp").forward(req,resp);
        } else {
            System.out.println("false");
            req.getRequestDispatcher("/admin/test.html").forward(req,resp);
        }
    }
}
