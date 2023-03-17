package sg.edu.ntu.m3project.m3project.entity;

import java.text.DecimalFormat;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="transport")
public class TransportEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    String description;

    float price;
    final DecimalFormat df = new DecimalFormat("000000.00");
    df.format(price);

    @Column(name="created_at", updatable= false)
    Timestamp createdAt = new Timestamp(new Date().getTime());

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}