package Block;

import java.util.ArrayList;

public class BlockList {

	/**
	 * 全部ブロックのリスト
	 */
	public final ArrayList<Block> BlockList = new ArrayList<Block>();

	/**
	 * コンストラクタ
	 */
	public BlockList() {
		BlockList.add(new Block_I());
		BlockList.add(new Block_T());
		BlockList.add(new Block_likeZ());
		BlockList.add(new Block_ReturnZ());
		BlockList.add(new Block_LikeL());
		BlockList.add(new Block_ReturnL());
		BlockList.add(new Block_Square());
	}

}
