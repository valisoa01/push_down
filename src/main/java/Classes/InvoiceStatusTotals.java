package Classes;

public class InvoiceStatusTotals {

    private double totalPaid;
    private double totalConfirmed;
    private double totalDraft;

    public InvoiceStatusTotals(double totalPaid, double totalConfirmed, double totalDraft) {
        this.totalPaid = totalPaid;
        this.totalConfirmed = totalConfirmed;
        this.totalDraft = totalDraft;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public double getTotalConfirmed() {
        return totalConfirmed;
    }

    public double getTotalDraft() {
        return totalDraft;
    }
}
