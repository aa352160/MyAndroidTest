package com.example.pcdalao.mytest.deggerdemo;

import dagger.Component;

/**
 * Created by pan jh on 2017/1/16.
 */

@Component(modules = {InfoModule.class})
public interface InfoComponent {
    Info infoModule();
}
