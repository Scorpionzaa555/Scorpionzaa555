package run;

public class Person {
    private String FirstName, LastName;
    private int age;
    private int Id;

    public Person(String FirstName, String LastName, int age, int Id) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.age = age;
        this.Id = Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public int getAge() {
        return age;
    }
    
    public int getId() {
        return Id;
    }

    public String getLastName() {
        return LastName;
    }
}
