package com.example.pcdalao.mytest.deggerdemo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pan jh on 2017/1/16.
 */

@Module
public class InfoModule {
    private String name;

    public InfoModule(String name){
        this.name=name;
    }

    @Provides
    Info provideInfo(){
        return new Info(name);
    }
}
