import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class TembelSirin extends Oyuncu{


	private Image tembelImg;
	
		public TembelSirin() {
		tembelImg=new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\uykucu.png").getImage();
		this.setLokasyon_x(6);
		this.setLokasyon_y(5);
	}
	
		
	
	
	
	
	@Override
	public int PuanGoster(int puan) {
		this.setSkor(this.getSkor()+puan);
		return this.getSkor();
	
					
	}

	@Override
	public void enKisaYol(int Y,int X) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hareketEt(int xBirim, int yBirim) {
		this.setLokasyon_x(xBirim+this.getLokasyon_x());
		this.setLokasyon_y(yBirim+this.getLokasyon_y());
		
	}






	public TembelSirin(int oyuncuID, String oyuncuAd, String oyuncuTur, int skor) {
		super(oyuncuID, oyuncuAd, oyuncuTur, skor);
		// TODO Auto-generated constructor stub
	}






	public TembelSirin(int karakterID, String karakterAd, String karakterTur, Lokasyon lokasyon) {
		super(karakterID, karakterAd, karakterTur, lokasyon);
		// TODO Auto-generated constructor stub
	}



	public Image getTembelImg() {
		return tembelImg;
	}

	public void setTembelImg(Image tembelImg) {
		this.tembelImg = tembelImg;
	}






	
	

}
