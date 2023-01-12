package khj.eatingrecord.dto;

public class MemberDto {

    private String id;
    private int height;
    private Character gender;
    private int age;
    private int weight;
    private int num_meal;
    private String goal;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNum_meal() {
        return num_meal;
    }

    public void setNum_meal(int num_meal) {
        this.num_meal = num_meal;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
