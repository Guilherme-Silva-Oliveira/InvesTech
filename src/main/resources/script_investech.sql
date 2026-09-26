DROP DATABASE IF EXISTS investech;
CREATE DATABASE IF NOT EXISTS investech;
USE investech;

CREATE TABLE usuario (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    status_usuario TINYINT(1) NOT NULL,
    data_cadastro DATE
);
-- USUÁRIO RESPECTIVO À ALGUMA CONTA DE INVESTIMENTO

CREATE TABLE conta (
	id INT PRIMARY KEY AUTO_INCREMENT,
    status_conta TINYINT(1) NOT NULL,
    moeda_base VARCHAR(50) NOT NULL,
    centro_operacao VARCHAR(255) NOT NULL,
    data_criacao DATE,
    usuario_id INT,
    CONSTRAINT fk_usuario_conta FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
-- CONTA ASSOCIADA AO USUÁRIO

CREATE TABLE carteira (
	id INT PRIMARY KEY AUTO_INCREMENT,
    saldo_disponivel DECIMAL(10,2) NOT NULL,
    saldo_investido DECIMAL(10,2) NOT NULL,
    saldo_total DECIMAL(10,2) NOT NULL,
    lucro_registrado DECIMAL(10,2) NOT NULL,
    prejuizo_registrado DECIMAL(10,2) NOT NULL,
    data_atualizacao DATETIME,
    conta_id INT,
    CONSTRAINT fk_carteira_conta FOREIGN KEY (conta_id) REFERENCES conta(id)
);
-- RESPONSÁVEL POR CONTER CENTRALIZAÇÃO DE VALORES E LUCROS/PREJUÍZOS DA CONTA

CREATE TABLE ativo (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    tipo_ativo VARCHAR(50) NOT NULL,
    preco_atual DECIMAL(10,2) NOT NULL,
    status_ativo TINYINT(1) NOT NULL
);
-- RESPONSÁVEL POR ARMAZENAR PRINCIPAIS CRIPTOMOEDAS EM OBSERVAÇÃO PARA INVESTIMENTO

CREATE TABLE parametro (
	id INT PRIMARY KEY AUTO_INCREMENT,
    status_parametro TINYINT(1) NOT NULL,
    quantidade_maxima DECIMAL(10,2) NOT NULL,
    preco_minimo DECIMAL(10,2) NOT NULL,
    preco_maximo DECIMAL(10,2) NOT NULL,
    data_enviado DATETIME,
    ativo_nome VARCHAR(255) NOT NULL,
    tipo_ativo VARCHAR(50) NOT NULL,
    carteira_id INT,
    CONSTRAINT fk_parametro_carteira FOREIGN KEY (carteira_id) REFERENCES carteira(id)
);
-- RESPONSÁVEL POR ENVIAR PARÂMETROS DE INVESTIMENTO AO PYTHON

CREATE TABLE posicao (
	id INT PRIMARY KEY AUTO_INCREMENT,
    quantidade DECIMAL(10,2) NOT NULL,
    valor_montante DECIMAL(10,2) NOT NULL,
    ultima_compra DATETIME,
    carteira_id INT,
    ativo_id INT,
    CONSTRAINT fk_posicao_ativo FOREIGN KEY (ativo_id) REFERENCES ativo(id), 
    CONSTRAINT fk_posicao_carteira FOREIGN KEY (carteira_id) REFERENCES carteira(id)
);
-- REPRESENTA A RELAÇÃO ENTRE O ATIVO E A CARTEIRA, COMO QUANTIDADE DE CRIPTOS NA CONTA E VALOR RESPECTIVO

CREATE TABLE movimentacao (
	id INT PRIMARY KEY AUTO_INCREMENT,
    valor DECIMAL(10,2) NOT NULL,
    status_movimentacao VARCHAR(50) NOT NULL,
    descricao VARCHAR(255),
    data_movimentacao DATETIME,
    carteira_id INT,
    CONSTRAINT fk_movimentacao_carteira FOREIGN KEY (carteira_id) REFERENCES carteira(id)
);
-- REPRESENTA MOVIMENTAÇÃO EXTERNA DA CONTA (ENTRADA OU SAÍDA DE VALOR NA CARTEIRA)

CREATE TABLE proposta (
	id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_ativo VARCHAR(50) NOT NULL,
    nome_ativo VARCHAR(255) NOT NULL,
    tipo_operacao VARCHAR(50) NOT NULL,
    quantidade_sugerida DECIMAL(10,2) NOT NULL,
    valor_suregido DECIMAL(10,2) NOT NULL,
    descricao_proposta VARCHAR(255),
    nivel_risco INT,
    data_proposta DATETIME,
    data_retorno DATETIME,
    status_proposta VARCHAR(255) NOT NULL
);
-- RESPONSÁVEL POR SER OBJETO QUE CARREGARÁ RETORNO DO PYTHON PÓS ANÁLISE

CREATE TABLE decisao (
	id INT PRIMARY KEY AUTO_INCREMENT,
    proposta_id INT,
    carteira_id INT,
    retorno_proposta VARCHAR(255) NOT NULL,
    motivo VARCHAR(255),
    valor_aprovado DECIMAL(10,2),
    quantidade_aprovada DECIMAL(10,2),
    tipo_operacao VARCHAR(50),
    data_decisao DATETIME,
	CONSTRAINT fk_decisao_proposta FOREIGN KEY (proposta_id) REFERENCES proposta(id),
	CONSTRAINT fk_decisao_carteira FOREIGN KEY (carteira_id) REFERENCES carteira(id)
);
-- REPRESENTA A AÇÃO DE COMPRA/VENDA QUE SERÁ RETORNADA AO PYTHON

CREATE TABLE operacao (
	id INT PRIMARY KEY AUTO_INCREMENT,
    carteira_id INT,
    proposta_id INT,
    decisao_id INT,
    ativo_id INT,
    tipo_operacao VARCHAR(255) NOT NULL,
    quantidade DECIMAL(10,2) NOT NULL,
    valor_operacao DECIMAL(10,2) NOT NULL,
    status_operacao VARCHAR(50) NOT NULL,
    data_operacao DATETIME NOT NULL,
    CONSTRAINT fk_operacao_carteira FOREIGN KEY (carteira_id) REFERENCES carteira(id),
	CONSTRAINT fk_operacao_proposta FOREIGN KEY (proposta_id) REFERENCES proposta(id),
    CONSTRAINT fk_operacao_decisao FOREIGN KEY (decisao_id) REFERENCES decisao(id),
	CONSTRAINT fk_operacao_ativo FOREIGN KEY (ativo_id) REFERENCES ativo(id)
);