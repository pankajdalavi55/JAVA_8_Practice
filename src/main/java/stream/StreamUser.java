package stream;

import java.util.List;

public class StreamUser {

    private Long id;
    private String name;
    private String department;
    private List<String> subjects;
    private double stifund;

    private String gender;

    public StreamUser(Long id) {
        this.id = id;
    }

    public StreamUser(Long id, String name, String department, List<String> subjects, double stifund, String gender) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.subjects = subjects;
        this.stifund = stifund;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public double getStifund() {
        return stifund;
    }

    public void setStifund(double stifund) {
        this.stifund = stifund;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StreamUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", subjects=" + subjects +
                ", stifund=" + stifund +
                ", gender='" + gender + '\'' +
                "}\n";
    }
}
