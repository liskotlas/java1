package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    public static String format(String phone) throws Exception {
        String phoneNumber = "";
        for (char c : phone.toCharArray()) {
            if (Character.isDigit(c)) {
                phoneNumber += c;
            }
        }
        if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
            throw new Exception("Неверное количество символов");
        }
        if (phoneNumber.substring(0, 1).equals("8") || phoneNumber.substring(0, 1).equals("7")) {
            phoneNumber = phoneNumber.substring(1);
        }
        return phoneNumber = "+7(" + phoneNumber.substring(0, 3) + ")" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
    }

    public static void main(String[] args) {
        try {
            System.out.println(format("8921dff246++387 8"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

