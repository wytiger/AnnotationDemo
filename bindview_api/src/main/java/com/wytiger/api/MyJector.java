package com.wytiger.api;

/**
 * description ：
 * author : wuyong_cd
 * date : 2019/11/19 0019
 */
public class MyJector {
    public static void bind(Object activity) {
        bind(activity, activity);
    }

    public static void bind(Object host, Object root) {
        Class<?> clazz = host.getClass();
        String proxyClassFullName = clazz.getName() + "ViewInjector";
        try {
            Class<?> proxyClazz = Class.forName(proxyClassFullName);
            ViewInjector viewInjector = (ViewInjector) proxyClazz.newInstance();
            viewInjector.inject(host, root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
