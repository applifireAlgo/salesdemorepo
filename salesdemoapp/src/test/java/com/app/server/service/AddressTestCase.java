package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
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
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

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
            addresstype.setAddressType("SBN2rU11KSJlb44Y9gUI4gx2M3oFqu2OXrK5z2aNat65s35911");
            addresstype.setAddressTypeDesc("vM2DHkiTB7MFgCwFguMXJfgMrGkWTliAVYaZvT4Apmgydot7OP");
            addresstype.setAddressTypeIcon("K0WrBv2RrRJ7Kl5E03VVLMwSRTkfHti5tKEDXGlOHHS2jgChaO");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("SdQjq4zlzTcLYijzdAhu6NEFy2u3fW2L");
            city.setCityDescription("hSwkAdwlEUkfeCygQfRpy0JQqGQJdvOfXq6F7EwLW1YCYsQquD");
            city.setCityFlag("91K1IzEXG4ZRtGUwfg5B2GIjU4gIH9DpEmyTedTJe4OdPHendp");
            city.setCityLatitude(0);
            city.setCityLongitude(7);
            city.setCityName("Ug4T8RSrmOQ0FV1ecAmjK97Thwrje9vwbHz1vQnXnnznlPJ6f8");
            Country country = new Country();
            country.setCapital("O327U29Ox2sq6SURDS9Sjo7e8oMi4J1X");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(1);
            country.setCountryCode1("biM");
            country.setCountryCode2("Zd5");
            country.setCountryFlag("VrVbJdtuUPzEwJMEEqjkhfVtyaimzQVe8p022R7UqWDn8EQdMC");
            country.setCountryName("uvEeYictwVUB0EyycTkfw73GMcfuI3Y8z4SGumSbzuqg3uivxZ");
            country.setCurrencyCode("ets");
            country.setCurrencyName("8sbaHJA8oQg4PmYnIsRtLjSn6bq0WWSHtgvg4Ibf0iQaY64jAQ");
            country.setCurrencySymbol("cm8GTKXoGRKXjxA5t4e8LvNV1Ppjlrjz");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("OTmLGacEFUuY1qfd9qDjtOfyBjhchEWAMzNQOoVwPEOVjbvzsv");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(3);
            state.setStateCode(0);
            state.setStateCodeChar2("BkAFSSCag9EeDCAiljXPtMyGIhVQWrDU");
            state.setStateCodeChar3("gBnbOpvMG3fkME2hX6mFpa18qOSieajB");
            state.setStateDescription("lFbzoyGZM4tFn9hU9OcBfhwu7YQuuSFgoU7F8FzqgUYWJmD3d3");
            state.setStateFlag("uFAYGLTdHAikDAL9K9IFSJwdVmJW5RUgv6DnjgkVLRiQOBdiqV");
            state.setStateName("tqBoc9LhdS9MAg4r9wNgjeg6eJg9gxiHklesjCdTMvDRnZoWmm");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("Ut3Mzh1gB0WvXK2C0plaOO1zp9yuXASA");
            city.setCityDescription("jMkEfSFNBjt2ybqMH5thU9cO2AYDEMd4KXUCVDLn2YAr0Hf0Mq");
            city.setCityFlag("8uWGVFLY8bRsYWhNexU8Vhea3kgs7bNnM6u1aYoe1lOCa7AHF3");
            city.setCityLatitude(11);
            city.setCityLongitude(2);
            city.setCityName("S5NBeR5SlUJrChgUlGHf3OXBrOJPlTHnLMSdNsQoO2z4RZGHdd");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("ClAlhRd4Rq9F3Da1lojjKFuem52xeo7J2ThLaFzftFNr3BjqQf");
            address.setAddress2("uEJbaVzksmxuRGxsxYemx2b5ehPQKOZAWacAEvlgE04NStUPoI");
            address.setAddress3("hIXTH75v906TaC5qEiCZ72wyS9bwcYKgRIul82Rzrv6U0UD6sw");
            address.setAddressLabel("Ol25Wpm8sS0");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("9EK8d7hWeTGtzzvLtK8e08mO3bXwFZI8ZT3DQkqqCI6M3y9V3g");
            address.setLongitude("ktvvQ1A0zaq9dhdJPdaouYhqGLTOjCGKdnSCDP42BVqVuz9QGE");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("aSlDK9");
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
            address.setAddress1("gGUawB24WMcaZwI797173zvpIgcKim1lflNRrr17UKeDjXyEQ8");
            address.setAddress2("kqeUlpSRDgZ0aljKTBctRu5jBc4swNQwfm2v5NMX1bdcLUgtTu");
            address.setAddress3("FcxRX8wQfsX2uKcSgYC4qteqbNmkPh6td6vkPvWrZy77szANXg");
            address.setAddressLabel("kXVJaSvaAqK");
            address.setLatitude("SmBZPDUFTl6eRyE8FOxovBE76zbTHz2ZpSMQQd3v269AWsBiTE");
            address.setLongitude("4vWetGPoHrRvWf2lZ7LXPhlSyUYX3Oq8lRgKBrwhDHSIHyr8Ts");
            address.setVersionId(1);
            address.setZipcode("KEgDCN");
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
