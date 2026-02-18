package Classes;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private  Long  id;
    private  String customer_name;
    InvoiceStatus status;

    private List<InvoiceLIne> lines = new ArrayList<>();

    public Invoice() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }
    public  void  setLines (List<InvoiceLIne> lines) {
        this.lines = lines;
    }
    public void addLine(InvoiceLIne line) {
        this.lines.add(line);
    }
    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer_name='" + customer_name + '\'' +
                ", status=" + status +
                '}';
    }
}
