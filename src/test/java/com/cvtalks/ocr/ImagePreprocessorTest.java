package com.cvtalks.ocr;

import static org.junit.Assert.*;
import java.awt.image.BufferedImage;
import org.junit.Test;
import boofcv.struct.image.ImageUInt8;

public class ImagePreprocessorTest {

	
	@Test
	public void binarizationTest() {
		
		BufferedImage image = ImagePreprocessor.loadImg("src/test/resources/img/test4.jpg");

		ImageUInt8 gray = ImagePreprocessor.makeGrayscale(image);
		ImageUInt8 binary = ImagePreprocessor.makeBinary(gray);
		assertEquals(0, binary.get(0, 0));
		assertEquals(1, binary.get(593, 151));
//		ShowImages.showWindow(image, "Original");
//		ShowImages.showWindow(gray, "Grayscale");
//		ShowImages.showWindow(VisualizeBinaryData.renderBinary(binary, null), "Binary");
	}

}
