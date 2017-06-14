package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Passagem;

public class DAOPassagem  extends DAO<Passagem>{

	public Passagem localizarPeloNumero(int numPassagem){
		try{
			Query q = manager.createQuery(
					"select p from Passagem p where p.numPassagem = :x");
			q.setParameter("x", numPassagem);
			return (Passagem) q.getSingleResult();
		}catch(NoResultException e){			
			return null;
		}
	}
	
	//consultas:
	public static int contarPassagens(){
		int i = 0;
		Query query = manager.createQuery("SELECT p FROM Passagem p");
		 List<Passagem> resp =  query.getResultList();
			if (resp != null) {
				for (Passagem psg : resp) {
					i += 1;
				}
				return i;	
			}
			else {
				return 0;
			}
	}
}