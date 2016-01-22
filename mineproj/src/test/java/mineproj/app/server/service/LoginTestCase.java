package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.LoginRepository;
import mineproj.app.shared.authentication.Login;
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
import mineproj.app.shared.authentication.User;
import mineproj.app.server.repository.UserRepository;
import mineproj.app.shared.authentication.UserAccessDomain;
import mineproj.app.server.repository.UserAccessDomainRepository;
import mineproj.app.shared.authentication.UserAccessLevel;
import mineproj.app.server.repository.UserAccessLevelRepository;
import mineproj.app.shared.authentication.PassRecovery;
import mineproj.app.shared.authentication.Question;
import mineproj.app.server.repository.QuestionRepository;
import mineproj.app.shared.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(86);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("GShb5YyRPfkzTHSbSHUqpozigrebdNHevWZ38w4OM41xYNBEf0");
            corecontacts.setFirstName("RZR1phxQMtDBoUP1b59expKJSKhYnMrgspoGMf8XWY451HOPFl");
            Gender gender = new Gender();
            gender.setGender("9ityXbmjIxb74F219kqbUD7Gk8OpiQBe56QisjCGqrsw8aAYHm");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("iE");
            language.setAlpha3("PqU");
            language.setAlpha4("sHLN");
            language.setAlpha4parentid(1);
            language.setLanguage("bepXdwPNZmmPkJiyXwxeL5sJQQneXy7Vya40KWmJvWJpvJuNPk");
            language.setLanguageDescription("N0Dz1791oUtWC2e2AGMAMYxCwKjG5FAtenoh87d4eBsha2cyI4");
            language.setLanguageIcon("tj6sUcITod7czrfSkeAoHEQvN8OjouuVf3OaEnreLS7e7JrY9w");
            language.setLanguageType("nezG3Y5NeJ6WlhC5Jgd1kSrh7AhuAT51");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("njeow5XoSZO3elsZXzfUM0592OjsoAkXhJudERBa40rbgkEdWG");
            timezone.setCountry("2c8KZhYZaCzRnpwAH2EdYmu8oezkNBOe1XkUG8NP1tx87fiEsh");
            timezone.setGmtLabel("vanIMZU8vjbvBU3mAyEMRIbb8Q1CtlzouNe2wT8zExg3AEg6tw");
            timezone.setTimeZoneLabel("k71O7DLdnOolMhDnnL5oxpVXOoryt0QJf1zlnbZqafuTvSzKUo");
            timezone.setUtcdifference(3);
            Title title = new Title();
            title.setTitles("rsC2eCC6cAwIomNMzWwU9FXdAmmldbJtqn2irBeoocx22AYILf");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(33);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Yy6xPEZ4LndygUyjjrocz0XhKwFf9xAnMAiEA1uKorFd4gJ98e");
            corecontacts.setFirstName("IK25pFXBvwds9IPqs8oXMH7YsxuWSgwapfCJNQeXYD2biaKUcD");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("Adf39zqbeD5Cr1sT9DOXAcBOVUqdTzpykVw6HqEGIcG2WdbpnC");
            corecontacts.setMiddleName("OXRrirB0FJBGjoykgETtrImhPudrvBM2JglNjMtPmTtD7GSgL8");
            corecontacts.setNativeFirstName("bStlmqLiOGYm8mhhHuUTs23lEdDNYmXNypkdiShx1r6MpxnGex");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("Ipu4dfm9vPrqOQUs5f6fiEr9e3V8LUEmoM6fBrDR6GnszndbkZ");
            corecontacts.setNativeMiddleName("tjxYU07tvhTcs7MJ1pgVdIT6Mo0Tvm8kWiV0g4QOlvZ5nO73dy");
            corecontacts.setNativeTitle("hVo5cwLdSKqPutXUlVX0ZPwRCRCuHDKZbhtBha6NjWeC4f3RHC");
            corecontacts.setPhoneNumber("CePcJFrRJlNLhk16HtgM");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("f");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("rZubYhwzqdEQvPiLmbmxvsaZc4TDeFLAFGRrHpzwNVnC6wmH9S");
            communicationgroup.setCommGroupName("99tgTWg8eYAelrlzjpyumvUVrdPBDLqWwkSiJEV45E3eDlOYoF");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("r44zr663gOcBnotgtk4FklyEMcOrsCivYbkAbCGVkihCxdzoan");
            communicationtype.setCommTypeName("tpeehHX2ltTeHR5AZKj88muTJrpe6y3jzuGiu4GVPSQ7zwaSHE");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("n");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("QDHKBkEg8BZKr7ntgPBDOKr0uE0E2bxProVBHjCjthKiuBAtwC");
            address.setAddress2("1tDzUjU0CPggAj4y3iSysXqXQOXE0xHKqU5Rx5TeOcWFBL4hXp");
            address.setAddress3("QhvfFkoKAyiU7meQ7dI4LMiOkiny8YfFeOxnk6W7vkDq2g4KTL");
            address.setAddressLabel("xcLus7q1aeO");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("y6e22VGwdjDpeBf90lCK6ak62El0u0fhLLsUiVim7bVy985W0v");
            addresstype.setAddressTypeDesc("9QHGlSy8jQtFP0gGfDsC5hEAZkI0tFBBBl0qlXqurbqXMfRGlE");
            addresstype.setAddressTypeIcon("xnwBLzyHLB4OnzCK3b3Yzo0kEpW4UNtv5i7fsWqA7gBUYblp7L");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("aGwpzdwCQG55jFGdneHz421eu9QNDZB6");
            city.setCityDescription("aNKuUU7MogzbMON1PLoKcbnoWcDmp0ZmuNSrL6N4e9IXMUct3q");
            city.setCityFlag("Hx8UvAEpY7ZWmNxaCMyjtSHcx8LNqj86TBNpQwjdDApdATwwHQ");
            city.setCityLatitude(11);
            city.setCityLongitude(7);
            city.setCityName("ZS8K0Znv2XmObugu6iqLLcCHcTEf7y36Rrq8ZcxkkIUf7ngQyI");
            Country country = new Country();
            country.setCapital("LhQVAK9GuWI62XzFfbBCLwWD0iD3HeDG");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(7);
            country.setCountryCode1("BBf");
            country.setCountryCode2("eLW");
            country.setCountryFlag("zhMllPw0d2OqAVnAVwHlPPvUtNaT7F63ypQQyGunhP4hGeVkai");
            country.setCountryName("bZQKmSoceN7EYoqvmGvKYZN7QRssyLX3J1FeeDSDUMJSbUxfqX");
            country.setCurrencyCode("4p8");
            country.setCurrencyName("4VRAMMqLSt6CkVdOSlWd0iyGe91mwggF5LAArJhVqLcq2c09SO");
            country.setCurrencySymbol("aaeYOgCA0dPmSlkz3B4EdeMdHzCbmVKt");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("mV8N591S4XBwbS0sPlePJQ7uFfIrLzpQIkgOhss2sIUUriTGqO");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(2);
            state.setStateCode(0);
            state.setStateCodeChar2("6DykWkDKf1A4cTQRsIWe8MmrvWxAipJv");
            state.setStateCodeChar3("IRi7w6odlUMnE2HFqluANay4jj4Pe4MO");
            state.setStateDescription("gKrYqJ8aR6Z8dd1wWhlQLE7ZeewKSudpQRw4NKx1xeHA2FM86M");
            state.setStateFlag("7inQandhozjpUiSLgr8z5TJLLuhknsM3ZmDxT2P2bhkkuOR7Ok");
            state.setStateName("xHrW32Ii1y7YeFyFjVq0QlLjU7ilMTgkN6eNrocdQ9WQKK0dHG");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("QwRf0D4wAkKX4ogZq87C6Zcozg0ZFGcf");
            city.setCityDescription("Jwejf1pqan1YAYbgfO3MMI5dULyql7jO6T8v4HMnhsQfEr8aCa");
            city.setCityFlag("UN6eA3CpsRHzc9TZYoqDn1fjOrS3tLEmctIq4kqB2h9ESW5fUF");
            city.setCityLatitude(7);
            city.setCityLongitude(10);
            city.setCityName("rVmEDssyIaVL28JXmOHQJbmEbz8DSgFFpqn4vAwJCzOqbX775o");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("LWs9P1M7UChA5k7eC5LRPOF9d0zo1btTfw0ieQZWI7KdTA1a9r");
            address.setAddress2("pNWe1Oj0IB2FGThCaklHGBzNTHe95FohuM5nsluVvpPzK92hVg");
            address.setAddress3("mbz70V2XY2co6jhSo21avhXys81EUQdpbpnWkcNfL4TjulMDHS");
            address.setAddressLabel("2x0OcjHEQsy");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("2wABgdabsZP2OdLgwADruIJ94ZwstQts9UVJVWlG7ZPznUWPHB");
            address.setLongitude("3svTSFqV3TzXOtRERbrVS9f9FwEewhGtN2ZZvLEAeGYRuT3l9p");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("so4VKJ");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("Qb0z2fGvu5EVnQ03dHxk4ijnY7BntmCKCsIVZN2dHObQWuRNeo");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(395);
            user.setUserAccessCode(8);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("fXLZpsQpUzJLnOwaPJtERfwzAekvn8OJSI9B2cv3V7L430w5m7");
            useraccessdomain.setDomainHelp("Dngxy02RKEZsBbfJyCl96yYJeWDDcjrVH3DOHO3TD0IdlUWEiS");
            useraccessdomain.setDomainIcon("w2FhAnz8T4z7CTajh86G6B7kCIGxwKqEfyP0rCgDMB8RB36UfW");
            useraccessdomain.setDomainName("wfXxQuvCxyPU3JqVeB7WaAdf6M69OO7xAfzF0nr3c4vjxENWp4");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("tJjkmHCZr3qczVHcIh2YkqMMjz0HXgwL4cRU02Ld2e81yZIPUG");
            useraccesslevel.setLevelHelp("OmBm7VyisNk9A7d7K0bqaBq89SJYiiMWP63KF84AR4DQDetGcX");
            useraccesslevel.setLevelIcon("9o6DTate3SL9xR1GeLdjvoOGFaWJ7LSM0dyK9qljyCuQLO8VST");
            useraccesslevel.setLevelName("dNHWyxeWo1FlQLMdSijUDeOXlbkBdB18t2Pmf26WOTX19b1dJv");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("m7sw3RqQ6jfdtgbkgmK1cfCCPMy51YLcfOcwdHdpPfjgN2ONPW");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3080);
            user.setUserAccessCode(9);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("0zTqF1rGjmQYHFsMGV6hAql5Q668WiJnOxZDAjEXgmPMuT16qF");
            Question question = new Question();
            question.setLevelid(9);
            question.setQuestion("WH0shZGQOUBPKMi0lYakztnjotCIPoa1NMAkDPcbSAzQCgdwuS");
            question.setQuestionDetails("5");
            question.setQuestionIcon("vm5Jdap8DyIfgpi183BwZG9Q51tCYuM5Z2aTmTNnbIEXMC52Qn");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("V0bz8mzWLOok5pPae45UTRXp4xHrtSvchOBUAMiciKWwztd8YJ");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("bcLKCuqdYhV9LdRMnUk3Mg9RnQEJ8iHS9Yv5Lk2k9cvwWRWODB");
            userdata.setOneTimePassword("y1NUxWTiwaYqjMIOkHA5prsbIkT00ICu");
            userdata.setOneTimePasswordExpiry(4);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("jMEIUS8KdjDbJbkJ7vfdLZpwVfrYhBqDJawle5rfhI1g6RLmNC");
            userdata.setLast5Passwords("dFyo5bck9MeahGAAAkVlSY9Q6qi0uPxytbi6RocAnu2j5Yyaqo");
            userdata.setOneTimePassword("M8XmUxSgMCRH2NirbY2z9HCN30SYCxv3");
            userdata.setOneTimePasswordExpiry(0);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("rlFVkPBvpzgTNiE2MfKMClTjW9y03B3FxxiFYQxrZTsRQiwX54");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(4);
            login.setIsAuthenticated(true);
            login.setLoginId("BIjRGrD7x2sXRh2VDSeyrRaV2sz66QfgyVIz4Jku0vjpmpjWLP");
            login.setServerAuthImage("cBGh48UIFexqgw4B8LDdFBk5Va4paz63");
            login.setServerAuthText("Lxe9jWEKqOrE8ZM0");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(4);
            login.setLoginId("H1UPkP9hqT7er9ni4qT5A3Uqlyq5PT6s1M76Gmh9ozeKGbJq93");
            login.setServerAuthImage("aXQVFyrW6Ax1nW2AsMIjYDl01ePYnxqk");
            login.setServerAuthText("0pSAvXBrj5LkiQZD");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
