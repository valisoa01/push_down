package Classes;
public class InvoiceTaxSummary {

    private int invoiceId;
    private double totalHt;
    private double totalTva;
    private double totalTtc;

    public InvoiceTaxSummary(int invoiceId, double totalHt, double totalTva, double totalTtc) {
        this.invoiceId = invoiceId;
        this.totalHt = totalHt;
        this.totalTva = totalTva;
        this.totalTtc = totalTtc;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public double getTotalHt() {
        return totalHt;
    }

    public double getTotalTva() {
        return totalTva;
    }

    public double getTotalTtc() {
        return totalTtc;
    }
}

