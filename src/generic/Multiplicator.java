package generic;

/**
 * Class to work with
 */
class Multiplicator {

    public static void main(String[] args) {
        Folder theFolder = new Folder<>();
        theFolder.put((new String("Multipli class")));
        Folder[] arrFolders = multiply(theFolder, 3);
        for (int i = 0; i < arrFolders.length; i++) {
            System.out.println((String)arrFolders[i].get());
        }
    }

    public static <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {
        // Method to implement

        Folder<T>[] arrFolders = new Folder[arraySize];
        for (int i = 0; i < arraySize; i++) {
            Folder<T> newInstance = new Folder<>();
            newInstance.put(folder.get().copy());
            arrFolders[i] = newInstance;
        }
        return arrFolders;
    }

}


// Don't change the code below
interface Copy<T> {
    T copy();
}

class Folder<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}
