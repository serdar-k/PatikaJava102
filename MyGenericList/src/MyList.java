public class MyList<T> {
    private int INIT_ARRAY_SIZE = 10;
    private Object[] myArray;
    private int customArraySize;

    public MyList() {
        myArray = new Object[INIT_ARRAY_SIZE];
    }

    public MyList(int customArraySize) {
        this.customArraySize = customArraySize;
        myArray = new Object[customArraySize];
    }

    // GEREKTIGINDE ARRAY BOYUTUNU AYARLAR
    public void setArrayCapacity() {
        System.out.println("Dizi Boyutu Iki Katina Cikarildi!");
        INIT_ARRAY_SIZE *= 2;
        Object[] newMyArray = new Object[INIT_ARRAY_SIZE];
        for (int i = 0; i < myArray.length; i++) {
            newMyArray[i] = myArray[i];
        }
        myArray = newMyArray;
    }

    // YENI ELEMAN EKLEME
    public void add(T data) {
        if (this.size() >= this.getCapacity()) {
            setArrayCapacity();
        }
        myArray[size()] = data;
    }

    // ELEMAN SAYISINI VERIR
    public int size() {
        int counter = 0;
        for (Object object : myArray) {
            if (object != null) {
                counter++;
            }
        }
        return counter;
    }

    // ARRAY BOYUTUNU VERIR
    public int getCapacity() {
        return myArray.length;
    }

    // GIRILEN INDEKSTE BULUNAN ELEMANI VERIR
    public Object get(int index) {
        if (index > size() || index < 0) {
            return null;
        }
        return myArray[index];
    }

    // GIRILEN INDEKSTE BULUNAN ELEMANI SILER VE DIGER ELEMANLARI KAYDIRIR
    public void remove(int index) {
        if (index > size() || index < 0) {
            System.out.println("Gecersiz Indeks!");
        }
        myArray[index] = null;
        Object temp;
        for (int i = 0; i < myArray.length - 1; i++) {
            if (myArray[i] == null) {
                temp = myArray[i];
                myArray[i] = myArray[i + 1];
                myArray[i + 1] = temp;
            }
        }
    }

    // GIRILEN INDEKSE GIRILEN DEGERI ATAR
    public void set(int index, T data) {
        if (index > size() || index < 0) {
            System.out.println("Yanlis Index Numarasi!");
        }
        myArray[index] = data;
    }

    // ARRAY ICIN YAZDIRMA METODU
    public void toStringMyArray() {
        System.out.print("[");
        for (Object object : myArray) {
            if (object != null) {
                System.out.print(object + ", ");
            }
        }
        System.out.println("]");
    }

    // GIRILEN DEGERIN ILK INDEKSINI VERIR
    public int indexOf(T data) {
        int index = -1;
        int counter = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (data == myArray[i]) {
                System.out.println("Aranan Deger Bulundu!");
                index = i;
                counter++;
            }
            if (counter == 1) break;
        }
        return index;
    }

    // GIRILEN DEGERIN SON INDEKSINI VERIR
    public int lastIndexOf(T data) {
        int index = -1;
        int counter = 0;
        for (int i = myArray.length - 1; i >= 0; i--) {
            if (data == myArray[i]) {
                System.out.println("Aranan Deger Bulundu!");
                index = i;
                counter++;
            }
            if (counter == 1) break;
        }
        return index;
    }

    // ARRAY'IN BOS OLUP OLMADIGINI BELIRTIR
    public boolean isEmpty() {
        int counter = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] != null) {
                counter++;
            }
        }
        if (counter != 0) {
            return false;
        }
        return true;
    }

    // ARRAY ELEMANLARINI TAMAMEN SILER
    public void clear() {
        myArray = new Object[INIT_ARRAY_SIZE];
        System.out.println("Liste Temizlendi!");
    }

    // GIRILEN INDEKS ARALIGINA GORE YENI BIR ARRAY VERIR
    public MyList<T> sublist(int start, int end) {
        MyList<T> mySubArray = new MyList<>(INIT_ARRAY_SIZE);
        if (start < 0 || end >= INIT_ARRAY_SIZE) {
            System.out.println("Gecersiz Indeks Araligi!");
            System.out.println("0 Ile " + INIT_ARRAY_SIZE + " " + "Araliginda Degerler Veriniz!");
        }
        for (int i = start; i < end; i++) {
            mySubArray.add((T) myArray[i]);
        }
        return mySubArray;
    }

    // ARRAY'IN GIRILEN DEGERI ICERIP ICERMEDIGINI BELIRTIR
    public boolean contains(T data) {
        int i = 0;
        for (Object object : myArray) {
            if (object == myArray[i]) {
                return true;
            }
            i++;
        }
        return false;
    }
}