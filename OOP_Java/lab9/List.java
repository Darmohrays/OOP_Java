import java.io.*;
import java.util.Iterator;

public class List implements Serializable {

    private String[] array = new String[10];
    private int index = 0;
    private int size = 10;

    public List(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (enoughSpace(index + 1)) {
                this.add(arr[i]);
            } else {
                array = this.increaseSize(array);
                this.add(arr[i]);
            }
        }
    }

    public void add(String elem) {
        array[index++] = elem;
    }

    public void getList() {
        for (int i = 0; i < index; i++) {
            System.out.print(array[i] + " ");
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[");
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                string.append(array[i]);
            } else string.append(array[i] + "," + " ");
        }
        string.append("]");
        return string.toString();
    }

    private boolean enoughSpace(int index) {
        return index <= size;
    }

    private String[] increaseSize(String[] array) {
        size = (size * 3) / 2 + 1;
        String[] arr_temp = new String[size];
        System.arraycopy(array, 0, arr_temp, 0, array.length);
        return arr_temp;
    }

    public void clear() {
        array = new String[size];
        index = 0;
    }

    public boolean remove(String string) {
        for (int i = 0; i < index; i++) {
            if (array[i].equals(string)) {
                String[] arr_temp = new String[size];
                System.arraycopy(array, 0, arr_temp, 0, i);
                System.arraycopy(array, i + 1, arr_temp, i, index - i);
                index--;
                array = arr_temp;
                return true;
            }
        }
        return false;
    }

    public boolean remove(int it){
        if (it <= index) {
            String[] arr_temp = new String[size];
            System.arraycopy(array, 0, arr_temp, 0, it);
            System.arraycopy(array, it + 1, arr_temp, it, index - it);
            index--;
            array = arr_temp;
            return true;
        }
        else return false;
    }
    public String[] toArray() {
        return array;
    }

    public int size() {
        return index;
    }

    public boolean contains(String string) {
        for (int i = 0; i < index; i++) {
	        if (array[i].equals(string)){
	            return true;
            }
        }
        return false;
    }

    public boolean containsAll(String[] strings){
        int found = 0;
        for (int i = 0; i < index; i++){
            for(int j = 0; j < strings.length; j++){
                if (array[i].equals(strings[j])){
                    found++;
                }
            }
        }
        return found == strings.length;
    }

    public Iterator<String> iterator() {
        return new Itr();
    }

    public void save(Object object){
        try {
            FileOutputStream fos = new FileOutputStream("temp.out");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(object);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List load(){
        List list = new List(new String[]{""});
        try {
            FileInputStream fis = new FileInputStream("temp.out");
            ObjectInputStream ois = new ObjectInputStream(fis);

            list = (List) ois.readObject();

            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    private class Itr implements Iterator<String>{
        int next;
        int current = -1;

        public boolean hasNext(){
            return next != index;
        }

        public String next(){
            int i = next;
            next = i+1;
            String[] data = List.this.array;
            return data[current = i];
        }

        public void remove(){
            List.this.remove(current);
            next = 0;
            current = -1;
        }
    }
}