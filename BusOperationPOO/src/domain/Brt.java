package domain;

/**
 * @author Fellipe Toledo
 * @created 10/12/2021
 */
public class Brt extends Bus{

    private String busLane;

    public Brt() {
    }

    public Brt(String busLane) {
        this.busLane = busLane;
    }

    public String getBusLane() {
        return this.busLane;
    }

    public void setBusLane(String busLane) {
        this.busLane = busLane;
    }

    public String toString() {
        return "\nInicio da operação: " + getOperationStartTime() +
                "\nNumero de Ordem: " + this.getOrderNumber() +
                "\nConsórcio: " + this.getConsortium() +
                "\nEmpresa: " + this.getCompany() +
                "\nCorredor: " + this.busLane +
                "\n------------------------";
    }
}
