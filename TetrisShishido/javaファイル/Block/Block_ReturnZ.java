package Block;

import java.awt.Color;

public class Block_ReturnZ extends Block {

	Block_ReturnZ() {
		super(new int[3][3], Color.CYAN, "l", 1, 1, 5);

		// パターン1
		super.stonePattarn1[0][2] = 1;
		super.stonePattarn1[0][1] = 1;
		super.stonePattarn1[1][0] = 1;
		super.stonePattarn1[1][1] = 1;

		// パターン2
		super.stonePattarn2[0][0] = 1;
		super.stonePattarn2[1][0] = 1;
		super.stonePattarn2[1][1] = 1;
		super.stonePattarn2[2][1] = 1;

		// パターン3を作る（今回はパターン1と同じ）
		super.stonePattarn3 = super.stonePattarn1;

		// パターン4を作る（今回はパターン2と同じ）
		super.stonePattarn4 = super.stonePattarn2;

		// 最初のブロックを登録
		super.nowStone = stonePattarn1;
		super.nextStone = super.stonePattarn2;

	}
}
