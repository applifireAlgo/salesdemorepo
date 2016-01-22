package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.AddressRepository;
import mineproj.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import mineproj.app.shared.location.AddressType;
import mineproj.app.server.repository.AddressTypeRepository;
import mineproj.app.shared.location.City;
import mineproj.app.server.repository.CityRepository;
import mineproj.app.shared.location.Country;
import mineproj.app.server.repository.CountryRepository;
import mineproj.app.shared.location.State;
import mineproj.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("fdvqOyIby4XNpBwrYZLUNVVf6CZ8b6mGzACTQEUUycuprSi6Nj");
            addresstype.setAddressTypeDesc("77Y2TxHGMf9ympi9hYk3vQ0K4g4EVYiMMGvDpl4efBApqNfsIR");
            addresstype.setAddressTypeIcon("NccCQkWe6R91NdMLcfJwjL2yrbhVmVbuc1MQiy3wKp0P9bto6z");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("ftjNE9EvNPCZOkNyr9h05WH5IN4rrdEN");
            city.setCityDescription("TzYffvNEE7ZYiSfymHbu6kYwWzOEhWXfeHR4zUjg8w5sOwDk6p");
            city.setCityFlag("QxkYyEJKNJjbOwqO4EloqbhNwrnaexRL6dquRiIXjhw3NjTh73");
            city.setCityLatitude(7);
            city.setCityLongitude(2);
            city.setCityName("HxsmPCBDFsvzK8JCZG6zHWt5EjTgyTUjdVp8Sv4XrRnayPjc4w");
            Country country = new Country();
            country.setCapital("3J1Wk8U5vCTiKMgXKjBbB6vu73M8ZRm6");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(6);
            country.setCountryCode1("nTH");
            country.setCountryCode2("Y9i");
            country.setCountryFlag("ymZmyHuudREEgKvJLMqPkmt5bW80EEARD1MgvCf93Zm66S1Tic");
            country.setCountryName("sXUvhfhbDMhzghFUOf6XAjopkRgYuBOUrhgORwV5XHfvZbW9cn");
            country.setCurrencyCode("8MD");
            country.setCurrencyName("JbNBREP3g1UUemAGTQIPPH12KgRsVqQip4GnarlwX6FR0d4Tx2");
            country.setCurrencySymbol("OHA3xMniqCSviEZXFHIGOsLh604r81lp");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("zxGY87qogda0HIoi6cPRvkfkfIo7m4mRZLHBmAsiWFtEPVmrZH");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(4);
            state.setStateCode(1);
            state.setStateCodeChar2("03nTIVcHHaRHpQdEtTg2uwbsk5G1MpXk");
            state.setStateCodeChar3("5QNLTYS9xr6BrRXWBPr65AvqM6v5Xu2f");
            state.setStateDescription("jkn7V6ViblHeCu7bfLn7dtMTHIxEuGITARJETVr3JUmxKH1CU2");
            state.setStateFlag("nVGvUivb4uODWYzH8G5PTBtn3Dkkc703h8pGIAuaaCyFHsUtn0");
            state.setStateName("u2bt7XGWOBximTpjtmttjP6tBfxCI16da0lxt9zx094EylGp9T");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("k7Twv5DTbmMTe9iFER0h4ye1x7bR0cVS");
            city.setCityDescription("2OFDFGWew6EYWQgGvI3H9P4VFbFePXT5jrha14fmRA2XoS7234");
            city.setCityFlag("NWhXPjIbNY4zh7ehkKTZSaMgaCIPtyxJM8pQz8FvtsV9NPxgDq");
            city.setCityLatitude(1);
            city.setCityLongitude(5);
            city.setCityName("XcdWy34eykd9svueJ4CE57sFRfihpSNxmQhLv4HbMnfJwxFqqM");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("qmaeAHq72gNfKyAGQ2fnPY6txmWuSA3noIfizAX8vniLeBGBZ9");
            address.setAddress2("kElLgUWb31tTiEnYJ823sDq3XPvz1IifoMLoztaBXpgz5nSgBG");
            address.setAddress3("8nq5K2BZ7KQE0aHdSXKPfXWWNxrYRhxXcKAwQA2GlvwkWr9w5Z");
            address.setAddressLabel("wY8Hgsl3Ioj");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("nx4JPYO70mo6dFINT92aZvXiEf99RJkKG0MkB9KnXc8jjpa2ZT");
            address.setLongitude("kAF6pIxnOKpgsfNmJYxNGLWEo5xS3lrsyoWTbfXdd3CUfL5SQu");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("AmtVCm");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("2lJwa6qdTH0J8dPbyf2xoJwiLMANcdH5WDeWUFWBjkv7X7M3NH");
            address.setAddress2("3cQ2m8YdJLSnJg6Y1RyeHyGIBX9hIfwoLtMKFxnbO4dcptqHCA");
            address.setAddress3("rWoYE5NCdhfYKraA4yE9Wvi8UyeuiBzXOLPdLy2VgtsHeMVJta");
            address.setAddressLabel("sJZgVnBNwxI");
            address.setLatitude("xtr8zydn63S3FFHy0ovVmt3a4cNn2XQNRVZK0JtkwCIjnamfSE");
            address.setLongitude("DPCB1VwkIIgus6E7xHMiRi3tEbPoXkQyG7fp0C37mTBNUtzMau");
            address.setVersionId(1);
            address.setZipcode("XDjlfy");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
