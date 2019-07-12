package org.wm.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: javaee
 * @description:
 *
 * @author: Mr.Wang
 * @create: 2019-07-12 19:13
 **/
public class DispatcherAndRedirect extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            /**
             * 重定向：
             *          同一服务器上的程序用根路径访问
             *          不同服务器上的程序用绝对路径访问
             */
            resp.sendRedirect("/2/admin/success.jsp");
        } else {
            System.out.println("false");
            req.setAttribute("usererror","账号格式不符合规范！");
            req.setAttribute("pwderror","密码格式不符合规范！");
            /**
             * 转发：
             *          只能访问同一服务器上的程序
             */
            req.getRequestDispatcher("/admin/test.jsp").forward(req,resp);
        }
    }
}
