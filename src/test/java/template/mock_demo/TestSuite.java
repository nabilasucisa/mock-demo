package template.mock_demo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import template.mock_demo.controller.TransactionControllerTest;
import template.mock_demo.repository.CustomerRepoTest;
import template.mock_demo.service.CustomerServiceImplTest;
import template.mock_demo.service.TransactionServiceImplTest;

@Suite
@SelectClasses({
//        CustomerRepoTest.class,
        CustomerServiceImplTest.class,
        TransactionServiceImplTest.class,
        TransactionControllerTest.class
})
public class TestSuite {

}
