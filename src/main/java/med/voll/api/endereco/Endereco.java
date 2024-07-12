package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
}
