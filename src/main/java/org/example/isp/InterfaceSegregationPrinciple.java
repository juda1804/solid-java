package org.example.isp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class InterfaceSegregationPrinciple {

    //Never do this
    interface DoAnything {
        void printFax();

        void takePhone();
    }

    class Fax implements DoAnything {

        @Override
        public void printFax() {
            System.out.println("Printing");
        }

        @Override
        public void takePhone() {
            throw new NotImplementedException();
        }
    }


    interface FaxServices {
        void printFax();
    }

    interface PhoneServices {
        void takePhone();
    }

    class Secretary implements FaxServices, PhoneServices {

        @Override
        public void printFax() {

        }

        @Override
        public void takePhone() {

        }
    }
}
