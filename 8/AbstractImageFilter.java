
public interface AbstractImageFilter{
	/**
	 * 画像にフィルタ処理を行うメソッド
	 * @param img フィルタをかける画像
	 */
	public void process(GrayImage img);
}
