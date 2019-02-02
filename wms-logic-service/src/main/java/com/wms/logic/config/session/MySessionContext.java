package com.wms.logic.config.session;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MySessionContext
 * Author:   Childwanwan
 * Date:     2019/2/2 19:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public class MySessionContext {
    /**
     * 用于存放登录过的session
     */
    private static Map<String, HttpSession> sessionMap = new HashMap<>();

    public static synchronized void addSession(HttpSession session) {
        if (session != null) {
            sessionMap.put(session.getId(), session);
        }
    }

    public static synchronized void delSession(HttpSession session) {
        if (session != null) {
            sessionMap.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String sessionID) {
        if (sessionID == null) {
            return null;
        }
        return sessionMap.get(sessionID);
    }


}
