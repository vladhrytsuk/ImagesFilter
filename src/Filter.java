import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class Filter {
    public static void main(String[] args) {
        try {
            BufferedImage input = ImageIO.read(new File("111.bmp"));

            int width = input.getWidth();
            int height = input.getHeight();

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

            Graphics g = image.getGraphics();
            g.drawImage(input, 0, 0, null);
            g.dispose();
           // ImageIO.write(image, "BMP", new File("./a.bmp"));

            addNoise(image);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[][] addNoise(BufferedImage image) throws Exception {
        Random random = new Random();
        int width = image.getWidth();
        int heigth = image.getHeight();
        int size = width * heigth;
        int count = (size * 10) / 100;
        int x, y;

        for (int i = 0; i < count; i++) {
            x = random.nextInt(width);
            y = random.nextInt(heigth);
            image.setRGB(x, y, (1 - image.getRGB(x, y) * Integer.parseInt(String.valueOf(random.nextInt(255)), 16)));
            image.getRGB(x, y);
        }

        ImageIO.write(image, "BMP", new FileOutputStream("bitmap-mis.bmp"));
        return null;
    }
}
