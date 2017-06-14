package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Passageiro;

public class DAOPassageiro  extends DAO<Passageiro>{

	public Passageiro localizarPeloCpf(int cpf){
		try{
			Query q = manager.createQuery(
					"select p from Passageiro p where p.cpf = :x");
			q.setParameter("x", cpf);
			return (Passageiro) q.getSingleResult();
		}catch(NoResultException e){			
			return null;
		}
	}
	
	//consultas:
	//Lista de passageiro por voo
			public static String consultarPassageirosdoVoo(int numVoo) {
				String texto = "";
				Query query = manager.createQuery("SELECT p.passageiro FROM Passagem p WHERE p.voo.numero = "+numVoo);
				List<Passageiro> resp =  query.getResultList();
					for (Passageiro psg : resp) {
						texto += "\n" + psg;
					}
					if (resp != null)
						return texto;	
					else
						return null;
			}
			
			public static String consultarPassageirosSemVoo() {
				Query query = manager.createQuery("SELECT p FROM Passageiro p WHERE p.passagens IS EMPTY");
				List<Passageiro> resultados = query.getResultList();
				String s = "Listagem de passageiros sem voo";
				if (resultados.isEmpty())
					s += "\nnenhum";
				for(Passageiro p : resultados)
					s += "\n --> " + p;
				return s;
				
			}
	
}