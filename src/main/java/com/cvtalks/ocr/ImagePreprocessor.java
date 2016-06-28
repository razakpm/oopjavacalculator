package com.cvtalks.ocr;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import boofcv.alg.filter.binary.GThresholdImageOps;
import boofcv.alg.filter.binary.ThresholdImageOps;
import boofcv.core.image.ConvertBufferedImage;
import boofcv.core.image.ConvertImage;
import boofcv.gui.binary.VisualizeBinaryData;
import boofcv.gui.image.ShowImages;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.image.ImageFloat64;
import boofcv.struct.image.ImageUInt8;

/**
 * The <tt>ImagePreprocessor</tt> class represents a basic image preprocessing
 * operations, such as: <em>convert image to grayscale</em>
 * <em>image binarization</em> This implementation uses <em>BoofCV</em> library.
 *
 * @author Radmilka Skazzi
 */

public class ImagePreprocessor {

    /**
     * <p>
     * Reads a grayscale or color image from the file specified by the string
     * path
     * </p>
     *
     * @param path Full file location
     * @return BufferedImage. If anything goes wrong it returns a null
     */
    public static BufferedImage loadImg(String path) {
        return UtilImageIO.loadImage(path);
    }

    /**
     * <p>
     * Converts image to grayscale
     * </p>
     *
     * @param image The image to grayscale
     * @return grayscale image (ImageUInt8)
     */

    public static ImageUInt8 makeGrayscale(BufferedImage image) {
        return ConvertBufferedImage.convertFromSingle(image, null, ImageUInt8.class);
    }

    /**
     * <p>
     * Converts image to binary image, based on threshold
     * </p>
     *
     * @param image The image to binarize
     * @return binary image (ImageUInt8)
     */

    public static ImageUInt8 makeBinary(ImageUInt8 image) {

        // Select a global threshold using Otsu's method.
        double threshold = GThresholdImageOps.computeOtsu(image, 0, 256);
        ImageUInt8 binary = new ImageUInt8(image.width, image.height);
        ImageFloat64 imageF64 = new ImageFloat64(image.width, image.height);
        ConvertImage.convert(image, imageF64);
        return binary = ThresholdImageOps.threshold(imageF64, binary, threshold, true);
    }


}
