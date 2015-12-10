import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GrayImage extends BufferedImage{
	
	/**
	 * コンストラクタ
	 * @param img カラー画像
	 */
	public GrayImage(BufferedImage img){
		super(img.getWidth(), img.getHeight(), TYPE_INT_ARGB);
		
		// 引数で受け取った画像をグレースケール変換して保持する
		for(int i = 0; i < img.getHeight(); i++){
			for(int j = 0; j < img.getWidth(); j++){
				// 画像から画素値を取得する
				int argb = img.getRGB(j, i);
				// グレースケール変換
				int l = rgbToGray(argb);
				// GrayImageに画素をセットする
				argb = grayToRgb(l);
				this.setRGB(j, i, argb);
			}
		}
	}
	
	/**
	 * 受けとった輝度値をカラー画像に書き込める形式に変換する
	 * @param gray 輝度値
	 * @return カラー画像に書き込める形式の輝度値
	 */
	private int grayToRgb(int gray){
		return (255 << 24) | (gray << 16) | (gray << 8) | gray;
	}

	/**
	 * 受けとったカラーの画素値をグレースケール変換する
	 * @param rgb カラーの画素値
	 * @return グレースケール変換した結果
	 */
	private int rgbToGray(int rgb){
		int a = (rgb >> 24) & 0xFF;
		int r = (rgb >> 16) & 0xFF;
		int g = (rgb >>  8) & 0xFF;
		int b = (rgb >>  0) & 0xFF;
		return (int)(0.2989 * r + 0.3587 * g + 0.1140 * b);
	}
}
