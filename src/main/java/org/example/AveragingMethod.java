package org.example;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 2.4. Группировка элементов и среднее значение.
 * Ваша задача найти для каждой компании средний возраст сотрудников.
 * */
public class AveragingMethod {

    public static class Company {

        private String name;

        public Company(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public static class Worker {

        private int age;

        private Company company;

        public Worker(int age, Company company) {
            this.age = age;
            this.company = company;
        }

        public int getAge() {
            return age;
        }

        public Company getCompany() {
            return company;
        }
    }

    public static Map<String, Double> averaging(List<Worker> workers) {
        return workers.stream()
                .collect(Collectors.groupingBy(a -> a.getCompany().getName(),
                        Collectors.averagingDouble(Worker :: getAge)
                        ));
    }

}
