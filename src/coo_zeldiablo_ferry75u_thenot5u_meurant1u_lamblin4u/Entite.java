package coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u;

public abstract class Entite {
	private int x,y;
	
	public int getX(){
		return this.x;
	}
	
	public  int getY(){
		return this.y;
	}
	
	public void setX(int x1){
		this.x = x1;
		
	}
	
	public void setY(int y1){
		this.y = y1;
	}

	public abstract void seDeplacer(int direction);
	

}
