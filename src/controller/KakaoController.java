package controller;

import audios.BGMusic;
import handlers.KakaoHandler;
import views.KakaoView;

public class KakaoController {
	
	public static void main(String[] args) {
	
		KakaoView view = new KakaoView();
		KakaoHandler l = new KakaoHandler(view);
		
		new BGMusic();
	
	}//main
}//class