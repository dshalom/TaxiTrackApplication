package com.taxitrack.davidshalom.taxitrackapplication.di;

import android.app.Application;

import com.taxitrack.davidshalom.taxitrackapplication.login.LoginPresenter;
import com.taxitrack.davidshalom.taxitrackapplication.login.LoginPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }


    @Provides
    LoginPresenter provideMoviesPagerPresenter() {
        return new LoginPresenterImpl();
    }

}
