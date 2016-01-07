package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
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
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("UlvP7gmPm40oSN1qwREFHDFSfxnkVFv9NMO3HxXb9Pfdild4ab");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("9H");
            language.setAlpha3("P35");
            language.setAlpha4("kuyR");
            language.setAlpha4parentid(8);
            language.setLanguage("WeDf7vkdEX212oI1gQBFh5EQDgQHgyijTVv3UvQ3Egnl00fIVk");
            language.setLanguageDescription("QbXgyJHIzyuZT4q95tlR4PiXNSXjGbllvw4BdSRxy0C5HybmGn");
            language.setLanguageIcon("es4LSGjGs9Vcfyro9RQvGyGB73wGUhGJvzlDf5ZODRqsvXzq5L");
            language.setLanguageType("N1KCfgyjAyEWN8oNUhUrzz5G1y7pHX81");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("tla4SeIL9uZQj6mltCjPVG6CMirwLIJCtxNptjCNmE3NDq2X6N");
            timezone.setCountry("IfcwIfhJUHiMdqKgEsnA2Q19zZN1yei5cKFOonAQiNJ269VslX");
            timezone.setGmtLabel("MEa2Aft9WDoWJMmAH1Q8y1xzbUCVmjJ36Vu12YDttDw2NGmKVO");
            timezone.setTimeZoneLabel("WDAsgkQIYcOjWTKsQQ5QwYnNEJrNjhlcmkdDuSn8Ro3MSJrz6A");
            timezone.setUtcdifference(3);
            Title title = new Title();
            title.setTitles("dLMyumpjnZjONAmn4gnnhdpQ7f1vb1jjurGgdevoLtw39bHzYJ");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(49);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("DSF3dL2Po7RUBNQRdXu4bSlibpXuRHB8WpCdqPR2Vo1dEgkgCV");
            corecontacts.setFirstName("9NqUs2g6oSm3tDG4ixB7AxHLjlYR8uhyM9CD41tTHkfFuauhWZ");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("EypZ8AID8PhQNLTmLnuN5p9vV0x5u0EICwhqez0LHcAkZ4LFUw");
            corecontacts.setMiddleName("nqu48dkesLuKXKdJGEMgr40oJzLibYpxscoU5aukneUMjeUyfz");
            corecontacts.setNativeFirstName("oPKqXifMmxbRgj9iw7S1Rw9HZ0u31LgOt9Uw0NIGIVkuLVD53J");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("wZejMcPPJvY2OFzfKBF2Yjx9e0FKKHGYtq66cuDoas0LOaCqKp");
            corecontacts.setNativeMiddleName("sTwpsNqWCamTOcClUQd8viprabHo5VO1l649ebTzMDxTnqsRzR");
            corecontacts.setNativeTitle("acb6aS6cRgExvpsoF8dc7hB7XjqYdIVsqkAZvjMgQ2BLpBkLFn");
            corecontacts.setPhoneNumber("XEs6cu20GXDri1GEDwU1");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Qqe");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("lgb2HBML4hnLHs57GTkQ5uh3wAjwVevUi0wLYGfUuiORWTEAqg");
            communicationgroup.setCommGroupName("veFfwFIrfotv5avlXgX5rphiMUp4l9bYsyHVktwTYc4IA4py1W");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("Bn7HrKzZnm1pBirEhqJ87oSK3vQqbPEIANhiOniLhcYI8QNQ7l");
            communicationtype.setCommTypeName("5g9l0Fb5YV4ZCaBmggM16EFZJeooRLN0JqY08e5CNVCHkA4BJo");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("c5h");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("F72bUCSr9m6EFGfEVw9XTFjAnX2bGDyH6hLVIgkNiwxZDcH43t");
            address.setAddress2("neCe0RYt1yEvXxfLvmKjBkUaUf3DDH1QoboHzQ5tKxuxsMMpLW");
            address.setAddress3("1jaNomwR2x9mdKLAwnaUfLL5HOPeMja8Dhg4MmaPLgmtSFmjxT");
            address.setAddressLabel("TCkWta8qXK1");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("DvMPqDGf2y8BcE972puNnzsXVxSzxXpt0IzmmaDFLsCgS6KyOv");
            addresstype.setAddressTypeDesc("Og8gj7ynKVBQcXBQF0ErgqquJjCpqyi03GWBgh9NZz3Xs5PVUO");
            addresstype.setAddressTypeIcon("XiUCeZWD7myQHcY8AHTD5PMwDA0ukoAhDlDLzkRUusP4NK7EWp");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("auTA2H65zQDLewg4hdftNfdtetzjuleb");
            city.setCityDescription("J45HJbwFyqzNkK6EtCGPhqb3lzZ5CTwzKvOgAad1jDkz2HNwPL");
            city.setCityFlag("MYiUyk317ZYfY4SzF9Wu9kIHhZbHioNBkFeM539VS9wKzvlkFj");
            city.setCityLatitude(11);
            city.setCityLongitude(6);
            city.setCityName("3YKH1Vl32N4v1FCtBF2tvjDNpPb8hi7j2lhhzyXCXp1rdQV4y6");
            Country country = new Country();
            country.setCapital("tGJVVqQTWUlfMT1eYaMbEAslthxhzSRf");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(10);
            country.setCountryCode1("x0D");
            country.setCountryCode2("SeK");
            country.setCountryFlag("XgaWpd6L0W08fkcsd9ecWknx63dswMQnrlqpEKrK66sIrkH5Jo");
            country.setCountryName("Nqa3Wlmf2HEpC6B63rymfSuyiG6iYKhPVqIPGCqQdMyJAnikpN");
            country.setCurrencyCode("UNG");
            country.setCurrencyName("SlVg3RTezfeP7aZ1tjiK8Wm4g359rYxupvC3v5jxNejQHtrwmZ");
            country.setCurrencySymbol("uMCIkOlBn4ohZKdPxffzXFHipeasbj7m");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("121wBDFnWpHiAmxixksspFfL50zZQuPX5goCvLn7iAhuSOUr2s");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("rwDZNVhaJ6cwc4mssbtIYObDlSdPEX5k");
            state.setStateCodeChar3("FuDqDsVVVCpDrALzjvXZnzCIY8evjQYL");
            state.setStateDescription("lUOwVLiaZFA1gCHjSAdKMj0i3PuKFlEMYgvx68rPSlqCzV441Y");
            state.setStateFlag("y7JFD3NB1LQ3GJL6MqTmDwEojE4HZEn54LeTldlMRm6ruxX8Yp");
            state.setStateName("YkK5qkfMXnTzysbyUwIXGJUvTw7F3Lnkk64GsprRYAo79HKMgP");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("gerfsVCjBV33RxS0YIzGEn7lsqAuCo1G");
            city.setCityDescription("ySBN4Na5G2FDw8uzoygbTeNIopFB120yc5hFg90Yvu6Hff0NS4");
            city.setCityFlag("CdFa0yjmbXZ3pz6SC9nSwHtGcZjgEpbFHUMPt6gUW0s51QEgK9");
            city.setCityLatitude(8);
            city.setCityLongitude(6);
            city.setCityName("0H0PMQFYHTaW8FhjRaELCm6E8fvsmhazkfzd9wEIrznyvK3Fz2");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("XfXAbXdACjHqI2gQ7Utb2oyKzm0kAgn0ND1uTnPYuEy85Dg2Ox");
            address.setAddress2("HiBvUuswljO2nT3oNRpWq6IRTBW1Vk6AJoCscOKpFyJTgundSb");
            address.setAddress3("uCwlPpomoKWSNodXlGNcM9wcNmd8LRCuMyrtX9ww23rz7zyNXl");
            address.setAddressLabel("KsObG7ArRtb");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Cg3OHVJKbjsnFrCng2H6o7iR6AxgMaSPzbTslIe2cQo2fsstH6");
            address.setLongitude("MNYK57YAp1qcLnC2jE0YbETxOg3EVNWxwG1AI8BxgAVirUqYT0");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("QjVGTc");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(24);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("MPsYBzrvOL7QbNhAht7Gw4Taca8MEWvCHCKgSlgFtWnysKf6Rj");
            corecontacts.setFirstName("qdggXsUvQ1pYL6ZflYSSx8yKoEkPz9ZOyr7ldD21QOOFj1pAWe");
            corecontacts.setLastName("jWBwsZYNTk2u04xUGt2MCKZaAR9tJxuiDDUU0rJTG7n5zN6Vzo");
            corecontacts.setMiddleName("nch2eXvNDjAOJVoG8V6Qzc8ZyBJ9jub9QPe3RZeeFGMAZ12SJq");
            corecontacts.setNativeFirstName("Xqtk5KvZSvdzem7JmBi9LAoeUJh6Rz4HPJQa9HTkrzIrzaXZQo");
            corecontacts.setNativeLastName("QdAGGIZUjn5bnunIIGQfpuSXEWmoxh9jjFx0kKKugeWWXtdDs8");
            corecontacts.setNativeMiddleName("EJ7FsD6kky9V8YGOckpBYiysANGNsIQ55R8JBXA8XLrZ4LYkNs");
            corecontacts.setNativeTitle("3C9otnzRj6GNs5xaijC69sD5Oq8hPnWak45FIffK7WOAnOCAGf");
            corecontacts.setPhoneNumber("KUpysULpz8XGDrtOBxgn");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
