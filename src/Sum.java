import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Sum {
	public static int[][] sum(int[][] firstImage, int[][] secondImage){
		int largura = firstImage.length;
		int altura = firstImage[0].length;
		int[][] output = new int[largura][altura];

		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				output[x][y] = (firstImage[x][y] + secondImage[x][y]);
//				ImageLog.writeInLog("Primeira Imagem: " + firstImage[x][y]);
//				ImageLog.writeInLog("Segunda Imagem: "  + secondImage[x][y]);
//				ImageLog.writeInLog("Terceira Imagem: "  + output[x][y]);
			}
		}

		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedImage img1 = ImageIO.read(new File("OriginalImage.gif"));
		BufferedImage img2 = ImageIO.read(new File("EdgeImage.gif"));

		ImageFormats.seeImage(img1);
		ImageFormats.seeImage(img2);
		ImageFormats.seeImage(Sum.sum(ImageFormats.getPixels(img1), ImageFormats.getPixels(img2)));
	}
}
