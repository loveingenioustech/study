package collection;

import java.util.*;

public class BitSetDemo {
	public static void main(String[] s) {
		BitSetDemo bitSetDemo = new BitSetDemo();

		bitSetDemo.testSieve();

		bitSetDemo.testSieve2();
	}

	/**
	 * This program runs the Sieve of Erathostenes benchmark. It computes all
	 * primes up to 2,000,000.
	 */
	private void testSieve() {
		int n = 2000000;
		long start = System.currentTimeMillis();
		BitSet b = new BitSet(n + 1);
		int count = 0;
		int i;
		for (i = 2; i <= n; i++)
			b.set(i);
		i = 2;
		while (i * i <= n) {
			if (b.get(i)) {
				count++;
				int k = 2 * i;
				while (k <= n) {
					b.clear(k);
					k += i;
				}
			}
			i++;
		}
		while (i <= n) {
			if (b.get(i))
				count++;
			i++;
		}
		long end = System.currentTimeMillis();
		System.out.println(count + " primes");
		System.out.println((end - start) + " milliseconds");
	}

	private void testSieve2() {
		int n = 2000000;
		long start = System.currentTimeMillis();
		CustomBitSet b = new CustomBitSet(n + 1);
		int count = 0;
		int i;
		for (i = 2; i <= n; i++)
			b.set(i);
		i = 2;
		while (i * i <= n) {
			if (b.get(i)) {
				count++;
				int k = 2 * i;
				while (k <= n) {
					b.clear(k);
					k += i;
				}
			}
			i++;
		}
		while (i <= n) {
			if (b.get(i))
				count++;
			i++;
		}

		long end = System.currentTimeMillis();
		System.out.println(count + " primes");
		System.out.println((end - start) + " milliseconds");
	}

}

class CustomBitSet {
	public CustomBitSet(int N) {
		bits = new char[(N - 1) / 8 + 1];
	}

	public boolean get(int n) {
		return (bits[n >> 3] & (1 << (n & 7))) != 0;
	}

	public void set(int n) {
		bits[n >> 3] |= 1 << (n & 7);
	}

	public void clear(int n) {
		bits[n >> 3] &= ~(1 << (n & 7));
	}

	private char[] bits;
};
