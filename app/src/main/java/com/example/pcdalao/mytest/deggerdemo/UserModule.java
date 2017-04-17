package com.example.pcdalao.mytest.deggerdemo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pan jh on 2017/1/16.
 */

@Module
public class UserModule {

    @Provides
    User provideUser(){
        return new User("xxxx","Sex","XXX@Gmail.com");
    }

}
