package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Fellipe Toledo
 * @created 10/12/2021
 */
public class Operation {

    private String description;
    private final LocalDateTime initialTime = LocalDateTime.now();
    private Set<Operator> linkedOperators = new LinkedHashSet();
    private Set<Bus> busInGarage = new LinkedHashSet();

    public Operation() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getInitialTime() {
        return this.initialTime;
    }

    public Set<Operator> getLinkedOperators() {
        return this.linkedOperators;
    }

    public void setLinkedOperators(Set<Operator> linkedOperators) {
        this.linkedOperators = linkedOperators;
    }

    public Set<Bus> getBusInGarage() {
        return this.busInGarage;
    }

    public void setBusInGarage(Set<Bus> busInGarage) {
        this.busInGarage = busInGarage;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Operation operation = (Operation)o;
            return Objects.equals(this.description, operation.description) &&
                    Objects.equals(this.initialTime, operation.initialTime) &&
                    Objects.equals(this.linkedOperators, operation.linkedOperators) &&
                    Objects.equals(this.busInGarage, operation.busInGarage);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.description, this.initialTime, this.linkedOperators, this.busInGarage);
    }

    public String toString() {

        return "Dados da Operação:\nDescrição: " +
                this.description +
                "\nData e hora de inicio: " +
                this.initialTime.format(DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss")) +
                "\nOperadores vinculados:\n " +
                this.linkedOperators +
                "\n-------------------------";
    }
}
