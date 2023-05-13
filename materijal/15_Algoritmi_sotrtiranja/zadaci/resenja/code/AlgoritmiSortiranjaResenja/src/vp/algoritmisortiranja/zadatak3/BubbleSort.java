package vp.algoritmisortiranja.zadatak3;

public class BubbleSort {
	public static void main(String[] args) {
		int[] niz = {21,3,5,7,2,6,1,9};
		//temp varijablu koristimo prilikom zamene mesta vrednostima
		int temp = 0;
		for (int i = 0; i < niz.length; i++) {
			for (int j = 0; j < niz.length-1; j++) {
				if(niz[j] > niz[j+1]){
					//zamena mesta vrednostima niz[i] i niz[j]
					temp = niz[j];
					niz[j] = niz[j+1];
					niz[j+1] = temp;
				}
			}
			System.out.println("Izgled niza nakon iteracije br. " + i);
			for (int x = 0; x < niz.length; x++) {
				System.out.print(niz[x]+" ");
			}
			System.out.println();	
		}
	}
}
