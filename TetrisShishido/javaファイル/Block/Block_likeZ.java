package Block;

import java.awt.Color;

public class Block_likeZ extends Block {

	Block_likeZ() {

		super(new int[3][3], Color.blue, "t", 1, 1, 4);

		// パターン1
		super.stonePattarn1[0][0] = 1;
		super.stonePattarn1[0][1] = 1;
		super.stonePattarn1[1][1] = 1;
		super.stonePattarn1[1][2] = 1;

		// パターン2
		super.stonePattarn2[0][1] = 1;
		super.stonePattarn2[1][0] = 1;
		super.stonePattarn2[1][1] = 1;
		super.stonePattarn2[2][0] = 1;

		// パターン3を作る（今回はパターン1と同じ）
		super.stonePattarn3 = super.stonePattarn1;

		// パターン4を作る（今回はパターン2と同じ）
		super.stonePattarn4 = super.stonePattarn2;

		// 最初のブロックを登録
		super.nowStone = super.stonePattarn1;
		super.nextStone = super.stonePattarn2;

	}
}
