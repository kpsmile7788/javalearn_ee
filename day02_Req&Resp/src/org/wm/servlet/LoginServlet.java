package org.wm.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @program: javaee
 * @description:
 * @author: Mr.Wang
 * @create: 2019-07-11 15:23
 **/
public class LoginServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        boolean isReturn = false;

        if (userName == null || "".equals(userName)){
            req.setAttribute("usererror","账号格式不符合规范！");
            isReturn = true;
        }
        if (pwd == null || (pwd.length()<=6)){
            req.setAttribute("pwderror","密码格式不符合规范！");
            isReturn = true;
        }

        if (isReturn){
            req.getRequestDispatcher("/admin/test.jsp").forward(req,resp);
            return;
        }


        if (userName.contains("sxt")){
            System.out.println("true");

            req.getRequestDispatcher("/admin/success.jsp").forward(req,resp);
        } else {
            System.out.println("false");
            req.setAttribute("usererror","账号格式不符合规范！");
            req.setAttribute("pwderror","密码格式不符合规范！");
            req.getRequestDispatcher("/admin/test.jsp").forward(req,resp);
        }
    }
}
