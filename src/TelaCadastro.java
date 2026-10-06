import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class TelaCadastro {

    public static void main(String[] args) {

        JFrame janela = new JFrame("Cadastro de Alunos");

        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();

        JLabel labelIdade = new JLabel("Idade:");
        JTextField campoIdade = new JTextField();

        JLabel labelNota = new JLabel("Nota:");
        JTextField campoNota = new JTextField();

        JButton botaoCadastrar = new JButton("CADASTRAR");

        labelNome.setBounds(30, 30, 80, 25);
        campoNome.setBounds(100, 30, 200, 25);

        labelIdade.setBounds(30, 70, 80, 25);
        campoIdade.setBounds(100, 70, 200, 25);

        labelNota.setBounds(30, 110, 80, 25);
        campoNota.setBounds(100, 110, 200, 25);

        botaoCadastrar.setBounds(100, 160, 120, 30);

        janela.add(labelNome);
        janela.add(campoNome);

        janela.add(labelIdade);
        janela.add(campoIdade);

        janela.add(labelNota);
        janela.add(campoNota);

        janela.add(botaoCadastrar);

        // Ação do botão Cadastrar
        botaoCadastrar.addActionListener(e -> {

            try {
                String nome = campoNome.getText();
                int idade = Integer.parseInt(campoIdade.getText());

                // Aceita nota com ponto ou vírgula
                double nota = Double.parseDouble(
                    campoNota.getText().replace(",", ".")
                );

                CadastrarAluno.cadastrar(nome, idade, nota);

                JOptionPane.showMessageDialog(
                    janela,
                    "Aluno cadastrado com sucesso!"
                );

                campoNome.setText("");
                campoIdade.setText("");
                campoNota.setText("");

            } catch (NumberFormatException erro) {

                JOptionPane.showMessageDialog(
                    janela,
                    "Digite idade e nota corretamente."
                );
            }
        });

        janela.setSize(360, 250);
        janela.setLayout(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
}
