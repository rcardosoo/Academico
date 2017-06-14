package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Poltrona;

public class DAOPoltrona  extends DAO<Poltrona>{

	public Poltrona localizarPeloNumero(int numPoltrona){
		try{
			Query q = manager.createQuery(
					"select p from Poltrona p where p.numPoltrona = :x");
			q.setParameter("x", numPoltrona);
			return (Poltrona) q.getSingleResult();
		}catch(NoResultException e){			
			return null;
		}
	}
	
	//consultas:
	
	//poltrona de um passageiro
		public static Poltrona poltronadePassageiro(int cpf) {
			Query query = manager.createQuery("SELECT p FROM Poltrona p WHERE p.passageiro.cpf = "+cpf);
			Poltrona resp =  (Poltrona) query.getSingleResult();
				if (resp != null)
					return resp;	
				else
					return null;
		}
		
		public static String consultarVagasemVoo(int numVoo) {
			Query query = manager.createQuery("SELECT COUNT(p) from Poltrona p where p.voo.numero = "+numVoo+" and p.ocupacao = FALSE");
			long resp = (long) query.getSingleResult();
				if (resp != 0)
					return "Existem "+resp+" vagas no voo "+numVoo;
				else
					return "Voo lotado";
		}
	
}