package field;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Collections;

import Block.Block;

public class Field {

	/**
	 * 揃っているラインのリスト
	 */
	ArrayList<Integer> dispeardLineHeight = new ArrayList<Integer>();
	/**
	 * 縦横の空白空間
	 */
	private int margin = 10;

	/**
	 * フィールド幅　高さ
	 */
	private int width = 100 + margin * 2, height = 190 + margin * 2;

	/**
	 * 全体フィールドから見た現在ブロックの横座標と縦座標
	 */
	private int nowBlockX, nowBlockY;

	/**
	 * 二次元配列にしたときの
	 */
	private int[][] field;

	/**
	 * マスひとつの大きさ
	 */
	private static int StoneSize = 10;

	/**
	 * フィールドを表すフラグ。二次元配列に格納
	 */
	private int fieldFlg = 1;

	/**
	 * フィールドを表すブロックの色。背景色と同じ白
	 */
	Color fieldColor = Color.white;

	/**
	 * コンストラクタ
	 */
	public Field() {

		// フィールドの配列を作る
		field = new int[height / StoneSize][width / StoneSize];

		for (int w = 0; w < field[0].length; w++) {
			field[height / StoneSize - 1][w] = 1;
		}
		for (int h = 0; h < field.length; h++) {
			field[h][0] = 1;
			field[h][field[0].length - 1] = 1;
		}

		// ブロックの落下位置をフィールドの大きさから決定
		this.nowBlockX = width / 2 - margin;
		this.nowBlockY = 0;

	}

	/**
	 * 動けるかどうか判定
	 * 
	 * @param block
	 *            ブロックの現在のx座標
	 * @param nowStone
	 *            　ブロックを構成する石の配置
	 * 
	 * @return 動けるかどうかの判定
	 */

	public boolean canMove(Block block, KeyEvent key) {

		// 左方向に動けない場合
		if (key.getKeyCode() == KeyEvent.VK_LEFT) {
			for (int h = 0; h < block.getNowStone().length; h++) {
				for (int w = 0; w < block.getNowStone()[0].length; w++) {
					if (block.getNowStone()[h][w] != 0
							&& field[(nowBlockY + (h + block.getShaft_height())
									* StoneSize)
									/ StoneSize][(nowBlockX + (w * block
									.getShaft_width()) * StoneSize)
									/ StoneSize - 1] != 0) {
						return false;
					}
				}
			}
			return true;
			// 右方向に動けない場合
		} else if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
			for (int h = 0; h < block.getNowStone().length; h++) {
				for (int w = 0; w < block.getNowStone()[0].length; w++) {
					if (block.getNowStone()[h][w] != 0
							&& field[(nowBlockY + (h + block.getShaft_height())
									* StoneSize)
									/ StoneSize][(nowBlockX + (w * block
									.getShaft_width()) * StoneSize)
									/ StoneSize + 1] != 0) {
						return false;
					}
				}
			}
			return true;

			// 回転できない場合
		} else if (key.getKeyCode() == KeyEvent.VK_Z) {
			// 次のブロックが画面の範囲内に納まらなかったらfalse
			for (int h = 0; h < block.getNextStone().length; h++) {
				for (int w = 0; w < block.getNextStone()[0].length; w++) {
					if (block.getNextStone()[h][w] != 0
							&& field[(nowBlockY + (h + block.getShaft_height())
									* StoneSize)
									/ StoneSize][(nowBlockX + (w * block
									.getShaft_width()) * StoneSize)
									/ StoneSize] != 0) {

						return false;

					}
				}
			}
			return true;

		}
		return true;

	}

	/**
	 * 動けるかどうか判定
	 * 
	 * @param block
	 *            　現在のブロック
	 * @return　判定結果
	 */
	public boolean canMove(Block block) {
		// 下についた場合
		for (int h = 0; h < block.getNowStone().length; h++) {
			for (int w = 0; w < block.getNowStone()[0].length; w++) {
				// 現在のブロックとフィールドにあるブロックが接触したら、動けない
				if (block.getNowStone()[h][w] != 0
						&& field[(nowBlockY + (h + block.getShaft_height())
								* StoneSize)
								/ StoneSize][(nowBlockX + w * StoneSize)
								/ StoneSize] != 0) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 揃っているラインがあるか判定
	 */
	public void shouldDisappeardLine() {

		// ラインが揃った場合はラインのインデックスをリストに追加
		for (int h = 0; h < field.length - 1; h++) {
			for (int w = 1; w < field[0].length - 1; w++) {
				if (field[h][w] == 0)
					break;
				if (w == field[0].length - 2) {
					dispeardLineHeight.add(h);
				}
			}
		}
	}

	/**
	 * ラインを消す
	 */
	public void disppeardLine() {
		// 現在揃っているラインリストから、揃っているラインの高さを取得
		for (int l : dispeardLineHeight) {
			while (l >= 0) {
				for (int w = 1; w < field[0].length - 1; w++) {

					// 一段ずつ下げる
					if (l == 0) {
						field[l][w] = 0;
					} else {
						field[l][w] = field[l - 1][w];
					}
				}
				l--;
			}

		}
		dispeardLineHeight.clear();

	}

	/**
	 * @return nowBlockX ブロックのx座標
	 */
	public int getNowBlockX() {
		return nowBlockX;
	}

	/**
	 * @param nowBlockX
	 *            　現在のx座標をセットする nowBlockX
	 */
	public void setNowBlockX(int nowBlockX) {
		this.nowBlockX = nowBlockX;
	}

	/**
	 * @return nowBlockY ブロックのY座標
	 */
	public int getNowBlockY() {
		return nowBlockY;
	}

	/**
	 * @param nowBlockY
	 *            現在のy座標をセットする nowBlockY
	 */
	public void setNowBlockY(int nowBlockY) {
		this.nowBlockY = nowBlockY;
	}

	/**
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            画面の幅をセットする width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return height 画面の高さ
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            画面の高さをセットする height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return StoneSize ひとつのブロックのサイズ
	 */
	public int getStoneSize() {
		return StoneSize;
	}

	/**
	 * @return field
	 */
	public int[][] getField() {
		return field;
	}

	/**
	 * @param field
	 *            フィールドをセットする field
	 */
	public void setField(int[][] field) {
		this.field = field;
	}

	/**
	 * @return margin
	 */
	public int getMargin() {
		return margin;
	}

	/**
	 * @param margin
	 *            空白をセットする margin
	 */
	public void setMargin(int margin) {
		this.margin = margin;
	}

	/**
	 * @return fieldFlg
	 */
	public int getFieldFlg() {
		return fieldFlg;
	}

	/**
	 * @param fieldFlg
	 *            セットする fieldFlg
	 */
	public void setFieldFlg(int fieldFlg) {
		this.fieldFlg = fieldFlg;
	}

	/**
	 * @return fieldColor
	 */
	public Color getFieldColor() {
		return fieldColor;
	}

	/**
	 * @param フィールドカラーをセットする
	 *            fieldColor
	 */
	public void setFieldColor(Color fieldColor) {
		this.fieldColor = fieldColor;
	}

	/**
	 * @return dispeardLineHeight
	 */
	public ArrayList<Integer> getDispeardLineHeight() {
		return dispeardLineHeight;
	}

	/**
	 * @param dispeardLineHeight
	 *            セットする dispeardLineHeight
	 */
	public void setDispeardLineHeight(ArrayList<Integer> dispeardLineHeight) {
		this.dispeardLineHeight = dispeardLineHeight;
	}

}
