class Complex {
    double real;
    double imaginary;

    Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    int current;

    void inc(){
        current++;
    }
    int getCurrent(){
        return current;
    }
}

