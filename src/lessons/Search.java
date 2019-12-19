package lessons;

public class Search{
	public static int seqSearchWithGuard(Comparable key, RecordNode[] r) {
		int i = r.length - 1;
		r[0].key = key;
		while((r[i].key).compareTo(key) != 0) {
			i--;
		}
		if (i>0) {
			return i;
		}else {
			return -1;
		}
	}
}