package entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tb_product")
@Data
public class Plate implements Serializable {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imgUrl;

    public Plate(Long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Plate() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plate plate)) return false;
        return Objects.equals(getId(), plate.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
