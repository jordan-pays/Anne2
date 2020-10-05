public class Baguenaudier{
	private static int nbCases;
	private static char[] tab;

	public Baguenaudier(int nb, char[] c){
		this.nbCases=nb;
		this.tab=c;
	}

	public static void main(String[] args){
		char[] c = {'.','.','.','.'};
		Baguenaudier(4,c);
		Baguenaudier.remplir(3);
	}

	public void viderAux(int n){
		if(n>0){
			if(n==1){
				this.tab[0]='.';
				System.out.println(this.toString());
			} else {
				if(n==2){
					this.tab[1]='.';
					this.vider(n-1);
					System.out.println(this.toString());
				} else{
					this.viderAux(n-2);
					this.tab[n]='.';
					System.out.println(this.toString());
					this.remplirAux(n-2);
					this.viderAux(n-1);
				}
			}
		}
	}

	public void remplirAux(int n){
		if(n==1){
			this.tab[0]='*';
			System.out.println(this.toString());
		}else {
			if (n==2) {
				this.tab[1]='*';
				this.remplirAux(n-1);
				System.out.println(this.toString());
			} else{
				this.remplir(n-1);
				this.vider(n-2);
				this.tab[n-1]='*';
				System.out.println(this.toString());
				this.tab[n]='*';
				System.out.println(this.toString());
				this.remplir(n-1);
			}
		}
	}

	public String toString(){
		String c="";
		for(int i=0; i<nbCases;i++){
			c+=tab[i];
		}
		return c;
	}

	/*
	public static void remplir(int n){
		if(n==1){
			System.out.println(0);
		}else{
			if (n==2) {
				remplir(n-1);
				System.out.println(1);
			}
			else{
				remplir(n-1);
				vider(n-2);
				System.out.println(n-1);
				System.out.println(n);
				remplir(n-1);
		}
	}
}

	public static void vider(int n){
		if(n==1){
			System.out.println(0);
		} else {
			 if (n==2){
				System.out.println(1);
				vider(n-1);
			}else  {
				vider(n-2);
				System.out.println(n);
				remplir(n-2);
				vider(n-1);
			}	
		}
	}*/
}