package lesson3;

import com.hibernate.dao.SimpleDao;
import com.hibernate.dao.SimpleDaoImpl;
import com.hibernate.entity.Customer;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHibernate extends Assert {

    private Session session = null;
    private SimpleDao simpleDao = null;

    @Before
    public void test1(){
        SimpleDaoImpl simpleDaoImpl = new SimpleDaoImpl();
        session = simpleDaoImpl.createHibernateSession();
        simpleDao = simpleDaoImpl;
        assertNotNull(session);
    }

    @Test
    public void test2(){
        List<String> list = simpleDao.getListProductFromCustomer(1L);
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void test3(){
        List<String> list = simpleDao.getListCustomerFromProduct(1L);
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void test4(){
        List<String> list = simpleDao.getHistoryCost(3L,2L);
        assertNotNull(list);
        assertEquals(list.toArray(), new Object[]{190});
    }

    @Test
    public void test5(){
        try{
            Customer customer = new Customer();
            customer.setId(4L);
            customer.setName("Volodya");
            session.refresh(customer);
            simpleDao.deleteCustomer(customer);
            assertTrue(true);
        } catch (RuntimeException e) {
            assertTrue(false);
        }
    }
}
