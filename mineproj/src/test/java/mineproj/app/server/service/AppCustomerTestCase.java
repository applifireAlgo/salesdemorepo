package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.AppCustomerRepository;
import mineproj.app.shared.customers.AppCustomer;
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
import mineproj.app.shared.customers.AppCustomerCategory;
import mineproj.app.server.repository.AppCustomerCategoryRepository;
import mineproj.app.shared.customers.AppCustomerType;
import mineproj.app.server.repository.AppCustomerTypeRepository;
import mineproj.app.shared.contacts.CoreContacts;
import mineproj.app.server.repository.CoreContactsRepository;
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
public class AppCustomerTestCase {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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
            AppCustomerCategory appcustomercategory = new AppCustomerCategory();
            appcustomercategory.setCustomerCategory("0RwjjOxdccGn1GdfqpXprK5Ooci4DjzEwuOoZQVATtwYIuPU58");
            AppCustomerCategory AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
            AppCustomerType appcustomertype = new AppCustomerType();
            appcustomertype.setCustomerType("L0r086X7DGvBtPwy6UJcdEpTXZ6Ddby1Dr7yBOhtDwJvwEEh7Y");
            appcustomertype.setDefaults(1);
            appcustomertype.setSequenceId(2147483647);
            AppCustomerType AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(17);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("J4cL8KlNfbrJUiEFSOki3iTcdkvfqlqPgI8JJp82XAWSpTRW1x");
            corecontacts.setFirstName("GCGTsYFRExFZ5iFdDxrDeTa2uvhPDM6liXZNKTdP3iHsN1sYpW");
            Gender gender = new Gender();
            gender.setGender("irOFeT2Kb4mq3dNCHZhX7KlyM7KCCluAEVqWpEL5isXe6knceV");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("si");
            language.setAlpha3("mkv");
            language.setAlpha4("7WcO");
            language.setAlpha4parentid(3);
            language.setLanguage("OHz2theAkKzbhjiccF33biGPzCRX9RnKNk3e3ehqoT5QuGMhal");
            language.setLanguageDescription("w8QACmkPB2SyCXvxcIms61e7xDtOuoqshK8jbcenaBH5g2e6Id");
            language.setLanguageIcon("awCJRtXfZJ0jyprPDuJBbIdBlW7Wi7G4RxYtQd8GgiVAheyTXw");
            language.setLanguageType("wfMBz4mOH1WdMshlkDpDGBommDTVxNaU");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("GBZNtxlcO9zrLoaqIbaZpLUnZgTZwPWhcKHsIR5oGD2us2M6v9");
            timezone.setCountry("4dF8gxNPICR9ug9O3PikHDQ2okx4T4XduViWypBexyGWkM87Vg");
            timezone.setGmtLabel("kOqx2qbpU1PMGycE9ekS19uMyYh5sIxdp8ZwELL28648dEYKGl");
            timezone.setTimeZoneLabel("nmds3FblFXIelth7xm35WmK38sEheFBzlFOUsPIxdK3nuYV6dh");
            timezone.setUtcdifference(1);
            Title title = new Title();
            title.setTitles("fRC2eZJoJQ5FJrBpvunl4CSpO3dhD50FF8PlRtgTltkCMaRjeF");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(70);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("J2TmmFHCzlAKl4SLo4PewGi0dobz5K3GiyVAyNMUiELjvteBoj");
            corecontacts.setFirstName("hmSMAeHh7OBOvsQKrzq333EkN0JdyxEw8GebNsq10ZUFxm0HcC");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("RFaOMu10WlM0eaIwn4QuJL6GrwHzCxKNFmy4USNRx9ilm4q5Pn");
            corecontacts.setMiddleName("GRJ5MCpDFMBCzcdM3YOjUpuD61bkPSbhGvvcoiZ9HjQIOMWb5N");
            corecontacts.setNativeFirstName("h0EOLBhh49J9VQ6AOh1rVoi6GvlzckoapSQgABtf6qqAta1Ero");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("Rw6XEnqWZvRKFL8f14msAXOAIM40oyOjFwiw1MeLSJVsXubOXB");
            corecontacts.setNativeMiddleName("QCGhusNio7ssN9dXpmLije370OHJHQZ23rswD4S5T3GZmciLCV");
            corecontacts.setNativeTitle("qtx1nD5QVqTgr2QpPyA1cFzleg5dcbA1vj1pC3cZdhjVI6xWZ4");
            corecontacts.setPhoneNumber("DjKsuDib5RTReXCfeDO1");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Y");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("TEdMxSMUqK5wTfoB73D9B2v5xgwr19Jz1V6JbcKb6dfhd3GbGG");
            communicationgroup.setCommGroupName("qWRa9gD9vgnm0VhJtuKmzMV5HAIRPARHqyxPwOsWRn6mhYCE7p");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("mgvO3kxrWISrHYBFyXGWRB97F1qxGQ2SMjLxbOUMqGGfjYkm25");
            communicationtype.setCommTypeName("3xsa6jYOYmsfEsVjRYVicvhYz3dqNJpbYkOYPBrQtzAAnhrMwI");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("O");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("3aahTBEE7FX88rNbcovaxiECclXXSkqm7GsuCfJAU1Cf4Sl12U");
            address.setAddress2("vGyMcFkEZCjxDUsyvgoSAG7mroTCKFglVxLQrf24RkuoDnNvMH");
            address.setAddress3("2yuRPQJRZRAEBV6hymCCY2l8hE8NBcENpQDR6SFfvmH3u10DpX");
            address.setAddressLabel("EDiQmkf5WQG");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("Ei9Ko45YRVfK3LGApXdr5ZS6dFPf8Le5WKaEXQJ277T4wbzDaE");
            addresstype.setAddressTypeDesc("y69lgpiMcj0CyZ1pN3GEOiKpR0FpudtUFTbdbkbd0c0HsFbz30");
            addresstype.setAddressTypeIcon("Zfp7xejQVQshFUDPMlyeNBPnrYSriuohwcRakCtgZt4IxaaYIx");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("CCfcdSmSUThQgTSycMI03dLcUpoXKck4");
            city.setCityDescription("jwEhldFmV5Qw3D5nEKjncmnmevvMUEeBo5zeNigi2ooiuB844A");
            city.setCityFlag("mjlLBXXEGvKe9Gg0l6emPjjJAKmts6Btwamm3jqGJigOrRLBO1");
            city.setCityLatitude(6);
            city.setCityLongitude(2);
            city.setCityName("cxaZbcri3ORgj4w7zT9idchpgfF8NLZ6L5TVN84EzJFrX9r0Lo");
            Country country = new Country();
            country.setCapital("ZT2B34E1UB4rV5GUiT8bGdsCkQL7uYPH");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(6);
            country.setCountryCode1("yPR");
            country.setCountryCode2("Hsw");
            country.setCountryFlag("O9bcSGBQaalZAUbgvUmTvw2tC1aOZIOAxaQQWnDKv2H4OOdxXK");
            country.setCountryName("JQ0lmlDHlJZnVsDWm7hKTVFQFDsICeFvqXfRf2fMmEhzRTxcsE");
            country.setCurrencyCode("LfB");
            country.setCurrencyName("yeQhYwl57ktbaCBEHYHZTCNbOlGttQzuIEFXHr44F7WNgikTXM");
            country.setCurrencySymbol("QwRgF6jvOMOcUhXp34Jnm9NJ6Dm1lp9k");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("kIwSki3CuKUjYoQmIQApgUHaPJUbmc4ityGSVlDGM4HdCRWYSm");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(4);
            state.setStateCode(1);
            state.setStateCodeChar2("CuFLOxofoc0GSc7Yl2NaaJEfBIbtlMnX");
            state.setStateCodeChar3("7cPw948loADjUlFwNS7c40lCNYBrYgA3");
            state.setStateDescription("uNtFhU3GVhbZniN1PEZ4NiHn7ruNYrtoF7qUkrohVN2mtQP7Eu");
            state.setStateFlag("mSbCiJ1vgawH5gCcstRIk2odkqAmXZaEUihJ7lj6Y3N5VcSwk1");
            state.setStateName("pbdLt3kT7BTaNEXnpUFMfoZIPDA2nvGG8tgG68irySlwJqjAn0");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("FQ8sSyCx5WRjKCsnY9fHyfTb6PCd8R8O");
            city.setCityDescription("duuwcWsylKGfm7WL7zPsex2fH18HGqiVpCA6c3OGfEcFhdpreS");
            city.setCityFlag("AoriuQ92vHMXeBwDbXSPHwhYGEWeVzc8bvGsFtd7WKdQDzrAFW");
            city.setCityLatitude(3);
            city.setCityLongitude(6);
            city.setCityName("zOqsVDnG3kfK48qCYxDMQ5EdealZYJsGCGYS9fNBdsb3qe4Y6K");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("WK1RuWBkSYONxKQl6aDqqZxcvsU5jj6kt3p4grL4GhWYA3uneg");
            address.setAddress2("lHo1miSIs5mEvc84Z8ZW7pZTQIZjsZ0rzDFwLtK0SNiDCdYM14");
            address.setAddress3("TRBZ09JT0CJNrRfZNUg1YLUQgPXG3YLtyPpoauPs2AW9WxyQOE");
            address.setAddressLabel("AtQvtG6ubPh");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("gVSmRnciVo0la5ZyLezEPVXph16mluK1jN34InB1AUFI7B1znw");
            address.setLongitude("oneVQDEhBIBLNgWBg7j171IAsZmiIr9qgW0SpWmbKodXPZf4fd");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("G997j0");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            AppCustomer appcustomer = new AppCustomer();
            appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
            appcustomer.setCustomerName("FJXGJRcZJfgl6VpDlAcBRXRHqLryzIP5iSfibcsV9lIgNDPFth");
            appcustomer.setCustomerStatus(1);
            appcustomer.setDeploymentModel(true);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.setEntityValidator(entityValidator);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("fRToU6nXBMQ5ld0Z7H2r0O5v7fiMR1czOMCNtYzjcInNTUxMW3");
            appcustomer.setCustomerStatus(1);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
