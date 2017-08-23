import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import br.com.matheus.image.ImageLog;

public class Sum {
	
	private static final String ORIGINAL_IMAGE = "Sum\\OriginalImage.gif";
	private static final String MASKED_IMAGE = "Sum\\MaskedImage.gif";
	private static final String EDGE_IMAGE = "Sum\\EdgeImage.gif";
	private static final String MASK = "Sum\\Mask.gif";
	
	
	public static int[][] sum(int[][] firstImage, int[][] secondImage){
		int largura = firstImage.length;
		int altura = firstImage[0].length;
		int[][] output = new int[largura][altura];

		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				output[x][y] = (firstImage[x][y] + secondImage[x][y]);
				if (secondImage[x][y] >= 10777215) {
					int r = (secondImage[x][y] & 0x00ff0000 >> 16);
					int g = (secondImage[x][y] & 0x0000ff00 >> 8);
					int b = (secondImage[x][y] & 0x000000ff);
					int r1 = (firstImage[x][y] & 0x00ff0000 >> 16);
					int g1 = (firstImage[x][y] & 0x0000ff00 >> 8);
					int b1 = (firstImage[x][y] & 0x000000ff);
					int r2 = (output[x][y] & 0x00ff0000 >> 16);
					int g2 = (output[x][y] & 0x0000ff00 >> 8);
					int b2 = (output[x][y] & 0x000000ff);
					
					ImageLog.writeInLog("Primeira Imagem: " + r1 +" "+ g1 +" "+ b1);
					ImageLog.writeInLog("Segunda Imagem: "  + r +" "+ g +" "+ b);
					ImageLog.writeInLog("Terceira Imagem: " + r2 +" "+ g2 +" "+ b2);
				}
			}
		}

		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedImage img1 = ImageIO.read(new File(MASKED_IMAGE));
		BufferedImage img2 = ImageIO.read(new File(EDGE_IMAGE));

		ImageFormats.seeImage(img1);
		ImageFormats.seeImage(img2);
		ImageFormats.seeImage(Sum.sum(ImageFormats.getPixels(img1), ImageFormats.getPixels(img2)));
	}
}
