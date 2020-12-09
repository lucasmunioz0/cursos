package com.datajpa.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.datajpa.domain.DetalleFactura;
import com.datajpa.domain.Factura;
@Component("factura/ver.xlsx")
public class FacturaExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"factura_view.xlsx\"");
		MessageSourceAccessor mensajes = getMessageSourceAccessor();
		Factura factura = (Factura) model.get("factura");
		Sheet sheet = workbook.createSheet("Factura Spring");
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(mensajes.getMessage("text.factura.ver.datos.cliente"));
		
		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
		
		row = sheet.createRow(2);
		cell = row.createCell(0);
		cell.setCellValue(factura.getCliente().getEmail());
		
		sheet.createRow(4).createCell(0).setCellValue(mensajes.getMessage("text.factura.ver.datos.factura"));
		sheet.createRow(5).createCell(0).setCellValue(mensajes.getMessage("text.cliente.factura.folio") + ": " +  factura.getId());
		sheet.createRow(6).createCell(0).setCellValue(mensajes.getMessage("text.cliente.factura.descripcion") + ": " + factura.getDescripcion());
		sheet.createRow(7).createCell(0).setCellValue(mensajes.getMessage("text.cliente.factura.fecha") + ": " + factura.getCreatedAt());
		
		CellStyle theaderStyle = workbook.createCellStyle();
		theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
		theaderStyle.setBorderTop(BorderStyle.MEDIUM);
		theaderStyle.setBorderRight(BorderStyle.MEDIUM);
		theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
		theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
		theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CellStyle tbody = workbook.createCellStyle();
		tbody.setBorderBottom(BorderStyle.THIN);
		tbody.setBorderTop(BorderStyle.THIN);
		tbody.setBorderRight(BorderStyle.THIN);
		tbody.setBorderLeft(BorderStyle.THIN);
		
		
		Row header = sheet.createRow(9);
		header.createCell(0).setCellValue(mensajes.getMessage("text.factura.form.item.nombre"));
		header.createCell(1).setCellValue(mensajes.getMessage("text.factura.form.item.precio"));
		header.createCell(2).setCellValue(mensajes.getMessage("text.factura.form.item.cantidad"));
		header.createCell(3).setCellValue(mensajes.getMessage("text.factura.form.item.total"));
		header.getCell(0).setCellStyle(theaderStyle);
		header.getCell(1).setCellStyle(theaderStyle);
		header.getCell(2).setCellStyle(theaderStyle);
		header.getCell(3).setCellStyle(theaderStyle);
		
		int rowNumber = 10;
		for (DetalleFactura detalle: factura.getDetalles()) {
			Row fila = sheet.createRow(rowNumber++);
			cell = fila.createCell(0);
			cell.setCellValue(detalle.getProducto().getNombre());
			cell.setCellStyle(tbody);
			
			cell = fila.createCell(1);
			cell.setCellValue(detalle.getProducto().getPrecio());
			cell.setCellStyle(tbody);
			
			cell = fila.createCell(2);
			cell.setCellValue(detalle.getCantidad());
			cell.setCellStyle(tbody);
			
			cell = fila.createCell(3);
			cell.setCellValue(detalle.calcularImporte());
			cell.setCellStyle(tbody);
		}
		Row fila = sheet.createRow(rowNumber);
		fila.createCell(2).setCellValue(mensajes.getMessage("text.factura.form.item.total"));
		fila.createCell(3).setCellValue(factura.getTotal());
	}	
}
