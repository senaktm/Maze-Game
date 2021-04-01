import java.awt.Image;

import javax.swing.ImageIcon;

public class Gargamel extends Dusman {

	private Image gargamelImg;
	private Map m=new Map();
	public Gargamel() {
		gargamelImg=new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\gargamel.png").getImage();
		   this.setLokasyon_x(m.getGargamelX());
		     this.setLokasyon_y(m.getGargamelY());
	}
	
	public Image getGargamelImg() {
		return gargamelImg;
	}

	public void setGargamelImg(Image gargamelImg) {
		this.gargamelImg = gargamelImg;
	}

	

    private int[][] harita = new int[11][13];
    public int[][] dusmanYol = new int[100][2];
    int mesafe = 0;
    @Override
	  public void enKisaYol(int oyuncuY,int oyuncuX) {
		  if(m.isGargamelMi()) {
		  int komsuSayisi=1;
	        for (int v = 0; v < komsuSayisi; v++) {

	          
				for (int i = 0; i < 11; i++) {
	                for (int j = 0; j < 13; j++) {
	                    harita[i][j] = Integer.MAX_VALUE;
	                }
	            }
	            harita[this.getLokasyon_y()][this.getLokasyon_x()] = 0;
	            dusmanYolBul(this.getLokasyon_y() - 1, this.getLokasyon_x(), 1);
	            dusmanYolBul(this.getLokasyon_y() + 1, this.getLokasyon_x(), 1);
	            dusmanYolBul(this.getLokasyon_y(), this.getLokasyon_x() - 1, 1);
	            dusmanYolBul(this.getLokasyon_y(), this.getLokasyon_x() + 1, 1);
	            

	          

	            mesafe = harita[oyuncuY][oyuncuX];
	            dusmanYol[mesafe][0] =oyuncuY;
	            dusmanYol[mesafe][1] = oyuncuX;
	            for (int i = mesafe - 1; i > -1; i--) {
	                if (harita[dusmanYol[i + 1][0] + 1][dusmanYol[i + 1][1]] == i) {
	                    dusmanYol[i][0] = dusmanYol[i + 1][0] + 1;
	                    dusmanYol[i][1] = dusmanYol[i + 1][1];
	                }  else if (harita[dusmanYol[i + 1][0]][dusmanYol[i + 1][1] - 1] == i) {
	                    dusmanYol[i][0] = dusmanYol[i + 1][0];
	                    dusmanYol[i][1] = dusmanYol[i + 1][1] - 1;
	               
	                } else if (harita[dusmanYol[i + 1][0]][dusmanYol[i + 1][1] + 1] == i) {
	                    dusmanYol[i][0] = dusmanYol[i + 1][0];
	                    dusmanYol[i][1] = dusmanYol[i + 1][1] + 1;
	                } else if (harita[dusmanYol[i + 1][0] - 1][dusmanYol[i + 1][1]] == i) {
	                    dusmanYol[i][0] = dusmanYol[i + 1][0] - 1;
	                    dusmanYol[i][1] = dusmanYol[i + 1][1];
	                }
	            }

	        //  this.hareketEt(dusmanYol[1][1] - getLokasyon_x(),dusmanYol[1][0] - getLokasyon_y() );
	          if(m.getMap(this.getLokasyon_y(), this.getLokasyon_x())!=0 || m.getMap(this.getLokasyon_y()+1, this.getLokasyon_x())!=0
	        		  || m.getMap(this.getLokasyon_y()-1, this.getLokasyon_x())!=0 || m.getMap(this.getLokasyon_y(), this.getLokasyon_x()+1)!=0 ||
	        		  m.getMap(this.getLokasyon_y(), this.getLokasyon_x()-1)!=0 || m.getMap(this.getLokasyon_y()+2, this.getLokasyon_x())!=0
	        		  || m.getMap(this.getLokasyon_y()-2, this.getLokasyon_x())!=0 || m.getMap(this.getLokasyon_y(), this.getLokasyon_x()-2)!=0||
	        		  m.getMap(this.getLokasyon_y(), this.getLokasyon_x()+2)!=0) {
	        	
	        	  this.hareketEt(dusmanYol[1][1] - getLokasyon_x(),dusmanYol[1][0] - getLokasyon_y() );
	        
	          }
	 
	        }

	    }}

	    public void dusmanYolBul(int oyuncuY, int oyuncuX, int mesafe) {
	        if ((oyuncuX > -1) && (oyuncuY > -1) && (oyuncuY < 10) && (oyuncuX < 12)) {
	          
	                if ((m.getMap(oyuncuY, oyuncuX)!=0) && (harita[oyuncuY][oyuncuX] > mesafe)) {
	                    harita[oyuncuY][oyuncuX] = mesafe-1;
	                    dusmanYolBul(oyuncuY - 1, oyuncuX, mesafe + 1);
	                    dusmanYolBul(oyuncuY + 1, oyuncuX, mesafe + 1);
	                    dusmanYolBul(oyuncuY, oyuncuX - 1, mesafe + 1);
	                    dusmanYolBul(oyuncuY, oyuncuX + 1, mesafe + 1);
	                }

	            
	        

	        }

	
	
	    }
	
/*
	@Override
	public void enKisaYol() {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void hareketEt(int xBirim, int yBirim) {
		this.setLokasyon_x(xBirim+this.getLokasyon_x());
		this.setLokasyon_y(yBirim+this.getLokasyon_y());
	}


	public Gargamel(int karakterID, String karakterAd, String karakterTur, Lokasyon lokasyon) {
		super(karakterID, karakterAd, karakterTur, lokasyon);
		// TODO Auto-generated constructor stub
	}

	public Gargamel(int dusmanID, String dusmanAd, String dusmanTur) {
		super(dusmanID, dusmanAd, dusmanTur);
		// TODO Auto-generated constructor stub
	}
	
	

}
