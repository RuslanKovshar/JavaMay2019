Переписать данный код правильно

class First {
int value = 3;
void addFive() { value += 5; System.out.println("first "); }
}
class Second extends First {
int value = 2;
void addFive () { value += 5; System.out.println("second "); }
}
public class Main {
public static void main(String[] args) {
First f = new Second();
f.addFive();
System.out.println(f.value);
}
}