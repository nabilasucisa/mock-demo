# TEST RESULT DOCUMENTATION

## CREATE CUSTOMER
### CREATE CUSTOMER SUCCESS
Code :

```` java
@Test
public void testCreateCustomer() throws ParseException {
// Given
Customer customer = new Customer();
customer.setName("Budi");
// Parse the date string
String birthDateString = "2001-01-01";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Date birthDate = sdf.parse(birthDateString);
customer.setBirth_date(birthDate);

        // When
        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        Customer createdCustomer = customerService.create(customer);


        // Then
        assertEquals("Budi", createdCustomer.getName());
        assertEquals(birthDate, createdCustomer.getBirth_date());
        Mockito.verify(customerRepository, Mockito.times(1)).save(customer);
    }
````
Output :
![img.png](img.png)

## GET ALL
### GET ALL CUSTOMER SUCCESS
Code :
````java
@Test
    public void testGetAllCustomer() throws ParseException {
        // given
        String birthDateString1 = "2001-01-01";
        String birthDateString2 = "2002-02-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate1 = sdf.parse(birthDateString1);
        Date birthDate2 = sdf.parse(birthDateString2);
        Customer customer1 = new Customer(1, "Budi", birthDate1);
        Customer customer2 = new Customer(1, "Budi", birthDate1);

        // when
        Mockito.when(customerRepository.findAll()).thenReturn(List.of(customer1, customer2));
        List<Customer> customerList = customerService.getAll();

        // then
        assertThat(!customerList.isEmpty());
        assertThat(customerList.size()==2);
    }
````
Output :
![img_1.png](img_1.png)



