package com.example.mongorealmapptest.DataModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

import org.bson.types.ObjectId;

public class Koerpertemperatur extends RealmObject {
    @PrimaryKey
    private ObjectId _id;

    private Boolean DataAvaliable;

    private String Koerpertemperatur;

    private String Patient_ID;

    private String Timestamp;

    @Required
    private String _partitionKey;

    private String user_id;

    // Standard getters & setters
    public ObjectId get_id() { return _id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public Boolean getDataAvaliable() { return DataAvaliable; }
    public void setDataAvaliable(Boolean DataAvaliable) { this.DataAvaliable = DataAvaliable; }

    public String getKoerpertemperatur() { return Koerpertemperatur; }
    public void setKoerpertemperatur(String Koerpertemperatur) { this.Koerpertemperatur = Koerpertemperatur; }

    public String getPatient_ID() { return Patient_ID; }
    public void setPatient_ID(String Patient_ID) { this.Patient_ID = Patient_ID; }

    public String getTimestamp() { return Timestamp; }
    public void setTimestamp(String Timestamp) { this.Timestamp = Timestamp; }

    public String get_partitionKey() { return _partitionKey; }
    public void set_partitionKey(String _partitionKey) { this._partitionKey = _partitionKey; }

    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id; }
}

