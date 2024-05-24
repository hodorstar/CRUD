package crud.models;

import java.sql.Timestamp;

public class Purchase {
    private Long id;
    private Long buyer;
    private Long seller;

    private Long type;
    private String name;
    private Timestamp date;

    public Purchase(Long id, Long buyer, Long seller, Long type,  String name, Timestamp date) {
        this.id = id;
        this.buyer = buyer;
        this.seller = seller;
        this.type = type;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "\nid=" + id +
                ",\n buyerId=" + buyer +
                ",\n sellerId=" + seller +
                ",\n name=" + name +
                ",\n date=" + date +
                "}\n";
    }

}
