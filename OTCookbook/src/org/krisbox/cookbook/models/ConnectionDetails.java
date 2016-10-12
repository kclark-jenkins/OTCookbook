package org.krisbox.cookbook.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Entity
@Table(name = "CONNECTIONS")
public class ConnectionDetails {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @NotNull
    private String username;
    @NotNull
    private String volume;
    @NotNull
    private String connectionString;
    private String extendedProperties;

    public ConnectionDetails(){}
    public ConnectionDetails(long id) {this.id = id;}
    
    public ConnectionDetails(String username, String volume, String connectionString, String extendedProperties) {
        this.username           = username;
        this.volume             = volume;
        this.connectionString   = connectionString;
        this.extendedProperties = extendedProperties;
    }

    public long getId(){return id;}
    public String getUsername(){return username;}
    public String getVolume(){return volume;}
    public String getConnectionString(){return connectionString;}
    public Map<String, Object> getExtendedProperties(){
    	Map<String, Object> retMap = new Gson().fromJson(extendedProperties, new TypeToken<HashMap<String, Object>>() {}.getType());
    	return retMap;
    }
    
    public void setId(long id){this.id=id;}
    public void setUsername(String username){this.username=username;}
    public void setVolume(String volume){this.volume=volume;}
    public void setConnectionString(String connectionString){this.connectionString=connectionString;}
    public void setExtendedProperties(String extendedProperties) {this.extendedProperties=extendedProperties;}
    
    @Override
    public String toString() {
        return String.format("id[id=%d, username='%s', volume='%s', connectionString='%s', extendedProperties='%s']",id, username, volume, connectionString, extendedProperties);
    }
}
