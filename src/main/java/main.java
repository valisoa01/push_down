import Connection.DBRetriever;
import Classes.InvoiceTotal;

import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main(String[] args) throws SQLException {
        DBRetriever dbRetriever = new DBRetriever();
        /*List<InvoiceTotal> invoices = dbRetriever.findInvoiceTotals();

        for (InvoiceTotal inv : invoices) {
            System.out.println(inv);
        }*/
        List<InvoiceTotal> invoiceTotals =dbRetriever.findConfirmedAndPaidInvoiceTotals();
        for (InvoiceTotal invoiceTotal : invoiceTotals) {
            System.out.println(invoiceTotal);
        }

        Double turnover = dbRetriever.computeWeightedTurnover();
        System.out.printf("Chiffre d’affaires pondéré = %.2f%n", turnover);

    }
}
