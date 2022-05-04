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
                !valor.isEmpty() ){
            if(cep.length()==8){
                if (Integer.parseInt(valor)!=0) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "O valor deve ser diferente \nde zero!");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "CEP precisa ter 8 números!");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos e \ntente novamente!");
        }
        return false; 
    }
}
