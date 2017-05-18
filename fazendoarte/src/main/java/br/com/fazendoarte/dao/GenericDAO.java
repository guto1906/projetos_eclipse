package br.com.fazendoarte.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.fazendoarte.util.HibernateUtil;

public class GenericDAO<Entidade> {// classe generica <QualqueNome>
	// atributo para armazenar a classe da Entidade
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		// abrir uma sessao com a fabrica de sessao
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		// declarar objeto do tipo transaction do org.hibernate
		Transaction transacao = null;
		try {
			// com a sessao aberta iniciar uma transacao
			transacao = sessao.beginTransaction();
			// salvar a sessao passando a entidade
			sessao.save(entidade);
			// encerrar a transacao
			transacao.commit();

		} catch (RuntimeException erro) {
			// caso de erro verifico se transacao foi aberta
			// caso foi aberta desfaço a transação
			if (transacao != null) {
				transacao.rollback();
			}
			// propago o erro para as camadas superiore
			throw erro;
		} finally {
			// independente do resultado a sessão sera fechada
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		// abrir uma sessao com a fabrica de sessao
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		try {
			// Criar um objeto Criteria do hibernate.org utilizando a sessao
			// aberta e classe da Entidade
			Criteria consulta = sessao.createCriteria(classe);
			// Armazenar o resultada da consulta em uma lista
			List<Entidade> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException erro) {
			// propago o erro para as camadas superiore
			throw erro;
		} finally {
			// independente do resultado a sessão sera fechada
			sessao.close();
		}

	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {
		// abrir uma sessao com a fabrica de sessao
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		try {
			// Criar um objeto Criteria do hibernate.org utilizando a sessao
			// aberta e classe da Entidade
			Criteria consulta = sessao.createCriteria(classe);
			//Adicionar uma restrição na consulta
			consulta.add(Restrictions.idEq(codigo));
			// Armazenar o resultada da consulta em uma objeto do tipo Entidade
			//utilizar o metodo uniqueResult e o casting do tipo Entidade
			Entidade resultado = (Entidade)consulta.uniqueResult();
			return resultado;

		} catch (RuntimeException erro) {
			// propago o erro para as camadas superiore
			throw erro;
		} finally {
			// independente do resultado a sessão sera fechada
			sessao.close();
		}

	}
	
	public void excluir(Entidade entidade) {
		// abrir uma sessao com a fabrica de sessao
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		// declarar objeto do tipo transaction do org.hibernate
		Transaction transacao = null;
		try {
			// com a sessao aberta iniciar uma transacao
			transacao = sessao.beginTransaction();
			// salvar a sessao passando a entidade
			sessao.delete(entidade);
			// encerrar a transacao
			transacao.commit();

		} catch (RuntimeException erro) {
			// caso de erro verifico se transacao foi aberta
			// caso foi aberta desfaço a transação
			if (transacao != null) {
				transacao.rollback();
			}
			// propago o erro para as camadas superiore
			throw erro;
		} finally {
			// independente do resultado a sessão sera fechada
			sessao.close();
		}

	}
	
	public void editar(Entidade entidade) {
		// abrir uma sessao com a fabrica de sessao
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		// declarar objeto do tipo transaction do org.hibernate
		Transaction transacao = null;
		try {
			// com a sessao aberta iniciar uma transacao
			transacao = sessao.beginTransaction();
			// salvar a sessao passando a entidade
			sessao.update(entidade);
			// encerrar a transacao
			transacao.commit();

		} catch (RuntimeException erro) {
			// caso de erro verifico se transacao foi aberta
			// caso foi aberta desfaço a transação
			if (transacao != null) {
				transacao.rollback();
			}
			// propago o erro para as camadas superiore
			throw erro;
		} finally {
			// independente do resultado a sessão sera fechada
			sessao.close();
		}

	}
	
	public void merge(Entidade entidade) {
		// abrir uma sessao com a fabrica de sessao
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		// declarar objeto do tipo transaction do org.hibernate
		Transaction transacao = null;
		try {
			// com a sessao aberta iniciar uma transacao
			transacao = sessao.beginTransaction();
			// salvar a sessao passando a entidade
			sessao.merge(entidade);
			// encerrar a transacao
			transacao.commit();

		} catch (RuntimeException erro) {
			// caso de erro verifico se transacao foi aberta
			// caso foi aberta desfaço a transação
			if (transacao != null) {
				transacao.rollback();
			}
			// propago o erro para as camadas superiore
			throw erro;
		} finally {
			// independente do resultado a sessão sera fechada
			sessao.close();
		}

	}
}
