package com.company;

class DessinFractale{
    private final Turtle bob;

    private final static int LARGEUR = 800;
    private final static int HAUTEUR = 600;
    //taille de la fenetre graphique


    public static void main(String[] args){
        DessinFractale d = new DessinFractale(500);
        d.triForce(300, 2);
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

    public void vonKochArbre(double l, int n, int alpha){
        bob.forward(l);
        if(n>0){
            bob.left(alpha);
            vonKochArbre(l/2,n-1,alpha);
            bob.right(alpha);
            vonKochArbre(l/2,n-1,alpha);
            bob.right(alpha);
            vonKochArbre(l/2,n-1,alpha);
            bob.left(alpha);
        }
        bob.backward(l);
    }

    public void triForce(int l, int n){
        if(n==0){
            for(int i=0;i<3; i++) {
                bob.forward(l);
                bob.left(120);
            }
        }
        else{
            triForce(l/2,n-1);
            bob.forward(l/2);
            triForce(l/2,n-1);
            bob.left(120);
            bob.forward(l/2);
            bob.right(120);
            triForce(l/2,n-1);
            bob.left(60);
            bob.backward(l/2);
            bob.right(60);
        }
    }

    public void dragon(double l, int n, int angle) {
        if(n == 0) {
            bob.forward(l);
        } else {
            dragon(l, n-1, 90);
            bob.left(angle);
            dragon(l, n-1, -90);
        }
    }
}