import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException; 
import java.nio.charset.Charset; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.Random; 

public class App {
    public static void imprimeDados(CadastroClientes cc, String titulo, int indices[]) {
        System.out.println(titulo + ":");
        for (int i = 0; i < indices.length; i++) {
            int ind = indices[i];
            String linha = "Cliente (" + ind + "):" + cc.get("nome", ind) + ", " + cc.get("email", ind) + ", "
                    + cc.get("sexo", ind) + ", " + cc.get("telefone", ind) + ", " + cc.get("cep", ind) + ", "
                    + cc.get("cidade", ind) + ", " + cc.get("pais", ind) + ", " + cc.get("profissao", ind) + ".";
            System.out.println(linha);
        }
        System.out.println("----------\n");
    }

    public static void carregaDadosCliente() {
        // TODO: LER O ARQUIVO CSV DO MICROSOFT TEAMS













        
        // PEGA O DIRETORIO DEFAULT
        String _dir = Paths.get("").toAbsolutePath().toString();
        // DIRETORIO DO ARQUIVO NOVO
        String fileDir = _dir + "\\" + "dados-cliente.dat";
        Path path = Paths.get(fileDir);

        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {

            // sc.useDelimiter("[,]")
        } catch (Exception e) {
            System.err.format("Erro de I/O: %s%n", e);
        }
    }

    public static void main(String args[]) {
        CadastroClientes cc = new CadastroClientes();
        cc.carregaDados();
        imprimeDados(cc, "Todos os clientes", cc.getTodosClientes());
        imprimeDados(cc, "Clientes homens", cc.getClientesPorSexo("Male"));
        imprimeDados(cc, "Clientes mulheres", cc.getClientesPorSexo("Female"));
    }
}