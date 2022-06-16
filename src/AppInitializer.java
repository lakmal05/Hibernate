import entity.Customer;
import entity.Item;
import entity.Order;
import entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

public class AppInitializer {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.setId("C001");
        c1.setName("Tital1");
        c1.setSalary(200000);
        c1.setAddress("Colombo");

        Customer c2 = new Customer();
        c2.setId("C002");
        c2.setName("Tital2");
        c2.setSalary(100000);
        c2.setAddress("Gampha");

        Item i1 = new Item();
        i1.setItemCode("I003");
        i1.setDescription("Item1");
        i1.setQtyOnHand(50);
        i1.setUnitPrice(600);



        Order o1 = new Order();
        o1.setCustomer("Tital1");
        o1.setTotal(150000);

        //Order_Detail
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setId("M001");
        orderDetail1.setOrder(o1);
        orderDetail1.setItem(i1);
        orderDetail1.setQty(1);
        orderDetail1.setSubTotal(150000);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        o1.addOrderDetail(orderDetail1);

        session.save(o1);

        transaction.commit();
        session.close();
    }
}
