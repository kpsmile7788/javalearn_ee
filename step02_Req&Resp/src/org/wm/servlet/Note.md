
 ## 客户端(用户控制)跳转的两种方式（发起新请求的两种方式）
 - 1.超链接
 - 2.提交表单
 - ***本质都是：在地址栏给出请求资源的url***

 ## 服务器端控制的两种跳转方式
 - 1.转发：Dispatcher
 - 2.重定向：Redirect
 - 还有一种方式 include，使用很少，其实不属于跳转；
 - 转发和重定向的共同点
    - 都实现了跳转，并且是程序控制的
 - 不同点
    1. 语句不同
       - 转发： request.getRequestDispatcher("/login2/login.jsp").forward(request,response);
       - 重定向 response.sendRedirect("/login2/success.jsp");
    2. 跳转后地址栏路径不同
       - 转发：跳转之前的地址
       - 重定向：跳转之后的地址  success.jsp
    3. 是否可以共享同一个request的数据
       - 转发：可以共享
       - 重定向：无法共享
    4. 原理的不同
       - 转发：  110  呼叫转移
       - 重定向： 114  忘记带手机
    5. 效率高低
       - 转发效率高
    6. 跳转的范围
       - 转发：只限于当前项目（最大也就是当前服务器）
       - 重定向：可以重定向到互联网的任意位置
    7. 路径的不同<br/>
        - 绝对路径
        - 转发：不支持
        - 重定向：支持
        - 根路径<br/>
           1. 转发  /代表当前项目 应用<br/>
           2. 重定向 /代表当前服务器<br/>
        
        - 相对路径
           1. 只能相对于当前文件自身，不能相对于基准路径
           2. 转发和重定向时使用哪个路径？
                - 要跳转到其他服务器，必须使用重定向，必须使用绝对路径
                - 要跳转到当前服务器，不管是当前项目还是其他项目，建议都使用根路径
                   - 重定向：建议使用request.getContextPath() 动态获取上下文路径
                   - 转发：指定在当前项目转发，/代表当前项目的根路径
        - 跳转时到底是使用转发还是重定向? 
            1. 某些情况下，无可选择
                - 希望前后两个组件共享request数据，使用转发
                - 跳转到同一个应用的WEB-INF目录下只能用转发
                - 跳转到不同的应用只能使用重定向
                - 使用Cookie存储数据需要使用重定向
            2. 跳转到同一个应用，哪种方式更好
                - 使用转发效率高，尽量使用转发
                - 使用转发需要解决重复提交问题，尤其是添加操作
                - 注销之后一般用重定向
                - 连续表单页面之间建议使用重定向，避免属性冲突
            3. 转发和重定向是服务器端的跳转还是客户端跳转
                - 转发：服务器
                - 重定向：客户端跳转，由服务器端的程序控制的
                - 点击超链接、提交表单也是客户端跳转，由用户控制