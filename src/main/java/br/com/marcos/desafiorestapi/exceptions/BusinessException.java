package br.com.marcos.desafiorestapi.exceptions;

public class BusinessException {

    public static class CustomerAlreadyExistsException extends RuntimeException {
        public CustomerAlreadyExistsException() {
            super("Customer already exists.");
        }
    }

    public static class CustomerNotFoundException extends RuntimeException {
        public CustomerNotFoundException() {
            super("Customer not found.");
        }
    }

    public static class CityNotFoundException extends RuntimeException {
        public CityNotFoundException() {
            super("City not found.");
        }
    }

    public static class CityAlreadyExistsException extends RuntimeException {
        public CityAlreadyExistsException() {
            super("City already exists.");
        }
    }

    public static class InvalidCityIdException extends RuntimeException {
        public InvalidCityIdException() {
            super("City id not found.");
        }
    }
    public static class InvalidStateException extends RuntimeException {
        public InvalidStateException() {
            super("State not found.");
        }
    }

    public static class InvalidYearOrAgeException extends RuntimeException {
        public InvalidYearOrAgeException() {super("The age informed is not corresponding with birth date.");}
    }


}
