package com.reed.ustc.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;

/**
 * created by reedfan on 2019/9/28 0028
 */
public class QrCodeUtils {

    /**
     * 二维码的生成
     *
     */
    public static void  createCode(){
        String text = "http://blog.csdn.net/gao36951";
        int width = 300;
        int height = 300;
        // 二维码的图片格式
        String format = "png";
        /**
         * 设置二维码的参数
         */
        HashMap hints = new HashMap();
        // 内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE,width,height,hints);
            // 生成二维码
            File outputFile = new File("D:"+ File.separator +"kankan" + File.separator + "TDC-test.png");
            MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 二维码的解析
     *
     * @param file
     */
    public static void parseCode(File file)
    {
        try
        {
            MultiFormatReader formatReader = new MultiFormatReader();

            if (!file.exists())
            {
                return;
            }

            BufferedImage image = ImageIO.read(file);

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            Result result = formatReader.decode(binaryBitmap, hints);

            System.out.println("解析结果 = " + result.toString());
            System.out.println("二维码格式类型 = " + result.getBarcodeFormat());
            System.out.println("二维码文本内容 = " + result.getText());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
