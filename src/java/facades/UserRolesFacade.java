
package facades;

import enitys.User;
import enitys.UserRoles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserRolesFacade extends AbstractFacade<UserRoles> {

    @PersistenceContext(unitName = "JPTV20_webBootsShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserRolesFacade() {
        super(UserRoles.class);
    }

    public boolean isRole(String roleName, User user) {
        List<String> userRoleNameList = em.createQuery("SELECT ur.role.roleName FROM UserRoles ur WHERE ur.user = :user")
                .setParameter("user", user)
                .getResultList();
        return userRoleNameList.contains(roleName);
    }
    
    public String getTopRole(User user) {
        List<String> listRoleNames = em.createQuery("SELECT ur.role.roleName FROM UserRoles ur WHERE ur.user = :user")
                .setParameter("user", user)
                .getResultList();
        if(listRoleNames.contains("ADMINISTRATOR"))return "ADMINISTRATOR";
        if(listRoleNames.contains("MANAGER"))return "MANAGER";
        if(listRoleNames.contains("READER"))return "READER";
        return null;
    }
}
