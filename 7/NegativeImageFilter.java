
/**
 * 画像にネガ・ポジ変換をかけるフィルタ
 * @author Satoshi MURASHIGE
 */
public class NegativeImageFilter extends AbstractImageFilter{
	
	@Override
	public void process(GrayImage img){
		for(int y = 0; y < img.getHeight(); ++y){
			for(int x = 0; x < img.getWidth(); ++x){
				int p = img.getGray(x, y);
				p = 255 - p;
				img.setGray(x, y, p);
			}
		}
	}
}
