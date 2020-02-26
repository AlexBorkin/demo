package demo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class Person
{
    @Size(min=2, max=30, message = "Имя должно быть длинне 2-х символов и не более 30-ти!")
    private String name;

    private ArrayList arrayList;

    private String description;

    public ArrayList getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @Min(value=18, message="Для пользования сайтом возраст должен быть не меньше 18 лет!")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return String.format("Человек по имени: %s возрастом %s лет!", this.name, this.age);
    }
}
