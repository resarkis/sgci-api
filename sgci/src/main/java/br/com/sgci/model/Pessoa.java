package br.com.sgci.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PESSOA")
public class Pessoa {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PESSOA")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "NOME")
	private String nome;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "EN_TIPO")
	private TipoPessoaEnum tipo;
	
	
	@NotNull
	@Size(max = 255)
	@Column(name = "DOCUMENTO", unique=true)
	private String documento;
	
	
	@NotNull
	@Size(max = 255)
	@Column(name = "TX_PROFISSAO")
	private String profissao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "EN_ESTADO_CIVIL")
	private EstadoCivilEnum estadoCivil;
	
	

		public Pessoa(
			@NotNull Endereco endereco, 
			@NotNull TipoPessoaEnum tipo, 
			@NotNull @Size(max = 255) String documento, 			// parametrizando construtor, não pode inicializar sem ter esses parametros
			@NotNull @Size(max = 255) String profissao, 
			@NotNull @Size(max = 255) String nome,
			@NotNull EstadoCivilEnum estadoCivil) {
		super();
		this.endereco = endereco;
		this.tipo = tipo;
		this.nome = nome;
		this.documento = documento;
		this.profissao = profissao;
		this.estadoCivil = estadoCivil;
	}
		
		
		
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}


		public TipoPessoaEnum getTipo() {
			return tipo;
		}

		public void setTipo(TipoPessoaEnum tipo) {
			this.tipo = tipo;
		}

		public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}
		
		public String getnome() {
			return nome;
		}

		public void setnome(String nome) {
			this.nome = nome;
		}
		

		public String getProfissao() {
			return profissao;
		}

		public void setProfissao(String profissao) {
			this.profissao = profissao;
		}

		public EstadoCivilEnum getEstadoCivil() {
			return estadoCivil;
		}

		public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
			this.estadoCivil = estadoCivil;
		}
	
	
}
