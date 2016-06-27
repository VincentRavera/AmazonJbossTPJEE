package fr.treeptik.amazon.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class NavBarManagedBean {
	
	public String goToUtilisateur(){
		return "/user/user-list";
	}
	public String goToCommandes(){
		return "/commande/commande-list";
	}
	public String goToArticle(){
		return "/article/article-list";
	}
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/user/user-list?faces-redirect=true";
	}

}
