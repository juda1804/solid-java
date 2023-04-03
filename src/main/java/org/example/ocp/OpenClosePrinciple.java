package org.example.ocp;

public class OpenClosePrinciple {
    interface Calculator {
        default Double getSalary() {
            return 0d;
        }

        Double getTaxes();
    }

    class Employee implements Calculator {

        @Override
        public Double getSalary() {
            return null;
        }

        @Override
        public Double getTaxes() {
            return null;
        }
    }

    class Partner implements Calculator {

        @Override
        public Double getSalary() {
            return null;
        }

        @Override
        public Double getTaxes() {
            return null;
        }
    }
}
