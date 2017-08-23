
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageFormats {

	public static BufferedImage getBufferedImage(byte[][] pixels){
		int largura = pixels.length;
		int altura = pixels[0].length;

		BufferedImage imageBuffer = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				imageBuffer.setRGB(x, y, pixels[x][y]);
			}
		}

		return imageBuffer;
	}

	public static BufferedImage getBufferedImage(int[][] pixels){
		int largura = pixels.length;
		int altura = pixels[0].length;

		BufferedImage imageBuffer = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				imageBuffer.setRGB(x, y, pixels[x][y]);
			}
		}

		return imageBuffer;
	}

	public static BufferedImage getBufferedImage(float[][] pixels){
		int largura = pixels.length;
		int altura = pixels[0].length;

		BufferedImage imageBuffer = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				float p =  (float) pixels[x][y];
				imageBuffer.setRGB(x, y, (int) p);
			}
		}

		return imageBuffer;
	}
	
	public static int[][] getPixels(BufferedImage img){
		int largura = img.getWidth();
		int altura = img.getHeight();

		int[][] output = new int[largura][altura];
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				output[x][y] = img.getRGB(x, y) & 0x00ffffff;
			}
		}
		return output;
	}

	public static void seeImage(byte[][] image){

		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(getBufferedImage(image))));
		frame.pack();
		frame.setVisible(true);

	}

	public static void seeImage(int[][] image){

		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(getBufferedImage(image))));
		frame.pack();
		frame.setVisible(true);

	}
	
	public static void seeImage(float[][] image){

		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(getBufferedImage(image))));
		frame.pack();
		frame.setVisible(true);

	}
	
	
	public static void seeImage(BufferedImage img){

		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon((img))));
		frame.pack();
		frame.setVisible(true);

	}
	public static void main(String[] args) throws IOException {
	}
}
