package br.com.fazendoarte.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	// cria um sessão com o metod criarFabricaDeSessao
	private static final SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();
	
	//acessar externamente a Fabrica de Sessão	
	public static SessionFactory getFabricadesessoes() {
		return fabricaDeSessoes;
	}
	
	private static SessionFactory criarFabricaDeSessoes(){
		try {
			//cria um objeto com as configurações do arquivo hibernate.cfg.xml
			Configuration configuracao = new Configuration().configure();
			
			//cria um objeto RegistroServiço utilizando as propriedades da configuracao e da um build para construir			
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			
			//Controi um sessao com o registro criado
			//SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			
			return fabrica;
		} catch (Throwable ex) {
			System.err.println("A fabrica não foi criada" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
