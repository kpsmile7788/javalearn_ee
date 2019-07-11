package org.wm.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @program: javaee
 * @description:
 *              1. 加载类
 *              2. 实例化类
 *              3. 初始化类
 *              4. 服务
 *              5. 摧毁
 * @author: Mr.Wang
 * @create: 2019-07-11 09:46
 **/
public class LifeServlet extends HttpServlet {

    public LifeServlet(){
        System.out.println("---------Constructor of LifeServlet------------");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("---------------MSG of INIT-----------------");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("------------MGS of Service---------------");
    }

    @Override
    public void destroy() {
        System.out.println("---------------MSG of Destory---------------");
    }
}
