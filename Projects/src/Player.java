public class Player {

    private String firstName;

    private String lastName;

    private int budget;

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Player(String firstName, String lastName, int budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.budget = budget;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getBudget() {
        return this.budget;
    }

    public void setBudget(int newBudget) {
        this.budget = newBudget;
    }
}