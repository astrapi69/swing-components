/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.img;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;

import lombok.extern.java.Log;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * The class {@link ImageToPdfExtensions}
 */
@Log
public class ImageToPdfExtensions
{

	/**
	 * Creates from the given Collection of images an pdf file.
	 *
	 * @param result
	 *            the output stream from the pdf file where the images shell be written.
	 * @param images
	 *            the BufferedImage collection to be written in the pdf file.
	 * @throws DocumentException
	 *             is thrown if an error occurs when trying to get an instance of {@link PdfWriter}.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void createPdf(final OutputStream result, final List<BufferedImage> images)
		throws DocumentException, IOException
	{
		final Document document = new Document();
		PdfWriter.getInstance(document, result);
		for (final BufferedImage image : images)
		{
			final ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			final Image img = Image.getInstance(baos.toByteArray());
			document.setPageSize(img);
			document.newPage();
			img.setAbsolutePosition(0, 0);
			document.add(img);
		}
		document.close();
	}

	/**
	 * Factory method for create a new {@link PdfPTable} with the given count of columns and the
	 * column header names
	 *
	 * @param numColumns
	 *            the count of columns of the table
	 * @param headerNames
	 *            the column header names
	 * @return the new {@link PdfPTable}
	 */
	public static PdfPTable newPdfPTable(int numColumns, List<String> headerNames)
	{
		PdfPTable table = new PdfPTable(numColumns);
		headerNames.stream().forEach(columnHeaderName -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnHeaderName));
			table.addCell(header);
		});
		return table;
	}
}
