package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
* Embeddable Attribute da JPA: Permite agrupar Campos relacionados em uma classe embutida,
* que pode ser reutilizada em várias entidades.
* Nesse Projeto, vamos usar a anotação @Embeddable, para deixar a Classe médico e Classe Endereço
* separarada, mas no banco de dados na mesma tabela;
* */
@Embeddable
//Usando o Lombok, para criar o construtor, getters e setters, EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    /*
    * Método que verifica qual dos campos serão atualizados,
    * para que nenhum campo com preenchimentos obrigatorio
    * seja atualizado com "null";
    * */
    public void atualizarInformacoes(DadosEndereco endereco) {
        if (endereco.logradouro() != null){
            this.logradouro = endereco.logradouro();
        }
        if (endereco.bairro() != null){
            this.bairro = endereco.bairro();
        }
        if (endereco.cep() != null){
            this.cep = endereco.cep();
        }
        if (endereco.cidade() != null){
            this.cidade = endereco.cidade();
        }
        if (endereco.uf() != null){
            this.uf = endereco.uf();
        }
        if (endereco.numero() != null){
            this.numero = endereco.numero();
        }
        if (endereco.complemento() != null){
            this.complemento = endereco.complemento();
        }
    }
}
