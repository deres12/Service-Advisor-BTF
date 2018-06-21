package interf;

import dto.UtenteDTO;
import model.User;

public interface GestioneUtenteBE {
	
	public UtenteDTO load(String username);
	public void insert(User utente);

}
