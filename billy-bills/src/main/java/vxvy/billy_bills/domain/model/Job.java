package vxvy.billy_bills.domain.model;

public class Job {
    private String name;
    private String description;

    public Job(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}