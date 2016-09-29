import java.util.Random;
import java.util.Vector;
import edu.princeton.cs.introcs.StdRandom;
public class TestShellSortCompares {

	
	private static void TestRandomInput(int N) {
		Double[] a = new Double[N];

		for (int i = 0; i < N; i++)
			a[i] = StdRandom.uniform();

		Vector<IncrCmp> v = ShellSort.sortInstrumented(a);

		System.out.println("Sorted an array of size = " + N);
		System.out.println("Increment-size(h)   Comparisions");
		int nIncrements = v.size();
		for (int i = 0; i < nIncrements; i++) {
			int h = v.get(i).h;
			int nCmp = v.get(i).nCmp;

			System.out.printf("%10d   %12d , ", h, nCmp);
			if (nCmp > nIncrements * N)
				System.out
						.println("This can't be!!! The number of comparisions is not bounded by - Number of increments times the size of the array, i.e "
								+ nIncrements
								+ " * "
								+ N
								+ " = "
								+ nIncrements
								* N);
			else
				System.out
						.println("The number of comparisions is bounded by - Number of increments times the size of the array, i.e "
								+ nIncrements
								+ " * "
								+ N
								+ " = "
								+ nIncrements
								* N);
		}
	}

	public static void main(String[] args) {
		int N = 1000 + Math.abs(new Random().nextInt(10000));
		TestRandomInput(N);
	}
}

class IncrCmp {
	int h;
	int nCmp;

	IncrCmp(int h, int nCmp) {
		this.h = h;
		this.nCmp = nCmp;
	}
}