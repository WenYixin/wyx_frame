import com.frame.wyx.model.Customer;
import com.frame.wyx.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 34919 on 2017/7/8.
 */
public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest(){
        customerService = new CustomerService();
    }

    @Before
    public void init(){
        // TODO 初始化数据库
    }

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customers = customerService.getCustomerList();
        Assert.assertEquals(2, customers.size());
    }

    public void getCustomerTest() throws Exception {
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("name", "yixin");
        map.put("contact", "yuxuan");
        map.put("tel", "12312342345");
        boolean result = customerService.createCustomer(map);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception {
        long userId = 2;
        Map<String,String> map = new HashMap<>();
        map.put("name", "customer3");
        map.put("contact", "yuxuan");
        map.put("tel", "12312342347");

        boolean result = customerService.updateCustomer(userId, map);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws Exception {
        long userId = 2;
        boolean result = customerService.deleteCustomer(userId);
        Assert.assertTrue(result);
    }
}
