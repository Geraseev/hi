package validacao;

import javax.swing.JOptionPane;

public class validacaoCadastro {
    public boolean valida(
            String usuario,
            String senha,
            String repetirSenha,
            String telefone){
        
        if (!usuario.isEmpty()
                && !senha.isEmpty()
                && !repetirSenha.isEmpty()
                && !telefone.isEmpty()) {
            if (usuario.length() > 4) {
                if (telefone.length() == 14) {
                    if (senha.length() > 3) {
                        if (senha.equals(repetirSenha)) {
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "As senhas devem ser iguais!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha deve ter ao menos 4 caracteres");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Telefone deve ter 11 caracteres");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario deve ter ao menos 5 caracteres");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos e tente novamente");
        }
        return false;
    }
}
