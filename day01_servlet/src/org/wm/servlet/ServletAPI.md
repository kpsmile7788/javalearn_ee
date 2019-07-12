java.servlet.Servlet(接口)-->java.servlet.GenericServlet(抽象类)-->java.servlet.http.HttpServlet(抽象)-->自己的编写的servlet类


##Servlet接口：所有servlet必须直接或间接实现的类。
init( ServletConfig config )
service(ServletRequest req, ServletResponse res)
destroy()
getServletInfo():获得Servlet信息。
getServletConfig()：获得Servlet配置相关信息。
##GenericServlet抽象类：implements Servlet, ServletConfig
定义了一个通用的，不依赖于具体协议的Servlet，给出了除service()方法外的其余四个方法的实现。
public void init(ServletConfig config) thows SerletExcepiton
protected  void init() thows SerletExcepiton
第一个是servlet接口的init(),调用第二个init(), 重写第二个init()即可

##HttpServlet类
public void service(ServletRequest req, ServletResponse res)
protected void service(HttpServletRequest req, HttpServletResponse res)
protected void doGet(request,response)
protected void doPost(request,response)
public service()是父类的方法，protected service()是自己的方法。前者首先把参数分别转换为HttpServletRequest和HttpServletResponse ，再调用protected service();
protected service()根据HTTP请求方法的类型调用相应doXXX()方法
我们自己编写的servlet应该继承HttpServlet，一般要覆盖doPost或者doGet方法。