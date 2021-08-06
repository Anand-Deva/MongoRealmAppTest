package com.example.mongorealmapptest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.mongorealmapptest.DataModel.Blutzucker;

import org.bson.types.ObjectId;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;
import io.realm.mongodb.sync.SyncConfiguration;

public class ConnectToRealmApp01{

    App app;
    String timeStamp;
    SimpleDateFormat simpleDateFormat;

    final String PatientID = "VM58";
    final String _partition = "Blutzucker";
    final String RealmAppID01  = "ad_testapp_01-uhjhn";
    private static final String TAG = "MongoDB RealmApp01";

    public ConnectToRealmApp01() {}

    public void RealmApp01(Context context) {

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        timeStamp = simpleDateFormat.format(new Date());

            Credentials credentials = Credentials.anonymous();
            app = new App(new AppConfiguration.Builder(RealmAppID01).build());
            app.loginAsync(credentials, it -> {
                if (it.isSuccess()) {
                    Log.w(TAG,"MongoDB Auth: Success");

                    User user = app.currentUser();
                    if(user!= null){
                        SyncConfiguration config = new SyncConfiguration.Builder(user, _partition)
                                .allowQueriesOnUiThread(true)
                                .allowWritesOnUiThread(true)
                                .build();

                        Realm.getInstanceAsync(config, new Realm.Callback() {
                            @Override
                            public void onSuccess(Realm realm) {
                                Log.w(TAG,"Blutzucker MongoDB Realm: "+ "Successfully opened a realm");

                                    // send data to MongoDB with DataAvailable flag false
                                    realm.executeTransaction(r -> {
                                        // Instantiate the class using the factory function.
                                        Blutzucker bz = r.createObject(Blutzucker.class, new ObjectId());
                                        // Configure the instance.
                                        bz.setPatient_ID(PatientID);
                                        bz.set_partitionKey(_partition);
                                        bz.setTimestamp(timeStamp);
                                        bz.setDataAvaliable(false);
                                    });

                                    Log.w(TAG, "Blutzucker document inserted in MongoDB successfully");

                                realm.close();
                                Log.w(TAG,"Blutzucker MongoDB Realm closed");

                            }
                        });
                    }else {
                        Log.w(TAG,"Blutzucker MongoDB Realm: Unsuccessful in opening the realm");
                    }

                } else {
                    Log.e("MongoDB Auth", it.getError().toString());
                    Toast.makeText(context,"Error while connecting to MongoDB",Toast.LENGTH_LONG).show();
                }
            });



    }
}