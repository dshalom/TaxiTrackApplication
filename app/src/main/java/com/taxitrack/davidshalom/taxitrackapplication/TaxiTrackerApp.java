package com.taxitrack.davidshalom.taxitrackapplication;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.taxitrack.davidshalom.taxitrackapplication.di.ApplicationComponent;
import com.taxitrack.davidshalom.taxitrackapplication.di.ApplicationModule;
import com.taxitrack.davidshalom.taxitrackapplication.di.DaggerApplicationComponent;

import timber.log.Timber;

public class TaxiTrackerApp extends Application {
    private ApplicationComponent applicationComponent;
    private static TaxiTrackerApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        instance = this;
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("1d0273b9f31bb2f172a75af23ba9e8657b310cb8")
                .clientKey("5fb6f165148d4e26021f965861e4022614422f90")
                .server("http://ec2-52-210-150-240.eu-west-1.compute.amazonaws.com:80/parse")
                .build());

        ParseObject object = new ParseObject("ExampleObject");
        object.put("myNumber", "123");
        object.put("myString", "rob");

        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException ex) {
                if (ex == null) {
                    Log.i("Parse Result", "Successful!");
                } else {
                    Log.i("Parse Result", "Failed" + ex.toString());
                }
            }
        });
    }

    public static TaxiTrackerApp getInstance() {
        return instance;
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
