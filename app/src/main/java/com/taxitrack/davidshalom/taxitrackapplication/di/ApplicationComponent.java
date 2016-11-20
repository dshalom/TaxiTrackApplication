package com.taxitrack.davidshalom.taxitrackapplication.di;

import com.taxitrack.davidshalom.taxitrackapplication.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);

}


