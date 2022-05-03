package validacao;

import javax.swing.JOptionPane;

public class validacaoAddImovel {
    public boolean valida(
            String logradouro,
            String numero, 
            String bairro, 
            String cidade, 
            String estado, 
            String cep, 
            String complemento,
            String status,
            String valor){
        if (!logradouro.isEmpty() &&
                !numero.isEmpty() &&
                !bairro.isEmpty() &&
                !cidade.isEmpty() &&
                !estado.isEmpty() &&
                !cep.isEmpty() &&
                !status.isEmpty() &&
                !valor.isEmpty()){
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos e \ntente novamente!");
        }
        return false; 
    }
}
