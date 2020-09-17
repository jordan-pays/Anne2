public class td1 {
	public static void main(String[] args){
		char []t = {'A','B', 'Z','B','A'};
		System.out.println("4 est-il pair " + pair(4));
		System.out.println("somme des impair en démarrant de 5 est " + sommeImpairs(5));
		System.out.println("test palyndrome ARZBA " + palAux(t,0,4));
	}

	public static boolean pair(int x){
		//prerequis n>=0
		//resultat retourne vrai ssi n est pair
		if(x==0)
			return true;
		if(x==1)
			return false;
		return pair(x-2);
	}

	public static int sommeImpairs(int n){
		//prerequis n>=1, n impair 
		if(n==1)
			return 1;
		return n+sommeImpairs(n-2);
	}

	public static boolean palAux(char []t, int i, int j){
		if(i<j){
			if(t[i]==t[j]){
				return palAux(t,i+1,j-1);
			}
			else 
				return false;
		}
		else 
			return  true;
	}

}

