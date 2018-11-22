import java.util.ArrayList;

/**
 *
 * @authors leonardo, matheus e rafael
 */
public class ArquivosClient {

    public static void main(String[] args) {

        Cliente c1 = new Cliente(1);
        Cliente c2 = new Cliente(2);
        Cliente c3 = new Cliente(3);

        ArrayList<Cliente> clientes = new ArrayList<>();

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        for (int i = 0; i < 10; i++) {
            for (Cliente cliente : clientes) {
                
                cliente.realizaRequisicao();
            }
        }
    }
}
