package Block;

import java.awt.Color;

public class Block_LikeL extends Block {

	Block_LikeL() {
		// コンストラクタ
		super(new int[3][3], Color.GREEN, "i", 1, 1, 8);

		// パターン1
		super.stonePattarn1[0][2] = super.blockID;
		super.stonePattarn1[1][0] = super.blockID;
		super.stonePattarn1[1][1] = super.blockID;
		super.stonePattarn1[1][2] = super.blockID;

		// パターン2
		super.stonePattarn2[0][0] = super.blockID;
		super.stonePattarn2[0][1] = super.blockID;
		super.stonePattarn2[1][1] = super.blockID;
		super.stonePattarn2[2][1] = super.blockID;

		// パターン3
		super.stonePattarn3[1][0] = super.blockID;
		super.stonePattarn3[1][1] = super.blockID;
		super.stonePattarn3[1][2] = super.blockID;
		super.stonePattarn3[2][0] = super.blockID;

		// パターン4
		super.stonePattarn4[0][1] = super.blockID;
		super.stonePattarn4[1][1] = super.blockID;
		super.stonePattarn4[2][1] = super.blockID;
		super.stonePattarn4[2][2] = super.blockID;

		// 最初のブロックを登録
		super.nowStone = super.stonePattarn1;
		super.nextStone = super.stonePattarn2;
	}

}
