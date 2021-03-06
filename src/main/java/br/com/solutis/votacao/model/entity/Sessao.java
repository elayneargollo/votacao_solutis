package br.com.solutis.votacao.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SESSAO")
public class Sessao {
	public static final long TEMPO_PADRAO = 3600;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@NotEmpty(message = "Descrição não pode ser vazio")
	@NotBlank(message = "Descrição é obrigatório")
	@NotNull(message = "Descrição não pode está nulo")
	@Size(min = 10, max = 255)
	private String descricao;
	
	@NotEmpty(message = "Tipo não pode ser vazio")
	@NotBlank(message = "Tipo é obrigatório")
	@NotNull(message = "Tipo não pode está nulo")
	@Size(min = 10, max = 255)
	private String tipo;
	
	private long tempoDuracao;

	public Sessao() {
	}

	public Sessao(Integer id, @NotEmpty @NotBlank @NotNull @Size(min = 10, max = 255) String descricao,
			long tempoDuracao, @Size(min = 10, max = 255) String tipo) {
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
		setTempoDuracao(tempoDuracao);
	}

	public Sessao(@NotEmpty @NotBlank @NotNull @Size(min = 10, max = 255) String descricao, long tempoDuracao,
			@Size(min = 10, max = 255) String tipo) {
		this.descricao = descricao;
		this.tipo = tipo;
		setTempoDuracao(tempoDuracao);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(long tempoDuracao) {
		if (tempoDuracao == 0)
			tempoDuracao = TEMPO_PADRAO;

		this.tempoDuracao = tempoDuracao;
	}

	@Override
	public String toString() {
		return "Sessao [id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + ", tempoDuracao=" + tempoDuracao
				+ "]";
	}
}
