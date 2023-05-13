/*
-----+-----
----+++----
---+++++---
--+++++++--
-+++++++++-
+++++++++++
*/

public class IspisMatrice1 {
	public static void main(String[] args) {
		int n = 11;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				if((j <= n-1+i) && (j >= n-1-i)) {
					System.out.print("+");
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
