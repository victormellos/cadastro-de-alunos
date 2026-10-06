import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListarAlunos {

    public static void main(String[] args) {

        String sql = "SELECT id, nome, idade, nota FROM alunos";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("===== LISTA DE ALUNOS =====");

            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                double nota = rs.getDouble("nota");

                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Idade: " + idade);
                System.out.println("Nota: " + nota);
                System.out.println("---------------------------");
            }

        } catch (Exception e) {

            System.out.println("Erro ao listar alunos:");
            e.printStackTrace();
        }
    }
}
