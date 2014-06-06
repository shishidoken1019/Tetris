package Block;

import java.awt.Color;

/**
 * テトリス棒
 */
public class Block_I extends Block {

	/**
	 * コンストラクタ
	 */
	public Block_I() {
		super(new int[4][4], Color.red, "i", 1, 1, 2);

		// パターン1を作る
		super.stonePattarn1[1][0] = 1;
		super.stonePattarn1[1][1] = 1;
		super.stonePattarn1[1][2] = 1;
		super.stonePattarn1[1][3] = 1;

		// パターン2を作る
		super.stonePattarn2[0][1] = 1;
		super.stonePattarn2[1][1] = 1;
		super.stonePattarn2[2][1] = 1;
		super.stonePattarn2[3][1] = 1;

		// パターン3を作る（今回はパターン1と同じ）
		super.stonePattarn3 = super.stonePattarn1;

		// パターン4を作る（今回はパターン2と同じ）
		super.stonePattarn4 = super.stonePattarn2;

		// 最初のブロックを登録
		super.nowStone = stonePattarn1;
		super.nextStone = super.stonePattarn2;

	}
}
