import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Map {


	private int[][] Map = new int[11][13];

    ArrayList<Azman> azman = new ArrayList<Azman>();
    ArrayList<Gargamel> gargamel = new ArrayList<Gargamel>();
	private Image yer,duvar,sirine;
	private boolean azmanMi=false,gargamelMi=false;
	
	
	public Map() {
	
		
		
		yer = new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\yer.jpg").getImage();
	    duvar = new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\duvar2.jpg").getImage();	
	   sirine = new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\sirine.jpg").getImage();
				
		dosyaOku();
	}
	
	

	public int getMap(int i, int j){
		int harita_1_0 = Map[i][j];
		return harita_1_0;
	}

	private int azmanX,azmanY,gargamelX,gargamelY;
	public void dosyaOku() {
		 
		  try
	        {
	            BufferedReader r = new BufferedReader(new FileReader("text.txt"));
	            int i=0;

	           

	            for(String satir ; (satir = r.readLine()) != null; )
	            {
	                if(satir.startsWith("K"))
	                {
	                    String[] dizi = satir.split(":");
	                

	                    if (dizi[1].startsWith("Azman"))
	                    { azmanMi=true;
	                    if (dizi.length>=3) {
	                        if (dizi[2].startsWith("A")) {
	                        	azmanMi=true;
	                        	 azmanX = 3;
	                            azmanY = 0;
	                           
	                        } else if (dizi[2].startsWith("B")) {
	                        	azmanMi=true;
	                            azmanX = 10;
	                            azmanY = 0;
	                            
	                        } else if (dizi[2].startsWith("C")) {
	                        	azmanMi=true;
	                            azmanX = 0;
	                            azmanY = 5;
	                           
	                        } else if (dizi[2].startsWith("D")) {
	                        	azmanMi=true;
	                             azmanX = 3;
	                            azmanY = 10;
	                           
	                        }
	                    }
	                        //azman.add(new Azman(x,y));
	                    }
	                    else if (dizi[1].startsWith("Gargamel"))
	                    { gargamelMi=true;
	                    if (dizi.length>=3) {
	                        if (dizi[2].startsWith("A")) {
	                        	gargamelMi=true;
	                        	gargamelX = 3;
	                            gargamelY = 0;
	                         
	                          
	                        } else if (dizi[2].startsWith("B")) {
	                        	gargamelMi=true;
	                        	gargamelX = 10;
	                            gargamelY = 0;
	                        
	                           
	                        } else if (dizi[2].startsWith("C")) {
	                        	gargamelMi=true;
	                        	gargamelX = 0;
	                            gargamelY = 5;
	                          
	                           
	                        } else if (dizi[2].startsWith("D")) {
	                        	gargamelMi=true;
	                        	gargamelX = 3;
	                            gargamelY = 10;
	                    
	                          
	                        }
	                    }
	                       //gargamel.add(new Gargamel(gargamelX,gargamelY));
	                    }
	                  

	                }
	                else
	                {
	                    String[] dizi = satir.split("\\s+");
	                    for (int j = 0; j < dizi.length; j++)
	                    {
	                        Map[i][j] = Integer.parseInt(dizi[j]);
	                    }
	                    i++;
	                }
	            }
	        }
	        catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
		  
		
		
	}

	public int[][] getMap() {
		return Map;
	}

	public void setMap(int[][] map) {
		Map = map;
	}

	public Map(int[][] map) {
		super();
		Map = map;
	}



	public ArrayList<Azman> getAzman() {
		return azman;
	}



	public void setAzman(ArrayList<Azman> azman) {
		this.azman = azman;
	}



	public ArrayList<Gargamel> getGargamel() {
		return gargamel;
	}



	public void setGargamel(ArrayList<Gargamel> gargamel) {
		this.gargamel = gargamel;
	}



	public Image getYer() {
		return yer;
	}



	public void setYer(Image yer) {
		this.yer = yer;
	}



	public Image getDuvar() {
		return duvar;
	}



	public void setDuvar(Image duvar) {
		this.duvar = duvar;
	}



	public Image getSirine() {
		return sirine;
	}



	public void setSirine(Image sirine) {
		this.sirine = sirine;
	}





	public int getAzmanX() {
		return azmanX;
	}



	public void setAzmanX(int azmanX) {
		this.azmanX = azmanX;
	}



	public int getAzmanY() {
		return azmanY;
	}



	public void setAzmanY(int azmanY) {
		this.azmanY = azmanY;
	}



	public int getGargamelX() {
		return gargamelX;
	}



	public void setGargamelX(int gargamelX) {
		this.gargamelX = gargamelX;
	}



	public int getGargamelY() {
		return gargamelY;
	}



	public void setGargamelY(int gargamelY) {
		this.gargamelY = gargamelY;
	}



	public boolean isAzmanMi() {
		return azmanMi;
	}



	public void setAzmanMi(boolean azmanMi) {
		this.azmanMi = azmanMi;
	}



	public boolean isGargamelMi() {
		return gargamelMi;
	}



	public void setGargamelMi(boolean gargamelMi) {
		this.gargamelMi = gargamelMi;
	}
	
	

}
