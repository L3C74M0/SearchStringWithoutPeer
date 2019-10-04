package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Search {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();

		int casos = Integer.parseInt(line);

		for (int i = 0; i < casos; i++) {
			line = br.readLine();
			String[] nombres = line.split(" ");
			System.out.println(buscarNombreSinPar(nombres));
		}
	}

	protected static String buscarNombreSinPar(String[] nombres) {
		int pos = tienePar(nombres, 0, nombres.length - 1);

		return nombres[pos];
	}

	protected static int tienePar(String[] nombres, int i, int j) {
		int izq;
		int der;
		int m = (i + j) / 2;

		if (i == j) {
			boolean is = false;
			if ((i + 1) <= nombres.length - 1) {
				if (nombres[i].equalsIgnoreCase(nombres[i + 1])) {
					is = true;
				}
			}

			if ((i - 1) >= 0) {
				if (nombres[i].equalsIgnoreCase(nombres[i - 1])) {
					is = true;
				}
			}

			if (is == false) {
				return i;
			} else {
				return -1;
			}
		} else {
			izq = tienePar(nombres, i, m);

			der = tienePar(nombres, m + 1, j);

			if (izq == -1 && der == -1) {
				return -1;
			} else {
				if (izq != -1) {
					return izq;
				} else {
					return der;
				}
			}
		}
	}
}