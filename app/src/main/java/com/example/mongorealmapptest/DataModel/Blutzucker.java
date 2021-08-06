package com.example.mongorealmapptest.DataModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

import org.bson.types.ObjectId;

public class Blutzucker extends RealmObject {
    @PrimaryKey
    private ObjectId _id;

    private String Blutzucker;

    private Boolean DataAvaliable;

    private String Patient_ID;

    private String Timestamp;

    @Required
    private String _partitionKey;

    // Standard getters & setters
    public ObjectId get_id() { return _id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getBlutzucker() { return Blutzucker; }
    public void setBlutzucker(String Blutzucker) { this.Blutzucker = Blutzucker; }

    public Boolean getDataAvaliable() { return DataAvaliable; }
    public void setDataAvaliable(Boolean DataAvaliable) { this.DataAvaliable = DataAvaliable; }

    public String getPatient_ID() { return Patient_ID; }
    public void setPatient_ID(String Patient_ID) { this.Patient_ID = Patient_ID; }

    public String getTimestamp() { return Timestamp; }
    public void setTimestamp(String Timestamp) { this.Timestamp = Timestamp; }

    public String get_partitionKey() { return _partitionKey; }
    public void set_partitionKey(String _partitionKey) { this._partitionKey = _partitionKey; }
}
