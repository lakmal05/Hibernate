package entity;

import javax.persistence.*;

@Entity
@Table(name = "Order_Details")
public class OrderDetail {
    @Id
    @Column(name = "order_detail_id")
    private String Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_code")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private int qty;
    private double subTotal;

    public OrderDetail() {
    }

    public OrderDetail(String id, Item item, Order order, int qty, double subTotal) {
        Id = id;
        this.item = item;
        this.order = order;
        this.qty = qty;
        this.subTotal = subTotal;
    }

    public OrderDetail(Item item, Order order, int qty, double subTotal) {
        this.item = item;
        this.order = order;
        this.qty = qty;
        this.subTotal = subTotal;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "Id='" + Id + '\'' +
                ", item=" + item +
                ", order=" + order +
                ", qty=" + qty +
                ", subTotal=" + subTotal +
                '}';
    }
}
