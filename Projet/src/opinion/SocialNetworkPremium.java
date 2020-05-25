package opinion;

public class SocialNetworkPremium extends SocialNetwork implements ISocialNetworkPremium {
	
	public float reviewOpinion(String login, String password, String title, String type, String mark, String comment) {
		if (type.trim().equalsIgnoreCase("film")) {
			//Parcourir liste de film et chercher le titre
			//Parcourir reviews du film et cherche le Membre
		}
		
		if (type.trim().equalsIgnoreCase("book")) {
			//Parcourir liste de livre et chercher le titre
			//Parcourir reviews du livre et cherche le Membre
		}
	}
		
}
