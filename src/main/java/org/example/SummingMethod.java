package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 2.3. Группировка элементов и сумма. Метод summigtInt()
 * Вам дан список пользователей, у каждого пользователя есть счет.
 * Ваша задача найти сумму баланса для каждого пользователя.
 */

public class SummingMethod {

    public static class User {

        private String name;

        private List<Bill> bills = new ArrayList<>();

        public User(String name, List<Bill> bills) {
            this.name = name;
            this.bills = bills;
        }

        public String getName() {
            return name;
        }

        public List<Bill> getBills() {
            return bills;
        }
    }

    public static class Bill {

        private int balance;

        public Bill(int balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }
    }

    private static class Pair {
        private User user;
        private Bill bill;

        public Pair(User user, Bill bill) {
            this.user = user;
            this.bill = bill;
        }

        public User getUser() {
            return user;
        }

        public Bill getBill() {
            return bill;
        }
    }

    public static Map<String, Integer> summing(List<User> users) {
        return users.stream()
                .collect(Collectors
                        .groupingBy(User :: getName,
                                Collectors.summingInt(o -> o.getBills()
                                        .stream()
                                        .mapToInt(Bill::getBalance)
                                        .sum()
                                )));


    }


}