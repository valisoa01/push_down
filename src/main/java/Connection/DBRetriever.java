package Connection;

import Classes.InvoiceStatusTotals;
import Classes.InvoiceTotal;
import Classes.InvoiceStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBRetriever {

    public List<InvoiceTotal> findInvoiceTotals() throws SQLException {

        List<InvoiceTotal> results = new ArrayList<>();

        String sql = """
            SELECT i.id AS invoice_id,
            i.customer_name,
            i.status,
            SUM(il.quantity * il.unit_price) AS total
            FROM invoice_line il
            JOIN invoice i ON i.id = il.invoice_id
            GROUP BY i.id, i.customer_name, i.status        
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                results.add(new InvoiceTotal(
                        rs.getInt("invoice_id"),
                        rs.getString("customer_name"),
                        InvoiceStatus.valueOf(rs.getString("status")),
                        rs.getBigDecimal("total")
                ));
            }

        }

        return results;
    }
    public List<InvoiceTotal> findConfirmedAndPaidInvoiceTotals() throws SQLException {
    List<InvoiceTotal> resultats = new ArrayList<>();
        String sql = """
            SELECT i.id AS invoice_id,
            i.customer_name,
            i.status,
            SUM(il.quantity * il.unit_price) AS total_facture
            FROM invoice_line il
            JOIN invoice i ON i.id = il.invoice_id
            where status in ('CONFIRMED', 'PAID')
            GROUP BY i.id, i.customer_name, i.status        
        """;
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                resultats.add(new InvoiceTotal(
                        rs.getInt("invoice_id"),
                        rs.getString("customer_name"),
                        InvoiceStatus.valueOf(rs.getString("status")),
                        rs.getBigDecimal("total_facture")
                ));
            }
        }
        return  resultats;
    }

    public InvoiceStatusTotals computeStatusTotals() {

        String sql = """
        SELECT
            SUM(CASE WHEN i.status = 'PAID'
                     THEN il.quantity * il.unit_price ELSE 0 END) AS total_paid,
            SUM(CASE WHEN i.status = 'CONFIRMED'
                     THEN il.quantity * il.unit_price ELSE 0 END) AS total_confirmed,
            SUM(CASE WHEN i.status = 'DRAFT'
                     THEN il.quantity * il.unit_price ELSE 0 END) AS total_draft
        FROM invoice_line il
        JOIN invoice i ON i.id = il.invoice_id
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return new InvoiceStatusTotals(
                        rs.getDouble("total_paid"),
                        rs.getDouble("total_confirmed"),
                        rs.getDouble("total_draft")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new InvoiceStatusTotals(0, 0, 0);
    }


}
