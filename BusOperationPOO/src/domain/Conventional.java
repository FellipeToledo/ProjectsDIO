package domain;

/**
 * @author Fellipe Toledo
 * @created 10/12/2021
 */
public class Conventional extends Bus{

    private int line;

    public Conventional() {
    }

    public int getLine() {
        return this.line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String toString() {
        return "\nInicio da operação: " + getOperationStartTime() +
                "\nNúmero de Ordem: " + this.getOrderNumber() +
                "\nConsórcio: " + this.getConsortium() +
                "\nEmpresa: " + this.getCompany() +
                "\nLinha: " + this.line +
                "\n------------------------";
    }
}
