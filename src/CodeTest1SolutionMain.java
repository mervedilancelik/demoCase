public class CodeTest1SolutionMain {


    public static void main(String[] args) {

        System.out.println(validateCreditCardNumber("4518377421351212"));

    }


    public static boolean validateCreditCardNumber(String cardNumber) {
        int sumOfDigits = 0;
        boolean flag = false;  // secondary digit
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = cardNumber.charAt(i);
            digit -= '0';
            if (flag) {
                digit *= 2;

                if (digit > 9) {
                    digit -= 9;
                }
            }
            sumOfDigits += digit;
            flag = !flag;
        }

        return sumOfDigits % 10 == 0;
    }

}
