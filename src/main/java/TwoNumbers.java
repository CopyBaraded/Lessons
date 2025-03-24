public class TwoNumbers {
    public String compare(int num_1, int num_2) {
        if (num_1 > num_2) {
            return num_1 + " больше " + num_2;
        } else if (num_1 < num_2) {
            return num_1 + " меньше " + num_2;
        } else {
            return num_1 + " равно " + num_2;
        }
    }
}
