package Block;

import java.awt.Color;

public class Block_Square extends Block {

	Block_Square() {

		super(new int[3][3], Color.magenta, "i", 1, 1, 7);

		// パターン1
		super.stonePattarn1[0][0] = super.blockID;
		super.stonePattarn1[0][1] = super.blockID;
		super.stonePattarn1[1][0] = super.blockID;
		super.stonePattarn1[1][1] = super.blockID;

		// パターン2を作る（今回はパターン1と同じ）
		super.stonePattarn2 = super.stonePattarn1;

		// パターン3を作る（今回はパターン1と同じ）
		super.stonePattarn3 = super.stonePattarn1;

		// パターン4を作る（今回はパターン1と同じ）
		super.stonePattarn4 = super.stonePattarn1;

		// 最初のブロックを登録
		super.nowStone = super.stonePattarn1;
		super.nextStone = super.stonePattarn2;
	}

}
