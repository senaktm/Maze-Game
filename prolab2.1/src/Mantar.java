import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Mantar extends Obje {
private Image mantarImg;


		Random r=new Random();
		int konumX=r.nextInt(9)+1;
		int konumY=r.nextInt(11)+1;

	public Mantar()  {
		

mantarImg=new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\mantar.jpg").getImage();
this.setX(konumX);
this.setY(konumY);


	

}


	


	@Override
	void objeOlustur() {
			
	
	}



	public Image getMantarImg() {
		return mantarImg;
	}



	public void setMantarImg(Image mantarImg) {
		this.mantarImg = mantarImg;
	}






	public Random getR() {
		return r;
	}


	public void setR(Random r) {
		this.r = r;
	}


	public int getKonumX() {
		return konumX;
	}


	public void setKonumX(int konumX) {
		this.konumX = konumX;
	}


	public int getKonumY() {
		return konumY;
	}


	public void setKonumY(int konumY) {
		this.konumY = konumY;
	}

	
}
