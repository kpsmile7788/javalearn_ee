package org.wm.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: javaee
 * @description:
 *              servlet可以作为逻辑控制来进行页面之间的跳转
 *              同样需要配置
 * @author: Mr.Wang
 * @create: 2019-07-10 20:40
 **/
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        if (userName.contains("sxt")){
            System.out.println("true");
            req.getRequestDispatcher("/admin/success.jsp").forward(req,resp);
        } else {
            System.out.println("false");
            req.getRequestDispatcher("/admin/test.html").forward(req,resp);
        }
    }
}
