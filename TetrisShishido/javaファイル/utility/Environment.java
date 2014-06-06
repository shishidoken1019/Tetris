package utility;

public class Environment {

	/**
	 * ゲーム開始時の落下スピード
	 */
	private final int RowSpeed = 600;
	/**
	 * 下を押した際の最高速度
	 */
	private final int HighSpeed = 100;
	/**
	 * 現在の速度
	 */
	private int nowSpeed = RowSpeed;
	/**
	 * 初期落下位置
	 */
	private int defoultPositionX = 40;
	private int defoultPositionY = 10;

	/**
	 * @return defoultPositionX
	 */
	public int getDefoultPositionX() {
		return defoultPositionX;
	}

	/**
	 * @param defoultPositionX
	 *            セットする defoultPositionX
	 */
	public void setDefoultPositionX(int defoultPositionX) {
		this.defoultPositionX = defoultPositionX;
	}

	/**
	 * @return defoultPositionY
	 */
	public int getDefoultPositionY() {
		return defoultPositionY;
	}

	/**
	 * @param defoultPositionY
	 *            セットする defoultPositionY
	 */
	public void setDefoultPositionY(int defoultPositionY) {
		this.defoultPositionY = defoultPositionY;
	}

	/**
	 * @return rowSpeed
	 */
	public int getRowSpeed() {
		return RowSpeed;
	}

	/**
	 * @return highSpeed
	 */
	public int getHighSpeed() {
		return HighSpeed;
	}

	/**
	 * @return nowSpeed
	 */
	public int getNowSpeed() {
		return nowSpeed;
	}

	/**
	 * @param nowSpeed
	 *            セットする nowSpeed
	 */
	public void setNowSpeed(int nowSpeed) {
		this.nowSpeed = nowSpeed;
	}

}
