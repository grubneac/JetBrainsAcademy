package interfaceExample;

public class AsciiCharSequence implements CharSequence{

    byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (end == start) {
            return new AsciiCharSequence(null);
        }
        byte[] newarr = new byte[end - start];
        for (int i = start; i < end; i++) {
            newarr[i] = this.array[i];
        }
        return new AsciiCharSequence(newarr);
    }

    @Override
    public String toString() {
        String result = "";
        if (array.length > 0) {
            for (byte bt : array) {
                result += (char) bt;
            }
        }
        return result;
    }
}
