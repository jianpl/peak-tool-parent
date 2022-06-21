package ink.gfwl.sample.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * 二维码工具
 * @author jianpòlan
 * @version 1.0
 **/
public class QrCodeUtil {

    //默认大小
    private static final int width = 300, height = 300;

    /**
     * 生成二维码
     * @param text 内容
     * @param width 宽度
     * @param height 高度
     * @return BitMatrix
     * @throws WriterException exception
     */
    public static BitMatrix genBitMatrix(String text, int width, int height) throws WriterException{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        return qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
    }

    /**
     * 生成二维码
     * @param text 内容
     * @return BitMatrix
     * @throws WriterException exception
     */
    public static BitMatrix genBitMatrix(String text) throws WriterException{
        return genBitMatrix(text, width, height);
    }

    /**
     * 输出到文件
     * @param bitMatrix 对象
     * @param filePath 文件路径
     * @throws IOException exception
     */
    public static void writeToFile(BitMatrix bitMatrix, String filePath) throws IOException {
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    /**
     * 输出到BufferedImage
     * @param bitMatrix 对象
     * @return BufferedImage
     */
    public static BufferedImage writeToBufferImage(BitMatrix bitMatrix){
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public static void readQrCode(InputStream inputStream) throws IOException {
        //从输入流中获取字符串信息
        BufferedImage image = ImageIO.read(inputStream);
        //将图像转换为二进制位图源
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        QRCodeReader reader = new QRCodeReader();
        Result result = null ;
        try {
            result = reader.decode(bitmap);
            System.out.println(result.getText());
        } catch (ReaderException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws WriterException, IOException {
        BitMatrix peak00001 = genBitMatrix("PEAK00001");
        writeToFile(peak00001, "/Users/alang/Downloads/app/peak0001.png");

    }

}
