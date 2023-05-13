
/*
----++----
---++++---
--++++++--
-++++++++-
++++++++++
-++++++++-
--++++++--
---++++---
----++----
*/

public class IspisMatrice3 {
	public static void main(String[] args) {
		int n = 11;
		int h = (n - 1) / 2;//4
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + 1; j++) {
				
				if ((i >= h - j) && (i <= h + j) && (i >= j - h - 1) && (i <= (3*h) + 1 - j)) {
					System.out.print("+");
				} else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
