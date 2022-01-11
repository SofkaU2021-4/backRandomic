package co.com.sofka.mentoring35.Controller;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Random {
    private Date date;
    @Id
    private String id;

    private String orginalList;

    private String randomList;

    public String getRandomList() {
        return randomList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setIde(String id) {
        this.id = id;
    }


    public String getOrginalList() {
        return orginalList;
    }

    public void setOrginalList(String orginalList) {
        this.orginalList = orginalList;
    }

    public void setRandomList(String randomList) {
        this.randomList = randomList;
    }

    
}
