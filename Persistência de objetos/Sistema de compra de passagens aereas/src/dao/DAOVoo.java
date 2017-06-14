package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Voo;

public class DAOVoo  extends DAO<Voo>{

	public Voo localizarVoo(int num){
		try{
			Query q = manager.createQuery(
					"select p from Voo p where p.numero = :x");
			q.setParameter("x", num);
			return (Voo) q.getSingleResult();
		}catch(NoResultException e){			
			return null;
		}
	}
	
	//consultas:
	public static String consultarVoosparaCidade(String cidade) {
		List<Voo> resp;
		String texto = "";
		Query query = manager.createQuery("SELECT v from Voo v where v.destino LIKE '"+cidade+"'");
		resp =  query.getResultList();
			for (Voo psg : resp) {
				texto += "\n" + psg.toString();
			}
			if (resp != null)
				return texto;	
			else
				return null;		

	}
	
}