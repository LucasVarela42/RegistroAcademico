/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Lucas
 * Created: Jun 19, 2018
 */

/**
* Database: registroacademico
*/

CREATE DATABASE IF NOT EXISTS registroacademico;
USE registroacademico;

/**
* Estrutura da tabela curso
*/ 

CREATE TABLE curso (
  id int(11) AUTO_INCREMENT NOT NULL,
  nome varchar(50) NOT NULL,
  tipoCurso varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

/**
* Estrutura da tabela aluno
*/
CREATE TABLE aluno (
  id int(11) AUTO_INCREMENT NOT NULL,
  nome varchar(50) NOT NULL,
  telefone varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  cursoId int(11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_Aluno_Curso FOREIGN KEY (cursoId) REFERENCES curso(id)
);

/**
* Estrutura da tabela disciplina
*/ 

CREATE TABLE disciplina (
  id int(11) AUTO_INCREMENT NOT NULL,
  nome varchar(50) NOT NULL,
  cargaHoraria int(11) NOT NULL,
  sigla varchar(10) NOT NULL,
  cursoId int(11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_Disciplina_Curso FOREIGN KEY (cursoId) REFERENCES curso(id)
);

/**
* Estrutura da tabela coordenador
*/ 

CREATE TABLE coordenador (
  id int(11) AUTO_INCREMENT NOT NULL,
  nome varchar(50) NOT NULL,
  telefone varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  cursoId int(11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_Coordenador_Curso FOREIGN KEY (cursoId) REFERENCES curso(id)
);

/**
* Estrutura da tabela protocolo
*/ 

CREATE TABLE protocolo (
  id int(11) AUTO_INCREMENT NOT NULL,
  numero varchar(50) NOT NULL,
  tipoProtocolo varchar(50) NOT NULL,
  dataCadastro date NOT NULL,
  alunoId int(11) NOT NULL,
  coordenadorId int(11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_Protocolo_Aluno FOREIGN KEY (alunoId) REFERENCES aluno(id),
  CONSTRAINT FK_Protocolo_Coordenador FOREIGN KEY (coordenadorId) REFERENCES coordenador(id)
);

/**
* Estrutura da tabela segundaChamada
*/ 

CREATE TABLE segundaChamada (
  id int(11) AUTO_INCREMENT NOT NULL,
  localProva varchar(50) NOT NULL,
  turno varchar(50) NOT NULL,
  motivoProva varchar(200) NOT NULL,
  dataAvaliacao date NOT NULL,
  justificativaProfessor varchar(200) NOT NULL,
  professorAplicadorProva varchar(50) NOT NULL,
  protocoloId int(11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_SegundaChamada_Protocolo FOREIGN KEY (protocoloId) REFERENCES protocolo(id)
);

/**
* Estrutura da tabela validacao
*/ 

CREATE TABLE validacao (
  id int(11) AUTO_INCREMENT NOT NULL,
  nota decimal(10,2) NULL,
  deferido bit(1) NOT NULL,
  observacao varchar(500) NOT NULL,
  tipoValidacao varchar(50) NOT NULL,
  protocoloId int(11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_Validacao_Protocolo FOREIGN KEY (protocoloId) REFERENCES protocolo(id)
);
