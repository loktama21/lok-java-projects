package TodoList;

public class Task {
    int id;
    String description;
    String assignedPerson;
    int daysToComplete;

    public Task(int id, String description, String assignedPerson, int daysToComplete) {
        this.id = id;
        this.description = description;
        this.assignedPerson = assignedPerson;
        this.daysToComplete = daysToComplete;
    }

    public Task(String description, String assignedPerson, int daysToComplete){
        this.description = description;
        this.assignedPerson = assignedPerson;
        this.daysToComplete = daysToComplete;
    }

    public int getId() {
        return id;
    }

    public String getDescription(){
        return description;
    }

    public String getAssignedPerson() {
        return assignedPerson;
    }

    public int getDaysToComplete() {
        return daysToComplete;
    }
}
