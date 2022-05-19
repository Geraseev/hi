package validacao;

import javax.swing.JOptionPane;

public class validacaoBuyImovel {
    public boolean valida(
            int idimovel
        ){
        
        if (idimovel != 0) {
               return true;
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um imovel e tente novamente");
        }
        return false;
    }
}
