package Main;

import java.applet.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import player.Player;

import utility.Environment;

import Block.Block;
import Block.BlockList;

import field.Field;

public class Main extends Applet implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;

	/**
	 * グラフィッククラス
	 */
	private Graphics offG;
	/**
	 * 描画イメージ
	 */
	private Image img;
	/**
	 * スレッドクラス
	 */
	private Thread th;
	/**
	 * フィールド状態
	 */
	private Field field = new Field();
	/**
	 * 環境状態
	 */
	private Environment env = new Environment();
	/**
	 * 登録されているブロックのリスト
	 */
	private BlockList blockList = new BlockList();
	/**
	 * 操作者
	 */
	private Player player = new Player();
	/**
	 * 現在のブロック
	 */
	private Block block;

	/**
	 * ブロックを選ぶための乱数
	 */
	private int ran = 1;

	/**
	 * ブラウザの縦幅
	 */
	private int BrowseHeight = 300;
	/**
	 * ブラウザの横幅
	 */
	private int BrowseWidth = 200;

	// 初期動作
	public void init() {
		// ブラウザの大きさ
		setSize(BrowseWidth, BrowseHeight);
		// レイアウト
		setLayout(null);
		// 描画イメージ
		img = createImage(field.getWidth(), field.getHeight());
		// オフスクリーンのイメージ
		offG = img.getGraphics();

		// キー入力をしたい
		addKeyListener(this);
		requestFocus();

		field.setNowBlockX(env.getDefoultPositionX());

	}

	// 同じく初期処理
	public void start() {
		if (th == null) {
			// 処理の流れを作る
			th = new Thread(this);
			th.start();
		}
	}

	// 描画処理
	public void paint(Graphics G) {
		// 画面表示処理
		// 画面を初期状態に戻す
		offG.clearRect(field.getMargin(), field.getMargin(), field.getWidth(),
				field.getHeight());

		// 背景色
		offG.setColor(Color.black);

		// 背景の開始位置、と大きさを指定
		offG.fillRect(field.getMargin(), field.getMargin(), field.getWidth(),
				field.getHeight());

		// 今回使うブロックを決定
		for (int i = 0; i < blockList.BlockList.size(); i++) {
			if (ran == i) {
				block = blockList.BlockList.get(i);
			}
		}

		// ブロックの描画
		for (int h = 0; h < block.getNowStone().length; h++) {
			for (int w = 0; w < block.getNowStone()[0].length; w++) {

				if (block.getNowStone()[h][w] != 0) {
					// ブロックの色を描写
					offG.setColor(block.getColor());
					offG.fillRect(field.getNowBlockX()
							+ (field.getStoneSize() * w), field.getNowBlockY()
							+ (field.getStoneSize() * h), field.getStoneSize(),
							field.getStoneSize());
					// ブロックの枠線を描写
					offG.setColor(Color.black);
					offG.drawRect(field.getNowBlockX()
							+ (field.getStoneSize() * w), field.getNowBlockY()
							+ (field.getStoneSize() * h), field.getStoneSize(),
							field.getStoneSize());
				}
			}
		}

		// フィールド状態を描画
		for (int h = 0; h < field.getField().length; h++) {
			for (int w = 0; w < field.getField()[0].length; w++) {

				// フィールドの周りに壁のように作ったブロックは白で表現
				offG.setColor(field.getFieldColor());
				if (field.getField()[h][w] == field.getFieldFlg()) {
					offG.fillRect((field.getStoneSize() * w),
							(field.getStoneSize() * h), field.getStoneSize(),
							field.getStoneSize());
				}

				// フィールドに積まれたブロック
				for (Block fieldBlock : blockList.BlockList) {

					if (field.getField()[h][w] == fieldBlock.getBlockID()) {
						// ブロックの色を描写
						offG.setColor(fieldBlock.getColor());
						offG.fillRect((field.getStoneSize() * w),
								(field.getStoneSize() * h),
								field.getStoneSize(), field.getStoneSize());
						// ブロックの枠線を描写
						offG.setColor(Color.black);
						offG.drawRect((field.getStoneSize() * w),
								(field.getStoneSize() * h),
								field.getStoneSize(), field.getStoneSize());
					}
				}
			}

			//得点表示
			offG.setColor(Color.white);
			offG.drawString("Score" + player.getScore(), 10, 30);

		}

		// 画面描画を開始
		G.drawImage(img, 0, 0, this);

	}

	// 一度画面を綺麗にする
	public void update(Graphics g) {
		paint(g);
	}

	// 処理開始
	public void run() {
		while (th == Thread.currentThread()) {
			try {
				Thread.sleep(env.getNowSpeed());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();

			// ブロックが下がっていく処理
			player.blockDownPosition(field);

			// ブロックが下まで行って、他のブロックにぶつかったら
			if (field.canMove(block) == false) {

				// ブロックをフィールドに残す
				for (int h = 0; h < block.getNowStone().length; h++) {
					for (int w = 0; w < block.getNowStone()[0].length; w++) {
						if (block.getNowStone()[h][w] != 0) {
							field.getField()[(field.getNowBlockY() + (h * field
									.getStoneSize())) / field.getStoneSize()][(field
									.getNowBlockX() + (w * field.getStoneSize()))
									/ field.getStoneSize()] = block
									.getBlockID();

						}
					}
				}

				// //ラインを消す処理
				// 消すラインのリストを取得
				field.shouldDisappeardLine();
				// 得点を入れる
				player.countScore(field.getDispeardLineHeight());
				// 該当ラインを消去
				if (field.getDispeardLineHeight().size() > 0) {
					field.disppeardLine();

				}

				// 上からまたブロックが降ってくる
				field.setNowBlockX(env.getDefoultPositionX());
				field.setNowBlockY(env.getDefoultPositionY());

				// ブロックを決める
				Random rnd = new Random();
				ran = rnd.nextInt(blockList.BlockList.size());
			}
		}
	}

	// キー入力から、動きを決定
	public void keyPressed(KeyEvent e) {

		// 左←が押された場合
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// 移動可能か判断
			if (field.canMove(block, e)) {
				player.blockMoveLeft(field);
			}
		}

		// 右→が押された場合
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// 移動可能か判断
			if (field.canMove(block, e)) {
				player.blockMoveRight(field);
			}
		}

		// 下↓が押された場合
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// 移動可能か判断
			if (field.canMove(block)) {
				// 加速
				player.blockMoveDown(env);
			}
		}

		// zが押された場合、回転
		else if (e.getKeyCode() == KeyEvent.VK_Z) {
			if (field.canMove(block, e)) {
				player.round(block);
			}
		}
	}

	// キーから離れた処理
	public void keyReleased(KeyEvent e) {
		env.setNowSpeed(env.getRowSpeed());
	}

	public void keyTyped(KeyEvent e) {
	}
}
