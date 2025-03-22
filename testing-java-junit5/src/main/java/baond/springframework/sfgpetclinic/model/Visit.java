package baond.springframework.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.Objects;

public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Pet pet;

    public Visit() {
        super(null);
    }

    public Visit(Long id) {
        super(id);
    }

    public Visit(Long id, LocalDate date) {
        super(id);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Visit visit = (Visit) object;
        return Objects.equals(date, visit.date) && Objects.equals(description, visit.description) && Objects.equals(pet, visit.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, description, pet);
    }
}
