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
		int middle = (nombres.length - 2) / 2;
		if (middle % 2 != 0) {
			middle += 1;
		}

		return tienePar(nombres, 0, nombres.length - 2, middle);
	}

	public static String tienePar(String[] nombres, int low, int high, int middle) {
		if (high - low == 1) {
			if (nombres[low].equals(nombres[high])) {
				return nombres[high + 1];
			} else {
				return nombres[low];
			}
		} else {
			if (nombres[middle].equals(nombres[middle + 1])) {
				low = middle;
				middle = ((high - low) / 2) + low;
				if (!((high - middle) == 1) && middle % 2 != 0) {
					middle += 1;
				}
				return tienePar(nombres, low, high, middle);
			} else {
				high = middle - 1;
				middle = ((high - low) / 2) + low;
				if (middle % 2 != 0) {
					middle += 1;
				}
				return tienePar(nombres, low, high, middle);
			}
		}
	}
}