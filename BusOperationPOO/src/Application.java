import domain.Brt;
import domain.Conventional;
import domain.Operation;
import domain.Operator;

/**
 * @author Fellipe Toledo
 * @created 10/12/2021
 */
public class Application {
    public static void main(String[] args) {

        //Novos Ônibus convencionais.
        Conventional conventional1 = new Conventional();
        conventional1.setConsortium("Intersul");
        conventional1.setCompany("Real");
        conventional1.setOrderNumber("A41558");
        conventional1.setLine(415);

        Conventional conventional2 = new Conventional();
        conventional2.setConsortium("Transcarioca");
        conventional2.setCompany("Redentor");
        conventional2.setOrderNumber("C47514");
        conventional2.setLine(397);

        Conventional conventional3 = new Conventional();
        conventional3.setConsortium("Internorte");
        conventional3.setCompany("Pavunense");
        conventional3.setOrderNumber("B28998");
        conventional3.setLine(218);

        //Novos ônibus BRTs.
        Brt brt1 = new Brt();
        brt1.setConsortium("BRT Santacruz");
        brt1.setCompany("Futuro");
        brt1.setOrderNumber("E48798D");
        brt1.setBusLane("Transoeste");

        Brt brt2 = new Brt();
        brt2.setConsortium("BRT Transcarioca");
        brt2.setCompany("Redentor");
        brt2.setOrderNumber("E47985C");
        brt2.setBusLane("Transcarioca");

        //Nova operação
        Operation operation = new Operation();
        operation.setDescription("Operação dos Coletivos na Cidade do Rio de Janeiro");

        //coloca Ônibus na garagem
        operation.getBusInGarage().add(conventional1);
        operation.getBusInGarage().add(conventional2);
        operation.getBusInGarage().add(conventional3);
        operation.getBusInGarage().add(brt1);
        operation.getBusInGarage().add(brt2);

        //Novos operadores
        Operator rioOnibus = new Operator();
        rioOnibus.setName("Rio Ônibus");

        Operator fetranspor = new Operator();
        fetranspor.setName("Fetranspor");

        //Vincula operador na operação.
        rioOnibus.linkOperatorToOperation(operation);
        fetranspor.linkOperatorToOperation((operation));

        //Coloca Ônibus em standby.
        rioOnibus.putBusIntoStandby(operation);
        rioOnibus.putBusIntoStandby(operation);
        fetranspor.putBusIntoStandby(operation);

        //Coloca Ônibus em operação.
        rioOnibus.putBusIntoOperation();
        rioOnibus.putBusIntoOperation();
        fetranspor.putBusIntoOperation();

        //Retira Ônibus de operação.
        rioOnibus.removeBusFromOperation();
        //rioOnibus.removeBusFromOperation();
        //rioOnibus.removeBusFromOperation();
        //fetranspor.removeBusFromOperation();
        //fetranspor.removeBusFromOperation();

        //desvincula operador da operação
        //rioOnibus.unlinkOperatorFromOperation(operation);
        //fetranspor.unlinkOperatorFromOperation(operation);

        //Dados da operação.
        System.out.println(operation);
    }
}
