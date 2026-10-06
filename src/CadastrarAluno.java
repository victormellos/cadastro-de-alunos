import java.sql.Connection;
import java.sql.PreparedStatement;

public class CadastrarAluno {

    public static void cadastrar(String nome, int idade, double nota) {

        String sql = "INSERT INTO alunos (nome, idade, nota) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setDouble(3, nota);

            stmt.executeUpdate();

            System.out.println("Aluno cadastrado com sucesso!");

        } catch (Exception e) {

            System.out.println("Erro ao cadastrar aluno:");
            e.printStackTrace();
        }
    }
}
