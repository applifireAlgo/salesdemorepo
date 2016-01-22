package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.CoreContactsRepository;
import mineproj.app.shared.contacts.CoreContacts;
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
import mineproj.app.shared.contacts.Gender;
import mineproj.app.server.repository.GenderRepository;
import mineproj.app.shared.location.Language;
import mineproj.app.server.repository.LanguageRepository;
import mineproj.app.shared.location.Timezone;
import mineproj.app.server.repository.TimezoneRepository;
import mineproj.app.shared.contacts.Title;
import mineproj.app.server.repository.TitleRepository;
import mineproj.app.shared.contacts.CommunicationData;
import mineproj.app.shared.contacts.CommunicationGroup;
import mineproj.app.server.repository.CommunicationGroupRepository;
import mineproj.app.shared.contacts.CommunicationType;
import mineproj.app.server.repository.CommunicationTypeRepository;
import mineproj.app.shared.location.Address;
import mineproj.app.server.repository.AddressRepository;
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
            gender.setGender("vqNPyGsdZ2kVK2wKLqbMVKDjn7K4AHzT1QNKKCTqUy0lgAnFsI");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("NR");
            language.setAlpha3("ObK");
            language.setAlpha4("FzYT");
            language.setAlpha4parentid(10);
            language.setLanguage("l1PSHP29momyMQ1kgEyNbIBjHO5FUQotRNTTmybpkU2Xeg3nna");
            language.setLanguageDescription("YFxluGOpyQboZRnRfIhqsTVMJDfHcOFbweHsNwGyxs5s9Vj6nm");
            language.setLanguageIcon("orM9tT1OPGuDOll8W7aH7xYcxEUZJQZY5fdhAmkdBp2p01jbOx");
            language.setLanguageType("dOxBJLMCPWDTOqI6PcOUhdzqTg3lACQG");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("6RgKZ7T0VaQ67vdZbq9EkiMJiwcJv8YQYOQ74mr3aixM5FAogj");
            timezone.setCountry("LLLKjjqTA7KesWyHMBk8KDppMoX5X754bf6WOjftOYxQOgPA5n");
            timezone.setGmtLabel("IHCHU96nwDv8PkmF9qHPGdyOqolOj0LEA3qx52y8tnMxefyl6e");
            timezone.setTimeZoneLabel("hObJUOsaVe2AGWaBwNimIvzLuBDitEwRxPKwvn0FG38cCtrDVz");
            timezone.setUtcdifference(7);
            Title title = new Title();
            title.setTitles("7dvTrP9UYuYbw9nKCjG5fXz5QuKloroekAtXlo2gtQgklrnj2L");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(125);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("kGbVZiYrfEulml9skXlyZTp0pn69WJcnmmAmu8aurNuHd8ckp8");
            corecontacts.setFirstName("I3VHdDFC8eaE4qsQBBkE7xWGakkJFScHB7caCzn5DDZ01imrY4");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("kyOGN0uRM2gMW2PfY67ztROHjOLnfvXKhAX1dWvyklIIzBI5Ti");
            corecontacts.setMiddleName("3Ax3fpVtvDi2qrrXymlGtKQcU1lgSrHDLWInJ6ovwtqC39uVig");
            corecontacts.setNativeFirstName("xtQJxDs2IZLWJybsR9dS0Pbv7RVjDGegxp3B6RKMISNOQlUpb9");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("Cxja917vXLVTHsgLrm5w7H6WjMUbb1QHeYV8RDSqWcrnyfC0Sn");
            corecontacts.setNativeMiddleName("OUKlTJQqmHBMcNeYoIcYunAWVL4QjZSITvenDgUqrN607UsNAh");
            corecontacts.setNativeTitle("EYj14i73U87KBndAE1n28wkyqjNYmnkXbi42pXOgtsnd6YD2FG");
            corecontacts.setPhoneNumber("O6nTCAM3gCJt0R49WLnF");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Q");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("EJRQxKtiofi7drA8UiAl6VBObQs8Wjk04kSljd8jwR0hL9i8tn");
            communicationgroup.setCommGroupName("BoTGKeLzlZKXy163YGOGoxS5NILZnCffx1KR4IiyGfAG2hNRZh");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("tdMjkg5PvHlJoNTGzFzfnnfMHLms4MO7nexVVSIxC6uJ7ziqVl");
            communicationtype.setCommTypeName("TWEkyIZh3OLNqMQ8mWyrCcmQcHmGWxMjXFpxM8TxOWf6Xyf5Xv");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("D");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("8ZzOgj1EWTpDLrkzriK8RqEDEfv5b8x7NMJRiWgqANLtQCwXt3");
            address.setAddress2("4lqid4fcRYoGfuK5Ytx0d8nDZ7HgnjEPQxk6dKYxj3ff3mFqzb");
            address.setAddress3("1rtVyr45VAYkpsPyJ9wVkhzgsiNnRdISSZrTt8G4whSzo67bdH");
            address.setAddressLabel("MzNmEAUI26E");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("fKNLgwf9735TyToHaTWsX7NH7gCYhfHx03Zowt4j0cSo5YUxb3");
            addresstype.setAddressTypeDesc("bTylHxx87wvsVo37xWEsGdOEsyt6CDZ7SjP6999x2SEamcmerB");
            addresstype.setAddressTypeIcon("odZslKlM5g3CmTFkQJ50EYbqh2l4fouPXDALNgHLIBzOrLPpXf");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("qULzQDhwZeZSalmerEhGHWMbEZYC6hZE");
            city.setCityDescription("MBYgkn4nUA8uA1LyIqNu20xDnoXI5aEXufVyLWFtHjmAAbvGQ6");
            city.setCityFlag("H2IdkyHwLvQnjl60AJiIVFaTkB3iddue67uEg6T1tkgdF6ToXz");
            city.setCityLatitude(3);
            city.setCityLongitude(8);
            city.setCityName("RqekmPTdO83YLbN5nQ5qCId5yBaZhSea3SOyBu6kH2J2Opcpvy");
            Country country = new Country();
            country.setCapital("UWPZix3tnVwAb2JTzu79U867ThZPIa4D");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(5);
            country.setCountryCode1("8Cw");
            country.setCountryCode2("jLZ");
            country.setCountryFlag("vvd6s30xzS6Z4Xx2XWosASnhCdMLCDOsaTbrl0lTFoJPnjvhWu");
            country.setCountryName("8kelOF5p9fB91yppzJNc0tjttBlCZXnfPLLcAKI60B8IVk7Qnl");
            country.setCurrencyCode("Yoe");
            country.setCurrencyName("LduYaVnNf2rfGScDCxUhB8Jj4UEvU3yFbSZBVFWgHCKlGQ6avk");
            country.setCurrencySymbol("bH8MnmG4ZsrdNJxDiilRWy1WeEqpKdnd");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("JOBSsTknAmDo2NSun4USgu8wJo9D7T57GKlKNVeY3K4mRSCjp1");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(0);
            state.setStateCode(2);
            state.setStateCodeChar2("13C0Z8CYkDwqbf1xVxR3XYCehyb81Vah");
            state.setStateCodeChar3("FMrviLuo1cLNFN6ahn5uPNEJFnXBRysg");
            state.setStateDescription("mFKfMdbCFutuTWkfgJrlelr980bsascWGTzFDgblPbdcz4HBrm");
            state.setStateFlag("XH8WRJ5HGnjSALi5x9NTUdWG2pHTjUjMxLVxBCHU3wtRWZsadM");
            state.setStateName("l93dpuBewYZDXixzTVLEFqd2QLVghUGVHsWLUUkgSxnqrQKSLu");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("kN29nU8QzDr0N8izU6EuMbOSgv7xn3xL");
            city.setCityDescription("sANUTqKtaSr0fgd7LtW9HM9bFOxqbtNlrDKC43K2KnuAapJkVK");
            city.setCityFlag("gInTK26VktOM7z9fjz7FM2cBbumZOLbVxLq27Rbbpe5khqznKN");
            city.setCityLatitude(7);
            city.setCityLongitude(7);
            city.setCityName("eTiEGCjndEayAJecIkcZ1BrMw3tzonw01rmv6xdjsMjqq7O9Yn");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("UFMSSZtUAHAvZ0gZBw6IwhJMM7tx2tT3FhIJ5ZuWtVJrTQGVxg");
            address.setAddress2("XiD6ahJENSvxkBeg3hbiIThFl2HqSBNjYra3NfH3Vd24Q92oQs");
            address.setAddress3("iheR3krc5LtCRprnuvbJ3VFQUgyQNrfsmKj9PkNFv0fKnUBe2t");
            address.setAddressLabel("GyFCTDTACJ5");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("V96I9dRWHIqdCx025PCgx8RLJauFtwbLLbtHpWkLM9BZGPp6Bz");
            address.setLongitude("8SfBOMVPj1eqNWjOzzXzkL9NR2TWhCGdrR9jw6Kzxls6gRLAA6");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("yJtCAv");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
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
            corecontacts.setAge(114);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ke7hz6i9sk2KPo6GlmnPp3TjrddO0mVxUADE3vV3cVAnGYLDFY");
            corecontacts.setFirstName("SWqwYeBZPzIA5SuEEOiQY2N9AYbPEEoSi6MXhUrWnjwi82zvCx");
            corecontacts.setLastName("YnsiwJZlQgZWJ4OG7OzhGO7ZxsgoDUyktEoiWE9fGVCRzYD7zL");
            corecontacts.setMiddleName("ha4a7ivHoGbtHZtwoysDj8RQMU9TH4rLgIEVODNSDZYcRxLnvJ");
            corecontacts.setNativeFirstName("ZDobWRVPnq8UrH1rVjiDFtokpQzcTYc9XZ7MaFPywOLkKZTACF");
            corecontacts.setNativeLastName("fdRkyvf4SZMvrfh422rPNtgHhpTdrtUSPKvnGCvAEyZg08auIZ");
            corecontacts.setNativeMiddleName("lHzI7vBCSG5cHIlAh3rr556cH2GEdzCKTXlPJEAJFedj8vOEOh");
            corecontacts.setNativeTitle("6Wcm36Z2uIBP6gBYXoY0QTzaAWymJumjBn5l9nN431mvokRQap");
            corecontacts.setPhoneNumber("rniy6As764OThleQdw3G");
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
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
