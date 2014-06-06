package player;

import java.util.ArrayList;

import utility.Environment;
import Block.Block;
import field.Field;

public class Player {

	//
	private int Score = 0;

	/**
	 * ブロックの落下処理
	 * 
	 * @param field
	 */
	public void blockDownPosition(Field field) {
		field.setNowBlockY(field.getNowBlockY() + field.getStoneSize());
	}

	/**
	 * ブロックを左に移動
	 * 
	 * @param field
	 */
	public void blockMoveLeft(Field field) {
		field.setNowBlockX(field.getNowBlockX() - field.getStoneSize());
	}

	/**
	 * ブロックを右に移動
	 * 
	 * @param field
	 */
	public void blockMoveRight(Field field) {
		field.setNowBlockX(field.getNowBlockX() + field.getStoneSize());
	}

	/**
	 * ブロックを下に移動
	 * 
	 * @param en
	 *            外的要因
	 */
	public void blockMoveDown(Environment en) {
		en.setNowSpeed(en.getHighSpeed());
	}

	/**
	 * 回転する
	 * 
	 * @param block
	 */
	public void round(Block block) {

		block.setRoundCount(block.getRoundCount() + 1);

		// 回転数に従ってブロックを変える
		switch (block.getRoundCount()) {

		case 1:
			block.setStone(block.getStonePattarn1());
			block.setNextStone(block.getStonePattarn2());
			break;
		case 2:
			block.setStone(block.getStonePattarn2());
			block.setNextStone(block.getStonePattarn3());
			break;
		case 3:
			block.setStone(block.getStonePattarn3());
			block.setNextStone(block.getStonePattarn4());
			break;
		case 4:
			block.setStone(block.getStonePattarn4());
			block.setNextStone(block.getStonePattarn1());
			break;
		}

		// 回転数が4になったら、最初に戻す
		if (block.getRoundCount() == 4) {
			block.setRoundCount(0);
		}
	}

	public void countScore(ArrayList<Integer> lineList) {

		switch (lineList.size()) {

		case 1:
			Score += 10;
			break;

		case 2:
			Score += 20;
			break;

		case 3:
			Score += 50;
			break;

		case 4:
			Score += 100;
			break;

		}

	}

	/**
	 * @return score
	 */
	public int getScore() {
		return Score;
	}

	/**
	 * @param score
	 *            セットする score
	 */
	public void setScore(int score) {
		Score = score;
	}

}
