public class TimeTester {
    public String symbol = "a";
    public int count = 100000;

    public void getStringTime(){
        String str1 = symbol;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            str1 += symbol;
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent);
    }

    public void getStringBuildTime(){
        StringBuilder str1 = new StringBuilder(symbol);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            str1.append(symbol);
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent);
    }
}