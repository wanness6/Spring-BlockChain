package edu.ap.spring.jpa;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BlockEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Timestamp timeStamp;
    @Column(length=1000)
    private String json;

	public BlockEntity() {}

    public BlockEntity(String json) {
        this.json = json;
        this.timeStamp = new Timestamp(System.currentTimeMillis());
    }
    
    public String getJson() {
        return this.json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
}
