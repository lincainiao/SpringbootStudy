package com.lin.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "girl")
public class Girl {
//    @Value("black silk")
    private String dressColor;
//    @Value("model")
    private String job;

    public Girl() {
    }
    public Girl(String dress, String job) {
        this.dressColor = dress;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "dress='" + dressColor + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public String getDressColor() {
        return dressColor;
    }

    public void setDressColor(String dressColor) {
        this.dressColor = dressColor;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
