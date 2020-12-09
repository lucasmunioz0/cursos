package com.datajpa.view;

import java.awt.Color;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.datajpa.domain.DetalleFactura;
import com.datajpa.domain.Factura;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("factura/ver")
public class FacturaPdfView extends AbstractPdfView{
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private LocaleResolver localeResolver;

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Factura factura = (Factura) model.get("factura");
		PdfPTable tabla = new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		Locale locale = localeResolver.resolveLocale(request);
		
		MessageSourceAccessor mensajes = getMessageSourceAccessor();
		
		PdfPCell celda = new PdfPCell(new Phrase(messageSource.getMessage("text.factura.ver.datos.cliente", null, locale)));
		celda.setBackgroundColor(new Color(184, 218, 255));
		celda.setPadding(8f);
		tabla.addCell(celda);
		tabla.addCell(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
		tabla.addCell(factura.getCliente().getEmail());
		
		PdfPTable tabla2 = new PdfPTable(1);
		tabla2.setSpacingAfter(20);
		celda = new PdfPCell(new Phrase(messageSource.getMessage("text.factura.ver.datos.factura", null, locale)));
		celda.setBackgroundColor(new Color(195, 230, 203));
		celda.setPadding(8f);
		tabla2.addCell(celda);
		tabla2.addCell(mensajes.getMessage("text.cliente.factura.folio") + factura.getId());
		tabla2.addCell(mensajes.getMessage("text.cliente.factura.descripcion") + factura.getDescripcion());
		tabla2.addCell(mensajes.getMessage("text.cliente.factura.fecha") + factura.getCreatedAt());
		
		PdfPTable tabla3 = new PdfPTable(4);
		tabla3.setWidths(new float[] {3.5f, 1, 1, 1});
		tabla3.addCell(mensajes.getMessage("text.factura.form.item.nombre"));
		tabla3.addCell(mensajes.getMessage("text.factura.form.item.precio"));
		tabla3.addCell(mensajes.getMessage("text.factura.form.item.cantidad"));
		tabla3.addCell(mensajes.getMessage("text.factura.form.item.total"));
		
		for (DetalleFactura detalle :  factura.getDetalles()) {
			tabla3.addCell(detalle.getProducto().getNombre());			
			tabla3.addCell(detalle.getProducto().getPrecio().toString());
			
			celda = new PdfPCell(new Phrase(detalle.getCantidad().toString()));
			celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tabla3.addCell(celda);
			tabla3.addCell(detalle.calcularImporte().toString());
		}
		
		celda = new PdfPCell(new Phrase(mensajes.getMessage("text.factura.form.item.total")));
		celda.setColspan(3);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
		tabla3.addCell(celda);
		tabla3.addCell(factura.getTotal().toString());
		
		document.add(tabla);
		document.add(tabla2);
		document.add(tabla3);
	}

}
