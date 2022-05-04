package javabeans;

public class Imovel {
    private int idimovel;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String valor;
    private String status;
    private String cep;
    private String complemento;

    public Imovel(String logradouro, String numero, String bairro, String cidade, String estado, String valor, String status, String cep, String complemento) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.valor = valor;
        this.status = status;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Imovel() {
        
    }

    public Imovel(int idimovel, String logradouro, String numero, String bairro, String cidade, String estado, String valor, String status, String cep, String complemento) {
        this.idimovel = idimovel;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.valor = valor;
        this.status = status;
        this.cep = cep;
        this.complemento = complemento;
    }

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
        if ("1".equals(status)){
            return "Disponivel";
        } else if ("2".equals(status)) {
            return "Não disponivel";
        }
        
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
