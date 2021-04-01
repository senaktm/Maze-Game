import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Board1  extends JPanel implements ActionListener{
	private Map m;
	private GozlukluSirin gozluklu;
	private TembelSirin tembel;
	private Azman azman;
	private Gargamel gargamel;
	private JButton butonGozluklu,butonTembel;
	private JLabel lb;
	private int click;
	
    private Timer timer,time;
	private String Message="";
	private boolean win=false;
	private boolean finish=false;
	private Font font = new Font("Monospaced",Font.BOLD,50);
	
	private ImageIcon gozlukluImg,tembelImg;
	  static JLabel[][] labeldizi = new JLabel[11][13];
	  private static int mantarMatris[][] = new int[1][2];
	  private Image bitis,gameover,altinImage,mantarImage;
	  Random random =new Random();
	  private int [][] mantar;
	  private int [][] altin;
public Board1(){
//	setBackground(Color.DARK_GRAY);
	m=new Map();
	gozluklu=new GozlukluSirin();
	tembel=new TembelSirin();
	azman=new Azman();
	gargamel=new Gargamel();
	addKeyListener(new Al());
    setFocusable(true);
    javax.swing.Timer ti = new Timer(25, this);
    ti.start();
 butonGozluklu= new JButton("",new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\gozluklu.jpg"));
butonTembel= new JButton("",new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\uykucu.png"));
setLayout(new FlowLayout());
add(butonGozluklu);
add(butonTembel);
time=new Timer(20,this);
bitis=new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\bitis2.jpeg").getImage();
gameover=new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\gameover.jpg").getImage();
altinImage=new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\altin.png").getImage();
mantarImage=new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje1\\prolab2.1\\resimler\\mantar2.png").getImage();
mantar=new int[1][2];
altin=new int [5][2];

java.util.Timer t = new java.util.Timer();
TimerTask gorev=new TimerTask() {
Thread mantar1;
	@Override
	public void run() {
		 mantar[0][0] = random.nextInt(11)+1;
         mantar[0][1] = random.nextInt(9)+1;
    	 while(m.getMap(mantar[0][1], mantar[0][0])==0 ||(azman.getLokasyon_x()==mantar[0][0] && azman.getLokasyon_y()==mantar[0][1]) || 
         		(gargamel.getLokasyon_x()==mantar[0][0]&& gargamel.getLokasyon_y()==mantar[0][1]) || tembel.getLokasyon_x()==mantar[0][0] && tembel.getLokasyon_y()==mantar[0][1] || gozluklu.getLokasyon_x()==mantar[0][0] &&
		        		 gozluklu.getLokasyon_y()==mantar[0][1] || mantar[0][0]==7 && mantar[0][1]==12 )  {
         	 mantar[0][0] = random.nextInt(11)+1;
             mantar[0][1] = random.nextInt(9)+1;
    	 }
            try {
				mantar1.sleep(7000);
				 mantar[0][0] = 30;
                 mantar[0][1] = 30;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
             if(mantar[0][0]==tembel.getLokasyon_x()&& mantar[0][1]==tembel.getLokasyon_y() ||
          	   mantar[0][0]==gozluklu.getLokasyon_x()&& mantar[0][1]==gozluklu.getLokasyon_y()	) {
 
            	 mantar[0][0] = 30;
                 mantar[0][1] = 30;
          		         		
          	}
                  
             
         }        
        
	};
t.schedule(gorev,0,20000);

java.util.Timer t2 = new java.util.Timer();
TimerTask gorev2=new TimerTask() {
Thread altin1;
	@Override
	public void run() {
		
		for(int i=0;i<5;i++) {
			altin[i][0]=random.nextInt(11)+1;
			altin[i][1]=random.nextInt(9)+1;
			
			 while((m.getMap(altin[i][1],altin[i][0])==0) ||(azman.getLokasyon_x()==altin[i][0] && azman.getLokasyon_y()==altin[i][1]) || 
		         (gargamel.getLokasyon_x()==altin[i][0]&& gargamel.getLokasyon_y()==altin[i][1]) || altin[i][0]==mantar[0][0] && altin[i][1]==mantar[0][1] 
		        		 || tembel.getLokasyon_x()==altin[i][0] && tembel.getLokasyon_y()==altin[i][1] || gozluklu.getLokasyon_x()==altin[i][0] &&
		        		 gozluklu.getLokasyon_y()==altin[i][1] || altin[i][0]==7 && altin[i][1]==12)  {
				
							altin[i][0]=random.nextInt(11)+1;
							altin[i][1]=random.nextInt(9)+1;
							
			
			 }
		}
		
		try {
			altin1.sleep(7000);
             for(int l=0;l<5;l++) {
				
				altin[l][0]=30;
				altin[l][1]=30;
				
			}
            
            
                  
             
         }      
			
			
		 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	
  for(int i=0;i<5;i++) {
	  if(altin[i][0]==tembel.getLokasyon_x()&& altin[i][1]==tembel.getLokasyon_y() ||
         	  altin[i][0]==gozluklu.getLokasyon_x()&& altin[i][1]==gozluklu.getLokasyon_y()	) {
      
		
					altin[i][0]=30;
					altin[i][1]=30;
           
         		         		
      
  }
	 
	}
	
        
	}};
t2.schedule(gorev2,0,10000);



butonGozluklu.addMouseListener(new MouseListener() {

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override

    public void mouseReleased(MouseEvent e) {

        click = 1;

        removeAll();
      
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
});


butonTembel.addMouseListener(new MouseListener() {

    @Override
    public void mouseClicked(MouseEvent me) {
        //.setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override

    public void mouseReleased(MouseEvent e) {
        click = 0;
     
        removeAll();   
  
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
});


}

@Override
public void actionPerformed(ActionEvent e) {
	if(m.getMap(tembel.getLokasyon_y(),tembel.getLokasyon_x())==1 && (tembel.getLokasyon_y()==7 && tembel.getLokasyon_x()==12)
			|| (m.getMap(gozluklu.getLokasyon_y(),gozluklu.getLokasyon_x())==1) && (gozluklu.getLokasyon_y()==7 && gozluklu.getLokasyon_x()==12) ) {
		Message =" WÝNNER ";
		finish=true;
		win=true;
	}
	else if(tembel.PuanGoster(0)<=0 || gozluklu.PuanGoster(0)<=0)  {
		Message =" GAME OVER ";
		finish=true;
		win=false;
		
	}
    repaint();

}

int i,j;
	
	
	public void paint(Graphics g) {
		super.paint(g);
		if(!finish) {
		if (!butonGozluklu.isDisplayable()) {
			
		for(i=0;i<11;i++) {	
			for(j=0;j<13;j++) {
				if(m.getMap(i,j)==1 && !(i==7 && j==12)) {
				//	g.drawImage(m.getYer(),j*32,i*32,null);
					g.setColor(Color.GRAY);
					g.fillRect(j*32, i*32, 32, 32);
					
			
				}
				else if(m.getMap(i, j)==1 && (i==7 && j==12)) {
					//g.fillRect(j*32, i*32, 32, 32);
					g.drawImage(m.getSirine(), j*32, i*32,32,32, null);
				}
				else if(m.getMap(i,j)==0 && !(i==7 && j==12)) {
					g.drawImage(m.getDuvar(),j*32,i*32,32,32,null);
			//		g.setColor(Color.black);
				//	g.fillRect(j*32, i*32,100, 100);
					
				}
				for(int k=1;k<azman.mesafe;k++) {
					if(azman.dusmanYol[k][0]==i && azman.dusmanYol[k][1]==j) {
						g.setColor(Color.BLUE);
					    g.fillRect(j*32, i*32, 32, 32);
					}
					
				}
				for(int k=1;k<gargamel.mesafe;k++) {
					if(gargamel.dusmanYol[k][0]==i && gargamel.dusmanYol[k][1]==j) {
						g.setColor(Color.RED);
					    g.fillRect(j*32, i*32, 32, 32);
					}
					
				}
			
			}
		}
	      
	

	
		}


		
		   if (click == 1 && !butonGozluklu.isDisplayable()) {

	            g.drawImage(gozluklu.getGozlukluImg(), (gozluklu.getLokasyon_x() * 32), (gozluklu.getLokasyon_y()*32),32,32, null);
	            Font f=new Font("Monospaced",Font.BOLD,20);
	            g.setFont(f);;
	            g.drawString("SCORE", 420, 20);
	            g.drawString(Integer.toString(gozluklu.PuanGoster(0)),440,40);
		          if(tembel.PuanGoster(0)<=0) {
		        	  gargamel.setLokasyon_x(m.getGargamelX());
		        	  gargamel.setLokasyon_y(m.getGargamelY());
		        	  azman.setLokasyon_x(m.getAzmanX());
		        	  azman.setLokasyon_y(m.getAzmanY());
		        
		          }

	        }
		   if (click == 1 || click == 0 && (!butonGozluklu.isDisplayable()|| !butonTembel.isDisplayable())) {
	           if(m.isAzmanMi())
		          g.drawImage(azman.getAzmanImg(), (azman.getLokasyon_x() * 32), (azman.getLokasyon_y() * 32),32,32, null);
		        if(m.isGargamelMi())   
		          g.drawImage(gargamel.getGargamelImg(), (gargamel.getLokasyon_x() * 32), (gargamel.getLokasyon_y()*32),32,32, null);
		     
		            
		            	g.drawImage(mantarImage,mantar[0][0]*32,mantar[0][1]*32,32,32,null );
		            
		            	 if(mantar[0][0]==tembel.getLokasyon_x()&& mantar[0][1]==tembel.getLokasyon_y())
		                    {
		            		 tembel.PuanGoster(50);
		            		 mantar[0][0] = 30;
		                     mantar[0][1] = 30;
		                        
		                           if(m.getMap(mantar[0][1],mantar[0][0])==0 ) {
		                        	   mantar[0][0] = random.nextInt(11)+1;
			                           mantar[0][1] = random.nextInt(9)+1;
		                           }
		                  
		               		                    	
		                    		 
		                    	}
		            
		            	  for(int a=0;a<5;a++) {
		            		    g.drawImage(altinImage,altin[a][0]*32,altin[a][1]*32,32,32,null );
		            		   
		            	     	 if(altin[a][0]==tembel.getLokasyon_x() && altin[a][1]==tembel.getLokasyon_y()) {
		                		    	tembel.PuanGoster(5);
		                		    	altin[a][0]=30;
		                		    	altin[a][1]=30;
		                		    	if(m.getMap(altin[a][1], altin[a][0])==0 || (altin[a][0]==mantar[0][0] && altin[a][1]==mantar[0][1])) {
		                		    
		                		    			  altin[a][0] = random.nextInt(11)+1;
		         	                           altin[a][1] = random.nextInt(9)+1;
		                		    	

		                		    		
		                		    	}
		                		    }
		            		    
		            		    
		            		    

		            	  }
		            	 
		            	
		            
		
		            
		        }
		   if (click == 0 && !butonTembel.isDisplayable()) {
	            g.drawImage(tembel.getTembelImg(), (tembel.getLokasyon_x() * 32), (tembel.getLokasyon_y() * 32),32,32, null);
	            Font f=new Font("Monospaced",Font.BOLD,20);
	            g.setFont(f);;
	          g.drawString("SCORE", 420, 20);
	          g.drawString(Integer.toString(tembel.PuanGoster(0)),440,40);
	          if(tembel.PuanGoster(0)<=0) {
	        	  gargamel.setLokasyon_x(m.getGargamelX());
	        	  gargamel.setLokasyon_y(m.getGargamelY());
	        	  azman.setLokasyon_x(m.getAzmanX());
	        	  azman.setLokasyon_y(m.getAzmanY());
	        	 
	          }
	          

	        }
		
		}
		if(finish) {
			if(win) {
				g.setColor(Color.RED);
	g.setFont(font);
	g.drawString(Message, 100, 50);
	g.drawImage(bitis, 0,60,500,300,null);
	}
			if(!win) {
				g.setColor(Color.BLACK);
	g.setFont(font);
	g.drawString(Message, 100, 50);
	g.drawImage(gameover, 0,60,500,300,null);
	}
		}
		
		
		
		}
	
	public class Al extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_UP && click == 1) {
                if ((m.getMap(gozluklu.getLokasyon_y()-1, gozluklu.getLokasyon_x()))!=0 &&
                		(m.getMap(gozluklu.getLokasyon_y()-2, gozluklu.getLokasyon_x()))!=0  ) {
                    gozluklu.hareketEt(0, -1);
                    azman.enKisaYol(gozluklu.getLokasyon_y(),gozluklu.getLokasyon_x());
                    gargamel.enKisaYol(gozluklu.getLokasyon_y(),gozluklu.getLokasyon_x());
                    if(azman.getLokasyon_x()==gozluklu.getLokasyon_x() && azman.getLokasyon_y()==gozluklu.getLokasyon_y()) {
                  	  gozluklu.PuanGoster(-5);
                  	   azman.setLokasyon_x(m.getAzmanX());
                  	   azman.setLokasyon_y(m.getAzmanY());
                     }
                     else if(gargamel.getLokasyon_x()==gozluklu.getLokasyon_x() && gargamel.getLokasyon_y()==gozluklu.getLokasyon_y() ||
                    		 gargamel.mesafe<1
                    	) {
                  	   gozluklu.PuanGoster(-15);
                  	   gargamel.setLokasyon_x(m.getGargamelX());
                  	   gargamel.setLokasyon_y(m.getGargamelY());
                     }
                    for(int a=0;a<5;a++) {
                  
        		    
        		  
        		    	  if(altin[a][0]==gozluklu.getLokasyon_x() && altin[a][1]==gozluklu.getLokasyon_y() || 
        		    			  altin [a][0]==gozluklu.getLokasyon_x()&& altin[a][1]==gozluklu.getLokasyon_y()+1) {
	            		    	gozluklu.PuanGoster(5);
	            		    	altin[a][0]=30;
	            		    	altin[a][1]=30;
	            		    	if(m.getMap(altin[a][1], altin[a][0])==0 || (altin[a][0]==mantar[0][0] && altin[a][1]==mantar[0][1])) {
	            		    		
	            		    			  altin[a][0] = random.nextInt(11)+1;
			                           altin[a][1] = random.nextInt(9)+1;
	            		    	
	 
	            		    		
	            		    	}
	            		    }
                    }
              	  if(mantar[0][0]==gozluklu.getLokasyon_x()&& mantar[0][1]==gozluklu.getLokasyon_y() || 
              			  mantar[0][0]==gozluklu.getLokasyon_x() && mantar[0][1]==gozluklu.getLokasyon_y()+1
	            			 
		            		) {
		            		  tembel.PuanGoster(50);
			            		 mantar[0][0] = 30;
			                     mantar[0][1] = 30;
			                           
			                           if(m.getMap(mantar[0][1],mantar[0][0])==0 ) {
			                        	   mantar[0][0] = random.nextInt(11)+1;
				                           mantar[0][1] = random.nextInt(9)+1;
			                           }
			                  
		            	  }
                   
        		    
             
                    
                }
            }
            if (keycode == KeyEvent.VK_DOWN && click == 1) {
                if ((m.getMap(gozluklu.getLokasyon_y()+1, gozluklu.getLokasyon_x()))!=0 &&
                (m.getMap(gozluklu.getLokasyon_y()+2, gozluklu.getLokasyon_x()))!=0){
                    gozluklu.hareketEt(0, 1);
                    azman.enKisaYol(gozluklu.getLokasyon_y(),gozluklu.getLokasyon_x());
                    gargamel.enKisaYol(gozluklu.getLokasyon_y(),gozluklu.getLokasyon_x());
                    if(azman.getLokasyon_x()==gozluklu.getLokasyon_x() && azman.getLokasyon_y()==gozluklu.getLokasyon_y()) {
                    	  gozluklu.PuanGoster(-5);
                    	   azman.setLokasyon_x(m.getAzmanX());
                    	   azman.setLokasyon_y(m.getAzmanY());
                       }
                    else if(gargamel.getLokasyon_x()==gozluklu.getLokasyon_x() && gargamel.getLokasyon_y()==gozluklu.getLokasyon_y() || 	 gargamel.mesafe<1
                   	) {
                    	   
                    	   gozluklu.PuanGoster(-15);
                    	   gargamel.setLokasyon_x(m.getGargamelX());
                    	   gargamel.setLokasyon_y(m.getGargamelY());
                       }
                    for(int a=0;a<5;a++) {
                
       		    
       		  
       		    	  if(altin[a][0]==gozluklu.getLokasyon_x() && altin[a][1]==gozluklu.getLokasyon_y() || 
       		    			  altin [a][0]==gozluklu.getLokasyon_x()&& altin[a][1]==gozluklu.getLokasyon_y()-1) {
	            		    	gozluklu.PuanGoster(5);
	            		    	altin[a][0]=30;
	            		    	altin[a][1]=30;
	            		    	if(m.getMap(altin[a][1], altin[a][0])==0 || (altin[a][0]==mantar[0][0] && altin[a][1]==mantar[0][1])) {
	            		    	
	            		    			  altin[a][0] = random.nextInt(11)+1;
			                           altin[a][1] = random.nextInt(9)+1;
	            		   
	 
	            		    		
	            		    	}
	            		    }
                   }
              	  if(mantar[0][0]==gozluklu.getLokasyon_x()&& mantar[0][1]==gozluklu.getLokasyon_y() || 
              			  mantar[0][0]==gozluklu.getLokasyon_x() && mantar[0][1]==gozluklu.getLokasyon_y()-1
	            			 
		            		) {
		            		  tembel.PuanGoster(50);
			            		 mantar[0][0] = 30;
			                     mantar[0][1] = 30;
			                           
			                           if(m.getMap(mantar[0][1],mantar[0][0])==0 ) {
			                        	   mantar[0][0] = random.nextInt(11)+1;
				                           mantar[0][1] = random.nextInt(9)+1;
			                           }
			                  
		            	  }
                 
                }
            }
            if (keycode == KeyEvent.VK_LEFT && click == 1) {
                if ((m.getMap(gozluklu.getLokasyon_y() , gozluklu.getLokasyon_x()-1))!=0 &&
                		(m.getMap(gozluklu.getLokasyon_y() , gozluklu.getLokasyon_x()-2))!=0) {
                    gozluklu.hareketEt(-1, 0);
                    azman.enKisaYol(gozluklu.getLokasyon_y(),gozluklu.getLokasyon_x());
                    gargamel.enKisaYol(gozluklu.getLokasyon_y(),gozluklu.getLokasyon_x());
                    if(azman.getLokasyon_x()==gozluklu.getLokasyon_x() && azman.getLokasyon_y()==gozluklu.getLokasyon_y()) {
                    	  gozluklu.PuanGoster(-5);
                    	   azman.setLokasyon_x(m.getAzmanX());
                    	   azman.setLokasyon_y(m.getAzmanY());
                       }
                    else if(gargamel.getLokasyon_x()==gozluklu.getLokasyon_x() && gargamel.getLokasyon_y()==gozluklu.getLokasyon_y()||
                    		 gargamel.mesafe<1 
                   	) {
                    	   gozluklu.PuanGoster(-15);
                    	   gargamel.setLokasyon_x(m.getGargamelX());
                    	   gargamel.setLokasyon_y(m.getGargamelY());
                       }
                    for(int a=0;a<5;a++) {
               
       		    
       		  
       		    	  if(altin[a][0]==gozluklu.getLokasyon_x() && altin[a][1]==gozluklu.getLokasyon_y() || 
       		    			  altin [a][0]==gozluklu.getLokasyon_x()+1&& altin[a][1]==gozluklu.getLokasyon_y()) {
	            		    	gozluklu.PuanGoster(5);
	            		    	altin[a][0]=30;
	            		    	altin[a][1]=30;
	            		    	if(m.getMap(altin[a][1], altin[a][0])==0 || (altin[a][0]==mantar[0][0] && altin[a][1]==mantar[0][1])) {
	            		    		
	            		    			  altin[a][0] = random.nextInt(11)+1;
			                           altin[a][1] = random.nextInt(9)+1;
	            		    		
	 
	            		    		
	            		    	}
	            		    }
                   }
              	  if(mantar[0][0]==gozluklu.getLokasyon_x()&& mantar[0][1]==gozluklu.getLokasyon_y() || 
              			  mantar[0][0]==gozluklu.getLokasyon_x()+1 && mantar[0][1]==gozluklu.getLokasyon_y()
	            			 
		            		) {
		            		  tembel.PuanGoster(50);
			            		 mantar[0][0] = 30;
			                     mantar[0][1] = 30;
			                           
			                           if(m.getMap(mantar[0][1],mantar[0][0])==0 ) {
			                        	   mantar[0][0] = random.nextInt(11)+1;
				                           mantar[0][1] = random.nextInt(9)+1;
			                           }
			                  
		            	  }
                  
                }
            }
            if (keycode == KeyEvent.VK_RIGHT && click == 1) {
                if ((m.getMap(gozluklu.getLokasyon_y(), gozluklu.getLokasyon_x()+1))!=0 &&
                		(m.getMap(gozluklu.getLokasyon_y(), gozluklu.getLokasyon_x()+2))!=0 ) {
                    gozluklu.hareketEt(1, 0);
                    azman.enKisaYol(gozluklu.getLokasyon_y(),gozluklu.getLokasyon_x());
                    gargamel.enKisaYol(gozluklu.getLokasyon_y(),gozluklu.getLokasyon_x());
                    if(azman.getLokasyon_x()==gozluklu.getLokasyon_x() && azman.getLokasyon_y()==gozluklu.getLokasyon_y()) {
                    	  gozluklu.PuanGoster(-5);
                    	   azman.setLokasyon_x(m.getAzmanX());
                    	   azman.setLokasyon_y(m.getAzmanY());
                       }
                    else if(gargamel.getLokasyon_x()==gozluklu.getLokasyon_x() && gargamel.getLokasyon_y()==gozluklu.getLokasyon_y() ||	 gargamel.mesafe<1
                   	) {
                    	   gozluklu.PuanGoster(-15);
                    	   gargamel.setLokasyon_x(m.getGargamelX());
                    	   gargamel.setLokasyon_y(m.getGargamelY());
                       }
                    for(int a=0;a<5;a++) {
                    		  
       		    	  if(altin[a][0]==gozluklu.getLokasyon_x() && altin[a][1]==gozluklu.getLokasyon_y() || 
       		    			  altin [a][0]==gozluklu.getLokasyon_x()-1&& altin[a][1]==gozluklu.getLokasyon_y()) {
	            		    	gozluklu.PuanGoster(5);
	            		    	altin[a][0]=30;
	            		    	altin[a][1]=30;
	            		    	if(m.getMap(altin[a][1], altin[a][0])==0 || (altin[a][0]==mantar[0][0] && altin[a][1]==mantar[0][1])) {
	            		    	
	            		    			  altin[a][0] = random.nextInt(11)+1;
			                           altin[a][1] = random.nextInt(9)+1;
	            		    	
	 
	            		    		
	            		    	}
	            		    }
                   }
              	  if(mantar[0][0]==gozluklu.getLokasyon_x()&& mantar[0][1]==gozluklu.getLokasyon_y() || 
              			  mantar[0][0]==gozluklu.getLokasyon_x()-1 && mantar[0][1]==gozluklu.getLokasyon_y()
	            			 
		            		) {
		            		  tembel.PuanGoster(50);
			            		 mantar[0][0] = 30;
			                     mantar[0][1] = 30;
			                           
			                           if(m.getMap(mantar[0][1],mantar[0][0])==0 ) {
			                        	   mantar[0][0] = random.nextInt(11)+1;
				                           mantar[0][1] = random.nextInt(9)+1;
			                           }
			                  
		            	  }
                }
            }
            
            if (keycode == KeyEvent.VK_UP && click == 0) {
                if ((m.getMap(tembel.getLokasyon_y()-1, tembel.getLokasyon_x()))!=0 ) {
                    tembel.hareketEt(0, -1);
                   azman.enKisaYol(tembel.getLokasyon_y(),tembel.getLokasyon_x());
                   gargamel.enKisaYol(tembel.getLokasyon_y(),tembel.getLokasyon_x());
                   if(azman.getLokasyon_x()==tembel.getLokasyon_x() && azman.getLokasyon_y()==tembel.getLokasyon_y()) {
                	   tembel.PuanGoster(-5);
                	   azman.setLokasyon_x(m.getAzmanX());
                	   azman.setLokasyon_y(m.getAzmanY());
                   }
                   else if(gargamel.getLokasyon_x()==tembel.getLokasyon_x() && gargamel.getLokasyon_y()==tembel.getLokasyon_y() || 	 gargamel.mesafe<1
                ) {
                	   tembel.PuanGoster(-15);
                	   gargamel.setLokasyon_x(m.getGargamelX());
                	   gargamel.setLokasyon_y(m.getGargamelY());
                   }
                    
                }
            }
            if (keycode == KeyEvent.VK_DOWN && click == 0) {
                if ((m.getMap(tembel.getLokasyon_y()+1, tembel.getLokasyon_x()))!=0) {
                    tembel.hareketEt(0, 1);
                    azman.enKisaYol(tembel.getLokasyon_y(),tembel.getLokasyon_x());
                    gargamel.enKisaYol(tembel.getLokasyon_y(),tembel.getLokasyon_x());
                    if(azman.getLokasyon_x()==tembel.getLokasyon_x() && azman.getLokasyon_y()==tembel.getLokasyon_y()) {
                 	   tembel.PuanGoster(-5);
                 	   azman.setLokasyon_x(m.getAzmanX());
                 	   azman.setLokasyon_y(m.getAzmanY());
                    }
                    else if(gargamel.getLokasyon_x()==tembel.getLokasyon_x() && gargamel.getLokasyon_y()==tembel.getLokasyon_y() ||
                    		 gargamel.mesafe<1) {
                 	   tembel.PuanGoster(-15);
                 	   gargamel.setLokasyon_x(m.getGargamelX());
                 	   gargamel.setLokasyon_y(m.getGargamelY());
                    }
                   
                }
            }
            if (keycode == KeyEvent.VK_LEFT && click == 0) {
                if ((m.getMap(tembel.getLokasyon_y() , tembel.getLokasyon_x()-1))!=0 ) {
                    tembel.hareketEt(-1, 0);
                    azman.enKisaYol(tembel.getLokasyon_y(),tembel.getLokasyon_x());
                    gargamel.enKisaYol(tembel.getLokasyon_y(),tembel.getLokasyon_x());
                    if(azman.getLokasyon_x()==tembel.getLokasyon_x() && azman.getLokasyon_y()==tembel.getLokasyon_y()) {
                 	   tembel.PuanGoster(-5);
                 	   azman.setLokasyon_x(m.getAzmanX());
                 	   azman.setLokasyon_y(m.getAzmanY());
                    }
                    else if(gargamel.getLokasyon_x()==tembel.getLokasyon_x() && gargamel.getLokasyon_y()==tembel.getLokasyon_y() ||
                    		 gargamel.mesafe<1) {
                 	   tembel.PuanGoster(-15);
                 	   gargamel.setLokasyon_x(m.getGargamelX());
                 	   gargamel.setLokasyon_y(m.getGargamelY());
                    }
                  
                }
            }
            if (keycode == KeyEvent.VK_RIGHT && click == 0) {
                if ((m.getMap(tembel.getLokasyon_y(), tembel.getLokasyon_x()+1))!=0 ) {
                    tembel.hareketEt(1, 0);
                    azman.enKisaYol(tembel.getLokasyon_y(),tembel.getLokasyon_x());
                    gargamel.enKisaYol(tembel.getLokasyon_y(),tembel.getLokasyon_x());
                    if(azman.getLokasyon_x()==tembel.getLokasyon_x() && azman.getLokasyon_y()==tembel.getLokasyon_y()) {
                 	   tembel.PuanGoster(-5);
                 	   azman.setLokasyon_x(m.getAzmanX());
                 	   azman.setLokasyon_y(m.getAzmanY());
                    }
                    else if(gargamel.getLokasyon_x()==tembel.getLokasyon_x() && gargamel.getLokasyon_y()==tembel.getLokasyon_y() ||
                    		 gargamel.mesafe<1) {
                 	   tembel.PuanGoster(-15);
                 	   gargamel.setLokasyon_x(m.getGargamelX());
                 	   gargamel.setLokasyon_y(m.getGargamelY());
                    }
                   
              
                }
            }
            
            
     
        }
    }
	

	




}

