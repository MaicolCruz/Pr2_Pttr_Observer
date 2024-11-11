package co.edu.uniquindio.consecionario.empresa.Model;

import co.edu.uniquindio.consecionario.empresa.Service.Observer;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private List<Observer> observers = new ArrayList<>();
    private List<String> inventory = new ArrayList<>();
    public Dealer() {
        initializeTestData();
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void addVehicle(String vehicle) {
        if (!inventory.contains(vehicle)) {
            inventory.add(vehicle);
            notifyObservers();
            System.out.println("Vehículo añadido: " + vehicle);
        } else {
            System.out.println("El vehículo ya está en el inventario: " + vehicle);
        }
    }

    public boolean sellVehicle(String vehicle) {
        boolean sold = inventory.remove(vehicle);
        if (sold) {
            notifyObservers();
            System.out.println("Vehículo vendido: " + vehicle);
        } else {
            System.out.println("No se pudo vender el vehículo. No está en el inventario: " + vehicle);
        }
        return sold;
    }

    public List<String> getInventory() {
        return inventory;
    }

    private void initializeTestData() {
        inventory.add("Camaro RX");
        inventory.add("Mercedes Benz");
        inventory.add("Ferrari");
        inventory.add("Renault 4");
        inventory.add("Chevrolet Onix Activ");
        inventory.add("Toyota Corolla");
        inventory.add("Honda Civic");
        inventory.add("Ford Mustang");
        inventory.add("Nissan Altima");
        inventory.add("BMW X5");
        notifyObservers();
    }

}
