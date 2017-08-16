package br.com.reduce.model;

import br.com.reduce.annotation.Reduce;
import br.com.reduce.convertview.R;

import java.io.Serializable;

/**
 * Created by Gilmar on 05/06/2017.
 */

public class Aluno implements Serializable {

    private String nome;
    private String idade;
    private String telefone;

    public Aluno() {
    }


    public Aluno(String nome, String idade, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    @Reduce(value = R.id.telefone)
    public String getTelefone() {
        return telefone;
    }

    @Reduce(value = R.id.telefone)
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Reduce(value = R.id.nome)
    public String getNome() {
        return nome;
    }

    @Reduce(value = R.id.nome)
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Reduce(value = R.id.idade)
    public String getIdade() {
        return idade;
    }

    @Reduce(value = R.id.idade)
    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Idade: " + idade + " Telefone: " + telefone;
    }


}
