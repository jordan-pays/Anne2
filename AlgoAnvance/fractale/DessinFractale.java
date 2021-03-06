class DessinFractale{
    private final Turtle bob;
    
    private final static int LARGEUR = 800;
    private final static int HAUTEUR = 600;
    //taille de la fenetre graphique


    public static void main(String[] args){
	DessinFractale d = new DessinFractale(500);
	d.vonKochArbre(300, 2);
	d.close();

    }
    

    public DessinFractale(){
	bob  = new Turtle();
	Turtle.setCanvasSize(LARGEUR,HAUTEUR);//à appeler APRES création de la tortue
    }

    public DessinFractale(int v){
	//attention, plus v est grand, plus bob va lentement !
	this();
	bob.speed(v);
    }


    public void reset(){
	bob.clear();
	bob.up();
	bob.setPosition(0,0);
	bob.setDirection(0);
	bob.down();

    }

     public void close(){
	bob.exit();
    }


    public void carre(double l){
		for (int i = 0; i<4; i++){
			bob.forward(l);
			bob.right(90);
		}
    }

    public void vonKoch(double l, int n){
    	if(n==0)
    		bob.forward(l);
    	if(n>=1){
    		vonKoch(l/3, n-1);
    		bob.left(60);
    		vonKoch(l/3,n-1);
    		bob.right(120);
    		vonKoch(l/3,n-1);
    		bob.left(60);
    		vonKoch(l/3,n-1);
    	}
    }

    public void vonKochArbre(double l, int n){
    	if(n==0){
    		bob.left(90);
    		bob.forward(l);
    	}
    	if(n>=1){
    		vonKochArbre(l/2, n-1);
    		bob.left(180);
    		vonKochArbre(l/2, n-1);
    		bob.left(45);
    		vonKochArbre(l/2, n-1);
    	}
    }


}