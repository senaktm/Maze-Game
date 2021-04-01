import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Altin extends Obje {

	private Image altinImg;



	public Altin() {
		altinImg=new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\altin.jpg").getImage();
}

	
	
	@Override
	void objeOlustur() {
		
		int altinAdet;
		Random r=new Random();
		int konumX=r.nextInt(11);
		int konumY=r.nextInt(13);
		
this.setX(konumX);
this.setY(konumY);
		
	
	}



	public Image getAltinImg() {
		return altinImg;
	}



	public void setAltinImg(Image altinImg) {
		this.altinImg = altinImg;
	}



}
