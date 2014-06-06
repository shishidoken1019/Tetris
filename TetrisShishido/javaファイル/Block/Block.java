package Block;

import java.awt.Color;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Block {

	/**
	 * ブロックID
	 */
	int blockID;
	/**
	 * 現在のブロック座標
	 */
	protected int[][] nowStone;

	/**
	 * 現在の石座標のリスト
	 */
	protected ArrayList<int[][]> stoneList;

	/**
	 * 次回転後のブロック座標
	 */
	protected int[][] nextStone;

	/**
	 * ブロックパターン1
	 */
	protected int[][] stonePattarn1;
	/**
	 * ブロックパターン2
	 */
	protected int[][] stonePattarn2;
	/**
	 * ブロックパターン3
	 */
	protected int[][] stonePattarn3;

	/**
	 * ブロックパターン4
	 */
	protected int[][] stonePattarn4;

	/**
	 * 色
	 */
	protected Color color;
	/**
	 * 柄
	 */
	protected String mark = "";

	/**
	 * 軸座標の高さの位置
	 */
	protected int shaftHeight = 1;

	/**
	 * 軸座標の幅の位置
	 */
	protected int shaftWidth = 1;

	/**
	 * 現在のブロックのパターン
	 */
	protected int roundCount = 1;

	/**
	 * 
	 * @param stone
	 *            最初の配列
	 * @param color
	 *            色
	 * @param mark
	 *            柄
	 * @param shaft_height
	 *            　軸ブロックの高さ
	 * @param shaft_width
	 *            軸ブロックの幅
	 * @param blockID
	 *            　　　　ブロックID
	 */
	Block(int[][] stone, Color color, String mark, int shaft_height,
			int shaft_width, int blockID) {

		this.stonePattarn1 = new int[stone.length][stone[0].length];
		this.stonePattarn2 = new int[stone.length][stone[0].length];
		this.stonePattarn3 = new int[stone.length][stone[0].length];
		this.stonePattarn4 = new int[stone.length][stone[0].length];
		this.color = color;
		this.mark = mark;
		this.shaftHeight = shaft_height;
		this.shaftWidth = shaft_width;

		this.nowStone = stone;
		this.blockID = blockID;

	}

	/**
	 * @return nowStone
	 */
	public int[][] getNowStone() {
		return nowStone;
	}

	/**
	 * @param nowStone
	 *            セットする nowStone
	 */
	public void setNowStone(int[][] nowStone) {
		this.nowStone = nowStone;
	}

	/**
	 * @return stone
	 */
	public int[][] getStone() {
		return nowStone;
	}

	/**
	 * @param stone
	 *            セットする stone
	 */
	public void setStone(int[][] stone) {
		this.nowStone = stone;
	}

	/**
	 * @return color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color
	 *            セットする color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return mark
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * @param mark
	 *            セットする mark
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * @return shaft_height
	 */
	public int getShaft_height() {
		return shaftHeight;
	}

	/**
	 * @param shaft_height
	 *            セットする shaft_height
	 */
	public void setShaft_height(int shaft_height) {
		this.shaftHeight = shaft_height;
	}

	/**
	 * @return shaft_width
	 */
	public int getShaft_width() {
		return shaftWidth;
	}

	/**
	 * @param shaft_width
	 *            セットする shaft_width
	 */
	public void setShaft_width(int shaft_width) {
		this.shaftWidth = shaft_width;
	}

	/**
	 * @return roundCount
	 */
	public int getRoundCount() {
		return roundCount;
	}

	/**
	 * @param roundCount
	 *            セットする roundCount
	 */
	public void setRoundCount(int roundCount) {
		this.roundCount = roundCount;
	}

	/**
	 * @return stonePattarn1
	 */
	public int[][] getStonePattarn1() {
		return stonePattarn1;
	}

	/**
	 * @param stonePattarn1
	 *            stonePattarn1をセットする
	 */
	public void setStonePattarn1(int[][] stonePattarn1) {
		this.stonePattarn1 = stonePattarn1;
	}

	/**
	 * @return stonePattarn2
	 */
	public int[][] getStonePattarn2() {
		return stonePattarn2;
	}

	/**
	 * @param stonePattarn2
	 *            ブロックパターン2をセットする stonePattarn2
	 */
	public void setStonePattarn2(int[][] stonePattarn2) {
		this.stonePattarn2 = stonePattarn2;
	}

	/**
	 * @return stonePattarn3
	 */
	public int[][] getStonePattarn3() {
		return stonePattarn3;
	}

	/**
	 * @param stonePattarn3
	 *            ブロックパターン3をセットする stonePattarn3
	 */
	public void setStonePattarn3(int[][] stonePattarn3) {
		this.stonePattarn3 = stonePattarn3;
	}

	/**
	 * @return stonePattarn4
	 */
	public int[][] getStonePattarn4() {
		return stonePattarn4;
	}

	/**
	 * @param stonePattarn4
	 *            ブロックパターン4をセットする stonePattarn4
	 */
	public void setStonePattarn4(int[][] stonePattarn4) {
		this.stonePattarn4 = stonePattarn4;
	}

	/**
	 * @return nextStone
	 */
	public int[][] getNextStone() {
		return nextStone;
	}

	/**
	 * @param nextStone
	 *            次回転後のブロックをセットする nextStone
	 */
	public void setNextStone(int[][] nextStone) {
		this.nextStone = nextStone;
	}

	/**
	 * @return blockID
	 */
	public int getBlockID() {
		return blockID;
	}

	/**
	 * @param blockID
	 *            セットする blockID
	 */
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}

}
