
package facades;

import enitys.History;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HistoryFacade extends AbstractFacade<History> {

    @PersistenceContext(unitName = "JPTV20_webBootsShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoryFacade() {
        super(History.class);
    }

}
