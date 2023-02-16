import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.nio.Buffer;
//import java.;
public class ITest {

    @Test
    public void exTest(){
        int[] g = new int[]{1, 2, 3, 4};
        gg(g);
        HashMap<String,String> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        TreeMap<String ,String> treeMap = new TreeMap<String, String>();
        System.out.println(g[1]);
//        Buffer buffer = new Buffer();
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array, (s1, s2) -> {
            return s1.compareTo(s2);
        });
        System.out.println(String.join(", ", array));
//        ArrayList<Integer> arrarList1 = arrayList.clone();
//        Class.forName(com.example.entity.User);
    }

    public void gg(int[] g) {
        g[1] = 100;
        return;
    }
}
