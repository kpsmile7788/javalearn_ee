package org.wm.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: javaee
 * @description: test for get Parameters
 *                  通过配置文件动态获取参数
 * @author: Mr.Wang
 * @create: 2019-07-11 10:45
 **/
public class ParamServlet extends HttpServlet {

    String encoding;
    String file;

    @Override
    public void init() throws ServletException {
        encoding = this.getServletConfig().getInitParameter("encoding");
        if (encoding == null){
            encoding = "utf-8";
        }

        file = this.getServletContext().getInitParameter("file");
        if (file == null){
            file = "sxt.properties";
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(file+"---------"+encoding);
    }
}
