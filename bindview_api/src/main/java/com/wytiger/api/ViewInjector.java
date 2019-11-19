package com.wytiger.api;

/**
 * description ：
 * author : wuyong_cd
 * date : 2019/11/19 0019
 */
public interface ViewInjector<Host> {
    void inject(Host host, Object object);
}
