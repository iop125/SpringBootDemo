package com.my.demo08;

import com.sun.tools.corba.se.idl.constExpr.GreaterEqual;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@WebServlet(value = "asyncServlet",asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long star = System.currentTimeMillis();
        //开启异步
        AsyncContext asyncContext = req.startAsync();
        //获取nio的异步请求
        ServletRequest servletRequest = asyncContext.getRequest();
        ServletResponse servletResponse = asyncContext.getResponse();
        CompletableFuture.runAsync(()->doSome(asyncContext,servletRequest,servletResponse));
        long end = System.currentTimeMillis();
        System.out.println(end -star);
    }
    public void doSome(AsyncContext asyncContext,ServletRequest servletReques,ServletResponse servletResponse ){
        try {
            TimeUnit.SECONDS.sleep(2);
            servletResponse.getWriter().println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //耗时通知任务完成
        asyncContext.complete();
    }
}
