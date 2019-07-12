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
 *                      1）用户在客户端请求某个servlet：http://localhost:8080/servlet/LifeServlet
 *  *                   2）Tomcat截取servlet路径：/servlet/LifeServlet，并且在web.xml中查找
 *  *                       <url-pattern>/servlet/LifeServlet</url-pattern>
 *  *                   3）如果没有找到，404错误；如果找到了
 *  *                       <servlet-name>LifeServlet</servlet-name>
 *  *                       进而找到
 *  *                       <servlet-class>com.bjsxt.servlet.LifeServlet</servlet-class>
 *  *                   4）获取Servlet的完整路径字符串
 *  *                       String className = “com.bjsxt.servlet.LifeServlet”;
 *  *                   5) 获取类的结构信息
 *  *                       Class clazz = Class.forName(className);
 *
 *              2. 实例化类
 *  *                   clazz.newInstance();
 *  *                   Servlet servlet = (Servlet)clazz.getConstructor().newInstance()
 *
 *              3. 初始化类
 *  *                   Method initMethod = clazz.getMethod("init",ServletConfig.class)
 *  *                   initMethod.invoke(servlet,var1);
 *
 *              4. 服务
 *  *                   Method serviceMethod = clazz.getMethod("service",ServletRequest.class,ServletReponse.class);
 *  *                   serviceMethod.invoke(servlet,request,response);
 *
 *              5. 销毁
 *  *                   Method destoryMethod = clazz.getMethod("destory");
 *  *                   destoryMethod.invoke(servlet);
 *
 *  * WARING--->注意:
 *  *       1.Servlet的生命周期由Tomcat来完成
 *  *       2.Servlet的生命周期中实例化和各个方法的调用离不开反射
 *  *       3.加载类不能省略
 *  *       4.什么时候加载类、实例化
 *  *           情况1：饿汗模式：项目启动的时候就会自动的加载类和实例化
 *  *               <load-on-startup>1</load-on-startup>
 *  *           情况2：懒汉模式：第一次请求该Servlet的时候才加载类和实例化
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
