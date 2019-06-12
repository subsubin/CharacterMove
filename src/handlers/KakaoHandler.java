package handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import audios.ObstacleAudio;
import audios.TreasureAudio;
import constant.KakaoConstant;
import views.KakaoView;

public class KakaoHandler implements KeyListener {
	
	private JLabel lbl;
	private KakaoView view;
	private int[] obstacleX, obstacleY, treasureX, treasureY;
	private int[] obstartX, obendX, obstartY, obendY;
	private int[] trstartX, trendX, trstartY, trendY;
	private JLabel lblScore;
	private boolean prev_status_hit = false;
	
	public KakaoHandler(KakaoView view) {
		super();
		this.view = view;
		this.lbl = view.getLbl();
		this.lblScore = view.getLblScore();
		this.obstacleX = view.getObstacleX();
		this.obstacleY = view.getObstacleY();
		this.treasureX = view.getTreasureX();
		this.treasureY = view.getTreasureY();
		this.obstartX = new int[obstacleX.length];
		this.obendX = new int[obstacleX.length];
		this.obstartY = new int[obstacleY.length];
		this.obendY = new int[obstacleY.length];
		
		for (int i = 0; i < obendX.length; i++) {
			obstartX[i] = obstacleX[i] - KakaoConstant.APEACH_JLABEL_WIDTH;
			obendX[i] = obstacleX[i] + KakaoConstant.OT_JLABEL_WIDTH;
			obstartY[i] = obstacleY[i] - KakaoConstant.APEACH_JLABEL_HEIGHT;
			obendY[i] = obstacleY[i] + KakaoConstant.OT_JLABEL_HEIGHT;
		}//for
		
		this.trstartX = new int[treasureX.length];
		this.trendX = new int[treasureX.length];
		this.trstartY = new int[treasureY.length];
		this.trendY = new int[treasureY.length];
		
		for (int i = 0; i < trendX.length; i++) {
			trstartX[i] = treasureX[i] - KakaoConstant.APEACH_JLABEL_WIDTH;
			trendX[i] = treasureX[i] + KakaoConstant.OT_JLABEL_WIDTH;
			trstartY[i] = treasureY[i] - KakaoConstant.APEACH_JLABEL_HEIGHT;
			trendY[i] = treasureY[i] + KakaoConstant.OT_JLABEL_HEIGHT;
		}//for
	}

	@Override
	public void keyPressed(KeyEvent e) {
		boolean object_hit = false;
		
		if(view.getScore() >= 100) {
			int ok = JOptionPane.showConfirmDialog(view, "2단계로 넘어갑니다");
			if(ok==0) {
				view.setScore(0);
				view.setVisible(false);
				view.dispose();
			}
		}
		int x = lbl.getX();
		int y = lbl.getY();
		
		//장애물의 위치를 확인해서 점수 감소
		for (int i = 0; i < obstacleX.length; i++) {
			
			if(x > obstartX[i] && x < obendX[i]) {
				if(y > obstartY[i] && y < obendY[i]) {
					if(!prev_status_hit) {
						view.setScore(view.getScore() - 10);
						lblScore.setText("점 수  :   " + view.getScore());
						
						new ObstacleAudio();
						prev_status_hit = true;
					}
					object_hit = true;
				}
			}
		}//for
		
		//보물의 위치를 확인해서 점수 증가
		for (int i = 0; i < treasureX.length; i++) {
			
			if(x > trstartX[i] && x < trendX[i]) {
				if(y > trstartY[i] && y < trendY[i]) {
					if(!prev_status_hit) {
						view.setScore(view.getScore() + 10);
						lblScore.setText("점 수  :   " + view.getScore());
						
						new TreasureAudio();
						prev_status_hit = true;
					}
					object_hit = true;
				}
			}
			
		}//for
		
		prev_status_hit = object_hit;
		
		switch (e.getKeyCode()) {
		
			case KeyEvent.VK_RIGHT:
				if(x == KakaoConstant.JLABEL_WIDTH - KakaoConstant.APEACH_JLABEL_WIDTH - 40) {
					lbl.setLocation(x, y);
				}else {
					lbl.setLocation(x+5, y);
				}
				lbl.setIcon(new ImageIcon("imgs/Apeach_right.png"));
				break;
				
			case KeyEvent.VK_LEFT:
				if(x == 0) {
					lbl.setLocation(x, y);
				}else {
					lbl.setLocation(x-5, y);
				}
				lbl.setIcon(new ImageIcon("imgs/Apeach_left.png"));
				break;
				
			case KeyEvent.VK_UP:
				if(y == 0) {
					lbl.setLocation(x, y);
				}else {
					lbl.setLocation(x, y-5);
				}
				lbl.setIcon(new ImageIcon("imgs/Apeach_back.png"));
				break;
				
			case KeyEvent.VK_DOWN:
				if(y == KakaoConstant.JLABEL_HEIGHT - KakaoConstant.APEACH_JLABEL_HEIGHT - 40) {
					lbl.setLocation(x, y);
				}else {
					lbl.setLocation(x, y+5);
				}
				lbl.setIcon(new ImageIcon("imgs/Apeach_front.png"));
				break;
	
			default:
				break;
		}//switch
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}//class