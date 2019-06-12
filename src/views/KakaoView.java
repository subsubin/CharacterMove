package views;

import javax.swing.JFrame;
import javax.swing.JLabel;

import constant.KakaoConstant;
import handlers.KakaoHandler;

import java.awt.Color;

import javax.swing.ImageIcon;

public class KakaoView extends JFrame {
	private JLabel lbl, lblScore;
	
	private int[] obstacleX = {100, 600, 400};
	private int[] obstacleY = {450, 170, 500};
	private int[] treasureX = {950, 100, 650, 300};
	private int[] treasureY = {100, 600, 400, 10};
	private JLabel[] lblObstacle, lblTreasure;	
	private int score;
	private KakaoHandler l;
	
	public KakaoView() {
		getContentPane().setBackground(Color.white);
		setLayout(null);

		//점수판
		lblScore = new JLabel("점 수  :   " + score);
		lblScore.setBounds(KakaoConstant.JLABEL_WIDTH - KakaoConstant.SCORE_JLABEL_WIDTH - 10,
				30, KakaoConstant.SCORE_JLABEL_WIDTH, KakaoConstant.SCORE_JLABEL_HEIGHT);
		
		add(lblScore);
		
		
		//Apeach
		ImageIcon icon = new ImageIcon("imgs/Apeach_front.png");
		
		lbl = new JLabel(icon);
		lbl.setBounds(0, 0,
				KakaoConstant.APEACH_JLABEL_WIDTH, KakaoConstant.APEACH_JLABEL_HEIGHT);
		
		add(lbl);
		
		
		lblObstacle = new JLabel[obstacleX.length];
		lblTreasure = new JLabel[treasureX.length];
		
		
		//bomb
		for (int i = 0; i < lblObstacle.length; i++) {
			lblObstacle[i] = new JLabel(new ImageIcon("bomb/bomb.png"));
			lblObstacle[i].setBounds(obstacleX[i], obstacleY[i],
					KakaoConstant.OT_JLABEL_WIDTH, KakaoConstant.OT_JLABEL_HEIGHT);
			
			add(lblObstacle[i]);
		}//for_lblObstacle
		

		//coin
		for (int i = 0; i < lblTreasure.length; i++) {
			lblTreasure[i] = new JLabel(new ImageIcon("coin/dollar.png"));
			lblTreasure[i].setBounds(treasureX[i], treasureY[i],
					KakaoConstant.OT_JLABEL_WIDTH, KakaoConstant.OT_JLABEL_HEIGHT);
			
			add(lblTreasure[i]);
		}//for_lblTreasure
		
		JLabel lblBg = new JLabel(new ImageIcon("imgs/bg.jpg"));
		lblBg.setBounds(0, 0, KakaoConstant.JLABEL_WIDTH, KakaoConstant.JLABEL_HEIGHT);
		add(lblBg);
		
		l = new KakaoHandler(this);
		addKeyListener(l);
		setFocusable(true);
		setTitle("어피치 KeyEvent");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 50, KakaoConstant.JLABEL_WIDTH, KakaoConstant.JLABEL_HEIGHT);
		setResizable(false);
		setVisible(true);
	}

	public JLabel getLbl() {
		return lbl;
	}

	public int[] getObstacleX() {
		return obstacleX;
	}

	public int[] getObstacleY() {
		return obstacleY;
	}

	public int[] getTreasureX() {
		return treasureX;
	}

	public int[] getTreasureY() {
		return treasureY;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public JLabel getLblScore() {
		return lblScore;
	}
	
}//class