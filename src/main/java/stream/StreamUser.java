package stream;

import java.util.List;

public class StreamUser {

    private String id;
    private String name;
    private String department;
    private List<String> subjects;
    private String stifund;

    public StreamUser(String id) {
        this.id = id;
    }

    public StreamUser(String id, String name, String department, List<String> subjects, String stifund) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.subjects = subjects;
        this.stifund = stifund;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getStifund() {
        return stifund;
    }

    public void setStifund(String stifund) {
        this.stifund = stifund;
    }

    @Override
    public String toString() {
        return "StreamUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", subjects=" + subjects +
                ", stifund='" + stifund + '\'' +
                '}';
    }
}
