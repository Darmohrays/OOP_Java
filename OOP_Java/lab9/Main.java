import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8" , "9", "10", "11"};
		String[] arr_3 = {"1", "2", "3"};
		List list = new List(arr);
		System.out.println(list);
		list.remove("3");
		list.remove("5");
		list.remove("3");
		System.out.println(list);
		String[] arr_2 = list.toArray();

		System.out.println(list.size());
		System.out.println(list.contains("1"));
		System.out.println(list.contains("3"));
		System.out.println(list.containsAll(arr_3));
		Iterator it = list.iterator();
		for(;it.hasNext();){
			System.out.println(it.next());
		}

		it.remove();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		list.save(list);

		List list2 = list.load();

		System.out.println(list2);

		String[] arr_for_each = list2.toArray();

		for(String a : arr_for_each){
			System.out.println(a);
		}
	}
}
