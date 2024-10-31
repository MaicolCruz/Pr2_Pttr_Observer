package co.edu.uniquindio.consecionario.empresa.Model;

import co.edu.uniquindio.consecionario.empresa.Service.Observer;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private List<Observer> observers = new ArrayList<>();
    private List<String> inventory = new ArrayList<>();

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
        inventory.add(vehicle);
        notifyObservers();
    }

    public void sellVehicle(String vehicle) {
        if (inventory.remove(vehicle)) {
            notifyObservers();
        }
    }

    public List<String> getInventory() {
        return inventory;
    }

}
