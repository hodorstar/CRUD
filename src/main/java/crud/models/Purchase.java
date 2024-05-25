package crud.models;

import jakarta.persistence.*;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import java.sql.Timestamp;


@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "buyer")
    private Long buyer;
    @Column(name = "seller")
    private Long seller;
    @Column(name = "type")
    private Long type;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Timestamp date;

    public Purchase() {
    }

    public Purchase(Long id, Long buyer, Long seller, Long type,  String name, Timestamp date) {
        this.id = id;
        this.buyer = buyer;
        this.seller = seller;
        this.type = type;
        this.name = name;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getBuyer() {
        return buyer;
    }

    public Long getSeller() {
        return seller;
    }

    public Long getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Timestamp getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", buyerId=" + buyer +
                ", sellerId=" + seller +
                ", typeId=" + type +
                ", name=" + name +
                ", date=" + date +
                "}";
    }

}
