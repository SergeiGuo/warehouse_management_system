package com.wms.logic.config.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MySessionListener
 * Author:   Childwanwan
 * Date:     2019/2/2 19:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //System.err.println("session add: " + httpSessionEvent.getSession().getId() + new Date());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //System.err.println("session destroy: " + httpSessionEvent.getSession().getId() + new Date());
        MySessionContext.delSession(httpSessionEvent.getSession());
    }


    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("httpSessionBindingEvent.getName:"+httpSessionBindingEvent.getName());
        if (httpSessionBindingEvent.getName().equalsIgnoreCase("user")) {
            MySessionContext.addSession(httpSessionBindingEvent.getSession());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equalsIgnoreCase("user")) {
            MySessionContext.delSession(httpSessionBindingEvent.getSession());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
