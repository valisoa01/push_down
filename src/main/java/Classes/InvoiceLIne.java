package Classes;

import java.math.BigDecimal;

public class InvoiceLIne {
    private int id;
    private Long invoiceId;
    private  String label;
    private Integer quantity;
    private BigDecimal uniPrice;

    public InvoiceLIne(int id) {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUniPrice() {
        return uniPrice;
    }

    public void setUniPrice(BigDecimal uniPrice) {
        this.uniPrice = uniPrice;
    }

    @Override
    public String toString() {
        return "InvoiceLIne{" +
                "id=" + id +
                ", invoiceId=" + invoiceId +
                ", label='" + label + '\'' +
                ", quantity=" + quantity +
                ", uniPrice=" + uniPrice +
                '}';
    }
}
