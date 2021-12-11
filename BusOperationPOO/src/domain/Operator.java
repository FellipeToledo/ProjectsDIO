package domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * @author Fellipe Toledo
 * @created 10/12/2021
 */
public class Operator {

    private String name;
    private Set<Bus> standByBus = new LinkedHashSet();
    private Set<Bus> busInOperation = new LinkedHashSet();

    public Operator() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Bus> getStandByBus() {
        return this.standByBus;
    }

    public void setStandByBus(Set<Bus> standByBus) {
        this.standByBus = standByBus;
    }

    public Set<Bus> getBusInOperation() {
        return this.busInOperation;
    }

    public void setBusInOperation(Set<Bus> busInOperation) {
        this.busInOperation = busInOperation;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Operator operator = (Operator)o;
            return Objects.equals(this.name, operator.name) &&
                    Objects.equals(this.standByBus, operator.standByBus) &&
                    Objects.equals(this.busInOperation, operator.busInOperation);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.name, this.standByBus, this.busInOperation);
    }

    public String toString() {
        return "\nDados do operador:\nNome: " +
                this.name + "\nÔnibus em standby: " +
                this.standByBus + "\nÔnibus em operação: " +
                this.busInOperation + "\n-------------------------\n";
    }

    public void linkOperatorToOperation(Operation linkOperator) {
        linkOperator.getLinkedOperators().add(this);
    }

    public void unlinkOperatorFromOperation(Operation linkOperator){
        Optional<Operator> operator = linkOperator.getLinkedOperators().stream().findFirst();
        if (operator.isPresent()){
            linkOperator.getLinkedOperators().remove(operator.get());
        }else {
            System.out.println("Não há operadores vinculados");
        }
    }

    public void putBusIntoStandby(Operation busInto) {
        Optional<Bus> bus = busInto.getBusInGarage().stream().findFirst();
        if (bus.isPresent()) {
            this.standByBus.add((Bus)bus.get());
            busInto.getBusInGarage().remove(bus.get());
        } else {
            System.out.println("Não há Ônibus na Garagem!!");
        }

    }

    public void putBusIntoOperation() {
        Optional<Bus> bus = this.standByBus.stream().findFirst();
        if (bus.isPresent()) {
            this.busInOperation.add((Bus)bus.get());
            ((Bus)bus.get()).setOperationStartTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
            this.standByBus.remove(bus.get());

        } else {
            System.out.println("Não há ônibus em standby!!");
        }

    }

    public void removeBusFromOperation() {
        Optional<Bus> bus = this.busInOperation.stream().findFirst();
        if (bus.isPresent()) {
            this.standByBus.add((Bus)bus.get());
            this.busInOperation.remove(bus.get());
        } else {
            System.out.println("Não há ônibus em operação!!");
        }

    }
}
