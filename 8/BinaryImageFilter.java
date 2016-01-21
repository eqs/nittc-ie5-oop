
public class BinaryImageFilter implements Processable{
	
	// 2値化に用いる閾値
	private int threshold = 128;

	@Override
	public void process(GrayImage img){
		for(int y = 0; y < img.getHeight(); ++y){
			for(int x = 0; x < img.getWidth(); ++x){
				int p = img.getGray(x, y);
				p = p < threshold ? 0 : 255;
				img.setGray(x, y, p);
			}
		}
	}
}
