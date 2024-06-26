package com.example.gestionlabo.service;

import com.example.gestionlabo.model.Commande;
import com.example.gestionlabo.model.ProduitCommande;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    public static ByteArrayInputStream generateCommandePdf(Commande commande) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc, PageSize.A4);
        pdfDoc.addNewPage();

        // Load font with French accents support
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

        // Add title
        Paragraph title = new Paragraph("Détails de la Commande")
                .setFont(boldFont)
                .setFontSize(18)
                .setTextAlignment(TextAlignment.CENTER);
        document.add(title);

        // Add Commande details
        document.add(new Paragraph("Désignation: " + commande.getDesignation()).setFont(boldFont));
        document.add(new Paragraph("Date: " + commande.getDate()).setFont(boldFont));
        document.add(new Paragraph("Observation: " + commande.getObservation()).setFont(boldFont));
        document.add(new Paragraph("Numéro: " + commande.getNumero()).setFont(boldFont));

        // Add Fournisseur details
        document.add(new Paragraph("Fournisseur:").setFont(boldFont));
        document.add(new Paragraph("Nom: " + commande.getFournisseur().getNom()).setFont(boldFont));
        document.add(new Paragraph("Adresse: " + commande.getFournisseur().getAdresse()).setFont(boldFont));
        document.add(new Paragraph("Email: " + commande.getFournisseur().getEmail()).setFont(boldFont));
        document.add(new Paragraph("Numéro de téléphone: " + commande.getFournisseur().getNmrTel()).setFont(boldFont));

        // Add Directeur details
        document.add(new Paragraph("Directeur:").setFont(boldFont));
        document.add(new Paragraph("Nom: " + commande.getUser().getLastName()).setFont(boldFont));
        document.add(new Paragraph("Prénom: " + commande.getUser().getFirstName()).setFont(boldFont));
        document.add(new Paragraph("Email: " + commande.getUser().getEmail()).setFont(boldFont));

        // Add Products table
        document.add(new Paragraph("Produits:").setFont(boldFont));
        Table table = new Table(UnitValue.createPercentArray(new float[]{3, 3, 1})).useAllAvailableWidth();
        table.addHeaderCell(new Cell().add(new Paragraph("Produit").setFont(boldFont)));
        table.addHeaderCell(new Cell().add(new Paragraph("Référence").setFont(boldFont)));
        table.addHeaderCell(new Cell().add(new Paragraph("Quantité Ajoutée").setFont(boldFont)));

        for (ProduitCommande produit : commande.getProduits()) {
            table.addCell(new Cell().add(new Paragraph(produit.getProduit().getDesignation()).setFont(font)));
            table.addCell(new Cell().add(new Paragraph(produit.getProduit().getReference()).setFont(font)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(produit.getQuantiteAjoutee())).setFont(font)));
        }

        document.add(table);

        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
