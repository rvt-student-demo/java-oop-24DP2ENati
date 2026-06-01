package rvt.StudentRegistration;

import java.time.*;

public class Student {
    private String vards;
    private String uzvards;
    private String epasts;
    private String personasKods;
    private LocalDateTime timestamp;

    public Student (String name, String surname, String email, String code, LocalDateTime stamp) {
        this.vards = name; 
        this.uzvards = surname;
        this.epasts = email;
        this.personasKods = code;
        this.timestamp = stamp;
    }

    public String getVards() {
        return vards;
    }

    public String getUzvards() {
        return uzvards;
    }

    public String getEpasts() {
        return epasts;
    }

    public String getPersonasKods() {
        return personasKods;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}