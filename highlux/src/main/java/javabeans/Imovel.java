package javabeans;

/**
 *
 * @author lgera
 */
public class Imovel {
    private int idendereco;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private int idimovel;
    private String valor;
    private String status;
    private int endereco_idendereco;
    
    

    public int getIdimovel() {
        return idimovel;
    }

    public void setIdimovel(int idimovel) {
        this.idimovel = idimovel;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEndereco_idendereco() {
        return endereco_idendereco;
    }

    public void setEndereco_idendereco(int endereco_idendereco) {
        this.endereco_idendereco = endereco_idendereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    private String cep;
    private String complemento;

    public int getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(int idendereco) {
        this.idendereco = idendereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
}
