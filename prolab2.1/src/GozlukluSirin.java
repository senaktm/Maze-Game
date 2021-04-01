import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class GozlukluSirin extends Oyuncu{

	private Image gozlukluImg;
	
		public GozlukluSirin() {
		super();
			gozlukluImg=new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\gozluklu.jpg").getImage();
		this.setLokasyon_x(6);
		this.setLokasyon_y(5);
	}
	
		
		@Override
		public int PuanGoster(int puan) {
			this.setSkor(this.getSkor()+puan);
			return this.getSkor();
		
						
		}

	@Override
	public void enKisaYol(int Y, int X) {

		
	}

	@Override
	public void hareketEt(int xBirim,int yBirim) {
	
	this.setLokasyon_x(2*xBirim+this.getLokasyon_x());
		this.setLokasyon_y(2*yBirim+this.getLokasyon_y());
		
	}


	

	public GozlukluSirin(int oyuncuID, String oyuncuAd, String oyuncuTur, int skor) {
		super(oyuncuID, oyuncuAd, oyuncuTur, skor);
	}

	public GozlukluSirin(int karakterID, String karakterAd, String karakterTur, Lokasyon lokasyon) {
		super(karakterID, karakterAd, karakterTur, lokasyon);
	}


	public Image getGozlukluImg() {
		return gozlukluImg;
	}


	public void setGozlukluImg(Image gozlukluImg) {
		this.gozlukluImg = gozlukluImg;
	}



	
	


}
