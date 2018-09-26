
import java.io.Serializable;
import java.time.LocalDate;


public class Schueler implements Serializable{
    
    private String name;
    private int age;
    private LocalDate birthday;
    
    public Schueler(String name, LocalDate birthday){
        this.name = name;
        this.birthday = birthday;
        this.age = LocalDate.now().getYear() - birthday.getYear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    
    
            
}
