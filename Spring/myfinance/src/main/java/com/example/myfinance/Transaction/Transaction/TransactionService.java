package com.example.myfinance.Transaction.Transaction;

import com.itextpdf.text.Paragraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @GetMapping
    public List<Transactions> getInfos(@RequestParam(required = false) String minDate,
                                       @RequestParam(required = false) String maxDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate minLocalDate = null;
        LocalDate maxLocalDate = null;


        if (minDate != null) {
            minLocalDate = LocalDate.parse(minDate, formatter);
        }
        if (maxDate != null) {
            maxLocalDate = LocalDate.parse(maxDate, formatter);
        }

        LocalDate finalMinLocalDate = minLocalDate;
        LocalDate finalMaxLocalDate = maxLocalDate;

        return transactionRepository.findAll().stream()
                .filter(e -> (finalMinLocalDate == null || e.getTransactionDate().isAfter(finalMinLocalDate)) &&
                        (finalMaxLocalDate == null || e.getTransactionDate().isBefore(finalMaxLocalDate)))
                .sorted(Comparator.comparing(Transactions::getTransactionDate))
                .collect(Collectors.toList());
    }

    public void addNewTransaction(Transactions transactions) {
        transactionRepository.save((transactions));
    }
    public ResponseEntity<byte[]> generatePdf() {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Transaction Report");
                contentStream.newLineAtOffset(0, -20);

                contentStream.setFont(PDType1Font.HELVETICA, 12);

                List<Transactions> transactions = transactionRepository.findAll();
                for (Transactions transaction : transactions) {
                    contentStream.showText("Type: " + transaction.getType() + " | Amount: " + transaction.getAmount() + " | Date: " + transaction.getTransactionDate());
                    contentStream.newLineAtOffset(0, -15);
                }

                contentStream.endText();
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            document.save(out);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "transactions.pdf");

            return ResponseEntity.ok().headers(headers).body(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

}
