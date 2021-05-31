package com.project.blog;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@ConfigurationProperties(prefix = "blog")
public class BlogApplicationProperties {
    private Integer number;
    private String username;
    private String telephoneNumber;
    private List<String> emailAddresses = Arrays.asList("yeritsyan.arsen@gmail.com");
    private String firstName;
    private String lastName;
    private Duration workingTime;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Duration getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Duration workingTime) {
        this.workingTime = workingTime;
    }
}
